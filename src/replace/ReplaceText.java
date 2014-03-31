package replace;

import java.io.*;

public class ReplaceText {
  public static void main(String[] args) throws Exception {
    // Check if source file exists
    // Check if target file exists
    File targetFile = new File("Password.txt");

    // Create input and output files
    PrintWriter output = new PrintWriter(targetFile);
    
    String s2 = "1111";
    output.print(s2);

    output.close();
  }
}
