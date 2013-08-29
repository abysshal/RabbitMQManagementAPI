package com.ramytech.rabbitmq.management.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

public class PlainHttpClient {

	public static HttpClient httpClient = new DefaultHttpClient();

	HttpUriRequest request = null;

	public PlainHttpClient get(String url) {
		request = new HttpGet(url);
		return this;
	}

	public PlainHttpClient put(String url) {
		request = new HttpPut(url);
		return this;
	}

	public PlainHttpClient post(String url) {
		request = new HttpPost(url);
		return this;
	}

	public PlainHttpClient delete(String url) {
		request = new HttpDelete(url);
		return this;
	}

	public PlainHttpClient basicAuth(String username, String password) {
		header("Authorization",
				"Basic "
						+ Base64.encodeBase64String((username + ":" + password)
								.getBytes()));
		return this;
	}

	public PlainHttpClient header(String key, String value) {
		if (this.request == null) {
			return this;
		}
		request.addHeader(key, value);
		return this;
	}

	public PlainHttpClient body(String body) {
		try {
			((HttpEntityEnclosingRequestBase) request)
					.setEntity(new StringEntity(body, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this;
	}

	public PlainHttpResponse response() {
		this.prepare();
		try {
			HttpResponse response = httpClient.execute(request);
			return new PlainHttpResponse(response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void prepare() {
		request.addHeader("user-agent", "ramyhc-java/0.3");
		request.getParams().setIntParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 60000);
		request.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT,
				60000);
	}

}
