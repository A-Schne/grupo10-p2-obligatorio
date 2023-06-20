package uy.edu.um.prog2.adt.TADs.Queue.Entities;

public class Node<Tipo> {
    private Tipo value;
    private uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node next;
    private uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node prev;

    public Tipo getValue() {
        return value;
    }

    public void setValue(Tipo value) {
        this.value = value;
    }

    public uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node getNext() {
        return next;
    }

    public void setNext(uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node next) {
        this.next = next;
    }

    public uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node getPrev() {
        return prev;
    }

    public void setPrev(uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Node prev) {
        this.prev = prev;
    }

    public Node(Tipo value){
        this.value = value;
        this.next = null;
    }
}