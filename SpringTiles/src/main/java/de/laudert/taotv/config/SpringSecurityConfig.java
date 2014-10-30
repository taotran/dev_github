package de.laudert.taotv.config;

import de.laudert.taotv.controller.LogoutSuccessHandler;
import de.laudert.taotv.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;

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
    private LoginService loginService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login*").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/tags/**").permitAll()
            .antMatchers("/**").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/dba/**").access("hasRole('ADMIN') or hasRole('DBA')");

        http.formLogin().loginPage("/login").failureUrl("/error").defaultSuccessUrl("/index")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutSuccessHandler(new LogoutSuccessHandler())
            .and()
            .exceptionHandling().accessDeniedPage("/error")
        ;
        http.rememberMe().tokenValiditySeconds(86400);
        http.csrf().disable();
//        http.addFilterAfter(authenticationFilter(), CustomUsernamePasswordAuthenticationFilter.class);
        http.addFilter(concurrentSessionFilter());
        http.sessionManagement().sessionAuthenticationStrategy(sas());
    }

    @Bean
    public CustomSessionRegistry sessionRegistry() {
        return new CustomSessionRegistry();
    }

    @Bean
    public ConcurrentSessionFilter concurrentSessionFilter() {
        return new ConcurrentSessionFilter(sessionRegistry(), "/expire");
    }

//    @Bean
//    public CustomUsernamePasswordAuthenticationFilter authenticationFilter() {
//        CustomUsernamePasswordAuthenticationFilter authenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
//        authenticationFilter.setAuthenticationManager(auth.getObject());
//        authenticationFilter.setSessionAuthenticationStrategy(sas());
//        authenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler());
//        authenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler());
//        return authenticationFilter;
//    }

//    @Bean
//    public ConcurrentSessionControlStrategy sas() {
//        ConcurrentSessionControlStrategy sas = new ConcurrentSessionControlStrategy(sessionRegistry());
//        sas.setMaximumSessions(1);
//        return sas;
//    }

    @Bean
    public ConcurrentSessionControlStrategy sas() {
        ConcurrentSessionControlStrategy sas = new ConcurrentSessionControlStrategy(sessionRegistry());
        sas.setMaximumSessions(1);
        return sas;
    }

//    @Bean
//    public SimpleUrlAuthenticationFailureHandler customAuthenticationFailureHandler() {
//        SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler = new SimpleUrlAuthenticationFailureHandler();
//        simpleUrlAuthenticationFailureHandler.setDefaultFailureUrl("/error");
//        return simpleUrlAuthenticationFailureHandler;
//    }
//
//    @Bean
//    public SimpleUrlAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
//        SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler = new SimpleUrlAuthenticationSuccessHandler();
//        simpleUrlAuthenticationSuccessHandler.setDefaultTargetUrl("/index");
//        return simpleUrlAuthenticationSuccessHandler;
//    }
}
