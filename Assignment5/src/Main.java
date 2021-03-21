import interfaces.IState;
import solution.Automaton;
import solution.StateABCDEFG;
import utils.Reader;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static final String pathAsger = "C:\\Users\\regsa\\OneDrive\\Desktop\\Softwareudvikling\\assignments\\MAL\\MAT-AL\\Assignment5\\src\\data\\logfile.txt";
    private static final String pathRuni = "src/data/logfile.txt";
    private static final String pathCamilla = "";

    public static void Controller() {
        Automaton automaton = new Automaton();
        Reader reader = new Reader();
        HashMap<String, ArrayList<String>> logEntries = reader.ScanFile(pathRuni);

        System.out.println("------");
        //Print grouped log entries
        System.out.println("Values read from logfile");
        for (HashMap.Entry<String, ArrayList<String>> entry : logEntries.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.println(key + " " + value);
        }

        System.out.println("------");
        //Check if actions is legal on instance ID
        System.out.println("Are the performed actions allowed?");
        for (HashMap.Entry<String, ArrayList<String>> entry : logEntries.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            IState state = new StateABCDEFG(0, false);
            System.out.println("key: " + key);
            for (int i = 0; i < value.size(); i++) {
                char action = value.get(i).toCharArray()[0];
                System.out.println("state " + state.getIndex() + ", action " + action + ": " + automaton.Ok(state, action));
                state = automaton.nextState(state, action);
            }
        }

        System.out.println("------");
        //List of instances running and "stuck" in non final state
        ArrayList<String> instanceID = new ArrayList<>();
        for (HashMap.Entry<String, ArrayList<String>> entry : logEntries.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            if (value.indexOf("G") == -1) {
                instanceID.add(key);
            }
        }
        System.out.println("List of instances not logged out");
        for (String id : instanceID) {
            System.out.println("Instance ID: " + id);
        }

    }

    public static void main(String[] args) {
        Automaton automaton = new Automaton();
        System.out.println("Printing Automaton");
        for (int i = 0; i < automaton.getTable().length; i++) {
            for (int j = 0; j < automaton.getTable()[i].length; j++) {
                if (automaton.getTable()[i][j] == null) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(automaton.getTable()[i][j].getIndex() + " ");
                }
            }
            System.out.println();
        }
        Controller();
//        System.out.println(automaton.Ok(new StateABCDEFG(0, false), 'A'));
//        System.out.println(automaton.nextState(new StateABCDEFG(1, false), 'A'));
//        System.out.println(automaton.nextState(new StateABCDEFG(1, false), 'B').getIndex());
//
    }
}
