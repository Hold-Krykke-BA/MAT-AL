package Datastructures.Queues.Priority.Impl;

import Datastructures.Queues.Priority.Interfaces.MinPriorityQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Testing mpq on String");
        MinPriorityQueue<String> pq = new MinPriorityQueueImpl();
        try (Scanner in = new Scanner(new File("src/Textfiles/tinyPQ.txt"))) {
            while (in.hasNext()) {
                String item = in.next();
                if (!item.equals("-")) pq.insert(item);
                else if (!pq.isEmpty()) System.out.print(pq.delMin() + " ");
            }
        }
        System.out.println("(" + pq.size() + " left on pq)");
        //Output: E A E (6 left on pq) (as in book)

        System.out.println("-----------------------------------------");
        System.out.println("Testing mpq on Integer");
        MinPriorityQueueImpl<Integer> pq2 = new MinPriorityQueueImpl();
        pq2.insert(5);
        pq2.insert(50);
        pq2.insert(75);
        pq2.insert(1);
        System.out.println("Added 4 items: 5, 50, 75, 1");
        System.out.println("pq2 (Integer) printed: " + pq2);
        //iterator begin
        Iterator iterator = pq2.iterator();
        System.out.println("Printing items using iterator");
        iterator.forEachRemaining(item -> System.out.print(item + " "));
        //iterator end
        System.out.println("\npq2 size: " + pq2.size());
        System.out.println("pq2 min: " + pq2.min());
        System.out.println("pq2 delMin(): " + pq2.delMin());
        System.out.println("pq2 size after delMin(): " + pq2.size());
        System.out.println("pq2 delMin(): " + pq2.delMin());
        System.out.println("pq2 size after delMin(): " + pq2.size());
        System.out.println("pq2 delMin(): " + pq2.delMin());
        System.out.println("pq2 size after delMin(): " + pq2.size());
    }
}
