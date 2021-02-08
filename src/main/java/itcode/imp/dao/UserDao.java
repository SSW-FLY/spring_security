package itcode.imp.dao;

import itcode.imp.entity.SysUser;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2020/12/11
 */
@Component
public class UserDao {

    public SysUser getUser() {
        List<GrantedAuthority> authorities = AuthorityUtils
            .commaSeparatedStringToAuthorityList("role");
        return SysUser.builder().username("yc").password(new BCryptPasswordEncoder().encode("123")).authorities(authorities).build();
    }
}
