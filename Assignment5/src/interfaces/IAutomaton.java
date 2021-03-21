package interfaces;

import java.util.List;

public interface IAutomaton {
    List<IState> getStates();
    IState getInitialState();
    IState nextState(IState state, char symbol);
}
