package uy.edu.um.prog2.adt.TADs.Heap.Entities;
import uy.edu.um.prog2.adt.TADs.Heap.Exceptions.NodoNoExiste;

import java.util.ArrayList;
import java.util.List;

public class MyHeapImpl<K extends Comparable<K>,T> implements MyHeap<K, T> {

    private boolean maximo;
    private int multi;
    private List<Nodo<K,T>> heap;

    public MyHeapImpl(boolean maximo) {
        if(maximo){
            this.multi = 1;
        }
        else{
            this.multi = -1;
        }
        this.heap = new ArrayList<>();
    }

    @Override
    public Nodo<K,T> add(K key, T data) {
        Nodo<K,T> nuevo = new Nodo<>(key, data);
        if (this.heap.isEmpty()){
            this.heap.add(nuevo);
            return nuevo;
        }
        else{
            this.heap.add(nuevo);
            boolean corriendo = true;
            while(corriendo){
                corriendo = swap(nuevo);
            }
            return nuevo;
        }

    }



    @Override
    public T obtenerYEliminar(K key) throws NodoNoExiste {
        if(heap.isEmpty()){
            return null;
        }
        else{
            Nodo<K,T> nodo = searchNode(key);
            if (nodo==null){
                throw new NodoNoExiste();
            }
            int posNodo = this.heap.indexOf(nodo);
            if(posNodo==-1){
                return null;
            }
            Nodo<K,T> ultNodo = this.heap.get(heap.size()-1);
            if(nodo.compareTo(ultNodo)==0){
                this.heap.remove(nodo);
                return nodo.getData();
            }
            this.heap.remove(ultNodo);
            this.heap.set(posNodo,ultNodo);
            boolean corriendo = true;
            while(corriendo){
                corriendo = order(ultNodo);
            }
            return nodo.getData();
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public List visualizeKey() {
        List lista = new ArrayList();
        if(this.heap.isEmpty()){
            return lista;
        }
        else {
            for (int i = 0; i < this.heap.size(); i++) {
                Nodo<K, T> nodo = this.heap.get(i);
                lista.add(nodo.getKey());
            }
            return lista;
        }
    }

    @Override
    public List visualizeData() {
        List lista = new ArrayList();
        if(this.heap.isEmpty()){
            return lista;
        }
        else {
            for (int i = 0; i < this.heap.size(); i++) {
                Nodo<K, T> nodo = this.heap.get(i);
                lista.add(nodo.getData());
            }
            return lista;
        }
    }

    public boolean isMaximo() {
        return maximo;
    }

    public void setMaximo(boolean maximo) {
        this.maximo = maximo;
    }

    public int getMulti() {
        return multi;
    }

    public void setMulti(int multi) {
        this.multi = multi;
    }

    public List<Nodo<K, T>> getHeap() {
        return heap;
    }

    public void setHeap(List<Nodo<K, T>> heap) {
        this.heap = heap;
    }

    public boolean swap(Nodo nodoHijo){
        int posicion = this.heap.indexOf(nodoHijo);
        Nodo<K,T> padre = this.heap.get(((posicion-1)/2)); //falta redondear para abajo (?) y queda pronto el swap

        if((padre.compareTo(nodoHijo) * multi) == -1){
            int posicionPadre = this.heap.indexOf(padre);
            int posicionHijo = this.heap.indexOf(nodoHijo);
            this.heap.set(posicionPadre, nodoHijo);
            this.heap.set(posicionHijo, padre);
            return true;
        }

        else{
            return false;
        }
    }

    public Nodo<K,T> searchNode(K key){
        if(heap.isEmpty()){
            return null;
        }
        else{
            for(int i=0; i<heap.size(); i++){
                Nodo<K,T> nodo = heap.get(i);
                if(nodo.getKey() == key){
                    return nodo;
                }
            }
        }
        return null;
    }

    public boolean order(Nodo<K,T> nodo){
        int posNodo = this.heap.indexOf(nodo);
        int posHijo1 = 2*posNodo+1;
        int posHijo2 = 2*posNodo+2;
        if(posHijo1>heap.size()-1 || posHijo2>heap.size()-1){
            return false;
        }
        Nodo<K,T> nodoHijo1 = this.heap.get(posHijo1);
        Nodo<K,T> nodoHijo2 = this.heap.get(posHijo2);
        if(nodo.compareTo(nodoHijo1)*multi < 0){
            this.heap.set(posHijo1,nodo);
            this.heap.set(posNodo, nodoHijo1);
            return true;
        }
        if(nodo.compareTo(nodoHijo2)*multi < 0){
            this.heap.set(posHijo2,nodo);
            this.heap.set(posNodo, nodoHijo2);
            return true;
        }
        return false;
    }
}
