package pl.szlify.exchange_service.mapper;

import lombok.experimental.UtilityClass;
import pl.szlify.exchange_service.model.CurrencyRatesDto;
import pl.szlify.exchange_service.model.CurrencyRates;

@UtilityClass
public class CurrencyMapper {

    public static CurrencyRatesDto mapToDto(CurrencyRates currencyRates){
        return new CurrencyRatesDto()
                .setCurrency(currencyRates.getCurrency())
                .setCode(currencyRates.getCode())
                .setBid(currencyRates.getBid())
                .setAsk(currencyRates.getAsk());
    }
}
