package pl.szlify.exchange_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue confirmationDataQueue(RabbitMQProperties props) {
        return new Queue(props.getConfirmationDataQueue(), true); // durable queue
    }
//    @Bean
//    public org.springframework.amqp.core.DirectExchange dummyExchange() {
//        return new org.springframework.amqp.core.DirectExchange("dummy.exchange");
//    }
//
//    @Bean
//    public org.springframework.amqp.core.Binding dummyBinding(Queue confirmationDataQueue,
//                                                              org.springframework.amqp.core.DirectExchange dummyExchange) {
//        return org.springframework.amqp.core.BindingBuilder
//                .bind(confirmationDataQueue)
//                .to(dummyExchange)
//                .with("dummy.routing");
//    }

}
