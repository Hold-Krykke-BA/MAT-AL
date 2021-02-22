package solution;

/**
 * Implementation of Weighted Union with Path Compression.
 * Notable changes are to be found in the findRoot() method.
 *
 * @see {@link #findRoot(int)}
 */
public class WeightedUnionPC implements IUnionFind {
    private final int[] id;                 // parent link
    private final int[] size;               // size of component for roots
    private int count;                      // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set
     * and is its own size.
     *
     * @param n the number of elements
     */
    public WeightedUnionPC(int n) {
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
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) return;         // if(connected(p, q)) return;

        if (size[pRoot] < size[qRoot]) {    // root of p is smaller than root of q
            id[pRoot] = qRoot;              // root of p now points to root of q
            size[qRoot] += size[pRoot];     // size/weight of q is incremented with size/weight of p
        } else {                              // root of p is greater or equal root of q
            id[qRoot] = pRoot;              // root of q now points to root of p
            size[pRoot] += size[qRoot];
        }
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
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        //Compress the path leading back to the root
        //We still have p (starting point) and now also actual root!
        //https://www.youtube.com/watch?t=185&v=KbFlZYCpONw&feature=youtu.be
        //This is done every time we use union, so we can constantly optimize the tree
        while (p != root) { //traverse from starting point p to root
            int next = id[p]; //save original next node pointer
            id[p] = root; //point element to root rather than next node
            p = next;
        }
        return root;
    }

    @Override
    /**
     * @return the number of sets (between 1 and n)
     */
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        WeightedUnionPC wupc = new WeightedUnionPC(10); //extra

        //weighted union with path compression (EXTRA)
        wupc.union(1,3);
        wupc.union(6,2);
        wupc.union(9,8);
        wupc.union(4,5);
        wupc.union(0,7);

        wupc.union(3,9);
        wupc.union(8,0);
        System.out.println("\n***** Weighted Union with Path Compression (EXTRA) *****\n");
        System.out.println("3 and 8 connected? " + wupc.connected(3,8)); //true
        System.out.println("0 and 3 connected? " + wupc.connected(0,3)); //true
        System.out.println("4 and 6 connected? " + wupc.connected(4,6)); //false
    }
}
