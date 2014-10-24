package de.laudert.taotv.service.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: tvt
 * Date: 10/20/14
 * Time: 2:46 PM
 */
@Service
public class LoggingServiceBean implements LoggingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingServiceBean.class);

    @Override
    public void performLogging() {
        LOGGER.info("I am performing some logging, you should see this message!");
    }
}
