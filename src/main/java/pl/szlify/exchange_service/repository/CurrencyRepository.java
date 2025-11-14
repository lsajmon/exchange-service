package pl.szlify.exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.szlify.exchange_service.model.CurrencyRates;

import java.util.Optional;


public interface CurrencyRepository extends JpaRepository<CurrencyRates, String> {

    @Query("select c from CurrencyRates c where c.code = :code")
    Optional<CurrencyRates> findByCode(@Param("code") String code);
}
