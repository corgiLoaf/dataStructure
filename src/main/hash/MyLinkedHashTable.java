package main.hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashTable<K, V> implements IHashTable<K, V>{
    private static final int DEFAULT_BUCKET_SIZE = 1024;

    // init values
    private List<Node>[] buckets;
    private int size;
    private int bucketSize;

    // generator
    public MyLinkedHashTable(){
        this.buckets = new List[DEFAULT_BUCKET_SIZE];
        this.size = 0;
        this.bucketSize = DEFAULT_BUCKET_SIZE;

        for (int i = 0; i < DEFAULT_BUCKET_SIZE; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    public MyLinkedHashTable(int bucketsize){
        this.buckets = new List[bucketsize];
        this.size = 0;
        this.bucketSize = bucketsize;

        for (int i = 0; i < bucketsize; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }


    @Override
    public void put(K key, V value) {
       int idx = this.hash(key); // 해당 key의 hash 값을 얻어옴
       List<Node> bucket = this.buckets[idx]; // buckets : "서랍장", bucket : "서랍"

       // bucket 에 있는 node들을 순환하며 node.key가 input으로 들어온 key와 같은지 체크
       for (Node node: bucket){
            if (node.key.equals(key)){
                node.data = value;
                return;
            }
       }

       Node node = new Node(key, value);
       bucket.add(node);
       this.size++;
    }


    @Override
    public V get(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node: bucket){
            if (node.key.equals(key)){
                return node.data;
            }
        }

        return null;
    }


    @Override
    public boolean delete(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Iterator<Node> iter = bucket.iterator(); iter.hasNext(); ) {
            Node node = iter.next();
            if (node.key.equals(key)) {
                iter.remove();
                this.size--;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean contains(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node: bucket){
            if (node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hash(K key){
        int hash = 0;
        for (Character ch : key.toString().toCharArray()){
            hash += (int)ch;
        }

        return hash % this.bucketSize;
    }

    private class Node {
        K key;
        V data;

        Node(K key, V data){
            this.key = key;
            this.data = data;
        }
    }
    
}
