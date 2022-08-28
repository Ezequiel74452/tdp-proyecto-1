package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student myInfo = new Student(131376, "García Caviglione", "Isaí Ezequiel", "ezequielcaviglione@hotmail.com", "https://github.com/Ezequiel74452", "https://i.imgur.com/yXKwmbc.png");
            	try {
            		SimplePresentationScreen screen = new SimplePresentationScreen(myInfo);
            		screen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
}