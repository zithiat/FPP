package day18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFiles {

	private BufferedReader br;
	private PrintWriter pw;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the file name to read:");
		String s = sc.nextLine();
		if (null == s || s.equals("")) {
			System.out.println("File name invalid");
		}
		MyFiles mf = new MyFiles();
		mf.readWriteFile(s);
		sc.close();
	}
	
	public void readWriteFile(String fileName) {
		try {
			String curDir = (String) new File("").getAbsolutePath() + "\\src\\day18\\";
			fileName = curDir + fileName;
			String[] sa = fileName.split("\\.(?=[^\\.]+$)");
			File sf = new File(fileName);
			File df = new File(sa[0] + "_copy." + sa[1]);
			FileReader fr = new FileReader(sf);
			FileWriter fw = new FileWriter(df);
			br = new BufferedReader(fr);
			pw = new PrintWriter(fw);
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				pw.write(s + "\n");
			}
			pw.close();
		} catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		} 
		
	}
}
