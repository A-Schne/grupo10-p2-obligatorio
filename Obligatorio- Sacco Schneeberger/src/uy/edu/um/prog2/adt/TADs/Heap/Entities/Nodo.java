package uy.edu.um.prog2.adt.TADs.Heap.Entities;

public class Nodo<K extends Comparable<K>,T> {

    public K key;
    public T data;

    public Nodo(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int compareTo(Nodo<K, T> obj) {
        return this.key.compareTo(obj.getKey());
    }
}
