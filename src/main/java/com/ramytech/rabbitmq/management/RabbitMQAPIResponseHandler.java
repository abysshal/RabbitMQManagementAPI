package com.ramytech.rabbitmq.management;

import com.ramytech.rabbitmq.management.entity.Binding;
import com.ramytech.rabbitmq.management.entity.Permission;
import com.ramytech.rabbitmq.management.entity.User;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public interface RabbitMQAPIResponseHandler {

	public User getUser(PlainHttpResponse response);

	public boolean createUser(PlainHttpResponse response);

	public boolean deleteUser(PlainHttpResponse response);

	public Permission getUserPermission(PlainHttpResponse response);

	public boolean createUserPermission(PlainHttpResponse response);

	public Binding getExchangeBinding(PlainHttpResponse response);

	public boolean createExchangeBinding(PlainHttpResponse response);
}
