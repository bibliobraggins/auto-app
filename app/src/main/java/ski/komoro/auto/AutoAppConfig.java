package biblio.braggins.auto;

import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AutoAppConfig extends Configuration {

    @Valid
    @NotNull
    DataSourceFactory database;

    @Valid
    @NotNull
    FlywayFactory flyway = new FlywayFactory();

}
