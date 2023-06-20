package uy.edu.um.prog2.adt.TADs.Stack.Test;

import uy.edu.um.prog2.adt.TADs.Stack.Entities.MyStackImpl;
import org.junit.Test;

import java.util.EmptyStackException;

public class TestStack {
    @Test
    public void testPush() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void testPop() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPeek() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
    }

    @Test
    public void testSize() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.size();
    }

    @Test
    public void testPrintStack() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
    }

    @Test
    public void testClearStack() throws EmptyStackException {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.clearStack();
    }
    @Test
    public void testIsEmpty() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.isEmpty();
    }
}
