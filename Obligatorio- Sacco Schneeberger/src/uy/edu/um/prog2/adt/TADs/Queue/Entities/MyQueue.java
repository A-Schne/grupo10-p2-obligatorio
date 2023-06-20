package uy.edu.um.prog2.adt.TADs.Queue.Entities;

import uy.edu.um.prog2.adt.TADs.Queue.exceptions.EmptyQueueException;

public interface MyQueue <Tipo> {

    void enqueue (Tipo element);

    Tipo dequeue () throws EmptyQueueException;

    boolean isEmpty();
}
 