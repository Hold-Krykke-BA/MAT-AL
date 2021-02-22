package solution;

public class Main {

    /**
     * Manual testing main
     * @param args none
     */
    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        WeightedUnion wu = new WeightedUnion(10);

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

        System.out.println("\n***** Quick Union *****\n");
        System.out.println("3 and 8 connected? " + qu.connected(3,8)); //true
        System.out.println("0 and 3 connected? " + qu.connected(0,3)); //true
        System.out.println("4 and 6 connected? " + qu.connected(4,6)); //false

        System.out.println("\n***** Weighted Union *****\n");
        System.out.println("3 and 8 connected? " + wu.connected(3,8)); //true
        System.out.println("0 and 3 connected? " + wu.connected(0,3)); //true
        System.out.println("4 and 6 connected? " + wu.connected(4,6)); //false

    }
}
