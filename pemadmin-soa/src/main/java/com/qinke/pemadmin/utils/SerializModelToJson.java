package com.qinke.pemadmin.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializModelToJson {

    private static ObjectMapper mapper;

    /**
     *序列化方法.
     * @param model 序列化model
     * @return 序列化结果
     */
    public static String serializeModelToJson(Object model) {

        if (mapper == null) {

            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_EMPTY);
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }

        String json = null;
        try {

            json = mapper.writeValueAsString(model);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return json;
    }
}
