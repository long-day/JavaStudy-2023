package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc 209.长度最小的子数组
 * @since 2023-03-04
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int start = 0;
        int sum = 0;
        int minLength = 111111;
        for(int end = 0;end<nums.length;end++){
            sum+=nums[end];
            if(sum>=target){
                minLength = Math.min(minLength,end-start+1);
                while(start < end && sum >= target){
                    sum-=nums[start++];
                    if(sum>=target){
                        minLength = Math.min(minLength,end-start+1);
                    }
                }
            }
        }
    }
}
