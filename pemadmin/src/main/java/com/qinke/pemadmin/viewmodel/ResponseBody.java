package com.qinke.pemadmin.viewmodel;

import java.io.Serializable;

public class ResponseBody implements Serializable {

	private static final long serialVersionUID = 2260000745396422570L;

	private String uid;

	private long expires_in;

	private long refreshtoken_expire_in;

	private String refresh_token;

	private String access_token;

	private String result;

	private int status;

	private String code;

	private String app_secret;

	private String app_id;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	public long getRefreshtoken_expire_in() {
		return refreshtoken_expire_in;
	}

	public void setRefreshtoken_expire_in(long refreshtoken_expire_in) {
		this.refreshtoken_expire_in = refreshtoken_expire_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getApp_secret() {
		return app_secret;
	}

	public void setApp_secret(String app_secret) {
		this.app_secret = app_secret;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
}
