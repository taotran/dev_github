package de.laudert.taotv.manager;

import com.googlecode.flyway.core.api.MigrationInfo;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Locale;

/**
 * User: tvt
 * Date: 10/24/14
 * Time: 5:54 PM
 */
public final class MigrationToolBox {

    private MigrationToolBox() {}

    private static final FastDateFormat FORMAT = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM, Locale.GERMANY);

    public static String getMigrationStatisticString(MigrationInfo[] migrationInfos) {

        final StringBuilder builder = new StringBuilder("migration status:\n");

        builder.append("--------------------------------------------------------------------------------------------- \n");
        builder.append(String.format("| %12s | %8s | %20s | %-40s | \n", "version", "state", "installed", "description"));
        builder.append("--------------------------------------------------------------------------------------------- \n");

        for (MigrationInfo patch : migrationInfos) {
            builder.append(
                String.format("| %12s | %8s | %20s | %-40s | \n",
                              patch.getVersion(),
                              patch.getState().getDisplayName(),
                              FORMAT.format(patch.getInstalledOn()),
                              patch.getDescription()));
        }

        builder.append("--------------------------------------------------------------------------------------------- ");

        return builder.toString();
    }
}
