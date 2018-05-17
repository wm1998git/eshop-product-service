package com.wm.eshop.product.rabbitmq;

public interface RabbitQueue {

	/** RabbitMQ队列名称 */
	public static final String DATA_CHANGE_QUEUE = "data-change-queue";

	/** 专用于刷数据的队列 */
	public static final String REFRESH_DATA_CHANGE_QUEUE = "refresh-data-change-queue";

	/** 专用于高优先级数据的队列 */
	public static final String HIGH_PRIORITY_DATA_CHANGE_QUEUE = "high-priority-data-change-queue";

}
