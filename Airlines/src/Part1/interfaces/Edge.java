package Part1.interfaces;

public interface Edge extends Comparable<Edge>{
    int from();
    int to();
    float weight();
}
