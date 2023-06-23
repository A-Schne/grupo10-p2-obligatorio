package uy.edu.um.prog2.adt.TADs.BST.Entities;

public interface MyTreeInt<K extends Comparable<K>, T> {
    T find(K key);

    void insert (K key, T data);

    void delete (K key);

    public Nodo<K, T> getRoot();



}
