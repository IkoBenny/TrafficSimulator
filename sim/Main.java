package sim;

public class Main {
	static Mediator main = new Mediator();
	
	public static void main(String[] args) {
		Setup setup = new Setup(main);
		SimulationAlgorithm sim = new SimulationAlgorithm(main);

		setup.execute();

		for (;;) {
			try {
				Thread.sleep(1000);
				System.out.println("MAIN - Done Sleeping");
				sim.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
