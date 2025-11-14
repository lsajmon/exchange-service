package pl.szlify.exchange_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.szlify.exchange_service.config.RabbitMQProperties;
import pl.szlify.exchange_service.model.ConfirmationDataDto;
@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmationDataSender {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitMQProperties;

    public void send(ConfirmationDataDto confirmationDataDto){
        rabbitTemplate.convertAndSend(rabbitMQProperties.getConfirmationDataQueue(), confirmationDataDto);
        log.info("Sent: {}" , confirmationDataDto);
    }

}
