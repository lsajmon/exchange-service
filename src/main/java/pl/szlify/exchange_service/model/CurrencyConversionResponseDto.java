package pl.szlify.exchange_service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class CurrencyConversionResponseDto {

    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal result;

}
