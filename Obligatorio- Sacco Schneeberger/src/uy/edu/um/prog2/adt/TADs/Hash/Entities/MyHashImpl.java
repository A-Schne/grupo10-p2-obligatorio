package uy.edu.um.prog2.adt.TADs.Hash.Entities;

import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.ErrorEncontrado;

public class MyHashImpl<K, V> implements MyHash<K, V> {
    private NodoHash[] tableHash;
    private int capacity;
    private int size;

    public MyHashImpl(int capacity) {
        this.tableHash = new NodoHash[capacity];
        this.capacity = capacity;
        int size = 0;
    }

    @Override
    public void put(K key, V value) throws ErrorEncontrado {
        int position = Math.abs(key.hashCode()) % tableHash.length; //tamano de la tabla
        NodoHash<K,V> temp = new NodoHash<>(key, value);

        if (tableHash[position] == null || tableHash[position].isDeleted()) {
            tableHash[position] = temp;
            size++;
        } else {
            int attempt = 1;
            int newPosition = Math.abs((key.hashCode()% tableHash.length + linearColision(attempt)));
            while (tableHash[newPosition] != null && !tableHash[newPosition].isDeleted() && attempt <= size) {
                attempt++;
                newPosition = (key.hashCode() + linearColision(attempt));
            }
            if (attempt > capacity) {
                throw new ErrorEncontrado("El hashtable es mas chico");
            }
            if (this.contains(key)){
                throw new ErrorEncontrado("La key ya existe");
            } else {
                tableHash[newPosition] = temp;
                size++;
            }
        }
    }

    private int linearColision(int attempt){
        return attempt;
    }

    @Override
    public boolean contains(K key) {
        int position = Math.abs(key.hashCode()) % tableHash.length;

        if (tableHash[position] != null && tableHash[position].getKey().equals(key) && !tableHash[position].isDeleted()) {
            return true;
        } else {
            int attemp = 1;
            int newPosition = Math.abs((key.hashCode()%tableHash.length + linearColision(attemp)));
            while (attemp <= size && tableHash[newPosition] != null && !tableHash[newPosition].isDeleted()) {
                if (tableHash[newPosition] != null && tableHash[newPosition].getKey().equals(key)) {
                    return true;
                }
                attemp++;
                newPosition = Math.abs((key.hashCode()%tableHash.length + linearColision(attemp)));
            }
            return false;
        }
    }

    @Override
    public void remove(K key) throws ErrorEncontrado{
        int position = find(key);

        if (position==0){
            throw new ErrorEncontrado("El elemento no esta en el hash");
        }
        else {
            tableHash[position].setIsDeleted(true);
            size--;
        }
    }

    private int find (K key){
        int position = Math.abs(key.hashCode()) % tableHash.length;

        if (tableHash[position] != null && tableHash[position].getKey().equals(key)) {
            return position;
        } else {
            int attemp = 1;
            int newPosition = Math.abs(key.hashCode()% tableHash.length + linearColision(attemp));
            while (attemp <= size && tableHash[newPosition] != null && !tableHash[newPosition].isDeleted()) {
                if (tableHash[newPosition] != null && tableHash[newPosition].getKey().equals(key)) {
                    return newPosition;
                }
                attemp++;
                newPosition = (key.hashCode() + linearColision(attemp));
            }
            return 0;
        }
    }

    public V findObject (K key){
        int position = Math.abs(key.hashCode() % tableHash.length);

        if (tableHash[position] != null && tableHash[position].getKey().equals(key)) {
            return (V) tableHash[position].getData();
        } else {
            int attemp = 1;
            int newPosition = Math.abs((key.hashCode()%tableHash.length + linearColision(attemp)));
            while (attemp <= size && tableHash[newPosition] != null && !tableHash[newPosition].isDeleted()) {
                if (tableHash[newPosition] != null && tableHash[newPosition].getKey().equals(key)) {
                    return (V) tableHash[newPosition].getData();
                }
                attemp++;
                newPosition = (key.hashCode() + linearColision(attemp));
            }
            return null;
        }
    }

    @Override
    public int size () {
        return size;
    }
}