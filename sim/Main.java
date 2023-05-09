package sim;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		//create the Model, View and Controller
		Model m = new Model();
		View v = new View();
		Controller c = new Controller();
		
		//Schedule the GUI to be created on the event thread 
				SwingUtilities.invokeLater(new Runnable(){
					public void run() {
						//show GUI/View, then connect it and Model to Controller
						v.createAndShowGUI();
						v.addChangeListeners(c);
						v.addActionListeners(c);
						c.setViewAndModel(m, v);
					}
				});
				
				//refreshes the GUI/View display every second
				while(true) {
					c.update();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}

}
