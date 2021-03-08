package itcode.imp.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author imp
 * @date 2020/12/11
 */
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //配置是否自动生成表
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    /**
     * 路径必须"/"开头
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        //设置自定义的登录页面，特定权限访问和
//        http.formLogin()
//            .loginPage("/login.html")
//            .loginProcessingUrl("/user/login")
//            .defaultSuccessUrl("/success.html").permitAll()
//            .and()
//            .authorizeRequests()
//            .antMatchers("/test/line", "/test/hello").permitAll()
//            .antMatchers("/test/index").hasRole("sale")
//            .anyRequest().authenticated().and().csrf().disable();
//
//        //设置登出，注销
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
//
//        //自定义403跳转页面
//        http.exceptionHandling().accessDeniedPage("/unauth.html");
//        //自动登录配置
//        http.rememberMe()
//            .tokenRepository(persistentTokenRepository())
//            //设置有效时长，单位是秒
//            .tokenValiditySeconds(60)
//            .userDetailsService(userDetailsService);
    }
}
