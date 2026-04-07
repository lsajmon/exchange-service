package pl.szlify.exchange_service.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbit")
@Data
public class RabbitMQProperties {
    private String confirmationDataQueue;
}
