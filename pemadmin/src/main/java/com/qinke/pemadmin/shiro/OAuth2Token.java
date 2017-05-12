package com.qinke.pemadmin.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class OAuth2Token implements AuthenticationToken {

	private static final long serialVersionUID = -1783084016084237662L;

	private String accessToken;
    private String principal;

    public OAuth2Token() {

    }

	public OAuth2Token(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipal() {
		return principal;
	}

	@Override
	public Object getCredentials() {
		return accessToken;
	}
}
