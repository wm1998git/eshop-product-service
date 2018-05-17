package com.wm.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wm.eshop.product.mapper.ProductMapper;
import com.wm.eshop.product.model.Product;
import com.wm.eshop.product.rabbitmq.RabbitMQSender;
import com.wm.eshop.product.rabbitmq.RabbitQueue;
import com.wm.eshop.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;

	public void add(Product product, String operationType) {

		productMapper.add(product);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, "{\"event_type\": \"add\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
	}

	public void update(Product product, String operationType) {

		productMapper.update(product);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, "{\"event_type\": \"update\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
	}

	public void delete(Long id, String operationType) {

		productMapper.delete(id);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, "{\"event_type\": \"delete\", \"data_type\": \"product\", \"id\": " + id + "}");
	}

	public Product findById(Long id) {
		return productMapper.findById(id);
	}

}
