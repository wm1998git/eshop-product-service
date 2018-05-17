package com.wm.eshop.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.wm.eshop.product.mapper.BrandMapper;
import com.wm.eshop.product.model.Brand;
import com.wm.eshop.product.rabbitmq.MessageModel;
import com.wm.eshop.product.rabbitmq.RabbitMQSender;
import com.wm.eshop.product.rabbitmq.RabbitQueue;
import com.wm.eshop.product.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;

	public void add(Brand brand, String operationType) {

		brandMapper.add(brand);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, JSONObject.toJSONString(new MessageModel("add", "brand", brand.getId())));
	}

	public void update(Brand brand, String operationType) {

		brandMapper.update(brand);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, JSONObject.toJSONString(new MessageModel("update", "brand", brand.getId())));
	}

	public void delete(Long id, String operationType) {

		brandMapper.delete(id);

		String queue = null;

		if (operationType == null || "".equals(operationType)) {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		} else if ("refresh".equals(operationType)) {
			queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
		} else if ("high".equals(operationType)) {
			queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
		}

		rabbitMQSender.send(queue, JSONObject.toJSONString(new MessageModel("delete", "brand", id)));
	}

	public Brand findById(Long id) {
		return brandMapper.findById(id);
	}

	public List<Brand> findByIds(String ids) {
		return brandMapper.findByIds(ids);
	}
}