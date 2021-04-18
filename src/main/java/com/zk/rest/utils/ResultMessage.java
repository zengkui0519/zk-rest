package com.zk.rest.utils;


import java.io.Serializable;

public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 6990626235592288017L;
    private static final String RESPONSE_CODE_SUCCESS_DEFAULT = "S_SYS_000000";//"S000000";
    /**
     * 默认失败编号：E000000
     */
    private static final String RESPONSE_CODE_ERROR_DEFAULT = "E_SYS_000000";

    public static final ResultMessage SUCCESS = new ResultMessage(RESPONSE_CODE_SUCCESS_DEFAULT, ResponseCode.Result.SUCCESS.getDesc(), true);
    public static final ResultMessage FAILURE = new ResultMessage(RESPONSE_CODE_ERROR_DEFAULT, ResponseCode.Result.FAIL.getDesc());
    public static final ResultMessage ESBSUCCESS = new ResultMessage(ResponseCode.Result.ESBSUCCESS.getCode(), ResponseCode.Result.ESBSUCCESS.getDesc(), true);

    /**
     * 响应码
     */
    protected String code;
    /**
     * 响应消息
     */
    protected String msg;
    /**
     * 响应数据
     */
    protected Object data;
    /**
     * 反调函数
     */
    protected String callFunction;
    /**
     * 反调函数参数
     */
    protected String[] callParams;
    /**
     * 国际化编码
     */
    protected String i18Template;
    /**
     * 国际化编码参数
     */
    protected String[] i18Params;
    /**
     * 是否为成功状态
     */
    protected boolean success;

    public ResultMessage() {
    }

    /**
     * success
     *
     * @param data
     */
    public ResultMessage(Object data) {
        this(RESPONSE_CODE_SUCCESS_DEFAULT, ResponseCode.Result.SUCCESS.getDesc(), data, true);
    }

    public ResultMessage(String code, String msg) {
        this(code, msg, null, false);
    }

    public ResultMessage(String code, String msg, boolean success) {

        this(code, msg, null, success);
    }

    public ResultMessage(String code, String msg, Object data, boolean success) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCallFunction() {
        return callFunction;
    }

    public ResultMessage setCallFunction(String callFunction) {
        this.callFunction = callFunction;
        return this;
    }

    public String[] getCallParams() {
        return callParams;
    }

    public ResultMessage setCallParams(String[] callParams) {
        this.callParams = callParams;
        return this;
    }

    public String getI18Template() {
        return i18Template;
    }

    public ResultMessage setI18Template(String i18Template) {
        this.i18Template = i18Template;
        return this;
    }

    public String[] getI18Params() {
        return i18Params;
    }

    public ResultMessage setI18Params(String[] i18Params) {
        this.i18Params = i18Params;

        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
