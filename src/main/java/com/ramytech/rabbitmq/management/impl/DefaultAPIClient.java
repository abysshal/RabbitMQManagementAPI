package com.ramytech.rabbitmq.management.impl;

import java.net.URLEncoder;

import org.json.JSONArray;

import com.ramytech.rabbitmq.management.RabbitMQAPIClient;
import com.ramytech.rabbitmq.management.RabbitMQAPIClientConfig;
import com.ramytech.rabbitmq.management.entity.Binding;
import com.ramytech.rabbitmq.management.entity.Permission;
import com.ramytech.rabbitmq.management.entity.User;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public class DefaultAPIClient extends BasicAPIClient implements
		RabbitMQAPIClient {

	public DefaultAPIClient(RabbitMQAPIClientConfig config) {
		super(config);
	}

	public PlainHttpResponse getUser(String user) {
		return responseGET(APIUtil.getUserURL(config.apiUrl, user));
	}

	public PlainHttpResponse createUser(User user) {
		return responsePUT(APIUtil.getUserURL(config.apiUrl, user.user), user
				.toJSON().toString());
	}

	public PlainHttpResponse deleteUser(String user) {
		return responseDELETE(APIUtil.getUserURL(config.apiUrl, user));
	}

	public PlainHttpResponse getUserPermission(String user) {
		return responseGET(APIUtil.getPermissionURL(config.apiUrl,
				config.vhost, user));
	}

	public PlainHttpResponse createUserPermission(String user,
			Permission permission) {
		return responsePUT(
				APIUtil.getPermissionURL(config.apiUrl, config.vhost, user),
				permission.toJSON().toString());
	}

	public PlainHttpResponse getExchangeBinding(String source, String dest) {
		return responseGET(APIUtil.getExchangeBindingURL(config.apiUrl,
				config.vhost, source, dest));
	}

	public PlainHttpResponse createExchangeBinding(String source, String dest,
			String routingKey) {
		Binding binding = new Binding();
		binding.routingKey = routingKey;
		binding.arguments = new JSONArray();
		return responsePOST(APIUtil.getExchangeBindingURL(config.apiUrl,
				config.vhost, source, dest), binding.toJSON().toString());
	}

	public PlainHttpResponse getExchanges() {
		StringBuilder sb = new StringBuilder();
		sb.append(config.apiUrl);
		sb.append("/exchanges/");
		sb.append(URLEncoder.encode(config.vhost));
		sb.append("?columns=name");
		return responseGET(sb.toString());
	}
}
