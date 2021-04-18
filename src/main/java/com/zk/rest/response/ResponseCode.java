package com.zk.rest.response;

public interface ResponseCode {

    /**
     * 默认成功编号：S_SYS_000000
     */
    public static String RESPONSE_CODE_SUCCESS_DEFAULT = "MS000A000";// "S000000";

    /**
     * SSDP 成功编号
     */
    public static String RESPONSE_CODE_SSDP_SUCCESS_DEFAULT = "S1A00000";
    /**
     * SSDP 失败
     */
    public static String RESPONSE_CODE_SSDP_ERROR_DEFAULT = "E1A00000";

    /**
     * 默认成功信息：成功
     */
    public static String RESPONSE_MSG_SUCCESS_DEFAULT = "成功";

    /**
     * 校验失败
     */
    public static String RESPONSE_CODE_CHECK_FAIL_DEFAULT = "MC000F000";

    /**
     * 异常
     */
    public static String RESPONSE_CODE_ERROR_DEFAULT = "ME000F000";

    // 未查到数据状态码
    public static String RESPONSE_CODE_NULL_DEFAULT = "ME000E000";

    // 未查到数据提示信息
    public static String RESPONSE_MSG_NULL_DEFAULT = "未查到相关数据";

    public enum Result {
        /**
         * S_SYS_000000 ：成功
         */
        SUCCESS("S_SYS_000000", "成功！"),
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
        UNKNOW("E_SYS_100000", "服务器异常，请联系系统管理员！"),
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

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}