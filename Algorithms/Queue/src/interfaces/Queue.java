package interfaces;

public interface Queue<T> {
    boolean isEmpty();

    /**
     * Removes and returns first entry
     */
    T pop() throws Exception;

    void push(T data);

}
