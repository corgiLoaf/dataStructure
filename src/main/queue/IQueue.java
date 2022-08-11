package main.queue;

public interface IQueue<T> {

    int size();

    void enqueue(T data);

    T dequeue();

    T peek();

    void clear();

    boolean isEmpty();
}