package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc 最小覆盖子串
 * @since 2023-03-02
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        int[] charCounter = new int[128];
        for(char c : t.toCharArray()){
            charCounter[c]++;
        }// 将目标字符串中的每种字符分别统计计数

        // 遍历
        int fast = 0;
        int slow = 0;
        int startOfMinWindow = 0;
        int sizeOfMinWindow = 111111;//因为范围是10^5
        int tCnt = t.length();// 记录t的长度,即需要找到的字符数,便于后续操作
        while(fast<s.length()){
            char oneCharOfS = s.charAt(fast);
            // 数组中的值大于0，只能是需要的字符的情况
            if(charCounter[oneCharOfS] > 0){
                tCnt--; // 找到一个字符，值减一
            }
            // 不管这个字符是不是要找的字符，都是需要将值减一的，只不过如果不是要找的字符
            // 那么这个值会变成负数，这个特点(指:负数)后续也会使用到
            charCounter[oneCharOfS] --;
            //====从此开始是slow移动的区域====
            // slow是一直不动的，直到满足指定条件(条件:fast指针已经将所有需要字符找到了)
            // tCnt就是用来记录、判断fast找到字符进度的,tCnt==0代表全部找到了
            if(tCnt == 0){
                // 过滤掉无用字符，charCounter中的值小于0，那么这个字符一定是无用字符
                while(slow<fast&&charCounter[s.charAt(slow)]<0){
                    charCounter[s.charAt(slow)]++;//将这个值加回来，不加回来影响下次循环
                    slow++;// slow步进
                }
                // 这是的slow到fast之间的字符就是找到的结果,只保留比当前已有更短的记录
                if(fast-slow+1<sizeOfMinWindow){
                    startOfMinWindow = slow;
                    sizeOfMinWindow = fast-slow+1;
                }
                //继续寻找下一组

                // 因为要步进一，且当前slow指向的字符一定是t中的一个
                // 所以要将其先先加回到charCounter中再步进
                charCounter[s.charAt(slow)]++;
                slow++;
                tCnt++;
            }
            //====slow移动的区域到此结束====

            fast++;
        }

    }
}
