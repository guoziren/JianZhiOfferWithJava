package com.ustc.interview.problem33;

import org.junit.Test;

public class InterviewProblem33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int high = sequence.length-1;
        if(high == -1){
            return false;
        }
        return verifySquenceOfBST(sequence,0,high);


    }
    @Test
    public void test(){
        int[] arr = {5,7,6,9,11,10,8};
        System.out.println( VerifySquenceOfBST(arr));
    }


    private boolean verifySquenceOfBST(int[] sequence, int begin, int end) {

        if (end == -1 || end - begin + 1 <= 1){
            return true;
        }

        int root = sequence[end];

        int i = begin;
        for (; i < end; i++) {
            if (sequence[i] > root){
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root){
                return false;
            }
        }


        boolean left = true;
        if (i != begin){
            left = verifySquenceOfBST(sequence,begin,i - 1);
        }

        boolean right = true;

             right = verifySquenceOfBST(sequence,i,end - 1);

        return left && right;
    }
}
