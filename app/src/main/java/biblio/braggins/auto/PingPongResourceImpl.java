package biblio.braggins.auto;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;

@Slf4j
public class PingPongResourceImpl implements PingPongApi {

    @Inject
    private Jdbi jdbi;

    @Override
    public String ping() {
        log.info("received ping, relying pong");
        jdbi.withHandle(h -> {
            final var execute = h.execute("select 1");
            log.info("db query response code {}", execute);
            return execute;
        });
        return "pong";
    }
}
