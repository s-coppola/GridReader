/*
Start:
...
...
...

End result:

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Random;

public class GameFileTester {

   private char[][] grid;
   private String fileName;
 
 public GameFileTester(String fileName) { //constructor
 
   //store filename
   this.fileName = fileName;
   this.grid = readFile(fileName); //read file
   toString();
   
 }
   // read file method
   private char[][] readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = 0;
            while ((line = br.readLine()) != null) {
                rows++;
            }
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            char[][] grid = new char[rows][];
            int i = 0;
            while ((line = br2.readLine()) != null) {
                grid[i] = line.toCharArray();
                i++;
            }
            return grid;
        } catch (IOException e) {
            return null;
        }
    } 
 
 public String toString() {
   //return a string that is the end result
   
   StringBuilder sb = new StringBuilder();
   for (int i=0; i< this.grid.length; i++) {
      for (int j=0; j < this.grid[i].length; j++) {
         sb.append(grid[i][j]);
      }
      sb.append("\n");
   }
   return sb.toString();
 }
 
 public char[][] playGame() {
   //if char is . - replace with X
   
 
   
   
   char[][] line = new char[grid.length][];
      for (int i = 0; i < grid.length; i++) {
         line[i] = Arrays.copyOf(grid[i], grid[i].length);
         //System.out.print(line[i]);
            //for(int j = 1; j < grid.length-1; i++) {
            //}
      }
      //System.out.print(line);
      return line;
   }
 
   public String getFileName() {
      //return the file name specified on construction
      return fileName;
   }

   public static void main(String[] args) {
    
      JaggedGridReader start = new JaggedGridReader("start.txt");
      System.out.println("Start:\n\n" + start); 
      
      char wall = '*';
      char path = '.';
      char token = 'X';
      char end = 'O';
      
      // CSC 141 class notes
      File f = new File("start.txt");
      PrintWriter outputFile = new PrintWriter("end.txt");
      
      Random r = new Random();
      
      if (!f.exists())
      {
          System.out.println("File not found.");
          System.exit(1); 
      }
   
      Scanner inputFile = new Scanner(f);
      
      while (inputFile.hasNext())   // keep looping while there are more lines in file
      {
       String line = inputFile.nextLine(); // read a line from file
       System.out.println(line.toUpperCase()); // uppercase that line
       outputFile.println(line.toUpperCase()); // write the uppercased line to file 2
      }
      
      System.out.println();
      
      inputFile.close();
      outputFile.close();  
      
      
      //GameFileTester end = new GameFileTester("end.txt");
      //System.out.println("End: \n\n" + end);
   }
   
   
}