package biblio.braggins.auto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import ru.vyarus.dropwizard.guice.test.ClientSupport;
import ru.vyarus.dropwizard.guice.test.jupiter.ext.TestDropwizardAppExtension;


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
