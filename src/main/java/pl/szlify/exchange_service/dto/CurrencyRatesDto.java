package pl.szlify.exchange_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRatesDto {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;

}
