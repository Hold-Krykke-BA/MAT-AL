package solution;
import interfaces.IAutomaton;
import interfaces.IState;

import java.util.List;

public class Automaton implements IAutomaton {
    // Accept decoded alphabet (rules)?
    // Accept grouped logfiles
    // determine
        // is the action legal according to the present state
        // is any instance stuck at a non-final (non-accepting) state
        // give a list of the running instances



    @Override
    public List<IState> getStates() {
        return null;
    }

    @Override
    public IState getInitialState() {
        return null;
    }

    @Override
    public IState nextState(IState state, char symbol) {
        return null;
    }
}
