package braggins.biblio.auto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import braggins.biblio.auto.dao.DatabaseBundleFactory;

@Slf4j
public class AutoAppApp extends Application<AutoAppConfig> {

    public static void main(final String[] args) throws Exception {
        new AutoAppApp().run(args);
    }

    @Override
    public String getName() {
        return "AutoApp";
    }

    @Override
    public void initialize(final Bootstrap<AutoAppConfig> bootstrap) {
        log.debug("Starting {}", getName());

        bootstrap.addBundle(GuiceBundle.builder()
            .printDiagnosticInfo()
            .enableAutoConfig(getClass().getPackage().getName()) // Auto Register stuff in our app package
            .dropwizardBundles(
                    new JdbiExceptionsBundle(),
                    DatabaseBundleFactory.buildFlyway()
                    )
            .bundles(DatabaseBundleFactory.buildJdbi())
            .modules(new AutoAppModule())
            .build());

        bootstrap.getObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public void run(final AutoAppConfig configuration,
                    final Environment environment) {
        // intentionally left blank
    }

}
