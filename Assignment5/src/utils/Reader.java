package utils;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Reader {
    // Accept alphabet from main
    // Decode alphabet?
    // Accept/read logfiles from path
    // Group logs by instance
    // Send grouped logs and alphabet to Automaton?

    public HashMap<String, ArrayList<String>> ScanFile(String path) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, ArrayList<String>> logEntries = new HashMap<>();
        while (sc.hasNextLine())
        {
            String[] arr = sc.nextLine().split(",");
            if (logEntries.containsKey(arr[2])) {
                logEntries.get(arr[2]).add(arr[3]);
            } else {
                ArrayList<String> tempArr = new ArrayList<>();
                tempArr.add(arr[3]);
                logEntries.put(arr[2],tempArr);
            }
        }
//        for (HashMap.Entry<String, ArrayList<String>> entry : logEntries.entrySet()) {
//            String key = entry.getKey();
//            ArrayList<String> value = entry.getValue();
//            System.out.println(key + " " + value);
//        }
        sc.close();
        return logEntries;
    }
}
