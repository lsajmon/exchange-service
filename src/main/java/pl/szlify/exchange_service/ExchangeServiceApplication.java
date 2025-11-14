package pl.szlify.exchange_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.szlify.exchange_service.config.RabbitMQProperties;

@SpringBootApplication
@EnableConfigurationProperties(RabbitMQProperties.class)
public class ExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeServiceApplication.class, args);
	}

}
