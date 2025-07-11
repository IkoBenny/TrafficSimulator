package sim;

import java.time.LocalTime;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Time implements Runnable {
    private String time;
    private static final Logger log = LoggerFactory.getLogger(Time.class);

    public Time() {
        log.info("Time()...");
    }

    private void timestamp() {
        log.info("Time.timestamp(){}...", time);
		time = LocalTime.now().toString();
    }

    @Override
    public void run() {
		timestamp();
    }
}