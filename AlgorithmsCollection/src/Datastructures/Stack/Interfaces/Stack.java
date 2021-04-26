package Datastructures.Stack.Interfaces;

public interface Stack<T> {
    /**
     * Adds to Stack
     */
    void push(T item);

    /**
     * Removes from stack
     */
    T pop();

    /**
     * Peek at top of stack
     */
    T peek();

    boolean isEmpty();

    boolean isFull();

}
