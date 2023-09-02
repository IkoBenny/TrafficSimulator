package sim;

public class Main {
	static Mediator main = new Mediator();
	
	public static void main(String[] args)  {
			Setup setup = new Setup(main);
			SimulationAlgorithm sim = new SimulationAlgorithm(main);
			
			setup.execute();
			sim.execute();
	}

}
