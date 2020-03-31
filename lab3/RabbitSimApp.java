package lab3;

import plotter.SimulationPlotter;

public class RabbitSimApp {
	public static void main(String[] args) {
		SimulationPlotter plotter = new SimulationPlotter();
		
		RabbitModel model = new RabbitModel();
		plotter.simulate(model);
		
		
		
		

	}

}
