package state;

import interfaces.State;
import interfaces.SyntaxTree;
import interfaces.ValueSet;

public class VSSLSyntaxTree implements SyntaxTree {

    @Override
    public State analyse(State condition) {
        if (condition instanceof MappedState) {
            var mapped = (MappedState) condition;
            for (ValueSet vs : mapped.getVariables().values()) {
                if (vs.canBeUndefined()) return null;
            }
            return condition;
        }

        return null;
    }
}
