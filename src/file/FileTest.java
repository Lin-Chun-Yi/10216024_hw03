package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("Password.txt");
		if (file.exists()){
			System.out.println("exists");
			Scanner input = new Scanner(file);
			String str = input.next();
			System.out.println(str);
			
			input.close();
		}
		
		PrintWriter output = new PrintWriter(file);
		output.print("0000");
		
		output.close();
		
	}

}
