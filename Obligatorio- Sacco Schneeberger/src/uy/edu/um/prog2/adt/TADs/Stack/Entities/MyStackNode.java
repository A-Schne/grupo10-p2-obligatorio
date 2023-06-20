package uy.edu.um.prog2.adt.TADs.Stack.Entities;

public class MyStackNode <T> {

    private MyStackNode<T> next;
    private T value;
    private MyStackNode<T> top;

    public MyStackNode<T> getNext() {
        return next;
    }

    public void setNext(MyStackNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyStackNode<T> getTop() {
        return top;
    }

    public void setTop(MyStackNode<T> top) {
        this.top = top;
    }
}