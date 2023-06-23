package Consultas;

import CSVResources.CSVTweetReader;
import Entities.User;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;

public class ConsultaMostTweetsUser implements CSVTweetReader {

    private MyHash<Integer, User> users;


    @Override
    public void execute(CSVRecord record) throws Exception {

    }
}
