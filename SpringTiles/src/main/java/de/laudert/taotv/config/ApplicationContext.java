package de.laudert.taotv.config;

import de.laudert.taotv.service.login.CustomSessionRegistry;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.web.session.ConcurrentSessionFilter;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:24 PM
 */
@Configuration
@ComponentScan(basePackages = {"de.laudert.taotv.service"})
@PropertySource("classpath:application.properties")
@Import({PersistenceConfig.class, SpringSecurityConfig.class})
public class ApplicationContext {

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public CustomSessionRegistry sessionRegistry() {
        return new CustomSessionRegistry();
    }

    @Bean
    public ConcurrentSessionFilter concurrentSessionFilter() {
        return new ConcurrentSessionFilter(sessionRegistry());
    }
}
