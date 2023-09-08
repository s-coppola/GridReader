package hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class JaggedGridReader {

   private char[][] grid;
   private String fileName;
 
 public JaggedGridReader(String fileName) { //constructor
 
   //store filename
   this.fileName = fileName;
   this.grid = readFile(fileName); //read file
   //System.out.println(getCopy());
   //System.out.println(toString());
   
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
   //return a string that is identical to the contents of the file
   
   StringBuilder sb = new StringBuilder();
   for (int i=0; i< this.grid.length; i++) {
      for (int j=0; j < this.grid[i].length; j++) {
         sb.append(grid[i][j]);
      }
      sb.append("\n");
   }
   return sb.toString();
 }
 
 public char[][] getCopy() {
   //return a deep copy of the grid or null if the file specified was not found
       if (grid == null) {
           return null;
       }
   
       char[][] copy = new char[grid.length][];
       for (int i = 0; i < grid.length; i++) {
           copy[i] = Arrays.copyOf(grid[i], grid[i].length);
       }
       return copy;
   }
 
   public String getFileName() {
      //return the file name specified on construction
      return fileName;
   }
       
    //test
   /*
   public static void main(String[] args) {
    
      JaggedGridReader g = new JaggedGridReader("ArrayInput.txt");
      
      System.out.println(g);   
   }
  */
}