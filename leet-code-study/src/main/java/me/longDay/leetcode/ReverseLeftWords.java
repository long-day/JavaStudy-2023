package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc 58.左旋转字符串
 * @since 2023-03-07
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;

        StringBuilder stringBuilder = new StringBuilder(s);
        int cnt = 0;

        for (char c : s.toCharArray()) {
            stringBuilder.append(c);
            cnt++;
            if(cnt == n){
                break;
            }
        }

        System.out.println(stringBuilder.substring(n,stringBuilder.length()));
    }
}
