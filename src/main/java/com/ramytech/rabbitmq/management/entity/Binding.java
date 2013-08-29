package com.ramytech.rabbitmq.management.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Binding {

	public static final String KEY_ROUTING_KEY = "routing_key";
	public static final String KEY_ARGUMENTS = "arguments";

	public String routingKey;
	public JSONArray arguments;

	public Binding fromJSON(JSONObject jo) {
		try {
			this.routingKey = jo.getString(KEY_ROUTING_KEY);
		} catch (JSONException e) {
		}

		try {
			this.arguments = jo.getJSONArray(KEY_ARGUMENTS);
		} catch (JSONException e) {
		}
		return this;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		try {
			jo.put(KEY_ROUTING_KEY, routingKey);
		} catch (JSONException e) {
		}
		try {
			jo.put(KEY_ARGUMENTS, arguments);
		} catch (JSONException e) {
		}
		return jo;
	}
}
