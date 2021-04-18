package com.zk.rest.response;

import java.io.Serializable;
import java.util.Map;

/**
 * 数据直报返回实体类
 */
public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SUCCESS_CODE = "S_SYS_000000";
    private static final String SUCCESS_DESC = "成功";
    public static final String FAIL_CODE = "E_SYS_000000";
    private static final String FAIL_DESC = "失败";

    /**
     * 报文头
     */
    private Head head;

    /**
     * 报文体
     */
    private Object body;

    public ResultData(Map<String, Object> myHead, String rspCode, String rspDesc, Object body) {
        this.head = new Head(myHead, rspCode, rspDesc);
        this.body = body;
    }

    /**
     * 成功
     */
    public static ResultData success() {
        return new ResultData(null, SUCCESS_CODE, SUCCESS_DESC, "");
    }

    /**
     * 成功
     */
    public static ResultData success(Object body) {
        return new ResultData(null, SUCCESS_CODE, SUCCESS_DESC, body);
    }

    /**
     * 成功
     */
    public static ResultData success(Map<String, Object> myHead, Object body) {
        return new ResultData(myHead, SUCCESS_CODE, SUCCESS_DESC, body);
    }

    /**
     * 成功或失败
     */
    public static ResultData finish(Map<String, Object> head, String rspCode, String rspDesc, Object body) {
        return new ResultData(head, rspCode, rspDesc, body);
    }

    /**
     * 失败
     */
    public static ResultData fail() {
        return new ResultData(null, FAIL_CODE, FAIL_DESC, "");
    }

    /**
     * 失败
     */
    public static ResultData fail(String rspCode, String rspDesc) {
        return new ResultData(null, rspCode, rspDesc, "");
    }

    /**
     * 失败
     */
    public static ResultData fail(Map<String, Object> myHead, String rspCode, String rspDesc) {
        return new ResultData(myHead, rspCode, rspDesc, "");
    }

    /**
     * 失败
     */
    public static ResultData fail(Map<String, Object> myHead) {
        return new ResultData(myHead, FAIL_CODE, FAIL_DESC, "");
    }

    /**
     * 失败
     */
    public static ResultData fail(Map<String, Object> myHead, Object body) {
        return new ResultData(myHead, FAIL_CODE, FAIL_DESC, body);
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
