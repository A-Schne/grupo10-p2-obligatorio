package Consultas;

import CSVResources.CSVTweetReader;
import Entities.Hashtag;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;

public class ConsultaAmountOfTweets implements CSVTweetReader {

    private String inputDate;
    private MyHash<String, Hashtag> hashtags;
    private int amountOfTweets;

    public ConsultaAmountOfTweets(String date) {
        this.inputDate = date;
        this.hashtags = new MyHashImpl<>(500000);
        this.amountOfTweets = 0;
    }

    @Override
    public void execute(CSVRecord record) throws Exception {

        String date = record.get("date");
        if(date.length()==19) {
            date = date.substring(0, 10);

            if (date.equals(inputDate)) {

                String hashtagSinSeparar = record.get("hashtags").replace("[", "");
                hashtagSinSeparar = hashtagSinSeparar.replace("]", "");
                hashtagSinSeparar = hashtagSinSeparar.replace(",", "");

                String[] hashtagsSeparados = hashtagSinSeparar.split(" ");

                for (String hashtag : hashtagsSeparados) {
                    hashtag = hashtag.toLowerCase();
                    if (hashtags.contains(hashtag)) {
                        continue;
                    } else {
                        Hashtag newHashtag = new Hashtag(hashtag);
                        hashtags.put(hashtag, newHashtag);
                        amountOfTweets++;
                    }
                }
            }
        }
    }

    public void hacerTerceraConsulta(){
        System.out.println("\nEn el dia " + inputDate + " se usaron " + amountOfTweets + " hashtags.");
    }

}
