package uy.edu.um.prog2.adt.TADs.Hash.Entities;

import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.HashVacio;
import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.NoExiste;

public interface MyHash<K, V> {
    void put(K key, V value);

    V get(K key) throws NoExiste;

    public void remove(K key) throws NoExiste, HashVacio;

    public boolean containsKey(K key);

    public void printTable();

    int tableSize();

    public boolean isEmpty();

    public void clear();

}

