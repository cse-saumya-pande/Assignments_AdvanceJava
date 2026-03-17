package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String QUEUE = "notification-queue";

	@Bean
	public TopicExchange orderExchange(@Value("${app.rabbit.exchange}") String exchangeName) {
		return new TopicExchange(exchangeName);
	}

	@Bean
	public Queue queue() {
		String queueName = QUEUE;
		return QueueBuilder.durable(queueName).build();
	}

	@Bean
	public Binding notificationBinding(
			Queue queue,
			TopicExchange orderExchange,
			@Value("${app.rabbit.routing-key}") String routingKey
	) {
		return BindingBuilder.bind(queue).to(orderExchange).with(routingKey);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();	
	}
}
