package Consultas;

import CSVResources.CSVTweetReader;
import Entities.Hashtag;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeInt;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

public class ConsultaMostHashtagUses implements CSVTweetReader {

    private Lista<Hashtag> listaHashtagsRegistrados;
    private MyTreeInt<Integer, Hashtag> hashtagsOrdenados;

    @Override
    public void execute(CSVRecord record) throws Exception {

        String hashtagSinSeparar = record.get("hashtags").replace("[", "");
        hashtagSinSeparar = hashtagSinSeparar.replace("]", "");
        hashtagSinSeparar = hashtagSinSeparar.replace(",", "");

        String[] hashtagsSeparados = hashtagSinSeparar.split(" ");

        for(String hashtag : hashtagsSeparados){
            if(hashtag.contains("F1") || (hashtag.contains("f1"))){
                continue;
            }
            else{
                hashtag = hashtag.toLowerCase();
                System.out.println(hashtag);
                for(int i=0; i< listaHashtagsRegistrados.size(); i++){
                    if(hashtag.equals(listaHashtagsRegistrados.get(i).getText())){

                    }
                }

            }
        }


    }
}
