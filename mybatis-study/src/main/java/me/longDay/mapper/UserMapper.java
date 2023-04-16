package me.longDay.mapper;

import me.longDay.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 君
 * @desc TODO
 * @since 2023-04-15
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    // @Select("SELECT * FROM db1.user WHERE id = ${id}")
    User selectById(Integer id);
}
