package solution;

public class WeightedUnion implements IUnionFind {
    private int[] id;                       // parent link
    private int[] size;                     // size of component for roots
    private int count;                      // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set
     * and is its own size.
     * @param n the number of elements
     */
    public WeightedUnion(int n)
    {
        count = n;                          // Initialize count to n
        this.id = new int[n];               // Initialize component id array
        this.size = new int[n];             // Initialize size array
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    @Override
    /**
     * Merges the set containing element p with the set containing element q
     * Make root of smaller tree point to root of larger tree.
     * @param  p one element
     * @param  q the other element
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;         // if(connected(p, q)) return;

        if (size[pRoot] < size[qRoot]) {    // root of p is smaller than root of q
            id[pRoot] = qRoot;              // root of p now points to root of q
            size[qRoot] += size[pRoot];     // size/weight of q is incremented with size/weight of p
        }
        else {                              // root of p is greater or equal root of q
            id[qRoot] = pRoot;              // root of q now points to root of p
            size[pRoot] += size[qRoot];
        }
        count--;
    }


    @Override
    /**
     * start at p, follow its link to another site and so
     * forth until reaching a site that has a link to itself (root)
     * @param  p an element
     * @return root of p
     */
    public int find(int p) {
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

//    @Override
//    /**
//     * @param  p one element
//     * @param  q the other element
//     * @return true if p and q are in the same set else false.
//     */
//    public boolean connected(int p, int q) {
//        return find(p) == find(q);
//    }
}
