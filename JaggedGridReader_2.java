import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.JFrame;

public class JaggedGridReader_2 {
    private String fileName;
    private char[][] grid;

   public static void main(String[] args) throws Exception {
   
    FileReader f = new FileReader("ArrayInput.txt"); //read in file
    BufferedReader reader = new BufferedReader(f);
    Scanner sc = new Scanner(reader);
    
   }

    public int JaggedGridReader(String fileName) {
        this.fileName = fileName;
        readFile();
        return -1;
    }

    private void readFile() {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int rowCount = 0;

            while (sc.hasNextLine()) {
                rowCount++;
                sc.nextLine();
            }

            sc.close();
            sc = new Scanner(new File(fileName));
            grid = new char[rowCount][];

            for (int i = 0; i < rowCount; i++) {
                String line = sc.nextLine();
                grid[i] = line.toCharArray();
            }
        } catch (FileNotFoundException e) {
            grid = null;
        }
    }

    public String toString() {
        if (grid == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public char[][] getCopy() {
        if (grid == null) {
            return null;
        }

        char[][] copy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }

    public String getFileName() {
        return fileName;
    }
}
