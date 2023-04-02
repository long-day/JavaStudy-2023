package me.longday.netty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @author 君
 * @version 1.0
 * @desc hello client
 * @since 2023-03-08
 */
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {

        Channel socketChannel = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());

                    }
                })
                .connect(new InetSocketAddress("localhost", 10022))
                .sync()
                .channel();
        System.out.println(socketChannel);

        socketChannel.writeAndFlush("hello service i am client");
        socketChannel.close();
    }
}
