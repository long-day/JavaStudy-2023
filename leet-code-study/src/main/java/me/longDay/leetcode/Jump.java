package me.longDay.leetcode;

import java.util.Arrays;

/**
 * @author 君
 * @version 1.0
 * @desc 45.跳跃游戏
 * @since 2023-03-03
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        // dp[t]到达目标数组(nums)下标t时的最小跳跃次数
        int[] dp = new int[nums.length];
        int len = nums.length;
        // 递推公式 dp[i+j+1] = dp[i]+1;
        Arrays.fill(dp,-1);
        // 初始化
        dp[0] = 0;
        // 推进
        for (int i = 0; i < len; i++) {
            for (int j = 0;j<nums[i];j++){
                if (i+j+1>len-1){
                    break;
                }
                if(dp[i+j+1] == -1 || dp[i]+1<dp[i+j+1]){
                    dp[i+j+1] = dp[i]+1;
                }
            }
        }
        System.out.println(dp[len-1]);
    }
}
