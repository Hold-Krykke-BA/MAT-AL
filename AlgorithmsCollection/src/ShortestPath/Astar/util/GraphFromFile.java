package ShortestPath.Astar.util;
import java.io.*;
import java.util.Arrays;

public class GraphFromFile {
    static final int EMPTY = 0;
    static final int START = 1;
    static final int TARGET = 2;
    static final int WALL = 3;

    public int[][] read(String filePath, int arr1, int arr2) throws IOException {
        int walls = 0;
        int start = 0;
        int end = 0;
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            int[][] arr = new int[arr1][arr2];
            int y = 0;
            String line;
            while ((line = r.readLine()) != null) {
                int x = 0;
                //System.out.println(line);
                for (char c : line.toCharArray()) {
                    System.out.print(c);
                    int res = -1;
                    if (c == '*') res = EMPTY;
                    if (c == 'S') {
                        res = START;
                        //start =
                    }
                    if (c == 'T') {
                        res = TARGET;
                        //end =
                    }
                    if (c == 'W'){
                        res = WALL;
                        walls++;
                    }
                    arr[x][y] = res; //seems "wrong" but this is the way it works with ManhattanProblem
                    x++;
                }
                System.out.println();
                y++; //new line, new array "line"
            }
            System.out.println("walls: " + walls);
            return arr;
        }
    }

    public static void main(String[] args) throws IOException {
        GraphFromFile gff = new GraphFromFile();
        int[][] result = gff.read("src/ShortestPath/Astar/util/ProblemA.txt", 25, 25);
        //System.out.println(Arrays.deepToString(result));
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
