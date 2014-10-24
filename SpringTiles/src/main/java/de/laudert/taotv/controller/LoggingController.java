package de.laudert.taotv.controller;

import com.google.gson.Gson;
import de.laudert.taotv.service.logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: tvt
 * Date: 10/20/14
 * Time: 2:44 PM
 */
@RestController
public class LoggingController {

    @Autowired
    LoggingService loggingService;

    @RequestMapping(value = "/logging", produces = MediaType.APPLICATION_JSON_VALUE)
    public String produceLogging() {
        for (int i = 0; i < 5; i++) {
            loggingService.performLogging();
        }
        String success = "Success";
        return new Gson().toJson(success);
    }
}
