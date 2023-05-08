package sim;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
	Timer timer;

	public Scheduler() {
		timer = new Timer();
	}
	
	public void schedule (TimerTask task, Long wait, Long interval) {
		timer.schedule(task, wait, interval);
	}
	
	public void cancel () {
		timer.cancel();
	}
	
}
