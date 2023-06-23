package braggins.biblio.auto;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Clock;
import javax.inject.Singleton;
import com.google.inject.Provides;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class AutoAppModule extends DropwizardAwareModule<AutoAppConfig> {

    @Override
    public void configure() {
        bind(ObjectMapper.class).toInstance(bootstrap().getObjectMapper());
        bind(MetricRegistry.class).toInstance(bootstrap().getMetricRegistry());
    }

    @Provides
    @Singleton
    public Clock provideSystemClock() {
        return Clock.systemUTC();
    }

}
