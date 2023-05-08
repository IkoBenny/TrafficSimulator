package sim;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
		public Timer t = new Timer();	//TimerTask requires Timer instance to function
		public Instant instant;
		
		@Override
		public void run() {
		}
	
		public String toString() {
			instant = Instant.now();
			return instant.toString();
		}
		
		public long timestamp() {
			return Instant.now().toEpochMilli();
		}
	}