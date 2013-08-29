package com.ramytech.rabbitmq.management.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

	public static final String KEY_USER = "name";
	public static final String KEY_PASS = "password";
	public static final String KEY_PASSHASH = "password_hash";
	public static final String KEY_TAGS = "tags";

	public String user = null;
	public String pass = null;
	public String passHash = null;
	public String tags = null;

	public User fromJSON(JSONObject jo) {
		try {
			user = jo.getString(KEY_USER);
		} catch (JSONException e) {
		}
		try {
			pass = jo.getString(KEY_PASS);
		} catch (JSONException e) {
		}
		try {
			passHash = jo.getString(KEY_PASSHASH);
		} catch (JSONException e) {
		}
		try {
			tags = jo.getString(KEY_TAGS);
		} catch (JSONException e) {
		}
		return this;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		if (user != null) {
			try {
				jo.put(KEY_USER, user);
			} catch (JSONException e) {
			}
		}
		if (pass != null) {
			try {
				jo.put(KEY_PASS, pass);
			} catch (JSONException e) {
			}
		}

		if (passHash != null) {
			try {
				jo.put(KEY_PASSHASH, passHash);
			} catch (JSONException e) {
			}
		}

		if (tags != null) {
			try {
				jo.put(KEY_TAGS, tags);
			} catch (JSONException e) {
			}
		}
		return jo;
	}
}
