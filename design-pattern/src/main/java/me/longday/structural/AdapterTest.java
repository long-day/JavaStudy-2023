package me.longday.structural;

import lombok.AllArgsConstructor;

/**
 * @author 君
 * @version 1.0
 * @desc 适配器模式
 * @since 2023-03-05
 */
public class AdapterTest {
    public static void main(String[] args) {
        ThunderboltToUsb toUsb = new ThunderboltToUsb(new ThunderboltConnector());
        toUsb.slowInput();
        toUsb.slowOutput();

    }
}

interface SlowSerialPort{
    void slowInput();
    void slowOutput();
}
interface FastSerialPort{
    void fastInput();
    void fastOutput();
}

class Usb implements SlowSerialPort {

    @Override
    public void slowInput() {
        System.out.println("USB输入");
    }

    @Override
    public void slowOutput() {
        System.out.println("USB输出");
    }
}

class ThunderboltConnector implements FastSerialPort{

    @Override
    public void fastInput() {
        System.out.println("雷电口输入");

    }

    @Override
    public void fastOutput() {
        System.out.println("雷电口输出");

    }
}
@AllArgsConstructor
class ThunderboltToUsb implements SlowSerialPort{
    private FastSerialPort fast;


    @Override
    public void slowInput() {
        System.out.println("USB转换输入");
        fast.fastInput();
    }

    @Override
    public void slowOutput() {
        fast.fastOutput();
        System.out.println("USB转换输出");
    }
}
