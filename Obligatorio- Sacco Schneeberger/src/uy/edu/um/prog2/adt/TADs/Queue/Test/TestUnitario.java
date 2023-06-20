package uy.edu.um.prog2.adt.TADs.Queue.Test;

import uy.edu.um.prog2.adt.TADs.Queue.Entities.MyQueueImpl;
import uy.edu.um.prog2.adt.TADs.Queue.exceptions.EmptyQueueException;
import org.junit.Test;

public class TestUnitario {
    MyQueueImpl queue = new MyQueueImpl();

    @Test
    public void testIsEmpty(){
        queue.isEmpty(); //Como no se hizo enqueue, da true
    }

    @Test
    public void testEnqueueDequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(1000);
        queue.enqueue("A");
        queue.enqueue(-1);
    //No se especifica el tipo de dato
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //Se vacia toda la queue
    }

    @Test
    public void testIsNotEmpty(){
        queue.isEmpty();
    }

    @Test
    public void testIsEmpty2(){
        queue.isEmpty();
    }
}
