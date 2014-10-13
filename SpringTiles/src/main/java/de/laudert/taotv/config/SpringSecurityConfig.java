package de.laudert.taotv.config;

import de.laudert.taotv.controller.LogoutSuccessHandler;
import de.laudert.taotv.repository.user.UserRepository;
import de.laudert.taotv.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 11:16 AM
 */
@Configuration
@EnableWebSecurity
@Import({PersistenceConfig.class})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public void configureGlobal(@SuppressWarnings("SpringJavaAutowiringInspection") AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from user where username=?")
//            .authoritiesByUsernameQuery("select username, role from user_role where username=?");
        auth.userDetailsService(new LoginService(userRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login*").permitAll()
            .antMatchers("/static/**").permitAll()
            .antMatchers("/index*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/dba/**").access("hasRole('ADMIN') or hasRole('DBA')");

        http.formLogin().loginPage("/login").failureUrl("/error").defaultSuccessUrl("/index")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
//                .logout().logoutSuccessUrl("/").logoutUrl("/logout").deleteCookies("JSESSIONID")
            .logout().logoutSuccessHandler(new LogoutSuccessHandler())
            .and()
            .exceptionHandling().accessDeniedPage("/error")
        ;
        http.rememberMe().tokenValiditySeconds(86400);
        http.csrf().disable();
    }
}
