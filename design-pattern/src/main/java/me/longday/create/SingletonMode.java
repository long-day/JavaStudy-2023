package me.longday.create;

/**
 * @author 君
 * @version 1.0
 * @desc 单例模式
 * @since 2023-03-05
 */
public class SingletonMode {
    public static void main(String[] args) {
        StaticMethod staticMethod = StaticMethod.getInstance();
        StaticInnerClass instance = StaticInnerClass.getInstance();
        EnumSingleton ins = EnumSingleton.ins;
        System.out.println(staticMethod);
        System.out.println(instance);
        System.out.println(ins);
    }
}

class StaticMethod{
    private static volatile StaticMethod s;

    private  StaticMethod(){

    }

    public static StaticMethod getInstance(){
        if (s == null){
            synchronized(StaticMethod.class){
                if (s == null){
                    s = new StaticMethod();
                }
            }
        }

        return s;
    }
}

class StaticInnerClass{

    private StaticInnerClass(){}

    public static StaticInnerClass getInstance(){
        return inner.getInstance();
    }

    private static class inner{
        private static final StaticInnerClass ins = new StaticInnerClass();
        public static StaticInnerClass getInstance(){
            return ins;
        }
    }
}

enum EnumSingleton{
    ins
}