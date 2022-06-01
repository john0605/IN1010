//Ferdig. 
import javax.swing.*;

public class GUI extends JFrame {
	GUI() {
		this.add(new Kontroll());
		this.setTitle("Slange spillet");
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch (Exception e) {
			System.exit(9);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pack();
		this.setVisible(true);
	}
}