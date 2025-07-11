package wrappers;

import javax.swing.SwingUtilities;

import interfaces.RunnableWrapperInterface;
import sim.Constants;
import sim.Time;
import sim.Mediator;

public class TimeWrapper implements Runnable,RunnableWrapperInterface {
	Mediator timeMediator;
	Time  timeObj;

	
	public TimeWrapper(Mediator timeMediator) {
		this.timeMediator = timeMediator;
		timeObj = new Time();
	}
	
	@Override
    public void run() {
		startRunnable();
	}
	
	@Override
	public void startRunnable() {
		for (;;) {
			try {
				Thread.sleep(1000);
				//String s = timeObj.start();
				if (!timeMediator.getModel().getMode().equals(Constants.SimulationMode.STOP)
						&& !timeMediator.getModel().getMode().equals(Constants.SimulationMode.PAUSE)) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							//timeMediator.getView().getTime().setText(s);
							timeMediator.getView().getFrame().repaint();
						}
					});
				}		
				else if (timeMediator.getModel().getMode().equals(Constants.SimulationMode.PAUSE)) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

