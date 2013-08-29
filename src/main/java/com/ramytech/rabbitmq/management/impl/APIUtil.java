package com.ramytech.rabbitmq.management.impl;

import java.net.URLEncoder;

public class APIUtil {
	public static String getUserURL(String rootUrl, String user) {
		StringBuilder sb = new StringBuilder();
		sb.append(rootUrl);
		sb.append("/users/");
		sb.append(user);
		return sb.toString();
	}

	public static String getPermissionURL(String rootUrl, String vhost,
			String user) {
		StringBuilder sb = new StringBuilder();
		sb.append(rootUrl);
		sb.append("/permissions/");
		sb.append(URLEncoder.encode(vhost));
		sb.append("/");
		sb.append(user);
		return sb.toString();
	}

	public static String getExchangeBindingURL(String rootUrl, String vhost,
			String source, String dest) {
		StringBuilder sb = new StringBuilder();
		sb.append(rootUrl);
		sb.append("/bindings/");
		sb.append(URLEncoder.encode(vhost));
		sb.append("/e/");
		sb.append(source);
		sb.append("/e/");
		sb.append(dest);
		return sb.toString();
	}

}
