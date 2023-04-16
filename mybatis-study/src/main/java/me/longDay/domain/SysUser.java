package me.longDay.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private List<SysRole> roles;
    
    @Serial 
    private static final long serialVersionUID = 1L;
}