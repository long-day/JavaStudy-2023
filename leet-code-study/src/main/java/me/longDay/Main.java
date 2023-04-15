package me.longDay;

import java.util.concurrent.TimeUnit;

/**
 * @author 君
 * @version 1.0
 * @desc test
 * @since 2023-03-17
 */
public class Main {
    private Class<?> studentClass;
    public static void main(String[] args) {
        while (true){
            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("hello");
        }
    }
}
