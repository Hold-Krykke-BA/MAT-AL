package impl;

import interfaces.Stack;

import java.util.EmptyStackException;

public class StackImpl<T> implements Stack<T> {
    private int capacity;
    private T[] stackArray;
    private int stackTop;

    public StackImpl(int size) {
        this.capacity = size;
        this.stackArray = (T[]) new Object[size]; //Java workaround for generic arrays
        this.stackTop = -1;
    }

    @Override
    public void push(T item) {
        if (this.isFull()) {
            System.out.println("Stack Overflow - increasing capacity");
            this.increaseCapacity();
        }
        this.stackArray[++stackTop] = item;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[stackTop--];
    }

    @Override
    public T peek() {
        return stackArray[stackTop];
    }

    @Override
    public boolean isEmpty() {
        return (stackTop == -1);
    }

    @Override
    public boolean isFull() {
        return (stackTop == capacity - 1);
    }

    private void increaseCapacity() {
        T[] newStack = (T[]) new Object[this.capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newStack[i] = this.stackArray[i];
        }
        this.stackArray = newStack;
        this.capacity = this.capacity * 2;
    }

    public int getCapacity() {
        return capacity;
    }
}
