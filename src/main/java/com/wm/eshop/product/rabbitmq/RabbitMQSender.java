package com.wm.eshop.product.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** RabbitMQ生产者 */
@Component
public class RabbitMQSender {

	// 在pom.xml引入了RabbitMQ的依赖后，可直接使用AmqpTemplate
	@Autowired
	private AmqpTemplate rabbitTemplate;

	/**
	 * 向RabbitMQ发送一条消息
	 * 
	 * @param queue
	 *          指定收发消息的队列
	 * @param message
	 *          消息
	 */
	public void send(String queue, String message) {
		this.rabbitTemplate.convertAndSend(queue, message);
	}

}