package uy.edu.um.prog2.adt.TADs.Linked_List.Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;


public interface Lista <Tipo> {
    void add(Tipo value);
    void remove(int position) throws Exception;
    Tipo get(int position) throws NoExiste, NoExiste;
    int size() throws Exception;
}
