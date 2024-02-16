package ski.komoro.auto.dao;

import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import org.jdbi.v3.sqlite3.SQLitePlugin;
import ru.vyarus.guicey.jdbi3.JdbiBundle;
import ski.komoro.auto.AutoAppConfig;

public final class DatabaseBundleFactory {

    private DatabaseBundleFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

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
