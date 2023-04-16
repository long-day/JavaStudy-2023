package me.longday.mapper;

import me.longDay.Application;
import me.longDay.mapper.UserMapper;
import me.longDay.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 君
 * @desc TODO
 * @since 2023-04-15
 * @version 1.0
 */
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void select_by_id(){
        User user = userMapper.selectById(1);
        // log.info("user: {}",user);
        System.out.println(user);
    }
}
