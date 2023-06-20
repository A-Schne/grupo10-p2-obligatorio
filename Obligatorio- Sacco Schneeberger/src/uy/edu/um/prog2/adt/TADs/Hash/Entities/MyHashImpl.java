package uy.edu.um.prog2.adt.TADs.Hash.Entities;

import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.HashVacio;
import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.NoExiste;

public class MyHashImpl<K, V> implements MyHash<K, V> {
    private MyHashNode<K, V>[] table;
    private int tableSize;
    public MyHashImpl() {
    }

    private int linearCollision(int attempt) {
        return attempt;
    }

    public void setTableSize(int size) {
        tableSize = size;
        table = new MyHashNode[tableSize];
    }

    @Override
    public void put(K key, V value) {
        int position = key.hashCode() % tableSize;
        MyHashNode<K, V> newNode = new MyHashNode<>(key, value);

        if ((table[position] == null) || table[position].isDeleted()) {
            table[position] = newNode;
        } else {
            int attempt = 1;
            int newPosition = (position + linearCollision(attempt)) % tableSize;

            while (table[newPosition] != null && !table[newPosition].isDeleted() && attempt <= tableSize) {
                attempt++;
                newPosition = (position + linearCollision(attempt)) % tableSize;
            }

            if (attempt > tableSize) {
                throw new RuntimeException("Table is full");
            }

            table[newPosition] = newNode;
        }
    }

    @Override
    public V get(K key) throws NoExiste {
        int position = key.hashCode() % tableSize;
        MyHashNode<K, V> node = table[position];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        throw new NoExiste("No se encontró");
    }

    @Override
    public void remove(K key) throws NoExiste, HashVacio {
        if (tableSize == 0) {
            throw new HashVacio("El hash está vacío");
        }
        int position = key.hashCode() % tableSize;
        MyHashNode<K, V> node = table[position];

        if (node != null && node.getKey().equals(key)) {
            table[position] = null;
            return;
        }

        while (node != null) {
            if (node.getNext() != null && node.getNext().getKey().equals(key)) {
                node.setNext(node.getNext().getNext());
                return;
            }
            node = node.getNext();
        }

        throw new NoExiste("No se encontró el elemento con la clave especificada");
    }

    @Override
    public boolean containsKey(K key) {
        int position = key.hashCode() % tableSize;
        if (table[position] != null && table[position].getKey().equals(key)) {
            return true;
        } else {
            int attempt = 1;
            int newPosition = (key.hashCode() + linearCollision(attempt)) % tableSize;
            while (table[newPosition] != null && attempt <= tableSize) {
                if (table[newPosition].getKey().equals(key)) {
                    return true;
                }
                attempt++;
                newPosition = (key.hashCode() + linearCollision(attempt)) % tableSize;
            }
        }
        return false;
    }

    @Override
    public void printTable() {
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                System.out.println("Position " + i + ": Key = " + table[i].getKey() + ", Value = " + table[i].getValue());
            } else {
                System.out.println("Position " + i + ": Empty");
            }
        }
    }

    @Override
    public int tableSize() {
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (tableSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
        tableSize = 0;
    }

}

