package me.longDay.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 君
 * @version 1.0
 * @desc 杨辉三角
 * @since 2023-03-05
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = new ArrayList<>(numRows);

        for(int row = 0;row < numRows; row++){
            ArrayList<Integer> tmp = new ArrayList<Integer>(row+1);

            for(int column = 0;column <= row;column++) {
                if(column == 0 || column == row){
                    tmp.add(1);
                }else{
                    tmp.add(res.get(row-1).get(column-1)+res.get(row-1).get(column));
                }
            }
            res.add(tmp);
        }
    }
}
