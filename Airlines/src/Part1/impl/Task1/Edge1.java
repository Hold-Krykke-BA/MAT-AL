package Part1.impl.Task1;

import Part1.impl.Task3.EdgeTask3;

public class Edge1 implements IEdge1{

    private String a, b; //vertex left, right
    private String w; //airline

    public Edge1(String a, String b, String w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public String from() {
        return a;
    }

    @Override
    public String to() {
        return b;
    }

    @Override
    public String airline() {
        return w;
    }

    @Override
    public int compareTo(IEdge1 other) {
        if (!other.airline().equals(airline())) return -1;
        return 0;
    }
}
