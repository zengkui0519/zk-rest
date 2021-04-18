package com.zk.rest.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class Head implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * 系统授信串
     */
    private String sysSecretCode;

    /*
     * 接口编码
     */
    private String serviceCode;

    /*
     * 用户token
     */
    private String token;

    /*
     * 业务流水号
     */
    private String tradeNo;

    /*
     * 响应码
     */
    private String rspCode;

    /*
     * 响应码描述
     */
    private String rspDesc;

    public Head() {
    }

    public Head(String sysSecretCode, String serviceCode, String token, String tradeNo, String rspCode, String rspDesc) {
        this.sysSecretCode = sysSecretCode;
        this.serviceCode = serviceCode;
        this.token = token;
        this.tradeNo = tradeNo;
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
    }

    public Head(Map<String, Object> head, String rspCode, String rspDesc) {
        if (null != head) {
            this.sysSecretCode = null != head.get("sysSecretCode") ? (String) head.get("sysSecretCode") : "";
            this.serviceCode = null != head.get("serviceCode") ? (String) head.get("serviceCode") : "";
            this.token = null != head.get("token") ? (String) head.get("token") : "";
            this.tradeNo = null != head.get("tradeNo") ? (String) head.get("tradeNo") : "";
        }
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
    }

}
