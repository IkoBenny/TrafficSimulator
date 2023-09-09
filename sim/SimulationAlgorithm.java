package sim;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;
import sim.Constants.SimulationMode;
import wrappers.CarDTO;

@Getter
public class SimulationAlgorithm implements Command {
	private Mediator mvc;
	
	SimulationAlgorithm(Mediator mvc) {
		this.mvc = mvc;
	}
	
	@Override
	public void execute() {
		try {
			sim();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sim() throws InterruptedException, InvocationTargetException {
		
			switch (mvc.getM().getMode()) {
			case START:
				System.out.println("START");
				while (mvc.getM().getMode() == SimulationMode.START) {
					mvc.getC().startPressed();
					String s = mvc.getM().getCarPosition(0);
					double d = mvc.getM().getCarSpeed(0);
					CarDTO c = new CarDTO(mvc, d, s, 0);
					c.start();
					mvc.getM().startLight(0);
					mvc.getM().started();
				}	
				break;
			case INIT:
				System.out.println("INIT");
				while (mvc.getM().getMode() == SimulationMode.INIT) {			
					mvc.getM().init();
						BuildLights lights = new BuildLights(mvc);
						lights.execute();
						BuildCars cars = new BuildCars(mvc);
						cars.execute();
						
						for (int i =0; i< Model.getCars().size(); i++) {
							CarView cv = new CarView(i);
							mvc.getV().getCarViews().add(cv);
						}
						
						for (int i =0; i< Model.getLights().size(); i++) {
							LightView lv = new LightView(i);
							mvc.getV().getLightViews().add(lv);
						}
						
						JFrame frame = new JFrame();
						JPanel panel = new JPanel();
						JPanel panel2 = new JPanel();
						frame.add(panel2);
						frame.add(panel);
						frame.setLayout(new GridLayout(2,0));
						
						for (int i =0; i< mvc.getV().getCarViews().size(); i++) {
							panel.add(mvc.getV().getCv(i).getCarPanel());
						}
						
						for (int i =0; i< mvc.getV().getLightViews().size(); i++) {
							panel2.add(mvc.getV().getLv(i).getLightPanel());
						}
						
						frame.setVisible(true);
				}
				break;
			default:
				break;
			}
		}
	}

