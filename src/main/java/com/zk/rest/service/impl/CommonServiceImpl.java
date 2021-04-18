package com.zk.rest.service.impl;

import com.zk.rest.response.ResultData;
import com.zk.rest.service.CommonService;
import com.zk.rest.service.HandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Resource
    private AppLevelService levelService;

    @Resource
    private List<HandleService> handleServiceList;

    private Map<String, HandleService> serviceMap = new HashMap<>();

    private boolean isServiceRepeat = false;

    private StringBuilder repeatServiceMsg = new StringBuilder(" :");

    @Override
    public Object doService(Map<String, Object> bean) {
        if (serviceMap.isEmpty() && null != handleServiceList && handleServiceList.size() > 0) {
            synchronized (this) {//要加锁,否则高并发下可能会误报接口有重复
                if (serviceMap.isEmpty()) {
                    for (HandleService service : handleServiceList) {
                        if (!serviceMap.containsKey(service.getServiceCode())) {
                            serviceMap.put(service.getServiceCode(), service);
                        } else {
                            isServiceRepeat = true;
                            repeatServiceMsg.append(" " + service.getServiceCode());
                        }
                    }
                }
            }
        }

        Map<String, Object> head = (Map<String, Object>) bean.get("head");

        if (isServiceRepeat) {
            logger.error("存在重复接口 {},已停止所有接口服务!(以便及时发现和修改问题)", repeatServiceMsg.toString());
            return ResultData.finish(head, ResultData.FAIL_CODE, "服务端接口有重复，请联系系统管理员！", "");
        }

        String serviceCode = (String) head.get("serviceCode");
        HandleService service = serviceMap.get(serviceCode);
        if (null == service) {
            logger.info("找不到接口！{}", serviceCode);
            return ResultData.finish(head, ResultData.FAIL_CODE, "找不到接口！(" + serviceCode + ")", "");
        }

        if (!levelService.isServiceLevelOk(service.getServiceLevel())) {
            logger.info("服务降级,当前接口{}运行级别{}低于服务器运行级别{}!", serviceCode, service.getServiceLevel(), levelService.getSysRunLevel());
            return ResultData.finish(head, ResultData.FAIL_CODE, "系统繁忙,请稍后重试或联系系统管理员!", "");
        }

        logger.info("当前请求接口编码: {}  业务处理类: {}", serviceCode, service.getClass().getName());

        try {
            return service.handle(bean);//执行业务处理方法
        } catch (Exception e) {
            logger.error("异常抛出 error:{}", e.getMessage());
            e.printStackTrace();
            return ResultData.finish(head, ResultData.FAIL_CODE, "网络异常,请稍后重试或联系系统管理员!", "");
        }

    }

}
