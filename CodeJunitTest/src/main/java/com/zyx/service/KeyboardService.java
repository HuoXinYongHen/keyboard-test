package com.zyx.service;


import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author yanxinzhang
 * @Title: KeyboardService
 * @Package com.zyx.service
 * @Description: ${todo}
 * @date 2020/11/4/16:17
 */
@Service
public class KeyboardService {

    private HashMap<String, RangeStrategy> rangeStrategyHashMap = new HashMap<>();

    public KeyboardService(List<RangeStrategy> rangeStrategyList) { // 托管给spring -- spring给我们去创建对象
        for (RangeStrategy rangeStrategy : rangeStrategyList) {
            rangeStrategyHashMap.put(rangeStrategy.rangeType(), rangeStrategy);
        }
    }
    public HashMap<String, RangeStrategy> getRangeStrategyHashMap() {
        return rangeStrategyHashMap;
    }


}
