package sim;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
		public Timer t = new Timer();	//TimerTask requires Timer instance to function
		public Instant instant;
		
		@Override
		public void run() {
			timestamp();
		}
	
		public synchronized String toString() {
			instant = Instant.now();
			return instant.toString();
		}
		
		public synchronized long timestamp() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Instant.now().toEpochMilli();
		}
	}