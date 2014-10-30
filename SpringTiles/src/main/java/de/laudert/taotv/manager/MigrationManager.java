package de.laudert.taotv.manager;

import com.googlecode.flyway.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static de.laudert.taotv.manager.MigrationToolBox.getMigrationStatisticString;

/**
 * User: tvt
 * Date: 10/24/14
 * Time: 4:04 PM
 */
@Component
public class MigrationManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MigrationManager.class);

    @Autowired
    private Flyway flyway;

    public void migrate() {
        System.out.println("ON MIGRATION");
//        flyway.clean();
        flyway.setInitOnMigrate(true);
        flyway.migrate();
        System.out.println(getMigrationStatisticString(flyway.info().all()));
    }
}
