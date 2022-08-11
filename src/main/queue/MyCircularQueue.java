package main.queue;

public class MyCircularQueue<T> implements IQueue<T>{

    // init values
    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    // generator
    public MyCircularQueue(int size){
        this.elements = (T[]) new Object[size + 1];
        this.front = 0;
        this.rear = 0;
        this.maxSize = size + 1;
    }


    @Override
    public int size() {
        if (this.rear >= this.front){
            return this.rear - this.front;
        }
        return this.rear + this.maxSize - this.front;
    }

    @Override
    public void enqueue(T data) { 
        if (this.isFull()){
            throw new IllegalStateException();
        }
        this.rear = (this.rear + 1) % this.maxSize;
        this.elements[this.rear] = data;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()){
            throw new IllegalStateException();
        }

        this.front = (this.front + 1) % this.maxSize;
        return this.elements[this.front];
    }

    @Override
    public T peek() {
        if (this.isEmpty()){
            throw new IllegalStateException();
        }

        return this.elements[this.front+1];
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
        // list-based circular queue operation is calculated by front and near integer
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }
    
    private boolean isFull() {
        return this.front == (this.rear + 1) % this.maxSize;
    }
}
