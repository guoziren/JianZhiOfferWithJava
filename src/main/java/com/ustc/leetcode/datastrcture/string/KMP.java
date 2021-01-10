package com.ustc.leetcode.datastrcture.string;

public class KMP {
    /**
     *
     * @param s 主串
     * @param t 子串
     * @return 返回子串在主串中首次出现的位置，如果存在，否则返回-1
     */
    public static int getIndex(String s,String t){
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(t.toCharArray());
        while(i1 < str1.length && i2 < str2.length){
            if (str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else{
                if (next[i2] == -1){
                    i1++;
                }else{
                    //往前
                    i2 = next[i2];
                }
            }
        }
        //i2 == str2.length 表示成功找到
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     *
     * @param t 模式串
     * @return
     */
    private static int[] getNextArray(char[] t) {
        if (t.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[]{t.length};
        next[0] = -1;
        next[1] = 0;
        int i = 2;//当前位置
        int cn = 0;//跳到的位置
        while (i < next.length){
            if (t[i - 1] == t[cn]){//如果当前调到的位置和我前一个字符是一样的
                next[i++] = ++cn;//cn表示前缀的长度，此时取长度+1
            }else if(cn > 0){
                cn = next[cn];//往前跳
            }else {
                next[i++] = 0;//不能往前跳了
            }
        }
        return next;
    }

}
