package com.qinke.pemadmin.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.common.utils.StringUtils;

@Component
public class OAuth2AuthenticationFilter extends AccessControlFilter {

	private String accessTokenParam = "access_token";

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest req = WebUtils.toHttp(request);
        req.getHeaderNames();
        Cookie [] cookies = req.getCookies();
        String access_token = "";
        if (cookies != null) {
	        for (Cookie cookie : cookies) {
	        	if (cookie.getName().equals(accessTokenParam)) {
	        		access_token = cookie.getValue();
	        		break;
	        	}
			}
        }

        if (StringUtils.isBlank(access_token)) {
        	access_token = req.getHeader("access_token");
        }

        if (StringUtils.isBlank(access_token)) {
        	onLoginFail(response);
        	return false;
        }

        OAuth2Token oAuth2Token = new OAuth2Token(access_token);

        try {
            getSubject(request, response).login(oAuth2Token);
        } catch (Exception e) {
            e.printStackTrace();
            onLoginFail(response);
            return false;
        }
        return true;
    }

    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		return false;
	}
}
