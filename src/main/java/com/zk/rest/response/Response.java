package com.zk.rest.response;

import com.zk.rest.utils.JacksonUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guyegui
 * @Desc 用于前端ajax请求或webservice接口请求后台响应的实体类
 * @date 2018年4月16日 上午11:14:01
 */
@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -1757271887959497135L;
    private static Logger logger = LoggerFactory.getLogger(Response.class);

    // 是否成功
    private boolean succeed;

    // 状态码
    private String returnCode;

    // 描述
    private String returnDesc;

    // 响应内容
    private String returnData;

    public Response() {
        this.succeed = true;
    }

    public Response(Object returnData) {
        this(true, ResponseCode.RESPONSE_CODE_SUCCESS_DEFAULT, ResponseCode.Result.SUCCESS.getDesc(), JacksonUtil.beanToJson(returnData));
    }

    public Response(String returnCode, String returnDesc) {
        this(returnCode, returnDesc, new String());
    }

    public Response(String returnCode, String returnDesc, Object returnData) {
        this(false, returnCode, returnDesc, returnData);
    }

    public Response(boolean succeed, String returnCode, String returnDesc, Object returnData) {
        this.succeed = succeed;
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
        this.returnData = new BASE64Encoder().encode(JacksonUtil.beanToJson(returnData).getBytes()).replace("\r", "").replace("\n", "");
    }

    public static Response success(Map<String, Object> head, Map<String, Object> body) {
        Map<String, Object> result = new HashMap<>();
        result.put("head", head);
        result.put("body", body);
        logger.info("转码前的响应报文: " + JacksonUtil.beanToJson(result));
        return new Response(result);
    }

    public static Response fail(Map<String, Object> head, String rspCode, String rspDesc, Map<String, Object> body) {
        Map<String, Object> result = new HashMap<>();
        head.put("rspCode", rspCode);
        head.put("rspDesc", rspDesc);

        result.put("head", head);
        if (null != body) {
            result.put("body", body);
        }
        logger.info("转码前的响应报文: " + JacksonUtil.beanToJson(result));
        return new Response(result);
    }

}
