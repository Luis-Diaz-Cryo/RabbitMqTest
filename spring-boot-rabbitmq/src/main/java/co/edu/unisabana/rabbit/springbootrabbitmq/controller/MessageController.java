package co.edu.unisabana.rabbit.springbootrabbitmq.controller;

import co.edu.unisabana.rabbit.springbootrabbitmq.dto.CafeOrder;
import co.edu.unisabana.rabbit.springbootrabbitmq.publisher.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMqProducer producer;

    public MessageController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody CafeOrder order){
        producer.sendOrder(order);
        return ResponseEntity.ok("order sent to Rabbitmq...");
    }
}
