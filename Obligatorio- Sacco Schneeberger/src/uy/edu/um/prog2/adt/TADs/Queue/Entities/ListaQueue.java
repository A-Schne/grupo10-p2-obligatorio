package uy.edu.um.prog2.adt.TADs.Queue.Entities;

import uy.edu.um.prog2.adt.TADs.Queue.exceptions.EmptyQueueException;
import uy.edu.um.prog2.adt.TADs.Queue.exceptions.NoExiste;

public interface ListaQueue<Tipo> {
    void add(Tipo value);
    void remove(int position) throws EmptyQueueException;
    Tipo get(int position) throws NoExiste, EmptyQueueException;
    int size();
}

