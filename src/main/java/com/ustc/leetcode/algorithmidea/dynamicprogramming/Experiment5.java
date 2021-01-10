package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 背包问题
 */
public class Experiment5 {


    public static void main(String[] args) throws FileNotFoundException {

//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("/Users/guoziren/IdeaProjects/剑指offer for Java/src/main/java/com/ustc/leetcode/algorithmidea/dynamicprogramming/input.txt"));
    }

    public void dongtaiguihua(InputStream in)  {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();//物品数n
        int c = scanner.nextInt();//背包容量c
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            weights[j] = w;
            values[j] = v;
        }
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j < weights[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[n][c]);
    }
    @Test
    public void tanxin(InputStream in)  {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();//物品数n
        int c = scanner.nextInt();//背包容量c
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];

        List<Result> list = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            weights[j] = w;
            values[j] = v;
            double d = (double) v / (double) w;//计算单价
            Result result = new Result(d,j);
            list.add(result);
        }
        //排序，单价最高的在前面
        Collections.sort(list, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if(o2.danjia - o1.danjia > 0){
                    return 1;
                }else if(o2.danjia - o1.danjia == 0){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        int sum = 0;
        int finalValue = 0;
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).index;
            if (sum + weights[index] <= c){
                sum = sum + weights[index];
                finalValue += values[index];
            }
        }
        System.out.println(finalValue);
    }
    class Result{
        public double danjia;
        public int index;

        public Result(double danjia, int index) {
            this.danjia = danjia;
            this.index = index;
        }
    }
}
