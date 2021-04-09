package state;

import interfaces.ValueSet;

import java.lang.reflect.MalformedParameterizedTypeException;

public class BooleanValueSet implements ValueSet {
    private boolean mightBeUndefined;
    private boolean state;

    public BooleanValueSet(boolean mightBeUndefined, boolean state) {
        this.mightBeUndefined = mightBeUndefined;
        this.state = state;
    }

    @Override
    public boolean canBeUndefined() {
        return mightBeUndefined;
    }

    @Override
    public boolean contains(int value) {
        throw new MalformedParameterizedTypeException("what");
    }

    @Override
    public boolean subsetOf(ValueSet other) {
        if (other instanceof BooleanValueSet) {
            var otherRvs = (BooleanValueSet) other;
            if (this.mightBeUndefined && !otherRvs.mightBeUndefined) return false;
            if (this.state == otherRvs.state) return true;
        }
        return false;
    }
}
