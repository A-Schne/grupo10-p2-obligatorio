package uy.edu.um.prog2.adt.TADs.Hash.Entities;

public class MyHashNode <K,V> {
    private K key;
    private V value;
    private MyHashNode<K,V> next;
    private boolean deleted;

    public MyHashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public MyHashNode<K,V> getNext() { return next; }
    public void setNext(MyHashNode<K,V> next) { this.next = next; }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public void put(K key, V value){
    }

}
