package ShortestPath.Astar.Interfaces;

public interface ManhattanGraph {
    static final int EMPTY = 0;
    static final int START = 1;
    static final int TARGET = 2;
    static final int WALL = 3;
    int width();
    int height();
    int get(int x, int y);
}
