package itcode.imp.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author imp
 * @date 2020/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser implements UserDetails {

    private String email;

    private String username;

    private String password;

    private List<GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

}
