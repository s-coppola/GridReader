import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.JFrame;

public class JaggedGridReader_ {

   public void JaggedGridReader(String FILE_NAME) throws Exception {
   
      FileReader f = new FileReader(FILE_NAME+".txt"); //read in file
      BufferedReader reader = new BufferedReader(f);
      Scanner sc = new Scanner(reader);
      
      int detectRow = 4; // hardcoded for now - need to fix
      int detectCol = 4;
      
      // below turns values from file into array
      int rows = detectRow;
      int columns = detectCol;
      int [][] myArray = new int[rows][columns];
      while(sc.hasNextLine()) {
         for (int i=0; i<myArray.length; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<line.length; j++) {
               myArray[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
      
      String out = Arrays.deepToString(myArray);
      System.out.println(out);
      
   }
   /*
   public static int getRowCol(Scanner sc) {
      int detectRow = 0;
      int detectCol = 0;
      
   }
   */
   
   public class Grid extends Canvas
   {
   
    public void paint(Graphics g) {
      Rectangle window = g.getClip().getBounds();
      double height = window.getHeight();
      double width = window.getWidth();
      double fracX = 25/300.0;
      double fracY = 25/300.0;
      double fracW = 140/300.0;
      double fracH = 40/300.0;
      double numRows = height/height;
      double numCols = width/width;
      /*
        g.setColor(Color.cyan);      // Set color
        g.fillRect((int)(fracX*width), (int)(fracY*height), (int)(fracW*width), (int)(fracH*height)); // Fill rectangle
        g.setColor(Color.blue);      // Set color
        g.drawRect(25,25,140,40); // Outline rectangle
        g.setColor(Color.black);     // Set color
        g.drawString("Hello, World!", 50, 50); // Display string
        g.setColor(Color.yellow);
        g.fillOval(25, 75, 140, 40); // Fill oval
        g.setColor(Color.red);
        g.drawOval(25, 75, 140, 40); // Outline oval
        g.setColor(Color.black);
        g.drawString("Welcome to Java", 50, 100);
        */
        
        for(int row = 0; row < 5; ++row) {
         for (int col = 0; col <5; ++col) {
            g.setColor(new Color((int)(255.0*row/5.0),(int)(255.0*col/5.0),0));
            drawCell(g,row, col, (int)width, (int)height,5,5);
         }
        }
    }//paint()
    
    public void drawCell(Graphics g, int row, int col, int width, int height, int numRows, int numCols) {
      int cellW = width/numCols;
      int cellH = height/numRows;
      int cellX = col*cellW;
      int cellY = row*cellH;
      g.fillRect(cellX, cellY, cellW, cellH);
      
   }

    public static void main(String[] args){
        JaggedGridReader();
        Grid c = new Grid();
        JFrame f = new JFrame();
        f.add(c);
        f.setSize(300, 300);
        f.setVisible(true);
    } //main
}

   
}