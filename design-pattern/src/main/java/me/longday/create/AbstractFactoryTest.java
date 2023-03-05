package me.longday.create;

/**
 * @author 君
 * @version 1.0
 * @desc 抽象工厂模式
 * @since 2023-03-04
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        new HuaWeiFactory().getPhone().getDescription();
        new HuaWeiFactory().getPad().getDescription();
        //                        ↑↑
        //               这里也可加上枚举,类似简单工厂那样
        //               例如Huawei P30 ,Huawei P50,华为pad等
        new AppleFactory().getPhone().getDescription();
        new AppleFactory().getPad().getDescription();
        //                       ↑↑
        //               这里也可加上枚举,类似简单工厂那样
        //               例如ipad11 ,ipad 12,iphone13 iphone14
    }
}

interface Phone{
    void getDescription();
}

interface Pad{
    void getDescription();
}

class HuaWeiPhone implements Phone{

    @Override
    public void getDescription() {
        System.out.println("华为手机");
    }
}

class ApplePhone implements Phone{

    @Override
    public void getDescription() {
        System.out.println("🍎手机");
    }
}


class HuaWeiPad implements Pad{

    @Override
    public void getDescription() {
        System.out.println("华为Pad");
    }
}

class ApplePad implements Pad{

    @Override
    public void getDescription() {
        System.out.println("🍎Pad");
    }
}



interface AbstractFactory{
    Phone getPhone();
    Pad getPad();
}

class HuaWeiFactory implements AbstractFactory{

    @Override
    public Phone getPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Pad getPad() {
        return new HuaWeiPad();
    }
}

class AppleFactory implements AbstractFactory{

    @Override
    public Phone getPhone() {
        return new ApplePhone();
    }

    @Override
    public Pad getPad() {
        return new ApplePad();
    }
}
