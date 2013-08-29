package com.ramytech.rabbitmq.management.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ramytech.rabbitmq.management.RabbitMQAPIResponseHandler;
import com.ramytech.rabbitmq.management.entity.Binding;
import com.ramytech.rabbitmq.management.entity.Permission;
import com.ramytech.rabbitmq.management.entity.User;
import com.ramytech.rabbitmq.management.http.PlainHttpResponse;

public class DefaultAPIResponseHandler implements RabbitMQAPIResponseHandler {
	public User getUser(PlainHttpResponse response) {
		if (response.getCode() != 200) {
			return null;
		}
		User usr = null;
		try {
			usr = new User().fromJSON(new JSONObject(response.getBody()));
		} catch (JSONException e) {
		}
		return usr;
	}

	public boolean createUser(PlainHttpResponse response) {
		if (response.getCode() != 204) {
			return false;
		}
		return true;
	}

	public boolean deleteUser(PlainHttpResponse response) {
		if (response.getCode() != 204 && response.getCode() != 404) {
			return false;
		}
		return true;
	}

	public Permission getUserPermission(PlainHttpResponse response) {
		if (response.getCode() != 200) {
			return null;
		}
		Permission permission = null;
		try {
			permission = new Permission().fromJSON(new JSONObject(response
					.getBody()));
		} catch (JSONException e) {
		}
		return permission;
	}

	public boolean createUserPermission(PlainHttpResponse response) {
		if (response.getCode() != 204) {
			return false;
		}
		return true;
	}

	public Binding getExchangeBinding(PlainHttpResponse response) {
		if (response.getCode() != 200) {
			return null;
		}
		try {
			JSONArray ja = new JSONArray(response.getBody());
			if (ja == null || ja.length() <= 0) {
				return null;
			}
			return new Binding().fromJSON(ja.getJSONObject(0));
		} catch (JSONException e) {
			return null;
		}
	}

	public boolean createExchangeBinding(PlainHttpResponse response) {
		if (response.getCode() != 201) {
			return false;
		}
		return true;
	}
}
