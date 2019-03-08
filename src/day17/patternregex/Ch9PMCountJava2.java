package day17.patternregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Ch9PMCountJava2 {
	public static void main(String[] args) {

		String document;
		int javaCount = 0;

		Matcher matcher;
		Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

		document = JOptionPane.showInputDialog(null, "Sentence:");

		matcher = pattern.matcher(document);

		while (matcher.find()) {
			javaCount++;
			System.out.println(document.substring(matcher.start(), matcher.end()) + " found at position "
					+ matcher.start() + " javaCount=" + javaCount);
		}

	}

}
