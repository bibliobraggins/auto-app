package ski.komoro.auto.dao;

import javax.sql.DataSource;
import org.jdbi.v3.guice.AbstractJdbiDefinitionModule;

public class GuiceJdbiModule extends AbstractJdbiDefinitionModule {

    public GuiceJdbiModule() {
        super(GuiceJdbi.class);
        requireBinding(DataSource.class);
    }

    @Override
    public void configureJdbi() {

    }

}
