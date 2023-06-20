package uy.edu.um.prog2.adt.TADs.Heap.Test;

import uy.edu.um.prog2.adt.TADs.Heap.Exceptions.NodoNoExiste;
import uy.edu.um.prog2.adt.TADs.Heap.Entities.MyHeapImpl;
import org.junit.Test;

public class TestUnitario {
    MyHeapImpl<Integer, Integer> heapMinimo = new MyHeapImpl<>(false);
    @Test
    public void testMinimo() throws NodoNoExiste {
        System.out.println(heapMinimo.visualizeKey());
        heapMinimo.add(1, 4);
        heapMinimo.add(2, 6);
        heapMinimo.add(8, 0);
        heapMinimo.add(3, 6);
        heapMinimo.add(5, 6);
        heapMinimo.add(4, 6);
        heapMinimo.add(9, 0);
        heapMinimo.add(15, 6);
        heapMinimo.add(7, 6);
        heapMinimo.add(91, 51);
        System.out.println(heapMinimo.visualizeKey()); //Muestra la heap en forma de array, imprimiendo los valores de las keys
        System.out.println(heapMinimo.obtenerYEliminar(3)); //Borra nodo con key = 3, rearregla al heap
        System.out.println(heapMinimo.visualizeData()); //Igual que visualizeKey, pero imprime los valores de las datas
        try {
            System.out.println(heapMinimo.obtenerYEliminar(-91)); //No existe este nodo, salta excepcion NodoNoExiste
        }
        catch (NodoNoExiste NNE){

        }
        System.out.println(heapMinimo.obtenerYEliminar(9));

    }

    //Mismos tests para un heapMaximo
    MyHeapImpl<Integer, Integer> heapMaximo = new MyHeapImpl<>(true);
    @Test
    public void testMaximo() throws NodoNoExiste {
        System.out.println(heapMaximo.visualizeKey());
        heapMaximo.add(1, 4);
        heapMaximo.add(2, 6);
        heapMaximo.add(8, 0);
        heapMaximo.add(3, 6);
        heapMaximo.add(5, 6);
        heapMaximo.add(4, 6);
        heapMaximo.add(9, 0);
        heapMaximo.add(15, 6);
        heapMaximo.add(7, 6);
        heapMaximo.add(91, 51);
        System.out.println(heapMaximo.visualizeKey()); //Muestra la heap en forma de array, imprimiendo los valores de las keys
        System.out.println(heapMaximo.obtenerYEliminar(3)); //Borra nodo con key = 3, rearregla al heap
        System.out.println(heapMaximo.visualizeData()); //Igual que visualizeKey, pero imprime los valores de las datas
        try {
            System.out.println(heapMaximo.obtenerYEliminar(-91)); //No existe este nodo, salta excepcion NodoNoExiste
        }
        catch (NodoNoExiste NNE){

        }
        System.out.println(heapMaximo.obtenerYEliminar(9));

    }
}
