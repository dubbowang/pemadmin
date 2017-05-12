package com.qinke.pemadmin.shiro;
import java.text.SimpleDateFormat;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinke.pemadmin.utils.OauthProp;
@Component
public class OAuth2Realm extends AuthorizingRealm {

	private final static ObjectMapper mapper = new ObjectMapper();

	/*@Autowired
	private UserInfoService userService;*/

	@Autowired
	private OauthProp oAuthProp;

	public OAuth2Realm() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
	}

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token; //表示此Realm只支持OAuth2Token类型
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /* String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = userService.getUserRoles(username, oAuthProp.getClient_id());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        return authorizationInfo;*/
    	return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*OAuth2Token oAuth2Token = (OAuth2Token) token;
        String accessToken = oAuth2Token.getAccessToken();
        UserInfo userInfo = extractUsername(accessToken);

        if (userInfo == null || StringUtils.isBlank(userInfo.getPassWord())) {
        	throw new IncorrectCredentialsException();
        }

        String username = userInfo.getUserName();

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, accessToken, getName());

        return authenticationInfo;*/
    	return null;
    }

}
