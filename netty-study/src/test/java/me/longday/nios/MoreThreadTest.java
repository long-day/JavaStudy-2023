package me.longday.nios;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 君
 * @version 1.0
 * @desc 多线程优化
 * @since 2023-03-07
 */
@Slf4j
public class MoreThreadTest {
    public static void main(String[] args) {
        try (ServerSocketChannel ssc = ServerSocketChannel.open();
             Selector boss = Selector.open();
             ){
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(10010));
            SelectionKey bossKey = ssc.register(boss, SelectionKey.OP_ACCEPT, null);
            Worker workerOne = new Worker("打工人一号");

            while (true){
                boss.select();
                Iterator<SelectionKey> iter = boss.selectedKeys().iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    iter.remove();
                    if(key.isAcceptable()){
                        SocketChannel sc = ssc.accept();
                        log.debug("connected {}",sc.getRemoteAddress());

                        sc.configureBlocking(false);
                        log.debug("分发工作前");
                        workerOne.selector.wakeup();
                        sc.register(workerOne.selector,SelectionKey.OP_READ,null);
                        log.debug("分发工作后");

                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Slf4j
    static class Worker implements Runnable{
        private Thread thread;
        private Selector selector;
        private String workerName;

        public Worker(String workerName){
            this.workerName = workerName;
            register();
        }

        public void register(){
           this.thread = new Thread(this);
            try {
                selector = Selector.open();
                thread.start();
            } catch (IOException e) {
                log.info("初始化异常: {}",e.toString());
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            SocketChannel scChannel = null;
                            try {
                                ByteBuffer byteBuffer = ByteBuffer.allocate(64);
                                scChannel = (SocketChannel) key.channel();
                                int readCnt = scChannel.read(byteBuffer);
                                if(readCnt<0){
                                    key.cancel();
                                    scChannel.close();
                                    continue;
                                }
                                byteBuffer.flip();
                                byte[] bytes = new byte[byteBuffer.remaining()];
                                byteBuffer.get(bytes);
                                log.info("worker:{}", Arrays.toString(bytes));
                            }catch (IOException e){
                                key.cancel();
                                scChannel.close();
                                log.error("read error {}",e.toString());
                            }

                        }

                        else if (key.isWritable()){
                            SocketChannel scChannel = (SocketChannel) key.channel();
                            scChannel.write(Charset.defaultCharset().encode("你好啊"));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
