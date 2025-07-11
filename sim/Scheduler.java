package sim;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public Scheduler() {
	}

	public void schedule_task_per_second_no_delay(Runnable task){
		scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
	}

}
