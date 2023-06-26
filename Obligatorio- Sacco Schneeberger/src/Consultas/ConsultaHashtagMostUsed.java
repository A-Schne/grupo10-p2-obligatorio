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

    @Override
    public void execute(CSVRecord record) throws Exception {
        String date = record.get("date");

        if(date.length()==19) {
            date = date.substring(0,10);
            if (date.equals(inputDate)) {
                String hashtagSinSeparar = record.get("hashtags").replace("[", "");
                hashtagSinSeparar = hashtagSinSeparar.replace("]", "");
                hashtagSinSeparar = hashtagSinSeparar.replace(",", "");
                String[] hashtagsSeparados = hashtagSinSeparar.split(" ");
                for (String hashtag : hashtagsSeparados) {
                    if (hashtag.contains("F1") || (hashtag.contains("f1")) || hashtag.contains("formula1") || hashtag.contains("Formula1")) {
                        continue;
                    } else {
                        hashtag = hashtag.toLowerCase();
                        boolean esta = false;
                        if (listaHashtagsRegistrados.contains(hashtag)) {
                            Hashtag a = listaHashtagsRegistrados.findObject(hashtag);
                            a.setNumTwitted(a.getNumTwitted() + 1);
                        } else {
                            Hashtag newHashtag = new Hashtag(hashtag);
                            newHashtag.setNumTwitted(1);
                            listaHashtagsRegistrados.put(hashtag, newHashtag);
                            nombresHashtags.add(hashtag);
                        }
                    }
                }
            }
        }
    }

    public void hacerCuartaConsulta() throws Exception {
        Hashtag dummyHashtag = new Hashtag("Hashtag con 0 usos");
        hashtagsOrdenados.insert(0, dummyHashtag);
        for(int i=0; i<nombresHashtags.size(); i++){
            hashtagsOrdenados.insert(listaHashtagsRegistrados.findObject(nombresHashtags.get(i)).getNumTwitted(),listaHashtagsRegistrados.findObject(nombresHashtags.get(i))) ;
        }
        getHashtag(hashtagsOrdenados.getRoot());
    }
    public void getHashtag(Nodo<Integer, Hashtag> nodoHashtag){
        if(nodoHashtag.getRightChild()!=null){
            getHashtag(nodoHashtag.getRightChild());
        }
        else {
            if (nodoHashtag.getData().getNumTwitted() == 0) {
                System.out.println("No se registró ningun hashtags este dia");
            } else {
                System.out.println("El hashtag mas usado para el dia " + inputDate + " es: " + nodoHashtag.getData().getText() + " con " + nodoHashtag.getData().getNumTwitted() + " usos.");
            }
        }
    }
}

