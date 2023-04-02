package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc 剑指 10-1 斐波那契数列
 * @since 2023-03-17
 */
public class FibPro {
    public static void main(String[] args) {
        int n = 8;
        Long[] dp = new Long[n+1];

        dp[0] = 0L;
        dp[1] = 1L;

        for(int i = 2;i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % (1000000007L);
        }
        System.out.println(dp[n].intValue());
    }
}
