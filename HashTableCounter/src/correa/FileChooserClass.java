package correa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileChooserClass {
	JFileChooser f_c = new JFileChooser();
	StringBuilder s = new StringBuilder();

	public void pick_me() throws FileNotFoundException {
		if (f_c.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = f_c.getSelectedFile();
			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				s.append(input.nextLine());
				s.append("\n");
			}
			input.close();
		} else {
			s.append("No file was selected");
		}
	}
}
