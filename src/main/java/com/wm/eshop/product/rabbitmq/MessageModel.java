package com.wm.eshop.product.rabbitmq;

/** 向RabbitMQ发送消息的消息实体类 */
public class MessageModel {

	/** 触发什么操作，如：add、update、delete */
	private String event_type;

	/** 操作的实体类型，如：实体表名 */
	private String data_type;

	/** 操作的实体id */
	private Long id;

	public MessageModel() {
	}

	/**
	 * 构建RabbitMQ的消息对象
	 * 
	 * @param event_type
	 *          触发什么操作，如：add、update、delete
	 * @param data_type
	 *          操作的实体类型，如：实体表名
	 * @param id
	 *          操作的实体id
	 */
	public MessageModel(String event_type, String data_type, Long id) {
		this.event_type = event_type;
		this.data_type = data_type;
		this.id = id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
