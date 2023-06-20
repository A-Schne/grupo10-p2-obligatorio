package uy.edu.um.prog2.adt.TADs.Stack.Entities;

import java.util.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T> {
    private MyStackNode<T> top;
    private int size;

    @Override
    public void push(T value) {
        if (value != null) {
            MyStackNode<T> newNode = new MyStackNode<>();
            newNode.setValue(value);
            newNode.setNext(top);
            top = newNode;
            size++;
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printStack() {
        MyStackNode<T> node = top;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clearStack() throws EmptyStackException {
        while (top != null) {
            top.setValue(null);
            top = top.getNext();
            size--;
        }
    }
}

