package com.ustc.interview.problem5;

/**
 * 面试题5：在原字符数组上替换空格，假设容量总是足够的
 */
public class InterviewProblem5 {
    private static final int LENGTH = 100;
    public static void main(String[] args) {
        String text = "hello";

        modifyString(text);
        System.out.println(text);

        char orgin[] = new char[LENGTH];
        //包含空格的字符串
        String str = "We are happy.";
        //包含多个连续空格的字符串
        String str4 = "We  are   happy.";
        //不包含空格的字符串
        String str2 = "WeAre";
        //空字符串
        String str1 = "";

        for (int i = 0; i < str4.length(); i++) {
            orgin[i] = str4.charAt(i);
        }
//        replace(orgin,str.length());
//        replace(orgin,str1.length());
        replace(orgin,str4.length());


    }

    /**
     * 用两个指针从后往前遍历,p2指向替换后字符数组的最后一个字符的位置
     * p1指向原始字符数组的最后一个字符的位置；
     * 往前遍历,非空格直接移动，是空格的话,p1前移1位，p2前移3位，
     * @param orgin
     * @param length 待操作字符数组的实际容量
     */
    public static void replace(char orgin[],int length){
        if (orgin == null || length <= 0){
            System.out.println("输入有误");
            return;
        }
        System.out.println(orgin);
        int space_count = 0;
        for (int i = 0; i < length; i++) {
            if (orgin[i] == ' '){
                space_count++;
            }
        }
        if (space_count == 0){
            System.out.println(orgin);
            return;
        }
        int new_length = length + space_count * 2;
        int p1 = length -1;
        int p2 = new_length - 1;

        //从后往前遍历
        while(p1 > 0 &&p1 != p2){
            if (orgin[p1] == ' '){
                orgin[p2] = '0';
                orgin[p2-1] = '2';
                orgin[p2-2] = '%';
                p2 = p2 -3;
            }else {
                orgin[p2] = orgin[p1];
                p2--;
            }
            p1--;
        }
        System.out.println(orgin);
    }
    public static void modifyString(String s){
        s = "world";
//        int arr[];
//        arr = {1,2,3};
//
//        int arr1[] = {1,2,3};
//        int arr2[] = new int[]{1,2,3};
//        int arr3[] = new int[3];
//        int arr33[] = new int[3]{0};//?
//        int arr4[] ;
//         arr4 = new int[3];
    }
}
