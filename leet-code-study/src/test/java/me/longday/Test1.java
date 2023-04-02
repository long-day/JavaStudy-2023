package me.longday;

import org.junit.jupiter.api.Test;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-04-02
 */

public class Test1 {
    @Test
    void integer(){
        Integer i1 = 40;
        Integer i2 = Integer.valueOf(40);
        System.out.println(i1.equals(i2));

    }
}
