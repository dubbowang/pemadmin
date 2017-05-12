package com.qinke.pemadmin.base;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinke.pemadmin.utils.ResponseModel;
import com.qinke.pemadmin.utils.SerializeModelToJson;

public class BaseResources {

	protected static final ObjectMapper mapper = new ObjectMapper();

	protected static final String ACCESS_TOEKN = "access_token";

	protected static final SimpleDateFormat shorSdf = new SimpleDateFormat("yyyy-MM-dd");

	protected static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected static final String MIME_JSON = MediaType.APPLICATION_JSON + ";charset=UTF-8";

	protected static DecimalFormat df = new DecimalFormat("#.##");

	public ObjectMapper getObjectMapper() {

		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return mapper;
	}

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	protected String toJson(Object serializable) {

		mapper.setSerializationInclusion(Include.NON_EMPTY);

		String result = null;

		try {
			result = mapper.writeValueAsString(serializable);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}


	protected ResponseModel responseModel;

	protected String responseJson;

	/*
	 * 自定义结果返回值
	 */
	protected String getJsonResponse(Object resultData) {

		return SerializeModelToJson.serializeModelToJson(getResponseModel(resultData));
	}

	/*
	 * 有结果返回值
	 */
	protected ResponseModel getResponseModel(Object resultData) {

		ResponseModel responseModel = new ResponseModel();
		if(resultData == null){

			responseModel = getResponseModel("data", "Not find data" ,null);
		} else {

			responseModel = getResponseModel("data", "successful" ,resultData);
		}

		return responseModel;
	}

	/*
	 * 自定义结果返回值
	 */
	protected ResponseModel getResponseModel(String resultType, String resultMsg,Object resultData) {

		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponseType(resultType);
		responseModel.setResponseMessage(resultMsg);
		responseModel.setResponseStatusCode(200);
		responseModel.setResponseBody(resultData);
		return responseModel;
	}

	/*
	 * 通用异常返回值
	 */
	protected String getErrorJsonResponse() {

		return SerializeModelToJson.serializeModelToJson(getErrorResponse(500 , "系统异常，请联系系统管理员"));
	}

	/*
	 * 通用异常返回值
	 */
	protected ResponseModel getErrorResponse() {

		return getErrorResponse(500 , "系统异常，请联系系统管理员");
	}

	/*
	 * 自定义异常返回值
	 */
	protected ResponseModel getErrorResponse(int code, String errorMsg) {

		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponseType("error");
		responseModel.setResponseMessage(errorMsg);
		responseModel.setResponseStatusCode(code);
		return responseModel;
	}

}
