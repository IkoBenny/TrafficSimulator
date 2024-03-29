package sim;

import java.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Time {
		private String time;
		private static Logger log = LoggerFactory.getLogger(Time.class);
		
		public Time () {
			log.info("Inside Time()...");
			log.info("Leaving Time()...");
		}
		
		public String getTime() {
			log.info("Inside Time.getTime()...");
			timestamp();
			log.info("Leaving Time.getTime()...");
			return time;
		}

		private synchronized void timestamp() {
			log.info("Inside Time.timestamp(){}...", time);
			time =  LocalTime.now().toString();
			notify();
			log.info("Leaving Time.timestamp()...", time);
		}

		public String stop() {
			return null;
		}

		public String start() {
			return getTime();
		}

		public String pause() {
			return getTime();
		}
		
	}