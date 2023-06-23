package Consultas;

import CSVResources.CSVTweetReader;
import Entities.Driver;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

public class ConsultaActiveDrivers implements CSVTweetReader {

    private Lista<Driver> drivers;
    private String inputDate;
    private Lista<String[]> textDate;

    public ConsultaActiveDrivers(Lista<Driver> drivers, String inputDate) {
        this.drivers = drivers;
        this.textDate = new LinkedList<>();
        this.inputDate = inputDate;
    }

    //Notar que execute no se llama desde el menu
    @Override
    public void execute(CSVRecord record) throws Exception {

        String date = record.get("date");

        //Agarra unicamente el año y mes
        date = date.substring(0,7);

        if(date.equals(this.inputDate)){

            String text = record.get("text");

            for(int i=0; i<drivers.size(); i++){

                if(text.contains(drivers.get(i).getName()) || text.contains(drivers.get(i).getSurname())){
                    drivers.get(i).setMentions(drivers.get(i).getMentions()+1);
                }
            }
        }
    }







}
