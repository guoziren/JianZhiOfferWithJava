package com.ustc.interview.problem16;

public class InterviewProblem16 {
    //题目保证2个参数，不同时为0
    public double Power(double base, int exponent) {
        if (base == 0){
            return base;
        }
        if (exponent == 0){
            return 1;
        }else if(exponent > 0){
            double r = base;
            while (exponent > 1){
                r = r * base;
                exponent--;
            }
            return r;
        }else{
            double r = base;
            int positive_exponent = Math.abs(exponent);
            while (positive_exponent > 1){
                r = r * base;
                positive_exponent--;
            }
            return 1 / r;
        }

    }
}
