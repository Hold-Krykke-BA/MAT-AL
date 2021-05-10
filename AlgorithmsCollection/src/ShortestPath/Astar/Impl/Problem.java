package ShortestPath.Astar.Impl;
import ShortestPath.Astar.Interfaces.ManhattanGraph;
import ShortestPath.Astar.util.GraphFromFile;
import java.io.IOException;

public class Problem implements ManhattanGraph {
    private int[][] map;
    private int arr1;
    private int arr2;

    public Problem(String filePath, int arr1, int arr2) throws IOException {
        this.arr1 = arr1;
        this.arr2 = arr2;
        GraphFromFile gff = new GraphFromFile();
        map = gff.read(filePath, arr1, arr2);
    }

    @Override
    public int width() {
        return arr1;
    }

    @Override
    public int height() {
        return arr2;
    }

    @Override
    public int get(int x, int y) {
        return map[x][y];
    }
}
