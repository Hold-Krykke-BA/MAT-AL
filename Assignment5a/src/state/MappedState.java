package state;

import interfaces.State;
import interfaces.ValueSet;

import java.util.HashMap;
import java.util.Map;

public class MappedState implements State {
    private Map<String, ValueSet> variables = new HashMap<>();

    public MappedState(Map<String, ValueSet> variables) {
        this.variables = variables;
    }

    public MappedState(){}

    public void put(String variableName, ValueSet values) {
        ValueSet vs = variables.get(variableName);
        if (vs != null) {
            vs.union(values);
        } else {
            variables.put(variableName, values);
        }
    }

//    public void put(String variableName) {
//        // all values
//    }

    @Override
    public ValueSet valuesOf(String variableName) {
        return variables.get(variableName);
    }

    @Override
    public boolean subStateOf(State other) {
        if (other instanceof MappedState) {
            var mapped = (MappedState) other;
            for (String variableName : mapped.variables.keySet()) {
                var thisVariable = variables.get(variableName);
                if (thisVariable == null) return false;
                var otherVariable = mapped.variables.get(variableName);
                return thisVariable.subsetOf(otherVariable);
            }
        }
        return false;
    }

    public Map<String, ValueSet> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, ValueSet> variables) {
        this.variables = variables;
    }
}
