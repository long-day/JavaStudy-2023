package me.longday.mapper;

import lombok.extern.slf4j.Slf4j;
import me.longDay.domain.SysUser;
import me.longDay.mapper.SysMenuMapper;
import me.longDay.mapper.SysRoleMapper;
import me.longDay.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 君
 * @desc 测试一对一,一对多,多对多
 * @since 2023-04-16
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class MyBatisTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;
    @Test
    void one_to_one(){
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(3);
        log.info("selectByPrimaryKey 结果 ---> {}",sysUser);

        SysUser sysUser1 = sysUserMapper.selectByPrimaryKeyWithRoles(3);
        log.info("selectByPrimaryKeyWithRoles 结果 ---> {}",sysUser1);

    }
}
