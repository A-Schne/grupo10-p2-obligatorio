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

    public ConsultaActiveDrivers(String inputDate) {
        this.drivers = new LinkedList<>();
        this.textDate = new LinkedList<>();
        this.inputDate = inputDate;
    }

    @Override
    public void execute(CSVRecord record) {

    }






}
