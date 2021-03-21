package solution;

import interfaces.IState;

public class StateABCDEFG implements IState {
    private int index;
    private boolean isFinal;

    public StateABCDEFG(int index, boolean isFinal) {
        this.index = index;
        this.isFinal = isFinal;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }
}
