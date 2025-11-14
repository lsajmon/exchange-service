package pl.szlify.exchange_service.model;

import lombok.Data;
import pl.szlify.exchange_service.validation.SupportedCurrency;

import java.math.BigDecimal;

@Data
public class ConvertParams {

    @SupportedCurrency
    private String from;

    @SupportedCurrency
    private String to;

    private BigDecimal amount;

}
