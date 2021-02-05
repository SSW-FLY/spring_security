package itcode.imp.dao;

import itcode.imp.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2020/12/11
 */
@Component
public class UserDao {

    public SysUser getUser(){
        return SysUser.builder().username("yc").password("123").build();
    }
}
