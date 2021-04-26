package Datastructures.Queues.Simple.Impl;


import Datastructures.Queues.Simple.Interfaces.Queue;

public class QueueImpl<T> implements Queue<T> {
    class Node {
        T data;
        Node next;

        Node(T item) {
            data = item;
            next = null;
        }
    }

    Node front;
    Node rear;

    public QueueImpl() {
        front = null;
        rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty");
        Node result = front; //save current front
        front = front.next; //set new front
        return result.data; //return "old" (current) front
    }

    @Override
    public void push(T data) {
        Node node = new Node(data);
        if (isEmpty()) front = rear = node;
        else {
            rear.next = node;
            rear = node;
        }
    }

}
