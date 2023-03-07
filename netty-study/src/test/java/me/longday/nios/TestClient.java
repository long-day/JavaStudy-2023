package me.longday.nios;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author 君
 * @version 1.0
 * @desc 测试用的客户端
 * @since 2023-03-07
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",10010));
        socketChannel.write(Charset.defaultCharset().encode("1234567890abcdef"));
        System.in.read();
    }
}
