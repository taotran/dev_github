package de.laudert.taotv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(@SuppressWarnings("SpringJavaAutowiringInspection")AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login*").access("IS_AUTHENTICATED_ANONYMOUSLY")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')");
//        http.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/admin/cartAdmin")
//            .usernameParameter("username")
//            .passwordParameter("password")
//            .and()
//            .logout().logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
//            .and()
//            .csrf();

        http.formLogin().loginPage("/login").failureUrl("/login?error='loginFailed'").defaultSuccessUrl("/admin/cartAdmin")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/").logoutUrl("/j_spring_security_logout").deleteCookies("JSESSIONID");
        http.rememberMe().tokenValiditySeconds(86400);
        http.csrf().disable();

    }
}
