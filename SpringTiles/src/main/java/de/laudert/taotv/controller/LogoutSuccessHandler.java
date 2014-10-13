package de.laudert.taotv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: tvt
 * Date: 10/13/14
 * Time: 2:06 PM
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            logger.debug(request.getSession().getId() + " LOGGED OUT");
        }
        setDefaultTargetUrl("/login");
        super.onLogoutSuccess(request, response, authentication);
    }
}
