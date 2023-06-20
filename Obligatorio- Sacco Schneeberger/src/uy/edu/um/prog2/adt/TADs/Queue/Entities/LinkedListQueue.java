package uy.edu.um.prog2.adt.TADs.Queue.Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node;
import uy.edu.um.prog2.adt.TADs.Queue.exceptions.EmptyQueueException;

public class LinkedListQueue implements ListaQueue {
    private Node first;

    @Override
    public int size() {
        int count = 0;
        Node temp = this.first;
        if (temp == null){
            return count;
        }
        while (temp.getNext() != null){
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    @Override
    public void add(Object value) {
        if (this.first == null){
            this.first = new Node(value);
        }
        else{
            Node temp = this.first;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            Node newNode = new Node(value);
            temp.setNext(newNode);
        }
    }

    @Override
    public void remove(int position) throws EmptyQueueException {
        if (this.first == null){
            throw new EmptyQueueException();
        }
        else{
            this.first = this.first.getNext();

        }
    }

    @Override
    public Object get(int position) throws EmptyQueueException{
        if (this.first == null){
            throw new EmptyQueueException();
        }
        else{
            Node temp = this.first;
            for (int i = 0; i != position; i++) {
                temp = temp.getNext();
            }
            return temp.getValue();

        }
    }
}
