package itcode.imp.service;

import itcode.imp.dao.UserDao;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author imp
 * @date 2020/12/11
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)){
            throw  new UsernameNotFoundException("用户不存在");
        }
        return userDao.getUser();
    }
}
