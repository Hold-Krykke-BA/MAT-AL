package state;

import interfaces.State;
import interfaces.ValueSet;

public class ConjunctionState implements State {
    private State left;
    private State right;

    public ConjunctionState(State left, State right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean subStateOf(State other) {
        return (other.subStateOf(left) && other.subStateOf(right));
    }

    @Override
    public ValueSet valuesOf(String variableName) {
        ValueSet leftValue = left.valuesOf(variableName);
        ValueSet rightValue = right.valuesOf(variableName);
        return new UnionValueSet(leftValue, rightValue);
    }
}
