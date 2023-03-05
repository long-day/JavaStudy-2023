package me.longday.create;

/**
 * @author 君
 * @version 1.0
 * @desc 工厂方法模式
 * @since 2023-03-04
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        new FactoryA().getProduct().getDescribe();//产品A
        new FactoryB().getProduct().getDescribe();//产品B
        //                       ↑↑
        //      这里，可以加一个参数,类似简单工厂那样,来进行进一步细化
    }
}

abstract class FactoryMethodFactory{
    public abstract IProduct getProduct();
}

class FactoryA extends FactoryMethodFactory{
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}

class FactoryB extends FactoryMethodFactory{
    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}

//
// interface IProduct{
//     void getDescribe();
// }
// class ProductA implements IProduct{
//
//     @Override
//     public void getDescribe() {
//         System.out.println("产品A");
//     }
// }
// class ProductB implements IProduct{
//
//     @Override
//     public void getDescribe() {
//         System.out.println("产品B");
//     }
// }