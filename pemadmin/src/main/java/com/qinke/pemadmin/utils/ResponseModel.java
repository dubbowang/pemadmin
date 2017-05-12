package com.qinke.pemadmin.utils;

import java.io.Serializable;

/**
 * 通用返回信息
 */
public class ResponseModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7909316060760037692L;

	/**
	 * 是否成功执行(是否有数据)
	 */
	private String responseType;

	/**
	 * 返回信息（成功信息或错误信息）
	 */
	private String responseMessage;

	/**
	 * 返回状态码
	 */
	private int responseStatusCode;

	/**
	 * 返回结果数据
	 */
	private Object responseBody;

	public ResponseModel() {

	}

	public ResponseModel(String responseType, int responseTypeCode) {

		this.responseType = responseType;
		this.responseStatusCode = responseTypeCode;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

}
