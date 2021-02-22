package solution;

import utils.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Timings {

    /**
     * Timings main
     *
     * Inspired by Algorithms pg. 221.
     *
     * Update paths to your files and run
     *
     * Example usage with System.in: java Timings < ..\data\tinyUF.txt
     * (requires updated JDK & terminal in the out\production\Assignment2\solution folder)
     *
     * @param args file path
     */
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in); //load filepath from system.in
        //String path = "./src/data/tinyUF.txt";
        //String path = "./src/data/mediumUF.txt";
        String path = "./src/data/largeUF.txt";

        try (Scanner in = new Scanner(new File(path))) {
            IUnionFind unionType;
            int N = in.nextInt(); // Read number of sites.

            unionType = new QuickUnion(N); // Initialize N components.
            //unionType = new WeightedUnion(N);
            //unionType = new WeightedUnionPC(N);
            
            Stopwatch sw1 = new Stopwatch();
            while (in.hasNext()) {
                int p = in.nextInt();
                int q = in.nextInt(); // Read pair to connect.
                //if (unionType.connected(p, q)) continue; // Ignore if connected.
                unionType.union(p, q); // Combine components
                //System.out.println(p + " " + q); // and print connection.
            }
            double timer = sw1.elapsedTime();
            System.out.println("Components: " + unionType.count());
            System.out.println("Elapsed time: " + timer + "ms");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found ->" + e);
        }

    }
}
