import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JaggedGridReader_ch {
    private String filename;
    private char[][] grid;

    public JaggedGridReader(String filename) {
        this.filename = filename;
        this.grid = readFile(filename);
    }

    private char[][] readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = 0;
            while ((line = br.readLine()) != null) {
                rows++;
            }
            br.close();
            br = new BufferedReader(new FileReader(filename));
            char[][] grid = new char[rows][];
            int i = 0;
            while ((line = br.readLine()) != null) {
                grid[i] = line.toCharArray();
                i++;
            }
            return grid;
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
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
        return filename;
    }

    public String toString() {
        if (grid == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            sb.append(row).append("\n");
        }
        return sb.toString();
    }
}
