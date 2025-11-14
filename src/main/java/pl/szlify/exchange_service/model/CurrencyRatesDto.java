package pl.szlify.exchange_service.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CurrencyRatesDto {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}
