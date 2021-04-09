package interfaces;

import state.UnionValueSet;

public interface ValueSet {
  boolean canBeUndefined();
  boolean contains(int value);
  /**
   * Remember to implement!!!
   */
  default boolean subsetOf(ValueSet other) {
    return false;
    }
  default ValueSet union(ValueSet other) {
    return new UnionValueSet(this, other);
    }
  // ...
  }
