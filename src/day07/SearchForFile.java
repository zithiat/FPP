package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchForFile {

	private ArrayList<String> absolutePath = new ArrayList<String>(); // to store found results
	
	public static void main(String[] args) {
		SearchForFile sff = new SearchForFile();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name:");
		String fileName = sc.nextLine();
		System.out.print("Enter path to search:");
		String startDir = sc.nextLine();
		if (!sff.searchForFile(fileName, startDir)) {
			System.out.println("Not found");
		} else {
			System.out.println("Found at: " + sff.absolutePath);
		}
		sc.close();
	}
	
	private boolean searchForFile(String fileName, String startDir) {
		boolean found = false;
		if (fileName.equals(null) || fileName.equals("") || startDir.equals(null) || startDir.equals("")) {
			return false;
		}
		File[] list = getFileList(startDir);
		for (File f : list) {
			System.out.println(f.getName());
			if (f.getName().startsWith(".")) { // to avoid the kind of file like ".DS_Store" on MacOS
				continue;
			}
			if (f.isDirectory()) {
				searchForFile(fileName, f.getAbsolutePath().toString());
			} else {
				if (f.getName().equals(fileName)) {
					this.absolutePath.add(f.getAbsolutePath());
					found = true;
				}
			}
		}
		return found;
	}
	
	private File[] getFileList(String path) {
		File dir = new File(path);
		return dir.listFiles();		
	}
}
