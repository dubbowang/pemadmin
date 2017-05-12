package com.qinke.pemadmin.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClient {

    public static String post(String url, Map<String, String> params) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String body = null;

        HttpPost post = postForm(url, params);
        body = invoke(httpclient, post);

        httpclient.getConnectionManager().shutdown();

        return body;
    }

    private static String invoke(DefaultHttpClient httpclient, HttpUriRequest httpost) {

        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);

        return body;
    }

    private static String paseResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        String body = null;
        try {
            body = EntityUtils.toString(entity);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpPost postForm(String url, Map<String, String> params) {

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtil.error(e);
        }

        return httpost;
    }

    private static HttpResponse sendRequest(DefaultHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            LogUtil.error(e);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error(e);
        }
        return response;
    }

    public static String loadClaim() {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new FileReader("D://claim.txt");
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }

        } catch (Exception e) {
        } finally {
            try {
                bufferedReader.close();
                reader.close();
            } catch (Exception e) {
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String claim = loadClaim();
        Map<String, String> params = new HashMap<String, String>();
        params.put("claim", claim);
        String entity = HttpClient.paramHttp("http://172.16.101.38:8082/check-claim/api/v2/checkClaim/claimImport", claim);
        System.out.println(entity);
    }

    public static String paramHttp(String url,String claim) {
        OutputStreamWriter out = null;
        try {
            HttpPost postRequest = new HttpPost(url);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            StringEntity input = new StringEntity(claim, "utf-8");
            input.setContentType("application/json;charset=utf-8");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            response.getStatusLine().getStatusCode();
            String resultString = EntityUtils.toString(response.getEntity());
            return resultString ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "" ;
    }
}
