package com.zyx.service;

import org.springframework.stereotype.Service;

//将数字从0到99转换成字母
@Service
public class MaxRangeStrategy  implements RangeStrategy{
    @Override
    public String rangeType() {
        return "MAXRANGE";
    }

    @Override
    public String getRegex() {
        return "[0-9]{1,2}";
    }
}
