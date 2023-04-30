import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
		public Timer t = new Timer();	//TimerTask requires Timer instance to function
		public Instant instant;
		
		@Override
		public void run() {
			instant = Instant.now();
			System.out.println(instant.toString());
		}
		
	}