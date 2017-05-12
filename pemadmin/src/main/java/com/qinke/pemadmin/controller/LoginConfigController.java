package com.qinke.pemadmin.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qinke.pemadmin.api.TestService;
import com.qinke.pemadmin.base.BaseResources;
import com.qinke.pemadmin.utils.LogUtil;
import com.qinke.pemadmin.utils.OauthProp;
import com.qinke.pemadmin.utils.ResponseModel;
import com.qinke.pemadmin.viewmodel.OauthInfo;

@RequestMapping("/oauth/config")
@RestController
public class LoginConfigController extends BaseResources {

    @Autowired
    private OauthProp oAuthProp;

    @Autowired
    private TestService testServiceImpl;
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseModel get() {
    	String test = testServiceImpl.test();
    	System.out.println(test);
        OauthInfo oauthInfo = new OauthInfo();
        oauthInfo.setClient_id(oAuthProp.getClient_id());
        oauthInfo.setClient_secret(oAuthProp.getClient_secret());
        oauthInfo.setGrant_type(oAuthProp.getGrant_type());
        oauthInfo.setOauth_accesstoken_rul(oAuthProp.getOauth_accesstoken_rul());
        oauthInfo.setRedirect_uri(oAuthProp.getRedirect_uri());
        oauthInfo.setResponse_type(oAuthProp.getResponse_type());
        oauthInfo.setUser_resources_rul(oAuthProp.getUser_resources_rul());
        oauthInfo.setLogin_resources_rul(oAuthProp.getLogin_resources_rul());
        oauthInfo.setSys_rul(oAuthProp.getSys_rul());

        String result = "";

        try {
            result = mapper.writeValueAsString(oauthInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LogUtil.error(e);
        }

        return getResponseModel(result);
    }

    @RequestMapping(value = "/get/anon", method = RequestMethod.GET)
    public ResponseModel getAnon() {
        OauthInfo oauthInfo = new OauthInfo();
        oauthInfo.setClient_id(oAuthProp.getClient_id());
        oauthInfo.setClient_secret(oAuthProp.getClient_secret());
        oauthInfo.setGrant_type(oAuthProp.getGrant_type());
        oauthInfo.setOauth_accesstoken_rul(oAuthProp.getOauth_accesstoken_rul());
        oauthInfo.setRedirect_uri(oAuthProp.getRedirect_uri());
        oauthInfo.setResponse_type(oAuthProp.getResponse_type());
        oauthInfo.setUser_resources_rul(oAuthProp.getUser_resources_rul());
        oauthInfo.setLogin_resources_rul(oAuthProp.getLogin_resources_rul());
        oauthInfo.setSys_rul(oAuthProp.getSys_rul());

        String result = "";

        try {
            result = mapper.writeValueAsString(oauthInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LogUtil.error(e);
        }

        return getResponseModel(result);
    }

    @SuppressWarnings("unused")
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public ResponseModel update(String content) {

        OauthInfo oauthInfo = null;

        try {
            oauthInfo = mapper.readValue(content, OauthInfo.class);
        } catch (IOException e1) {
            e1.printStackTrace();
            LogUtil.error(e1);
        }

        return getResponseModel("保存成功");
    }

    @SuppressWarnings("unused")
    private void updateProperties(String key, String value) {
        Properties props = new Properties();
        ClassLoader classLoader = LoginConfigController.class.getClassLoader();
        InputStream propResourceStream = classLoader.getResourceAsStream("META-INF/oauth.properties");
        try {
            props.load(propResourceStream);
            propResourceStream.close();
            props.setProperty(key, value);
            OutputStream fos = new FileOutputStream(Thread.currentThread().getContextClassLoader()
                    .getResource("META-INF/oauth.properties").getPath());
            props.store(fos, "");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error(e);
        }
    }

}
