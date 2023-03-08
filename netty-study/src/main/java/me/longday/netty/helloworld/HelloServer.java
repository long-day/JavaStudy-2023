package me.longday.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 君
 * @version 1.0
 * @desc server
 * @since 2023-03-08
 */
@Slf4j
public class HelloServer {
    public static void main(String[] args) {
        log.info("client: {}",123);
        // 1 启动器 负责组装netty组件,启动服务器
        new ServerBootstrap()
                // 2 创建管理者和连接处理者  Boss 和 worker
                .group(new NioEventLoopGroup())
                // 3 选择服务器的ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                // 4.boss负责处理连接worker(child)负责处理读写，决定了worker(child)能执行哪些操作(handler)
                .childHandler(
                        //5 channel代表和客户端进行数据读写的通道Initializer初始化，负责添加别的handler
                        new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        // 添加具体的Handle
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        nioSocketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            // 读操作
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                                // super.channelRead(ctx, msg);
                            }
                        });
                    }
                })
                // 绑定监听端口
                .bind(10022);
    }
}
