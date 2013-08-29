package com.ramytech.rabbitmq.management.impl;

import com.ramytech.rabbitmq.management.RabbitMQAPIClientConfig;
import com.ramytech.rabbitmq.management.http.PlainHttpClient;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public abstract class BasicAPIClient {
	public static final String HEADER_KEY_ACCEPT = "accept";
	public static final String HEADER_VALUE_ACCEPT = "application/json";
	public static final String HEADER_KEY_CONTENT_TYPE = "content-type";
	public static final String HEADER_VALUE_CONTENT_TYPE = "application/json";

	RabbitMQAPIClientConfig config;

	public BasicAPIClient(RabbitMQAPIClientConfig config) {
		this.config = config;
	}

	protected PlainHttpResponse responseGET(String url) {
		return new PlainHttpClient().get(url)
				.basicAuth(config.adminUser, config.adminPass)
				.header(HEADER_KEY_ACCEPT, HEADER_VALUE_ACCEPT).response();
	}

	protected PlainHttpResponse responsePUT(String url, String body) {
		return new PlainHttpClient().put(url)
				.basicAuth(config.adminUser, config.adminPass)
				.header(HEADER_KEY_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE)
				.body(body).response();
	}

	protected PlainHttpResponse responseDELETE(String url) {
		return new PlainHttpClient().delete(url)
				.basicAuth(config.adminUser, config.adminPass)
				.header(HEADER_KEY_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE)
				.response();
	}

	protected PlainHttpResponse responsePOST(String url, String body) {
		return new PlainHttpClient().post(url)
				.basicAuth(config.adminUser, config.adminPass)
				.header(HEADER_KEY_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE)
				.body(body).response();
	}
}
