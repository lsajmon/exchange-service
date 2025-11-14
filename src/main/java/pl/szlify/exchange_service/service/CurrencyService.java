package pl.szlify.exchange_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Pageable;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.szlify.exchange_service.exception.ExchangeServiceException;
import pl.szlify.exchange_service.model.ConfirmationDataDto;
import pl.szlify.exchange_service.model.ConvertParams;
import pl.szlify.exchange_service.model.CurrencyConversionResponseDto;
import pl.szlify.exchange_service.model.CurrencyRates;
import pl.szlify.exchange_service.model.CurrencyRatesDto;
import pl.szlify.exchange_service.mapper.CurrencyMapper;
import pl.szlify.exchange_service.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.util.List;
import static java.math.RoundingMode.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final ConfirmationDataSender confirmationDataSender;

    @Cacheable
    public List<CurrencyRatesDto> getAll() {
        log.info("Currencies...");
        return currencyRepository.findAll().stream()
                .map(CurrencyMapper::mapToDto)
                .toList();
    }

    public CurrencyRatesDto getByCode(String code) {
        return currencyRepository.findByCode(code)
                .map(CurrencyMapper::mapToDto)
                .orElseThrow(() -> new ExchangeServiceException("Invalid code"));

    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    public CurrencyConversionResponseDto convert (ConvertParams params){
        CurrencyRates from = currencyRepository.findByCode(params.getFrom())
                .orElseThrow();
        CurrencyRates to = currencyRepository.findByCode(params.getTo())
                .orElseThrow();
        BigDecimal rate = from.getBid().divide(to.getAsk(),4, HALF_UP);
        BigDecimal result = params.getAmount().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP);

        CurrencyConversionResponseDto response = new CurrencyConversionResponseDto()
                .setFrom(params.getFrom())
                .setTo(params.getTo())
                .setRate(rate)
                .setAmount(params.getAmount())
                .setResult(result);
        String email = "java.mail.testowy@gmail.com";
        confirmationDataSender.send(new ConfirmationDataDto(response, email));
        return response;

    }
}
