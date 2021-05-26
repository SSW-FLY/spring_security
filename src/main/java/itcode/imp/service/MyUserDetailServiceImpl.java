package itcode.imp.service;

import itcode.imp.entity.MyUser;
import javax.annotation.Resource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author imp
 * @date 2021/5/24
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {


    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = new MyUser();
        user.setUserName(username);
        user.setPassword(this.passwordEncoder.encode("123"));
        return new User(username,user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),user.isCredentialsNonExpired(),user.isAccountNonLocked(),
            AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
    }
}
