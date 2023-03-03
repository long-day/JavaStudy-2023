package me.longDay.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * @author 君
 * @version 1.0
 * @desc 二分查找算法
 * @since 2023-02-26
 */
@Slf4j
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1,22,33,44,55,76,867,4564,6453,8342,12341};
        doBinarySearch(a,55);
    }
    public static void doBinarySearch(@NotNull int[] a, int target){

        int right = a.length-1;
        int left = 0;
        int mid = (right+left)>>1;
        while (a[mid] != target && left < right){
            if(target<a[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
            mid = (right+left)>>1;
        }
        log.info("得到的结果{}",mid);
    }
}
