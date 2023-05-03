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
	
	public static void main (String [] args) {
		Car c = new Car();
		//c.run();
		TrafficLight tl = new TrafficLight();
		//tl.run();
		Timer t = new Timer();
		Timer t2 = new Timer();
		t2.schedule(c, 1000, 1000);
		t.schedule(tl, 2000, 2000);
	}
}
