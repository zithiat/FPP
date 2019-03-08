package day17.patternregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Ch9PMCountJava {
	public static void main(String[] args) {

		String document;
		int javaCount;

		Matcher matcher;
		Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

		document = JOptionPane.showInputDialog(null, "Sentence:");

		javaCount = 0;
		matcher = pattern.matcher(document);

		while (matcher.find()) {
			javaCount++;
		}

		JOptionPane.showMessageDialog(null, "The word 'java' occurred " + javaCount + " times.");
	}

}
