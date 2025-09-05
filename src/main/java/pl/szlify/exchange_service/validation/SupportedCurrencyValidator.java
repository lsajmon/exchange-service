package pl.szlify.exchange_service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import pl.szlify.exchange_service.service.CurrencyService;

@RequiredArgsConstructor
public class SupportedCurrencyValidator implements ConstraintValidator<SupportedCurrency, String> {

    private final CurrencyService currencyService;

    @Override
    public boolean isValid(String currencySymbol, ConstraintValidatorContext constraintValidatorContext) {
        return currencyService.getCurrencySymbols().getSymbols().containsKey(currencySymbol);
    }
}
