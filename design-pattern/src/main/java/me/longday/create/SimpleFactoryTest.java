package me.longday.create;

/**
 * @author 君
 * @version 1.0
 * @desc 简单工厂
 * @since 2023-03-04
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        IProduct a = simpleFactory.getProductByType("A");
        a.getDescribe();
        IProduct b = simpleFactory.getProductByType("B");
        b.getDescribe();
    }

}

interface IProduct{
    void getDescribe();
}

class ProductA implements IProduct{

    @Override
    public void getDescribe() {
        System.out.println("产品A");
    }
}
class ProductB implements IProduct{

    @Override
    public void getDescribe() {
        System.out.println("产品B");
    }
}

class SimpleFactory{
    public IProduct getProductByType(String type){
        switch (type){
            case "A" :
                return new ProductA();
            case "B" :
                return new ProductB();
            default:
               throw  new RuntimeException("请传入正确类型");
        }
    }
}