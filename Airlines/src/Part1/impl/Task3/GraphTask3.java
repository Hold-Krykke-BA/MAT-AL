package Part1.impl.Task3;

public interface GraphTask3 {
    int V(); //vertex
    int E(); //Edge
    Iterable<EdgeTask3> adj(String v);
    Iterable<EdgeTask3> edges();
}
