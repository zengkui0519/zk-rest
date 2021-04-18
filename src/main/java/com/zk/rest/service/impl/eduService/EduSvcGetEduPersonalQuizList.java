package com.zk.rest.service.impl.eduService;

import com.zk.rest.response.ResultData;
import com.zk.rest.service.HandleService;
import com.zk.rest.service.feignclient.EduService;
import com.zk.rest.service.impl.AppLevelService;
import com.zk.rest.utils.ResponseCode;
import com.zk.rest.utils.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zengkui
 * @description 获取考试列表接口
 * @date 2020/9/27 下午3:51
 */
@Service
public class EduSvcGetEduPersonalQuizList implements HandleService {

    private Logger logger = LoggerFactory.getLogger(EduSvcGetEduPersonalQuizList.class);

    private final String serviceCode = "EduSvcGetEduPersonalQuizList";// 获取考试列表接口

    private final String serType = "read";// read:读操作(查询) write:写操作(增删改)
    // 注意:如果是写操作要加事务控制注解!

    private final int serLevel = 5;// 接口等级(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 5:正常;
    // 小于5:低级; 大于5:高级

    @Resource
    private EduService eduService;

    @Resource
    private AppLevelService levelService;

    @Override
    public String getServiceCode() {
        return serviceCode;
    }

    @Override
    public String getServiceLevel() {
        return levelService.myLevel(serType, serLevel);
    }

    @Override
    public Object handle(Map<String, Object> bean) {
        Map<String, Object> head = (Map<String, Object>) bean.get("head");
        Map<String, Object> body = (Map<String, Object>) bean.get("body");

        if (null == head || null == body) {
            return ResultData.fail(ResultData.FAIL_CODE, EduSvcGetEduPersonalQuizList.MyInner.errBody);
        }

        String userCode = head.get("username").toString();

        body.put("userCode", userCode);

        logger.info("userCode: {}", userCode);
        ResultMessage resultMessage = eduService.getPersonalQuizList(body);

        String rspCode = resultMessage.getCode();
        String rspDesc = resultMessage.getMsg();
        if (ResponseCode.RESPONSE_CODE_ERROR_DEFAULT.equals(rspCode)) {
            return ResultData.finish(head, rspCode, rspDesc, "");
        }

        return ResultData.success(head, resultMessage.getData());
    }

    private static class MyInner {
        private static String errBody = "报文缺少必传参数,请仔细检查!";
    }

}
