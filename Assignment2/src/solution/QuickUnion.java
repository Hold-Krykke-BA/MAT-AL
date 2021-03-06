package solution;

public class QuickUnion implements IUnionFind {
    private int[] id;               // access to component id
    private int count;              // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set.
     * @param n the number of elements
     */
    public QuickUnion(int n) {
        this.id = new int[n];    // Initialize component id array
        count = n;               // Initialize count to n
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    /**
     * Merges the set containing element p with the set containing element q
     *
     * Follow links to find the roots associated with p and q,
     * then rename one of the components by linking one of these
     * roots to the other
     * @param  p one element
     * @param  q the other element
     */
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) return; // if(connected(p, q)) return;
        id[pRoot] = qRoot;
        count--;
    }

    @Override
    /**
     * Start at p, follow its link to another site and so
     * forth until reaching a site that has a link to itself (root)
     * @param  p an element
     * @return root of p
     */
    public int findRoot(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    /**
     * @return the number of sets (between 1 and n)
     */
    public int count() {
        return count;
    }

}
