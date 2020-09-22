package com.ustc.interview.problem20;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题20 表示数值的字符串
 * [A][.[B]][e|EC]
 * A为有符号整数部分
 * B为无符号整数
 * C为指数也是有符号整数
 */
public class JZ20 {
    static int index = 0;
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        boolean result = scanInteger(str);
      //如果出现点
        if (index != str.length && str[index] == '.'){
            index++;
            result = scanUnsingnedInteger(str) || result;
        }
        // 如果出现e
        if (index != str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            result = scanInteger(str);
        }
        if (index < str.length){
            index = 0;
            return false;
        }
        index = 0;
        return result;
    }

    private boolean scanInteger(char[] str){
        if (index == str.length){
            return false;
        }
        if (str[index] == '+' || str[index] == '-'){
            index++;
            return scanUnsingnedInteger(str);
        }else {
            return scanUnsingnedInteger(str);
        }

    }
    private boolean scanUnsingnedInteger(char[] str){
        int count = 0;
        while (index < str.length && isNumber(str[index])){
            index++;
            count++;
        }
        if (count == 0){
            return false;
        }else {
            return true;
        }

    }

    private boolean isNumber(char c){
        if (c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        Assert.assertEquals(true,isNumeric(".123".toCharArray()));
        Assert.assertEquals(false,isNumeric(".123.".toCharArray()));
        Assert.assertEquals(true,isNumeric("+1".toCharArray()));
        Assert.assertEquals(true,isNumeric("+1.5".toCharArray()));
        Assert.assertEquals(true,isNumeric("+1.5e-2".toCharArray()));
        Assert.assertEquals(true,isNumeric("+1.5e+2".toCharArray()));
        Assert.assertEquals(false,isNumeric("+1.5e+2.".toCharArray()));
        Assert.assertEquals(false,isNumeric(".".toCharArray()));
        Assert.assertEquals(false,isNumeric("12e".toCharArray()));
        Assert.assertEquals(false,isNumeric("1a3.14".toCharArray()));
        Assert.assertEquals(false,isNumeric("1.2.3".toCharArray()));
        Assert.assertEquals(false,isNumeric("12e+4.3".toCharArray()));
        Assert.assertEquals(true,isNumeric("-1E-16".toCharArray()));
        Assert.assertEquals(true,isNumeric("3.1416".toCharArray()));
    }

}
