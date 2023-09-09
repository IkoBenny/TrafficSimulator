package sim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

@Getter
public class Mediator {
	private Model m = new Model();
	private View v = new View();
	private Controller c = new Controller(this);
	private static Logger log = LoggerFactory.getLogger(Mediator.class);
	
	public Mediator() {
		log.info("Inside Mediator() {}...");
		log.info("Leaving Mediator() {}...");
	}
	
}
