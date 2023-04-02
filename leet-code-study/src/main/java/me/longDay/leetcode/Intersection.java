package me.longDay.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 君
 * @version 1.0
 * @desc 349.两个数组的交集
 * @since 2023-03-22
 */
public class Intersection {
    public static void main(String[] args) {
        Integer[] num1 = new Integer[]{4,9,5};
        Integer[] num2 = new Integer[]{9,4,9,8,4};
        List<Integer> res = new ArrayList<>();
        List<Integer> n1 = Arrays.stream(num1).collect(Collectors.toSet())
                .stream().sorted().collect(Collectors.toList());
        List<Integer> n2 = Arrays.stream(num2).collect(Collectors.toSet())
                .stream().sorted().collect(Collectors.toList());

        Integer[] n33 = Arrays.stream(num1).sorted().distinct().toArray(Integer[]::new);
        int index1 = 0;
        int index2 = 0;

        while (index1 < n1.size() && index2 < n2.size()){
            if (n1.get(index1).equals(n2.get(index2))){
                res.add(n2.get(index2));
                index1++;
                index2++;
            } else if (n1.get(index1) < n2.get(index2)){
                index1++;
            }else {
                index2++;
            }
        }

        System.out.println(Arrays.toString(res.stream().mapToInt(Integer::valueOf).toArray()));

    }
}
