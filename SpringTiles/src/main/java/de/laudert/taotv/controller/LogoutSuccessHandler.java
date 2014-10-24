package de.laudert.taotv.controller;

import de.laudert.taotv.service.user.UserSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutSuccessHandler.class);

    @Autowired
    private UserSessionService userSessionService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {

        }
        setDefaultTargetUrl("/index");
        super.onLogoutSuccess(request, response, authentication);
    }
}
