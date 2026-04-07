package pl.szlify.exchange_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfirmationDataDto {

    private CurrencyConversionResponseDto response;
    private String email;
}
