package pl.szlify.exchange_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szlify.exchange_service.model.ConvertParams;
import pl.szlify.exchange_service.model.CurrencyConversionResponseDto;
import pl.szlify.exchange_service.model.CurrencyRatesDto;
import pl.szlify.exchange_service.service.CurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<CurrencyRatesDto> getAllCurrencies(){
        return currencyService.getAll();
    };

    @GetMapping("/convert")
    public CurrencyConversionResponseDto convert(@Valid ConvertParams convertParams) {
        return currencyService.convert(convertParams);
    }
}
