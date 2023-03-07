package ski.komoro.auto;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import java.time.Clock;
import javax.inject.Singleton;
import com.google.inject.Provides;
import javax.sql.DataSource;
import org.jdbi.v3.core.Jdbi;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import ski.komoro.auto.dao.GuiceJdbiModule;

public class AutoAppModule extends DropwizardAwareModule<AutoAppConfig> {

    @Override
    public void configure() {
        //install(new GuiceJdbiModule()); // TODO
        bind(ObjectMapper.class).toInstance(bootstrap().getObjectMapper());
        bind(MetricRegistry.class).toInstance(bootstrap().getMetricRegistry());
    }

    @Provides
    @Singleton
    public Clock provideSystemClock() {
        return Clock.systemUTC();
    }

    @Provides
    @Singleton
    public Jdbi provideJdbi(Environment environment, AutoAppConfig autoAppConfig) {
        return new JdbiFactory().build(environment, autoAppConfig.getDatabase(), "sqlite");
    }

}
