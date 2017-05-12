package com.qinke.pemadmin.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeModelToJson {

	private static ObjectMapper mapper;

	public static String serializeModelToJson(Object model) {

		if (mapper == null) {

			mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_EMPTY);
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
//			mapper.registerModule(new JaxbAnnotationModule());
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}

		String json = null;
		try {

			json = mapper.writeValueAsString(model);

		} catch (Exception exception) {

			LogUtil.error(exception);
		}

		return json;
	}

	public static ObjectMapper getMapper(){
		if(mapper != null){

			return mapper;
		}

		mapper = new ObjectMapper();
		mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
//		mapper.registerModule(new JaxbAnnotationModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
		return mapper;
	}
}

