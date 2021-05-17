package Part1.impl.Task3;

import Part1.interfaces.Edge;

public class EdgeImplTask3 implements EdgeTask3 {

    private String a, b; //vertex left, right
    private float w; //weight

    public EdgeImplTask3(String a, String b, float w) {
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
    public float weight() {
        return w;
    }

    @Override
    public int compareTo(EdgeTask3 o) {
        //this.compareTo(other) < 0 if this < other
        //this.compareTo(other) = 0 if this == other
        //this.compareTo(other) > 0 if this > other
        //if(this.w < o.getWeight()) return ...
        //TOG's way:
        float f = this.w - o.weight();
        if (f > 0) return 1;
        if (f < 0) return -1;
        return 0;
    }
}
