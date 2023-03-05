package me.longDay.leetcode;

import java.util.Arrays;

/**
 * @author 君
 * @version 1.0
 * @desc 31.下一个排列
 * @since 2023-03-05
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int len = nums.length;
        //长度为1直接返回即可
        if( len <= 1){
            return;
        }

        int i = len - 2;
        int j = len - 1;
        int k = len - 1;

        // 找第一个条件 A[i]<A[j]的值
        while(i>=0&&nums[i]>=nums[j]){
            i--;
            j--;
        }

        // 第二个条件 将A[i] 与 A[j]到A[end]中,逆序查找到的第一个大于A[i]的数字A[k]交换位置
        if(i>=0){
            while(nums[i] >= nums[k]){
                k--;
            }
            int tmp = nums[k];
            nums[k] = nums[i];
            nums[i] = tmp;
        }

        Arrays.sort(nums,j,len);
    }
}
