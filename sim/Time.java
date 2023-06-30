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
			log.info("Inside Time()...");
			wait = true;
			log.info("Leaving Time()...");
		}
		
		@Override
		public void run() {
			log.info("Inside Time.run()...");
			timestamp();
			log.info("Leaving Time.run()...");
		}
		
		public String getTime() {
			log.info("Inside Time.getTime()...");
			timestamp();
			log.info("Leaving Time.getTime()...");
			return time;
		}

		public synchronized void timestamp() {
			log.info("Inside Time.timestamp(){}...", time);
			time =  LocalTime.now().toString();
			notify();
			wait = false;
			log.info("Leaving Time.timestamp()...", time);
		}
		
		public synchronized void clockLock() throws InterruptedException {
			log.info("Inside Time.clockLock()...");
			while(wait) {
				log.info("Inside Time.clockLock() while loop...");
				wait();
			}
			log.info("Leaving Time.clockLock() while loop...");
			log.info("Leaving Time.clockLock()...");
		}
		
	}