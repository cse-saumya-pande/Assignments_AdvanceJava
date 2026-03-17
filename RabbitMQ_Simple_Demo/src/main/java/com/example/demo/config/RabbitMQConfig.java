package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange orderExchange(@Value("${app.rabbit.exchange}") String exchangeName) {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue orderQueue(@Value("${app.rabbit.queue}") String queueName) {
        return new Queue(queueName, true);
    }

    @Bean
    public Binding orderCreatedBinding(
            Queue orderQueue,
            DirectExchange orderExchange,
            @Value("${app.rabbit.routing-key}") String routingKey
    ) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with(routingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }
}

