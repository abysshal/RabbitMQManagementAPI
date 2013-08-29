package com.ramytech.rabbitmq.management;

import com.ramytech.rabbitmq.management.impl.DefaultAPIClient;
import com.ramytech.rabbitmq.management.impl.DefaultAPIResponseHandler;

public class RabbitMQAPIFactory {

	public static RabbitMQAPIClient getAPIClient(RabbitMQAPIClientConfig config) {
		return new DefaultAPIClient(config);
	}

	public static RabbitMQAPIResponseHandler getAPIResponseHandler() {
		return new DefaultAPIResponseHandler();
	}
}
