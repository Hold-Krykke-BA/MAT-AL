import interfaces.State;
import interfaces.SyntaxTree;
import interfaces.ValueSet;
import state.*;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Testing RangeValueSet");
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


        System.out.println("-------------------------------------------");


        System.out.println("Testing BooleanValueSet");

        MappedState P2 = new MappedState(); // precondition
        Map<String, ValueSet> pre2 = P2.getVariables();

        BooleanValueSet bvs = new BooleanValueSet(false, true);
        pre2.put("One", bvs);
        BooleanValueSet bvs2 = new BooleanValueSet(false, false);
        pre2.put("Two", bvs2);


        //Map<String, ValueSet> postConditionVariables = new HashMap<>();
        MappedState Q2 = new MappedState(); // postcondition

        Map<String, ValueSet> post2 = Q2.getVariables();

        BooleanValueSet bvs3 = new BooleanValueSet(false, true);
        post2.put("One", bvs3);
        BooleanValueSet bvs4 = new BooleanValueSet(false, false);
        post2.put("Two", bvs4);

        SyntaxTree C2 = new VSSLSyntaxTree(); // commands / code / program
        State S2 = C2.analyse(P);
        if (S2.subStateOf(Q2)) {
            System.out.println("Hurra!");
        } else {
            System.out.println("Øv!");
        }
    }
}
