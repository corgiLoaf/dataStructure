package main.list;

public class MyDoubleLinkedList<T> implements IList<T> {

    // private init values
    private int size;
    private Node head;
    private Node tail;

    // generator
    public MyDoubleLinkedList(){
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }


    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, this.tail);

        last.next = node;
        this.tail.prev = node;

        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }

        Node prev = null;
        Node curr = null;

        if (index < (this.size / 2)) { // pivot = head
            curr = this.head.next;

            int i = 0;
            while(i++ < index){
                curr = curr.next;
            }
            prev = curr.prev;
        }

        else { // pivot = tail
            curr = this.tail;

            int i = this.size;
            while(i-- > index){
                curr = curr.prev;
            }
            prev = curr.prev;
        }
        
        Node node = new Node(t, prev, curr);
        prev.next = node;
        curr.prev = node;

        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {
        Node curr = this.head.next;

        while (curr.next != null){
            if (curr.data == t){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                curr.next = null;
                curr.prev = null;
                this.size--;

                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node curr = null;
        
        if (index < (this.size / 2)) { // pivot = head
            curr = this.head.next;

            int i = 0;
            while(i++ < index){
                curr = curr.next;
            }
        }

        else { // pivot = tail
            curr = this.tail.prev;

            int i = this.size - 1;
            while(i-- > index){
                curr = curr.prev;
            }  
        }

        Node prev = curr.prev;
        Node next = curr.next;

        prev.next = next;
        next.prev = prev;
        curr.next = null;
        curr.prev = null;

        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node curr = null;
        if (index < this.size / 2) { // pivot = head
            curr = this.head.next;

            int i = 0;
            while(i++ < index){
                curr = curr.next;
            }
        }

        else { // pivot = tail
            curr = this.tail.prev;

            int i = this.size - 1;
            while(i-- > index){
                curr = curr.prev;
            }
        }
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        Node curr = this.head.next;

        int i = 0;
        while (curr.next != null){
            if (curr.data == t){
                return i;
            }
            curr = curr.next;
            i++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        Node left = this.head.next;
        Node right = this.tail.prev;

        while (left.next != null & right.prev != null){
            if (left.data != null & left.data.equals(t)){
                return true;
            }
            if (right.data != null & right.data.equals(t)){
                return true;
            }

            left = left.next;
            right = right.prev;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node{
        T data;
        Node prev;
        Node next;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    
}
