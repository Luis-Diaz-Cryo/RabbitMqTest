package co.edu.unisabana.rabbit.springbootrabbitmq.consumer;

import co.edu.unisabana.rabbit.springbootrabbitmq.dto.CafeOrder;
import co.edu.unisabana.rabbit.springbootrabbitmq.publisher.RabbitMqProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(CafeOrder order){
        LOGGER.info(String.format("recieved message -> %s",order.toString()));
    }
}
