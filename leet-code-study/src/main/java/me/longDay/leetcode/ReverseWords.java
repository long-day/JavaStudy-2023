package me.longDay.leetcode;

import java.util.HashMap;

/**
 * @author 君
 * @version 1.0
 * @desc 151.反转字符串中的单词
 * @since 2023-03-15
 */
public class ReverseWords {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        String s = "the sky is blue";
        String[] s1 = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length-1;i>=0;i--){
            if(s1[i].length()>0){
                builder.append(s1[i]).append(" ");
            }
        }
    }
}
