package state;

import interfaces.ValueSet;

public class RangeValueSet implements ValueSet {
    private boolean mightBeUndefined;
    private int floor;
    private int roof;

    public RangeValueSet(boolean mightBeUndefined, int floor, int roof) {
        this.mightBeUndefined = mightBeUndefined;
        this.floor = floor;
        this.roof = roof;
    }

    @Override
    public boolean canBeUndefined() {
        return mightBeUndefined;
    }

    @Override
    public boolean contains(int value) {
        return floor <= value && value < roof;
    }

    @Override
    public boolean subsetOf(ValueSet valueSet) {
        if (valueSet instanceof RangeValueSet) {
            var other = (RangeValueSet) valueSet;
            if (this.mightBeUndefined && !other.mightBeUndefined) return false;
            if (other.floor <= this.floor && this.roof <= other.roof) return true;
        }
        return false;
    }

    public boolean getMightBeUndefined() {
        return mightBeUndefined;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoof() {
        return roof;
    }
}

/*
 this :         10 ... 20
 other: 0 ...               100
 */