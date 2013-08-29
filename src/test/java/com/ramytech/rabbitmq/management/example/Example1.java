package com.ramytech.rabbitmq.management.example;

import org.json.JSONException;

import com.ramytech.rabbitmq.management.RabbitMQAPIClient;
import com.ramytech.rabbitmq.management.RabbitMQAPIClientConfig;
import com.ramytech.rabbitmq.management.RabbitMQAPIFactory;
import com.ramytech.rabbitmq.management.RabbitMQAPIResponseHandler;
import com.ramytech.rabbitmq.management.entity.User;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public class Example1 {
	public static void main(String[] args) throws JSONException {
		RabbitMQAPIClientConfig config = new RabbitMQAPIClientConfig();
		config.apiUrl = "http://xxx:15672/api";
		config.adminUser = "admin";
		config.adminPass = "admin";
		config.vhost = "/";

		RabbitMQAPIClient client = RabbitMQAPIFactory.getAPIClient(config);
		RabbitMQAPIResponseHandler responseHandler = RabbitMQAPIFactory
				.getAPIResponseHandler();

		PlainHttpResponse response = client.getUser("admin");
		System.out.println(response.getCode());
		System.out.println(response.getBody());

		User user = new User();
		user.user = "test111";
		user.pass = "test111";
		user.tags = "";

		response = client.createUser(user);
		System.out.println(response.getCode());
		System.out.println(response.getBody());

		// response = client.deleteUser(user.user);
		// System.out.println(response.code);
		// System.out.println(response.body);

		// response = client.getUserPermission(user.user);
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());
		//
		// Permission permission = new Permission().fromJSON(new JSONObject(
		// response.getBody()));
		// permission.configure += ".*";
		// response = client.createUserPermission(user.user, permission);
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());
		// response = client.getUserPermission(user.user);
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());

		// response = client.getExchangeBinding("TESTCW", "TESTEX");
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());
		//
		// response = client.createExchangeBinding("TESTCW", "TESTEX");
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());
		//
		// response = client.getExchangeBinding("TESTCW", "TESTEX");
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());

		// response = client.getExchanges();
		// System.out.println(response.getCode());
		// System.out.println(response.getBody());
	}

}
