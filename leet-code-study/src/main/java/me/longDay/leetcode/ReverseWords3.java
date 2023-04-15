package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-04-07
 */
public class ReverseWords3 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        char[] chars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        char ch = ' ';
        for (int i = 0; i < chars.length; i++) {
            slow = i;
            fast = i;
            while(i < chars.length && chars[i] !=' '){
                i++;
                fast++;
            }
            fast--;
            while(slow < fast){
                ch = chars[fast];
                chars[fast--] = chars[slow];
                chars[slow++] = ch;
            }
        }
    }
}
