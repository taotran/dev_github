package de.laudert.taotv.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * User: tvt
 * Date: 10/9/14
 * Time: 9:11 AM
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}
