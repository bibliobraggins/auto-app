package braggins.biblio.auto;

import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PingPongResourceImpl implements PingPongApi {

    private final Jdbi jdbi;

    @Override
    public String ping() {
        log.info("received ping, replying pong");
        jdbi.withHandle(h -> {
            final var execute = h.execute("select 1");
            log.info("db query response code {}", execute);
            return execute;
        });
        return "pong";
    }
}
