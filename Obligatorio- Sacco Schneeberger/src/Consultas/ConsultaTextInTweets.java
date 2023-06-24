package Consultas;

import CSVResources.CSVTweetReader;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

public class ConsultaTextInTweets implements CSVTweetReader {

    private String inputText;
    private int cantidadDeTweets;

    public ConsultaTextInTweets(String inputText) {
        this.inputText = inputText;
        this.cantidadDeTweets = 0;
    }

    @Override
    public void execute(CSVRecord record) throws Exception {
        String text = record.get("text").toLowerCase();
        if(text.contains(inputText)){
            cantidadDeTweets++;
        }
    }

    public void hacerSextaConsulta(){
        if(cantidadDeTweets==0)
            System.out.println("Ningun tweet contiene la palabra/frase '" + inputText +"'");
        else if(cantidadDeTweets==1)
            System.out.println("Solo un tweet contiene la palabra/frase'" + inputText +"'");
        else
            System.out.println("\nLa cantidad de tweets que contienen la palabra/frase '" + inputText + "' son " + cantidadDeTweets);
    }
}
