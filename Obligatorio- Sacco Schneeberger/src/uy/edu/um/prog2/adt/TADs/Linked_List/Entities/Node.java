package uy.edu.um.prog2.adt.TADs.Linked_List.Entities;

public class Node<Tipo> {
    private Tipo value;
    private Node next;
    private Node prev;

    public Tipo getValue() {
        return value;
    }

    public void setValue(Tipo value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node(Tipo value){
        this.value = value;
        this.next = null;
    }
}
