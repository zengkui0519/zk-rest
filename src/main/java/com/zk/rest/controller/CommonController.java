package com.zk.rest.controller;

import com.zk.rest.service.CommonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class CommonController {

    @Resource
    private CommonService commonService;

    /**
     * @param bean
     * @return java.lang.Object
     * @description 通用接口(统一入口, 根据接口编码区分不同业务)
     * @author zengkui
     * @date 2020/12/12 下午11:59
     */
    @PostMapping(value = "/commonService", produces = "application/json;charset=utf-8")
    public Object commonService(@RequestBody Map<String, Object> bean) {
        return commonService.doService(bean);
    }

}
