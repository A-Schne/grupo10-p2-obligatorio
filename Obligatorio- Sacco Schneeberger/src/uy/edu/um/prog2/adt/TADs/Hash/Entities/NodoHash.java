package uy.edu.um.prog2.adt.TADs.Hash.Entities;

public class NodoHash<K,T> {
    K key;
    T data;
    boolean deleted;

    public NodoHash(K key, T data) {
        this.key = key;
        this.data = data;
        this.deleted = false;
    }

    public K getKey() {return key;}

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.deleted = isDeleted;
    }
}