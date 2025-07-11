package sim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static Mediator main = new Mediator();
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		Setup setup = new Setup(main);
		SimulationAlgorithm sim = new SimulationAlgorithm(main);

		setup.execute();

		for (;;) {
			try {
				Thread.sleep(1000);
				log.info("sleep(1000) completed...");
				sim.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
