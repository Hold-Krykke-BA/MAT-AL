package Datastructures.UnionFind.Interfaces;

/**
 * Generic type interface. Notice how <code>isConnected()</code> returns boolean and <code>count()</code> returns int.
 * <p>
 * Here's a non-interface solution using generics and HashMaps:
 * https://codereview.stackexchange.com/questions/49186/generic-implementation-of-the-quick-union-algorithm-with-path-compression
 *
 * @param <T> Type of choice
 */
public interface UnionFind<T> {
    /**
     * add connection between p and q
     *
     * @param p Element 1
     * @param q Element 2
     */
    void union(T p, T q);

    /**
     * number of components/sets
     *
     * @return int value of structure size
     */
    int count();

    /**
     * component identifier for p ( given point p, return set of p)
     *
     * @param p
     * @return
     */
    T findRoot(T p);

    /**
     * //     * @param  p one element
     * //     * @param  q the other element
     * //     * @return true if p and q are in the same set else false.
     * //
     */
    default boolean isConnected(T p, T q) {
        return findRoot(p) == findRoot(q);
    }
}
