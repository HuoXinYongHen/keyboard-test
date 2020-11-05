package com.zyx.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yanxinzhang
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/4/15:07
 */
public class DigitsToLettersMap {
    public static final Map<String, List<String>> dataMap;
    static
    {
        dataMap = new ConcurrentHashMap<>();
        dataMap.put("0", Arrays.asList(""));
        dataMap.put("1",Arrays.asList(""));
        dataMap.put("2",Arrays.asList("A","B","C"));
        dataMap.put("3",Arrays.asList("D","E","F"));
        dataMap.put("4",Arrays.asList("G","H","I"));
        dataMap.put("5",Arrays.asList("J","K","L"));
        dataMap.put("6",Arrays.asList("M","N","O"));
        dataMap.put("7",Arrays.asList("P","Q","R","S"));
        dataMap.put("8",Arrays.asList("T","U","V"));
        dataMap.put("9",Arrays.asList("W","X","Y","Z"));
    }


}
