package Part1.impl.Task1;

public interface IGraph1 {
    int V(); //vertex
    int E(); //Edge
    Iterable<IEdge1> adj(String v);
    Iterable<IEdge1> edges();
}
