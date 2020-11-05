package com.zyx.test;


import com.zyx.common.DigitsToLettersMap;
import com.zyx.service.KeyboardService;
import com.zyx.service.RangeStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author yanxinzhang
 * @Title: 数字转字母
 * @Package com.zyx.algorithm
 * @Description: 将数字转换成字母
 * @date 2020/11/4/16:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeJunitTest {
    @Autowired
    KeyboardService keyboardService;

    @Test
    public void test0To99Digits() {
        Assert.assertNotNull(keyboardService);
        Assert.assertTrue(doneDigitsToLetters("MAXRANGE")); //MAXRANGE or MINRANGE
    }

//    @Test
//    public void test0To9Digits() {
//        Assert.assertNotNull(keyboardService);
//        Assert.assertTrue(doneDigitsToLetters("MINRANGE")); //MAXRANGE or MINRANGE
//    }


    /**
     * 将数字转换成字母并打印输入输出结果
     * @param rangeType 范围类型 0-9:MINRANGE or 0-99:MAXRANGE
     */
    public Boolean doneDigitsToLetters(String rangeType){
        RangeStrategy rangeStrategy = keyboardService.getRangeStrategyHashMap().get(rangeType);
        if(rangeStrategy == null){
            System.err.println("error: param rangeType is not exist");
            return false; //提前结束
        }
        System.out.println("Please input a digits:");
        Scanner scan= new Scanner(System.in, "UTF-8");
        String inputData = "";
        while(true){
            inputData=scan.next();
            if(!inputData.matches(rangeStrategy.getRegex())){
                System.out.println("输入不合法,请重新输入:");
            }else{
                break;
            }
        }

        StringBuilder arrInput=new StringBuilder("Input:arr[] ={");
        String[] arrStr = inputData.split("");

        List<String[]> dataList=new ArrayList<String[]>();
        for(int i=0;i<arrStr.length;i++){
            arrInput.append(arrStr[i]);
            if(i<arrStr.length-1){
                arrInput.append(",");
            }
            List<String> lettersList = DigitsToLettersMap.dataMap.get(arrStr[i]);
            if(lettersList.size()>0){  //排除数字0&1
                String[] letterArr = (String[]) lettersList.toArray();
                dataList.add(letterArr);
            }
        }
        arrInput.append("}");

        //组装需要打印的输出数据
        List<String[]> resultList = assemblyLetters(dataList,0,null);

        //打印输入内容
        System.out.println(arrInput.toString());
        //打印输出内容
        System.out.print("Output:");
        if(!CollectionUtils.isEmpty(resultList)){  //输入0&1数字
            for(int i=0;i<resultList.size();i++){
                String[] letterArr = resultList.get(i);
                System.out.print(" ");
                for(String s: letterArr) {
                    System.out.print(s.toLowerCase());
                }
                if(i == resultList.size()-1){
                    System.out.print("\n");
                }
            }
        }
        return true;
    }


    /**
     * 实现集合中各数组的排列组合(递归)
     * @param dataList 输入数字对应的字母集合
     * @param index  集合的索引位
     * @param resultList 最终的排列集合
     * @return
     */
    private List<String[]> assemblyLetters(List<String[]> dataList, int index, List<String[]> resultList){
        if(index == dataList.size()){
            return resultList;
        }
        List<String[]> resultListByIndex=new ArrayList<String[]>();
        if(index == 0){//处理第一索引位的字母集合
            String[] dataArr = dataList.get(0);
            for(String data : dataArr){
                resultListByIndex.add(new String[]{data});
            }
        }else{
            String[] dataArr=dataList.get(index);
            for(String[] dataArrOld: resultList){
                for(String data : dataArr){
                    String[] dataArrNew=new String[dataArrOld.length+1]; //扩充数组元素位
                    System.arraycopy(dataArrOld, 0, dataArrNew, 0, dataArrOld.length); //复制数组元素
                    dataArrNew[dataArrNew.length-1] = data; //追加数组元素
                    resultListByIndex.add(dataArrNew); //封装结果集
                }
            }
        }
        return assemblyLetters(dataList,++index,resultListByIndex);
    }

}
