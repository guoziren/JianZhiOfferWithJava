package com.ustc.leetcode.algorithmidea.binarysearch;

import org.junit.Test;

import java.util.*;

/**
 * 540. 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 */
public class L540 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
      if (len == 1){
          return nums[0];
      }
      if (nums[0] != nums[1]){
          return nums[0];
      }
      if (nums[len - 1] != nums[len - 2]){
          return nums[len - 1];
      }
      int low = 0;
      int high = len - 1;
      //始终在奇数个长度的数组中查找
      while (low <= high){
          int mid = (low + high) >>> 1;
          if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid+ 1]){
              return nums[mid];
          }
          //0-mid长度为 奇数个
          if ((mid - low) % 2  == 0 && nums[mid] == nums[mid - 1]){
              high = mid -2;
          }else if((mid - low) % 2 == 0 && nums[mid] == nums[mid + 1]){
              low = mid + 2;
              //0-mid长度为偶数
          }else if((mid - low) % 2 != 0 && nums[mid] == nums[mid - 1]){
              low = mid + 1;
          }else if((mid - low) % 2 != 0 && nums[mid] == nums[mid + 1]){
              high = mid - 1;
          }
      }
      return -1;
    }


    @Test
    public void test(){
        for (int i = 0; i < 50; i++) {
            int[] arr = generateRandomArray(100000);
        //    System.out.println(Arrays.toString(arr));
      //      arr = new int[]{58282625, 58282625, 74167868, 74167868, 385636391, 638646832, 638646832, 1083885012, 1083885012, 1111793665, 1111793665, 1371509395, 1371509395};
            int a = singleNonDuplicate(arr);
            int b = absoluteRight(arr);
            if (a != b){
                System.out.println("false");
                System.out.println(a);
                System.out.println(b);
                return;
            }
//            System.out.println("------>");
        }
        System.out.println("true");


    }
    public  int[] generateRandomArray(int maxSize){
        //生成随机数组
        int size = (int)((maxSize) * Math.random()) + 1;
        size = size % 2 == 0 ? size + 1 : size;
        HashSet<Integer> set = new HashSet();
        int temp = 0;
        while (set.size() != size - 1){
             temp = (int)(Integer.MAX_VALUE * Math.random());
            set.add(temp);
        }
        temp = (int)(Integer.MAX_VALUE * Math.random());

        while (set.contains(temp)){

            temp = (int)(Integer.MAX_VALUE * Math.random());
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        list.addAll(set);
        list.add(temp);
        Collections.sort(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    private int absoluteRight(int[] nums){
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        if (nums[0] != nums[1]){
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]){
            return nums[len - 1];
        }
        for (int i = 1; i < len - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }
}
