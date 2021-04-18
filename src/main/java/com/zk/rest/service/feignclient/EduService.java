package com.zk.rest.service.feignclient;

import com.zk.rest.utils.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author zengkui
 * @description 移动端跨服务调用ehs-edu服务接口
 * @date 2020/9/7 上午11:12
 */
@FeignClient(name = "ZK-EDU-SERVICE")
public interface EduService {

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取考试列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalQuizList")
    ResultMessage getPersonalQuizList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 考试获取试卷信息
     * @author zengkui
     * @date 2020/9/7 上午11:14
     */
    @PostMapping(value = "/edu/eduRest/getEduQuizPaper")
    ResultMessage getEduQuizPaper(Map param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 开始考试
     * @author zengkui
     * @date 2020/9/7 下午5:22
     */
    @PostMapping(value = "/edu/eduRest/startQuiz")
    ResultMessage startQuiz(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 考试交卷
     * @author zengkui
     * @date 2020/9/7 下午6:31
     */
    @PostMapping(value = "/edu/eduRest/submitQuiz")
    ResultMessage submitQuiz(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 保存考生反馈信息
     * @author zengkui
     * @date 2020/9/7 下午7:19
     */
    @PostMapping(value = "/edu/eduRest/saveUserItemFeedback")
    ResultMessage saveUserItemFeedback(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取答案与解析
     * @author zengkui
     * @date 2020/9/7 下午7:19
     */
    @PostMapping(value = "/edu/eduRest/getQuizPaperAnswersAndAnalysis")
    ResultMessage getQuizPaperAnswersAndAnalysis(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 考试列表获取答案与解析
     * @author zengkui
     * @date 2020/11/18 下午6:32
     */
    @PostMapping(value = "/edu/eduRest/getQuizAnswersAndAnalysisForList")
    ResultMessage getQuizAnswersAndAnalysisForList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每日答题列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getDailyPracticeItemListNew")
    ResultMessage getDailyPracticeItemListNew(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description （暂时无用）获取每日答题列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalDailyPracticeList")
    ResultMessage getPersonalDailyPracticeList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description （暂时无用）获取每日答题题目列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getDailyPracticeItemList")
    ResultMessage getDailyPracticeItemList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 提交每日答题
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/submitDailyPractice")
    ResultMessage submitDailyPractice(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每日答题答案与解析
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getDailyPracticeAnswersAndAnalysis")
    ResultMessage getDailyPracticeAnswersAndAnalysis(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取个人每日答题记录列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalDailyPracticeRecordList")
    ResultMessage getPersonalDailyPracticeRecordList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每周答题及其试卷列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalWeekPracticeAndPaperList")
    ResultMessage getPersonalWeekPracticeAndPaperList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description （暂时无用）获取每周答题列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalWeekPracticeList")
    ResultMessage getPersonalWeekPracticeList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description （暂时无用）获取每周答题试卷列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getWeekPracticePaperList")
    ResultMessage getWeekPracticePaperList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每周答题题目列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getWeekPracticeItemList")
    ResultMessage getWeekPracticeItemList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 提交每周答题
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/submitWeekPractice")
    ResultMessage submitWeekPractice(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每周答题答案与解析
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getWeekPracticeAnswersAndAnalysis")
    ResultMessage getWeekPracticeAnswersAndAnalysis(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 列表获取每周答题答案与解析
     * @author zengkui
     * @date 2020/11/3 下午5:30
     */
    @PostMapping(value = "/edu/eduRest/getWeekAnswersAndAnalysisForList")
    ResultMessage getWeekAnswersAndAnalysisForList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取专项答题列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getPersonalSpecialPracticeList")
    ResultMessage getPersonalSpecialPracticeList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取专项答题题目列表
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getSpecialPracticeItemList")
    ResultMessage getSpecialPracticeItemList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 提交专项答题
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/submitSpecialPractice")
    ResultMessage submitSpecialPractice(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取每周答题答案与解析
     * @author zengkui
     * @date 2020/9/27 下午3:49
     */
    @PostMapping(value = "/edu/eduRest/getSpecialPracticeAnswersAndAnalysis")
    ResultMessage getSpecialPracticeAnswersAndAnalysis(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 列表获取每周答题答案与解析
     * @author zengkui
     * @date 2020/11/3 下午5:32
     */
    @PostMapping(value = "/edu/eduRest/getSpecialAnswersAndAnalysisForList")
    ResultMessage getSpecialAnswersAndAnalysisForList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取个人考试错题列表
     * @author zengkui
     * @date 2020/11/2 下午4:32
     */
    @PostMapping(value = "/edu/eduRest/getPersonalWrongItemList")
    ResultMessage getPersonalWrongItemList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 查看单个错题的答案与解析
     * @author zengkui
     * @date 2020/11/2 下午4:32
     */
    @PostMapping(value = "/edu/eduRest/getWrongItemAnswersAndAnalysis")
    ResultMessage getWrongItemAnswersAndAnalysis(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 删除错题
     * @author zengkui
     * @date 2020/11/2 下午4:32
     */
    @PostMapping(value = "/edu/eduRest/removeTheWrongItem")
    ResultMessage removeTheWrongItem(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取我的反馈列表
     * @author zengkui
     * @date 2020/11/4 上午10:16
     */
    @PostMapping(value = "/edu/eduRest/getPersonalItemFeedbackList")
    ResultMessage getPersonalItemFeedbackList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取个人积分明细列表
     * @author zengkui
     * @date 2020/11/4 上午10:16
     */
    @PostMapping(value = "/edu/eduRest/getPersonalScoreDetailList")
    ResultMessage getPersonalScoreDetailList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取个人总积分
     * @author zengkui
     * @date 2020/11/4 上午10:16
     */
    @PostMapping(value = "/edu/eduRest/getPersonalTotalScore")
    ResultMessage getPersonalTotalScore(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 润工作扫码课程签到
     * @author zengkui
     * @date 2020/11/19 上午11:40
     */
    @PostMapping(value = "/edu/eduRest/trainingSignIn")
    ResultMessage trainingSignIn(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 润工作扫码课程报名
     * @author zengkui
     * @date 2020/11/19 上午11:40
     */
    @PostMapping(value = "/edu/eduRest/trainingSignUp")
    ResultMessage trainingSignUp(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取课程评价表题目
     * @author zengkui
     * @date 2020/11/19 下午8:41
     */
    @PostMapping(value = "/edu/eduRest/getEvaluationFormQuestionList")
    ResultMessage getEvaluationFormQuestionList(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 提交课程评价
     * @author zengkui
     * @date 2020/11/19 下午8:41
     */
    @PostMapping(value = "/edu/eduRest/submitTrainingEvaluation")
    ResultMessage submitTrainingEvaluation(Map<String, Object> param);

    /**
     * @param param
     * @return com.crc.ehs.rest.util.ResultMessage
     * @description 获取课程信息
     * @author zengkui
     * @date 2020/11/19 下午8:41
     */
    @PostMapping(value = "/edu/eduRest/getTrainingClassInfo")
    ResultMessage getTrainingClassInfo(Map<String, Object> param);

}
