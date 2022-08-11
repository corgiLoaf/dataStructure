package main.queue;

public class MyLinkedQueue<T> implements IQueue<T>{
    private class Node {
        T data;
        Node next;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    // init values
    private Node head;
    private Node tail;
    private int size;

    // generator
    public MyLinkedQueue(){
        this.size = 0;
        this.head = new Node(null);
        this.tail = this.head;
    }
    

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void enqueue(T data) { 
        Node node = new Node(data);
        
        this.tail.next = node;
        this.tail = this.tail.next;
        this.size++;
    }

    @Override
    public T dequeue() { //poll
        if (this.isEmpty()){
            throw new IllegalStateException();
        }
        
        Node node = this.head.next;

        this.head.next = node.next;
        node.next = null;
        this.size--;

        // if dequqe the last node, initialize (because tail disappears)
        if (this.head.next == null){
            this.tail = this.head;
        }

        return node.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()){
            throw new IllegalStateException();
        }
        
        return this.head.next.data;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = this.head;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }
}
