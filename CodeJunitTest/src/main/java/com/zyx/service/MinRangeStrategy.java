package com.zyx.service;

import org.springframework.stereotype.Service;


//将数字从0到9转换成字母
@Service
public class MinRangeStrategy implements RangeStrategy{
    @Override
    public String rangeType() {
        return "MINRANGE";
    }

    @Override
    public String getRegex() {
        return "[0-9]{1}";
    }
}
