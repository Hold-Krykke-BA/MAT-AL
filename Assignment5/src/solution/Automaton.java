package solution;
import interfaces.IAutomaton;
import interfaces.IState;

import java.util.ArrayList;
import java.util.List;


public class Automaton implements IAutomaton {
    // Accept decoded alphabet (rules)?
    // Accept grouped logfiles
    // determine
        // is the action legal according to the present state
        // is any instance stuck at a non-final (non-accepting) state
        // give a list of the running instances

    private List<IState> states = new ArrayList<>();
    private IState initialState;


    public Automaton(int stateCount){
        states.add(initialState = new StateABCDEFG(0, false));
        for (int index = 1; index < stateCount; index++) {
            if (index == stateCount-1) states.add(new StateABCDEFG(index, true));
            else states.add(new StateABCDEFG(index, false));
        }
    }


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
