package me.longDay;

import java.lang.ref.WeakReference;

/**
 * @author 君
 * @version 1.0
 * @desc test
 * @since 2023-03-17
 */
public class Main {
    private Class<?> studentClass;
    public static void main(String[] args) {
        System.out.println("未用到student");


        System.out.println(Student.class);
        System.out.println("已加载student");
        new Main().studentClass = Student.class;

        Student student = new Student();
        System.out.println("创建student对象");

        WeakReference<String> s = new WeakReference<>(new String("234"));
        System.out.println(s.get());

        System.gc();
        System.out.println(student);
    }
}
