package com.zk.rest.utils;

public interface ResponseCode {


    /**
     * 默认成功编号：S_SYS_000000
     */
    String RESPONSE_CODE_SUCCESS_DEFAULT = "S_SYS_000000";//"S000000";
    String RESPONSE_CODE_SUCCESS_FOROA = "S000A000";
    /**
     * 默认成功信息：成功
     */
    String RESPONSE_MSG_SUCCESS_DEFAULT = "成功";

    /**
     * 默认失败编号：E000000
     */
    String RESPONSE_CODE_ERROR_DEFAULT = "E_SYS_000000";
    String RESPONSE_CODE_ERROR_404 = "E_SYS_000404";
    String RESPONSE_CODE_ERROR_500 = "E_SYS_000500";

    /**
     * 参数不能为空
     */
    String ERROR_PARMA_NULL = "E_SYS_000001";


    /**
     * 用户名称和密码错误
     */
    String ERROR_NAME_PWD = "E_SYS_000002";

    /**
     * Session超时或者未登录
     */
    String ERROR_SESSION_NO_LOGIN = "E_SYS_000003";
    /**
     * 当前用户不存在
     */
    String ERROR_OBJECT_NULL = "E_SYS_000004";

    /**
     * 服务器异常，请联系管理员
     */
    String ERROR_SERVER_CODE = "E_SYS_000005";

    ResultMessage RM_RELOGIN = new ResultMessage(ERROR_SESSION_NO_LOGIN, "未有登录，可能超时或者未登录，跳转登录界面");

    public enum Result {
        /**
         * S_SYS_000000 ：成功
         */
        SUCCESS("S_SYS_000000", "操作成功"),
        /**
         * S_SYS_000404：请求不存在
         */
        NOFOUND("S_SYS_000404", "请求不存在！"),
        /**
         * S_SYS_000500：程序执行异常
         */
        ERROR("S_SYS_000500", "程序执行异常！"),
        /**
         * S_SYS_000001：会话超时
         */
        TIMEOUT("S_SYS_000001", "会话超时！"),

        /**
         * E_SYS_000000：失败
         */
        FAIL("E_SYS_000000", "失败!"),
        /**
         * E_SYS_000002：用户名或密码错误
         */
        userOrPasswordError("E_SYS_000002", "用户名或密码错误！"),
        /**
         * E_SYS_000003：用户不存在
         */
        userNotExists("E_SYS_000003", "用户不存在！"),
        /**
         * E_SYS_100000：未知异常
         */
        UNKNOW("E_SYS_100000", "服务器异常，请联系管理员！"),
        /**
         * S000A000 ：成功
         */
        ESBSUCCESS("S000A000", "成功！");

        private String code;

        private String desc;

        Result(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

    }
}