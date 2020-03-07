package com.ustc.leetcode.algorithmidea.binarysearch;

import com.ustc.zuoshen.util.Duishuqi;
import org.junit.Test;

import java.util.Arrays;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class L744 {
    //字符数组不会出现a...za...z....,只可能是a....z..
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters.length < 2){
            return 0;
        }
        int len = letters.length;//这个变量不要，执行用时可从击败33%提升到100%
        int low = 0;
        int high = len - 1;
        while (low <= high){
            int midIndex = low + ((high - low) >>> 1);
            if (letters[midIndex] > target){
                high = midIndex - 1;
            }else{
                low = midIndex + 1;
            }
        }
        if (high == len - 1 || letters[high + 1] <= target){
            return letters[0];
        }else{
            return letters[high + 1];
        }
    }
    @Test
    public void test(){
        for (int i = 0; i < 50000; i++) {
            testThis();
        }
        System.out.println(true);

    }

    private void testThis() {
        char[] array = Duishuqi.generateRandomLetterArray(20000);
        Arrays.sort(array);
        char target = (char)('a' + (26 *Math.random()));

        char r2 = absoluteRight(array,target);
        char r1 = nextGreatestLetter(array,target);

        if (r1 != r2){
            System.out.println(Arrays.asList(array));
            System.out.println(r1);
            System.out.println(r2);
        }
    }

    public char absoluteRight(char[] letters, char target) {
        if (letters.length < 2){
            return 0;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];

    }
}
