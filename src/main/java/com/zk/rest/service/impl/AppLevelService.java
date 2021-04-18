package com.zk.rest.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @param
 * @author liyongzheng
 * @decription: 接口等级(用于服务降级, 系统繁忙时停掉等级低的接口)
 * @decription: 划分为两个维度, read, write, 分别1到10级, 级别大于等于当前设置的系统级别的接口才可运行 (初步设计预留功能，待完善及扩展)
 * @return
 */
@Service
public class AppLevelService {

    private final Set<String> serTypes = Stream.of("n", "r", "w").collect(Collectors.toSet());//n:no limit; r:read; w:write; u:unknow

    private final Set<Integer> serLevels = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toSet());// 5:正常; 小于5:低级; 大于5:高级

    private Set<String> runTypes = new HashSet<>(serTypes);//正在运行的服务类型

    private int runRLevel = 1;//正在运行的读服务等级(大于等于当前值的服务可运行)

    private int runWLevel = 1;//正在运行的写服务等级(大于等于当前值的服务可运行)

    /* 设置单个接口等级 */
    public String myLevel(String serType, int serLevel) {
        if ("read".equals(serType)) {
            serType = "r";
        }
        if ("write".equals(serType)) {
            serType = "w";
        }
        if (serTypes.contains(serType)) {
            if (serLevels.contains(serLevel)) {
                return serType + serLevel;
            }
            return serType + "5";
        }
        return "u1";
    }

    /* 设置运行的接口等级
     *  runSerTypes 运行类型：字符串数组 r:read; w:write;
     *  runRSerLevel 读服务运行等级
     *  runWSerLevel 写服务运行等级 */
    public String setRunSerLevel(String[] runSerTypes, int runRSerLevel, int runWSerLevel) {
        runTypes.remove("r");
        runTypes.remove("w");
        if (null != runSerTypes && runSerTypes.length > 0) {
            for (String s : runSerTypes) {
                if (serTypes.contains(s)) {
                    runTypes.add(s);
                }
            }
        }

        if (serLevels.contains(runRSerLevel)) {
            runRLevel = runRSerLevel;
        } else if (runRSerLevel < 1) {
            runRLevel = 1;
        } else if (runRSerLevel > 10) {
            runRLevel = 10;
        }

        if (serLevels.contains(runWSerLevel)) {
            runWLevel = runWSerLevel;
        } else if (runWSerLevel < 1) {
            runWLevel = 1;
        } else if (runWSerLevel > 10) {
            runWLevel = 10;
        }

        return "success";
    }

    /* 验证接口是否能运行(是否没被降级) */
    public boolean isServiceLevelOk(String serviceLevel) {
        boolean isCheckOk = false;
        if (StringUtils.isNotEmpty(serviceLevel)) {
            String myType = serviceLevel.substring(0, 1);
            int myLevel = 0;
            try {
                myLevel = Integer.parseInt(serviceLevel.substring(1));
            } catch (Exception e) {
            }
            if ("n".equals(myType)) {
                isCheckOk = true;
            } else if (runTypes.contains(myType)) {
                isCheckOk = "r".equals(myType) ? myLevel >= runRLevel : myLevel >= runWLevel;
            }
        }
        return isCheckOk;
    }

    /* 查询当前运行级别 */
    public String getSysRunLevel() {
        String result = "";
        if (!runTypes.isEmpty()) {
            for (String s : runTypes) {
                if (!"n".equals(s)) {
                    result += "r".equals(s) ? s + runRLevel + " " : s + runWLevel + " ";
                }
            }
        }
        result = StringUtils.isEmpty(result) ? "none level" : result;
        return result;
    }
}
