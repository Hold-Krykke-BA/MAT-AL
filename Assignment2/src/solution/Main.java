package solution;

public class Main {

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        WeightedUnion wu = new WeightedUnion(10);
        WeightedUnionPC wupc = new WeightedUnionPC(10); //extra

        //quick union
        qu.union(1,3);
        qu.union(6,2);
        qu.union(9,8);
        qu.union(4,5);
        qu.union(0,7);

        qu.union(3,9);
        qu.union(8,0);

        //weighted union
        wu.union(1,3);
        wu.union(6,2);
        wu.union(9,8);
        wu.union(4,5);
        wu.union(0,7);

        wu.union(3,9);
        wu.union(8,0);

        //weighted union with path compression (EXTRA)
        wupc.union(1,3);
        wupc.union(6,2);
        wupc.union(9,8);
        wupc.union(4,5);
        wupc.union(0,7);

        wupc.union(3,9);
        wupc.union(8,0);

        System.out.println("\n***** Quick Union *****\n");
        System.out.println("3 and 8 connected? " + qu.connected(3,8));
        System.out.println("0 and 3 connected? " + qu.connected(0,3));
        System.out.println("4 and 6 connected? " + qu.connected(4,6));

        System.out.println("\n***** Weighted Union *****\n");
        System.out.println("3 and 8 connected? " + wu.connected(3,8));
        System.out.println("0 and 3 connected? " + wu.connected(0,3));
        System.out.println("4 and 6 connected? " + wu.connected(4,6));

        System.out.println("\n***** Weighted Union with Path Compression (EXTRA) *****\n");
        System.out.println("3 and 8 connected? " + wupc.connected(3,8));
        System.out.println("0 and 3 connected? " + wupc.connected(0,3));
        System.out.println("4 and 6 connected? " + wupc.connected(4,6));

    }
}
