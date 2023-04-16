package me.longDay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 君
 * @desc TODO
 * @since 2023-04-15
 * @version 1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("me.longDay.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
