package me.longday.netty.compoment;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-03-08
 */
@Slf4j
public class TestEventLoop {
    public static void main(String[] args) {
        // taskAndScheduleTask();
        server();
    }

    private static void taskAndScheduleTask() {
        EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(2);
        // EventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();
        nioEventLoopGroup.next().submit(()->{
            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            log.info("hello");
        });
        nioEventLoopGroup.next().scheduleAtFixedRate(()->{
            log.info("ok");
        },5,1,TimeUnit.SECONDS);
        log.info("hi");
    }

    public static void server(){

        DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();

        new ServerBootstrap().
                group(new NioEventLoopGroup(),new NioEventLoopGroup(2)).
                channel(NioServerSocketChannel.class).
                childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast("handle1", new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                log.info(buf.toString(Charset.defaultCharset()));
                                ctx.fireChannelRead(msg);
                            }
                        }).addLast(defaultEventLoopGroup,"handle2", new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                log.info(buf.toString(Charset.defaultCharset()));
                            }
                        });
                    }
                }).bind(10022);
    }
}
