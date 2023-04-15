package me.longday.netty.custom;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-04-06
 */
@Slf4j
public class MyChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    @Override
    protected void initChannel(NioSocketChannel nsc) throws Exception {
        log.info("init channel");
        nsc.pipeline().addLast(new StringDecoder());
        nsc.pipeline().addLast(new ChannelInboundHandlerAdapter(){
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                log.info("第一个添加的入口处理器");
                ctx.fireChannelRead(msg);
            }
        });

        nsc.pipeline().addLast(new ChannelInboundHandlerAdapter(){
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                log.info("第二个添加的入口处理器");
                ctx.fireChannelRead(msg);
            }
        });

        nsc.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
            @Override
            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                log.info("第一个添加的出口处理器");
                super.write(ctx, msg, promise);
            }
        });

        nsc.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
            @Override
            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                log.info("第二个添加的出口处理器");
                super.write(ctx, msg, promise);
            }
        });
    }
}
