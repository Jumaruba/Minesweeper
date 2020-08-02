package lpoo.model.game;

import lpoo.model.Model;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class ClockModel implements Model {
    private Instant start;
    Clock clock;

    public ClockModel(Clock clock) {
        this.clock = clock;
        this.start = getCurrent();
    }

    public Instant getCurrent() {
        return clock.instant();
    }

    public Instant getStart() {
        return start;
    }

    public Integer getSeconds() {
        return (int) Duration.between(getStart(), getCurrent()).toMillis() / 1000;
    }
}
