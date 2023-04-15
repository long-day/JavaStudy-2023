package me.longday.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import me.longday.netty.custom.MyChannelInitializer;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-04-06
 */
@Slf4j
public class TcpServe {
    public static final Integer PORT = 45678;
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            serverBootstrap.group(boss,worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new MyChannelInitializer())
                    .bind(PORT);
            log.info("stop");
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
