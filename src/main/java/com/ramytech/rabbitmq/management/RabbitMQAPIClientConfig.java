package com.ramytech.rabbitmq.management;

import java.util.Properties;

public class RabbitMQAPIClientConfig {
	public static final String KEY_API_URL = "RM.ApiUrl";
	public static final String KEY_ADMIN_USER = "RM.AdminUser";
	public static final String KEY_ADMIN_PASS = "RM.AdminPass";
	public static final String KEY_VHOST = "RM.Vhost";

	public String apiUrl;
	public String adminUser;
	public String adminPass;
	public String vhost;

	public RabbitMQAPIClientConfig fromProperties(Properties prop) {
		this.apiUrl = prop.getProperty(KEY_API_URL);
		this.adminUser = prop.getProperty(KEY_ADMIN_USER);
		this.adminPass = prop.getProperty(KEY_ADMIN_PASS);
		this.vhost = prop.getProperty(KEY_VHOST);
		return this;
	}

	public Properties toProperties() {
		Properties prop = new Properties();
		prop.put(KEY_API_URL, this.apiUrl);
		prop.put(KEY_ADMIN_USER, this.adminUser);
		prop.put(KEY_ADMIN_PASS, this.adminPass);
		prop.put(KEY_VHOST, this.vhost);
		return prop;
	}
}
