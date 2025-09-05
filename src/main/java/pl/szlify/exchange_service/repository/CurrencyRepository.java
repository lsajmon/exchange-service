package pl.szlify.exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szlify.exchange_service.entity.CurrencyRates;

public interface CurrencyRepository extends JpaRepository<CurrencyRates, String> {

}
