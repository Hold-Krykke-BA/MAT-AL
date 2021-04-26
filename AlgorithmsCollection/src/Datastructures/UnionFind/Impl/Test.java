package Datastructures.UnionFind.Impl;

import Datastructures.UnionFind.Interfaces.UnionFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String path = "src/Textfiles/tinyUF.txt";
        //String path = "src/Textfiles/mediumUF.txt";
        //String path = "src/Textfiles/largeUF.txt";

        try (Scanner in = new Scanner(new File(path))) {
            UnionFind unionType;
            int N = in.nextInt(); // Read number of sites.

            unionType = new QuickUF(N); // Initialize N components.
            //unionType = new WeightedUF(N);
            //unionType = new WeightedUFWithPC(N);

            while (in.hasNext()) {
                int p = in.nextInt();
                int q = in.nextInt(); // Read pair to connect.
                //if (unionType.isConnected(p, q)) continue; // Ignore if connected.
                unionType.union(p, q); // Combine components
                //System.out.println(p + " " + q); // and print connection. (don't do for largeUF!)
            }
            System.out.println("Components: " + unionType.count());

        } catch (FileNotFoundException e) {
            System.out.println("File not found ->" + e);
        }
    }
}
