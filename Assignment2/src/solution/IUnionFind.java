package solution;

public interface IUnionFind {
    void union(int p, int q);                   // add connection between p and q
    int count();                                // number of components/sets
    int findRoot(int p);                            // component identifier for p ( given point p, return set of p)

    /**
     //     * @param  p one element
     //     * @param  q the other element
     //     * @return true if p and q are in the same set else false.
     //     */
    default boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    };
}
