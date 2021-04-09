import interfaces.State;
import interfaces.SyntaxTree;
import interfaces.ValueSet;
import state.*;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MappedState P = new MappedState(); // precondition
        Map<String, ValueSet> pre = P.getVariables();

        RangeValueSet rvs = new RangeValueSet(false, 0, 100);
        pre.put("One", rvs);
        RangeValueSet rvs2 = new RangeValueSet(false, 50, 1500);
        pre.put("Two", rvs2);


        //Map<String, ValueSet> postConditionVariables = new HashMap<>();
        MappedState Q = new MappedState(); // postcondition

        Map<String, ValueSet> post = Q.getVariables();

        RangeValueSet rvs3 = new RangeValueSet(false, 0, 100);
        post.put("One", rvs);
        RangeValueSet rvs4 = new RangeValueSet(false, 50, 1500);
        post.put("Two", rvs2);


        SyntaxTree C = new VSSLSyntaxTree(); // commands / code / program
        State S = C.analyse(P);
        if (S.subStateOf(Q)) {
            System.out.println("Hurra!");
        } else {
            System.out.println("Øv!");
        }
    }
}
