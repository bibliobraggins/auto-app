package braggins.biblio.auto.dao;

import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import lombok.experimental.UtilityClass;
import org.jdbi.v3.sqlite3.SQLitePlugin;
import ru.vyarus.guicey.jdbi3.JdbiBundle;
import braggins.biblio.auto.AutoAppConfig;

@UtilityClass
public class DatabaseBundleFactory {
    public static JdbiBundle buildJdbi() {
        return JdbiBundle.<AutoAppConfig>forDatabase((c, e) -> c.getDatabase())
                .withPlugins(new SQLitePlugin());
    }

    public static FlywayBundle<AutoAppConfig> buildFlyway() {
        return new FlywayBundle<>() {

            @Override
            public PooledDataSourceFactory getDataSourceFactory(AutoAppConfig autoAppConfig) {
                return autoAppConfig.getDatabase();
            }

            @Override
            public FlywayFactory getFlywayFactory(AutoAppConfig configuration) {
                return configuration.getFlyway();
            }
        };
    }
}
