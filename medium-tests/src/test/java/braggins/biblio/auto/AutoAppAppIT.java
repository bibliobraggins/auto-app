package braggins.biblio.auto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vyarus.dropwizard.guice.test.client.DefaultTestClientFactory.USE_LOGGER;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junitpioneer.jupiter.SetSystemProperty;
import ru.vyarus.dropwizard.guice.test.ClientSupport;
import ru.vyarus.dropwizard.guice.test.jupiter.ext.TestDropwizardAppExtension;


@SetSystemProperty(key = USE_LOGGER, value = "true")
class AutoAppAppIT {

    @RegisterExtension
    @Order(Integer.MAX_VALUE)
    static TestDropwizardAppExtension appExt = TestDropwizardAppExtension.forApp(AutoAppApp.class)
            .config("src/test/resources/test-config.yml")
            .randomPorts(true)
            .create();

    @Test
    void testPingApiOverHttp(ClientSupport clientSupport) {
        clientSupport.targetMain().register(PingPongApi.class);
        final var pingPongApi = WebResourceFactory.newResource(PingPongApi.class, clientSupport.targetMain());
        assertEquals("pong", pingPongApi.ping());
    }

}
