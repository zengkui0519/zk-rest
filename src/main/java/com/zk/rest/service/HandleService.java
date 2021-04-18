package com.zk.rest.service;

import java.util.Map;

public interface HandleService {

    /**
     * 返回接口编码
     */
    String getServiceCode();

    /**
     * 返回接口等级(预留扩展服务降级)
     */
    String getServiceLevel();

    /**
     * 业务处理方法
     */
    Object handle(Map<String, Object> bean);
}
