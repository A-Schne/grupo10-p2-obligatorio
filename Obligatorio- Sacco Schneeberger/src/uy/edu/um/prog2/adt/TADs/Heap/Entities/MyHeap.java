package uy.edu.um.prog2.adt.TADs.Heap.Entities;
import uy.edu.um.prog2.adt.TADs.Heap.Exceptions.NodoNoExiste;

import java.util.List;

public interface MyHeap<K extends Comparable<K>,T> {

    public Nodo<K,T> add(K key, T data);

    public T obtenerYEliminar(K key) throws NodoNoExiste;

    public int size();

    public List visualizeKey();

    public List visualizeData();

}
