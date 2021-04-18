package com.zk.rest.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author zengkui
 * @description 利用jackson实现：bean转json格式或者json转bean格式
 * @date 2020/9/10 下午1:47
 */
public class JacksonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String beanToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }

        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("jackson序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
        try {
            logger.info("反序列化字符串：" + jsonStr);
            return mapper.readValue(jsonStr, objClass);
        } catch (Exception e) {
            logger.error("jackson反序列化出错：", e);
            return null;
        }
    }

    public static <T> T mapToBean(Map map, Class<T> objClass) {
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.convertValue(map, objClass);
        } catch (Exception e) {
            logger.error("jackson mapToBean 发送异常：", e);
            return null;
        }
    }

}