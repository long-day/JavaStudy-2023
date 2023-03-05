package me.longday.nios;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author 君
 * @version 1.0
 * @desc ByteBuffer
 * @since 2023-03-04
 */
@Slf4j
public class TestByteBuffer {
    @Test
    void byteBufferTest(){
        // 获取channel
        try (FileChannel channel = new FileInputStream("src/main/resources/date.txt").getChannel()) {
            // 创建Buffer,并赋予容量
            ByteBuffer byteBuffer = ByteBuffer.allocate(8);
            // 由于容量的限制,所以有可能一次无法完全读取全部内容,所以加一个循环,用来重复读完全部内容
            while (channel.read(byteBuffer)!=-1){
                log.info("---- 分割 ----");
                // 开启buffer的读取模式
                byteBuffer.flip();
                // 用来逐字节读取
                while (byteBuffer.hasRemaining()){
                    byte b = byteBuffer.get();
                    log.info("读出来的数据: {}",(char)b);
                }
                // 开启Buffer的写模式,用来为下次可能存在的读取做准备
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void scatterReads(){
        try (FileChannel channel = new RandomAccessFile("src/main/resources/date.txt", "r").getChannel()) {
            ByteBuffer b1 = ByteBuffer.allocate(7);
            ByteBuffer b2 = ByteBuffer.allocate(5);
            ByteBuffer b3 = ByteBuffer.allocate(6);
            channel.read(new ByteBuffer[]{b1,b2,b3});
            b1.flip();
            b2.flip();
            b3.flip();
            byte[] bytes1 = new byte[7];
            byte[] bytes2 = new byte[5];
            byte[] bytes3 = new byte[6];
            b1.get(bytes1);
            b2.get(bytes2);
            b3.get(bytes3);
            log.info("b1:{},b2:{},b3:{}",
                    Arrays.toString(bytes1), Arrays.toString(bytes2), Arrays.toString(bytes3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void gatheringWrite(){
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好啊");

        try (FileChannel channel = new RandomAccessFile("src/main/resources/date.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{b1,b2,b3});
        } catch (IOException e) {
        }
    }
}
