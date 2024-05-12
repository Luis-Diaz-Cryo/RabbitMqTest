package co.edu.unisabana.rabbit.springbootrabbitmq.consumer;

import co.edu.unisabana.rabbit.springbootrabbitmq.dto.CafeOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(CafeOrder order) {
        LOGGER.info(String.format("Received message: %s", order));

        try {
            processOrder(order);
            LOGGER.info("Message processed successfully");
        } catch (Exception e) {
            LOGGER.error("Error processing message: " + e.getMessage());
            handleProcessingError(order, e);
        }
    }

    private void processOrder(CafeOrder order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Interrupted while processing order: " + e.getMessage());
        }
    }

    private void handleProcessingError(CafeOrder order, Exception e) {
        LOGGER.error("Handling processing error for order " + order.getOrderId() + ": " + e.getMessage());
    }
}
