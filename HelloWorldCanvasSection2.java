import java.awt.*;
import javax.swing.JFrame;

public class HelloWorldCanvasSection2 extends Canvas
{
    public void paint(Graphics g) {
         Rectangle window = g.getClip().getBounds();
         double width = window.getWidth();
         double height = window.getHeight();
         
         double fracX = 25.0/300.0;
         double fracY = 25.0/300.0;
         double fracW = 140.0/300.0;
         double fracH = 40.0/300.0;
         double strX = 50.0/300;
         double strY = 50.0/300;
        g.setColor(Color.cyan);      // Set color
        g.fillRect((int)(fracX*width), (int)(fracY*height), 
                   (int)(fracW*width), (int)(fracH*height)); // Fill rectangle
        
        //g.fillRect(25, 25, 140, 40); // Fill rectangle
        g.setColor(Color.blue);      // Set color
        g.drawRect((int)(fracX*width), (int)(fracY*height), 
                   (int)(fracW*width), (int)(fracH*height)); // Outline rectangle
        g.setColor(Color.black);     // Set color
        //g.drawString("Hello, World!", 50, 50); // Display string
        g.drawString("Hello, World!", (int)(strX*width), 
                                      (int)(strY*height)); // Display string

        g.setColor(Color.yellow);
        g.fillOval(25, 75, 140, 40); // Fill oval
        g.setColor(Color.red);
        g.drawOval(25, 75, 140, 40); // Outline oval
        g.setColor(Color.black);
        g.drawString("Welcome to Java", 50, 100);
        
        int nrows = 5;
        int ncols = 5;
        for(int row = 0; row < nrows; ++row) {
           for( int col = 0; col < ncols; ++col) {
              g.setColor(new Color((int)(255.0 * row/nrows),
                                   (int)(255.0 * col/ncols),
                                   0));
              
              drawCell(g, row,col,(int)width,(int)height,nrows,ncols);
              }
              }
        
    }//paint()
    
    public static void drawCell(Graphics g, int row, int col, int width, int height,
                                int numRows, int numCols) {
      int cellWidth = width/numCols;
      int cellHeight = height /numRows;
      int cellX = col * cellWidth;
      int cellY = row * cellHeight;
      g.fillRect(cellX, cellY, cellWidth, cellHeight);
   
   
   
   
   
   
   
   
   
                                
                                
   }

    public static void main(String[] args){
        HelloWorldCanvas c = new HelloWorldCanvas();
        JFrame f = new JFrame();
        f.add(c);
        f.setSize(300, 300);
        f.setVisible(true);
    } //main
} //HelloWorldCanvas