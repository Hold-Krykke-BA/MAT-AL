package Graphs.Directed.Interfaces;


public interface DirectedEdge extends Comparable<DirectedEdge>{
    int from();
    int to();
    float weight();
}