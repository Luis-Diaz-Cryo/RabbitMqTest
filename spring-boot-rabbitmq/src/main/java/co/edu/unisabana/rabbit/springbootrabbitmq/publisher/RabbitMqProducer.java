package co.edu.unisabana.rabbit.springbootrabbitmq.publisher;


import co.edu.unisabana.rabbit.springbootrabbitmq.dto.CafeOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(CafeOrder order){
        LOGGER.info(String.format("Order sent -> %s",order.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }
}
