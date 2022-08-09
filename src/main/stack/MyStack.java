package main.stack;

public class MyStack<T> implements IStack<T>{

    // init values
    private int size;
    private Node head;

    public MyStack(){
        this.size = 0;
        this.head = new Node(null);
    }

    @Override
    public void push(T data) {
        Node node = new Node(data, this.head.next);
        this.head.next = node;
        this.size++;
    }

    @Override
    public T pop() {

        if (this.isEmpty()){
            return null;
        }
        Node top = this.head.next;
        this.head.next = top.next;
        top.next = null;
        this.size--;

        return top.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()){
            return null;
        }

        Node top = this.head.next;
        return top.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isEmpty(){
        Node top = this.head.next;
        return top.data == null;
    }

    private class Node{
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
    
}