package com.ramytech.rabbitmq.management.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class Permission {

	public static final String KEY_USER = "user";
	public static final String KEY_VHOST = "vhost";
	public static final String KEY_CONFIGURE = "configure";
	public static final String KEY_WRITE = "write";
	public static final String KEY_READ = "read";

	public String user = null;
	public String vhost = null;
	public String configure = null;
	public String write = null;
	public String read = null;

	public Permission fromJSON(JSONObject jo) {
		try {
			user = jo.getString(KEY_USER);
		} catch (JSONException e) {
		}
		try {
			vhost = jo.getString(KEY_VHOST);
		} catch (JSONException e) {
		}
		try {
			configure = jo.getString(KEY_CONFIGURE);
		} catch (JSONException e) {
		}
		try {
			write = jo.getString(KEY_WRITE);
		} catch (JSONException e) {
		}
		try {
			read = jo.getString(KEY_READ);
		} catch (JSONException e) {
		}
		return this;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		try {
			jo.put(KEY_USER, user);
		} catch (JSONException e) {
		}
		try {
			jo.put(KEY_VHOST, vhost);
		} catch (JSONException e) {
		}
		try {
			jo.put(KEY_CONFIGURE, configure);
		} catch (JSONException e) {
		}
		try {
			jo.put(KEY_WRITE, write);
		} catch (JSONException e) {
		}
		try {
			jo.put(KEY_READ, read);
		} catch (JSONException e) {
		}
		return jo;
	}

	public boolean isPermissionEqual(Permission permission) {
		if (configure == null || write == null || read == null) {
			return false;
		}
		if (permission.configure == null || permission.write == null
				|| permission.read == null) {
			return false;
		}
		if (!configure.equals(permission.configure)) {
			return false;
		}
		if (!write.equals(permission.write)) {
			return false;
		}
		if (!read.equals(permission.read)) {
			return false;
		}
		return true;
	}

	public Permission clone() {
		Permission permission = new Permission();
		permission.user = user == null ? null : user.toString();
		permission.vhost = vhost == null ? null : vhost.toString();
		permission.configure = configure == null ? null : configure.toString();
		permission.write = write == null ? null : write.toString();
		permission.read = read == null ? null : read.toString();
		return permission;
	}
}
