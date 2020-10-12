package correa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class HTCMain {

	public static void main(String[] args) throws IOException {
		// Chooser Method for specific Java files
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".java") || f.isDirectory();
			}

			public String getDescription() {
				return "Java Files";
			}
		});

		int r = chooser.showOpenDialog(new JFrame());
		if (r == JFileChooser.APPROVE_OPTION) {
			final long startTime = System.currentTimeMillis();
			Reader l = new FileReader(chooser.getSelectedFile());
			BufferedReader br = new BufferedReader(l);
			PrintStream o = new PrintStream(new File("output.txt"));
			Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
			String line;
			int i = 0;
			int count = 0;
			// Number of Lines
			SourceCodeLineCounter soc = new SourceCodeLineCounter();
			String name = chooser.getSelectedFile().getName();
			o.println("Number of lines (without comments) of " + name + " is " + soc.getNumberOfLines(br));
			// Number of Control Structures
			Reader r1 = new FileReader(chooser.getSelectedFile());
			BufferedReader key = new BufferedReader(r1);

			while ((line = key.readLine()) != null) {
				if (line.contains("int") || line.contains("double") || line.contains("static")
						|| line.contains("public") || line.contains("String")) {
					count++;
					hash.put(i, line);
					i++;
				}
			}
			for (int j = 0; j < hash.size(); j++) {
				o.println((j + 1) + ". : " + hash.get(j));
			}
			o.println("Number of key words: " + count);
			final long endTime = System.currentTimeMillis();
			o.println("Total execution time in milliseconds: " + (endTime - startTime) + " ms");

		}

	}
}
