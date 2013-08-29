package com.ramytech.rabbitmq.management;

import com.ramytech.rabbitmq.management.entity.Permission;
import com.ramytech.rabbitmq.management.entity.User;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public interface RabbitMQAPIClient {

	public PlainHttpResponse getUser(String user);

	public PlainHttpResponse createUser(User user);

	public PlainHttpResponse deleteUser(String user);

	public PlainHttpResponse getUserPermission(String user);

	public PlainHttpResponse createUserPermission(String user,
			Permission permission);

	public PlainHttpResponse getExchangeBinding(String source, String dest);

	public PlainHttpResponse createExchangeBinding(String source, String dest,
			String routingKey);

	public PlainHttpResponse getExchanges();

}
