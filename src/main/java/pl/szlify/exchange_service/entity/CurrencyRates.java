package pl.szlify.exchange_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}
