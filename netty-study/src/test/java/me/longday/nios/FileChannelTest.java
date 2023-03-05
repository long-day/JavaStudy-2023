package me.longday.nios;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 君
 * @version 1.0
 * @desc 文件channel
 * @since 2023-03-04
 */
@Slf4j
public class FileChannelTest {
    @Test
    void twoChannelTransfer(){
        try(
            FileChannel input = new FileInputStream("src/main/resources/date.txt").getChannel();
            FileChannel output = new FileOutputStream("src/main/resources/to.txt").getChannel()) {
            long size = input.size();
            for (long left = size; left > 0;){
                left -= input.transferTo(size-left, left, output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void pathAndPaths(){

    }

    @Test
    void walkFileTree(){
        try {
            AtomicInteger dirCount = new AtomicInteger();
            AtomicInteger FileCount = new AtomicInteger();
            Files.walkFileTree(Paths.get("C:\\Users\\君\\Desktop\\收的作业"),new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    log.info("==> {}",dir.toString());
                    dirCount.incrementAndGet();
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileCount.incrementAndGet();
                    return super.visitFile(file, attrs);
                }
            });

            log.info("文件夹数量:{},文件数量:{}",dirCount,FileCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
