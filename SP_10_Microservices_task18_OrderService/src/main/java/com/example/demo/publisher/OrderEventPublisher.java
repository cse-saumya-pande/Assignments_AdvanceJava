package com.example.demo.publisher;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishOrderEvent(OrderEvent event) {
        try {
            log.info("Publishing order event: {}", event);
            rabbitTemplate.convertAndSend(
                RabbitMQConfig.ORDER_EXCHANGE, 
                RabbitMQConfig.ORDER_ROUTING_KEY, 
                event
            );
            log.info("Order event published successfully for order id: {}", event.getOrderId());
        } catch (Exception e) {
            log.error("Failed to publish order event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to publish order event", e);
        }
    }
}