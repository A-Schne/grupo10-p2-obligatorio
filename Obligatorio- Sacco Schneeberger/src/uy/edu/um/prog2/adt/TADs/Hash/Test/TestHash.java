package uy.edu.um.prog2.adt.TADs.Hash.Test;

import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.HashVacio;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.NoExiste;
import org.junit.Test;

public class TestHash {

    @Test
    public void testPut() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        hash.printTable();
    }

    @Test
    public void testGet() throws NoExiste, HashVacio {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        System.out.println(hash.get(2));
    }

    @Test
    public void testRemove() throws NoExiste, HashVacio {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        hash.remove(2);
        hash.printTable();
        hash.put(2, "dos");
        hash.printTable();
    }

    @Test
    public void testContainsKey() throws NoExiste, HashVacio {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        System.out.println(hash.containsKey(2));
        System.out.println(hash.containsKey(4));
    }

    @Test
    public void testPrintTable() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        hash.printTable();
    }

    @Test
    public void testTableSize() throws NoExiste, HashVacio {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        System.out.println(hash.tableSize());
        hash.clear();
        System.out.println(hash.tableSize());
    }

    @Test
    public void testIsEmpty() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        System.out.println(hash.isEmpty());
        hash.clear();
        System.out.println(hash.isEmpty());
    }

    @Test
    public void testClear() throws NoExiste, HashVacio {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.setTableSize(10);
        hash.put(1, "uno");
        hash.put(2, "dos");
        hash.put(3, "tres");
        hash.clear();
        hash.printTable();
    }
}

