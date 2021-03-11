package com.company;

public class Main {

    /*
    * Move the top n-1 disks to the auxiliary tower.
      Move 1 disk from source rod to destination rod.
      Take the n-1 disks from auxiliary disk to the destination rod.
    * */
    private static int count = 0;
    static void towerOfHanoi(int n, char start_rod, char destination_rod, char helper_rod)
    {
        count++;
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  start_rod + " to rod " + destination_rod);
            return;
        }
        towerOfHanoi(n-1, start_rod, helper_rod, destination_rod);
        System.out.println("Take disk " + n + " from rod " +  start_rod + " to rod " + destination_rod);
        towerOfHanoi(n-1, helper_rod, destination_rod, start_rod);
    }

    public static void main(String args[])
    {
        int n = 8;
        towerOfHanoi(n,'A','C', 'B');
        System.out.println("Minimum amount of moves: " + count);
    }

}
