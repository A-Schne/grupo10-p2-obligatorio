package Consultas;

import CSVResources.CSVTweetReader;
import Entities.Hashtag;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeImpl;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeInt;
import uy.edu.um.prog2.adt.TADs.BST.Entities.Nodo;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

public class ConsultaHashtagMostUsed implements CSVTweetReader {

    private MyHash<String, Hashtag> listaHashtagsRegistrados;
    private Lista<String> nombresHashtags;
    private MyTreeInt<Integer, Hashtag> hashtagsOrdenados;
    private String inputDate;

    public ConsultaHashtagMostUsed(String date) {
        this.listaHashtagsRegistrados = new MyHashImpl<>(5000000);
        this.nombresHashtags = new LinkedList<>();
        this.hashtagsOrdenados = new MyTreeImpl<>();
        this.inputDate = date;
    }

}