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
    private final IState[][] table;
    private IState initialState;

    //AB(C(D|E))|F*G
    public Automaton(){
        states.add(initialState = new StateABCDEFG(0, false));
        for (int index = 1; index < 6; index++) {
            if (index == 4) states.add(new StateABCDEFG(index, true));
            else states.add(new StateABCDEFG(index, false));
        }
        table = new IState[states.size()-1][7];
        table[0][0] = states.get(1);
        table[1][1] = states.get(2);
        table[1][5] = states.get(1);
        table[1][6] = states.get(4);
        table[2][2] = states.get(3);
        table[2][5] = states.get(2);
        table[2][6] = states.get(4);
        table[3][3] = states.get(2);
        table[3][4] = states.get(2);
    }

    public boolean Ok(IState state, char symbol) {
        return nextState(state, symbol) == null ? false : true;
    }

    public IState[][] getTable() {
        return table;
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
        return state == null ? null : table[state.getIndex()][indexOfSymbol(symbol)];
    }

    private int indexOfSymbol(char symbol) {
        if (Character.toLowerCase(symbol) < 'a' || 'g' < Character.toLowerCase(symbol)) throw new IllegalArgumentException();
        return Character.toLowerCase(symbol) - 'a';
    }
}
