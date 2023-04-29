import java.time.Instant;

public class Time {
	Instant instant;

	public Time() {
		instant = Instant.now();
	}

	@Override
	public String toString() {
		return "Time [instant=" + instant + "]";
	}
}
