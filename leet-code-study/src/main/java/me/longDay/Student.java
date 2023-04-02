package me.longDay;

/**
 * @author 君
 * @version 1.0
 * @desc JVM调试类
 * @since 2023-03-27
 */
public class Student {
    public static final int a = 12;

    public static int b = 15;

    static {
        b = 99;
    }
    int c= 24;
    int d = 56;

    {
        d = 77;
    }

}
