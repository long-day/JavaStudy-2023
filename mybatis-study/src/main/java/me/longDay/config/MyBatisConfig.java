package me.longDay.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;

/**
 * @author 君
 * @desc TODO
 * @since 2023-04-15
 * @version 1.0
 */
// @Configuration
public class MyBatisConfig {

    // @Bean
    // @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
