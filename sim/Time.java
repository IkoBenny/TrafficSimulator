package sim;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends TimerTask {
		public Timer t = new Timer();	//TimerTask requires Timer instance to function
		private volatile boolean wait;
		private String time;
		
		public Time () {
			wait = true;
		}
		
		@Override
		public void run() {
			timestamp();
			System.out.println(time);
		}
		
		public String getTime() {
			return time;
		}

		public synchronized void timestamp() {
			time =  LocalTime.now().toString();
			notify();
			wait = false;
		}
		
		public synchronized void clockLock() throws InterruptedException {
			while(wait) {
				wait();
			}
		}
		
	}