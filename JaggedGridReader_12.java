import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class JaggedGridReader_12 {
   public static void main(String args[]) throws Exception {
      
      FileReader fileName = new FileReader("ArrayInput.txt");
      BufferedReader reader = new BufferedReader(fileName);
      Scanner sc = new Scanner(reader);

      
      int rows = 4;
      int columns = 4;

      char [][] myArray = new char[rows][columns];
      while(sc.hasNextLine()) {
         for (int i=0; i<myArray.length; i++) {
            String[] line = sc.nextLine().trim().split("");
            for (int j=0; j<line.length; j++) {
               myArray[i][j] = line[j]; //char array fix
            }
         }
      }
      
      String out = Arrays.deepToString(myArray);
      System.out.println(out);
      System.out.println(rows + " " + columns);
      
   }
   
      public static int getRow(Scanner sc) {
         int rows = 0;
         int columns = 0;
   
               while (sc.hasNextLine()) {
                   rows++;
                   String line = sc.nextLine();
                   if (columns == 0) {
                       columns = line.length();
                   }
               }
               return rows;
       }
       
       public static int getCol(Scanner sc) {
         int rows = 0;
         int columns = 0;
   
               while (sc.hasNextLine()) {
                   rows++;
                   String line = sc.nextLine();
                   if (columns == 0) {
                       columns = line.length();
                   }
               }
               return columns;
       }
   
}