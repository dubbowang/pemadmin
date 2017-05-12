package com.qinke.pemadmin.api.base;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper mapper;

	static {
		ObjectMapper mapper = new ObjectMapper();
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	public BaseService() {
		this.getObjectMapper();
	}

	/**
	 * 序列化使用.
	 */
	public ObjectMapper getObjectMapper() {

		return mapper;

	}

	protected JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

}
