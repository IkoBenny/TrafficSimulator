package sim;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Time extends TimerTask {
		public Timer t = new Timer();	//TimerTask requires Timer instance to function
		private volatile boolean wait;
		private String time;
		
		private static Logger log = LoggerFactory.getLogger(Time.class);
		
		public Time () {
			log.trace("Inside Time()...");
			wait = true;
			log.trace("Leaving Time()...");
		}
		
		@Override
		public void run() {
			log.trace("Inside Time.run()...");
			timestamp();
			log.trace("Leaving Time.run()...");
		}
		
		public String getTime() {
			log.trace("Inside Time.getTime()...");
			timestamp();
			log.trace("Leaving Time.getTime()...");
			return time;
		}

		public synchronized void timestamp() {
			log.trace("Inside Time.timestamp()...");
			time =  LocalTime.now().toString();
			notify();
			wait = false;
			log.trace("Leaving Time.timestamp()...");
		}
		
		public synchronized void clockLock() throws InterruptedException {
			log.trace("Inside Time.clockLock()...");
			while(wait) {
				log.trace("Inside Time.clockLock() while loop...");
				wait();
			}
			log.trace("Leaving Time.clockLock() while loop...");
			log.trace("Leaving Time.clockLock()...");
		}
		
	}