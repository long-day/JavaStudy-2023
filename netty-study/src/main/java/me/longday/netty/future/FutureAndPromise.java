package me.longday.netty.future;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 君
 * @version 1.0
 * @desc FutureAndPromise
 * @since 2023-03-11
 */
@Slf4j
public class FutureAndPromise {
    public static void main(String[] args) {
        ThreadPoolExecutor cusThreadPool =
                new ThreadPoolExecutor(2,4,
                        60, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(20));
        // jdkFuture(cusThreadPool);

        // nettyFuture();
        // LinkedList
        // nettyPromise();
        NioEventLoopGroup loopGroup = new NioEventLoopGroup(2);
        EventLoop next = loopGroup.next();
        DefaultPromise<Integer> promise = new DefaultPromise<>(next);
        cusThreadPool.submit(()->{
            promise.setSuccess(3);
            return 3;
        });
        try {
            log.info("promise :{}",promise.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }


    }

    private static void nettyFuture() throws Exception{
        NioEventLoopGroup loopGroup = new NioEventLoopGroup(2);
        EventLoop next = loopGroup.next();
        Future<Integer> submit = next.submit(() -> {
            log.info("sleep before 2s");
            Thread.sleep(2000);
            log.info("sleep after 2s");
            return 3;
        });
        log.info("getNow :{}",submit.getNow());
        Thread.sleep(2100);
        log.info("getNow sleep 2s:{}",submit.getNow());
        log.info("get :{}",submit.get());

        submit.addListener(future -> {
            log.info("getNow :{}",future.getNow());
            Thread.sleep(2100);
            log.info("getNow sleep 2s:{}",future.getNow());
            log.info("get :{}",future.get());
        });
    }

    private static void jdkFuture(ThreadPoolExecutor cusThreadPool) throws Exception{
        java.util.concurrent.Future<Integer> future = cusThreadPool.submit(() -> {
            log.info("sleep before 1s");
            Thread.sleep(1000);
            log.info("sleep after 1s");
            return 22;
        });
        log.info("future get");
        log.info("得到的 future 结果:{}",future.get());
    }
}
