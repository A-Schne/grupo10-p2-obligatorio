package uy.edu.um.prog2.adt.TADs.Hash.Entities;

import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.ErrorEncontrado;

public interface MyHash<K, V> {

    public void put(K key, V value) throws ErrorEncontrado;

    public boolean contains(K key);

    public void remove(K key) throws ErrorEncontrado;

    int size();

    public V findObject(K key);
}