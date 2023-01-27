import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jan25Example {
    private File myFile;
    private Scanner input;
 
    public Jan25Example(String fileName) {
        
        while(input == null) {
         try{
            myFile = new File(fileName);
            input = new Scanner(myFile);

         } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found!");
            Scanner s = new Scanner(System.in);
            System.out.print("Enter correct filename: ");
            fileName = s.nextLine();
         }
        }
    }

}