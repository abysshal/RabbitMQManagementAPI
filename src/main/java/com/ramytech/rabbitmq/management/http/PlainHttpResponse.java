package com.ramytech.rabbitmq.management.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class PlainHttpResponse {

	HttpResponse response;
	int code = 403;
	String body = "";

	public PlainHttpResponse(HttpResponse response) {
		this.response = response;

		this.code = this.response.getStatusLine().getStatusCode();
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			try {
				byte[] rawBody = getBytes(responseEntity.getContent());
				this.body = new String(rawBody);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int getCode() {
		return this.code;
	}

	public String getBody() {
		return this.body;
	}

	private static byte[] getBytes(InputStream is) throws IOException {
		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

}
