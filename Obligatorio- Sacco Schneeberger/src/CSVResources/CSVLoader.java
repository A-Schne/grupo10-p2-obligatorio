package CSVResources;

import Entities.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class CSVLoader{
    private CSVTweetReader tweetReader;

    public CSVLoader(CSVTweetReader tweetReader) {
        this.tweetReader = tweetReader;
    }

    public void readCSV() throws Exception {

        String csvFile = "src/CSVResources/f1_dataset.csv";

        String[] headers = {"user_num", "user_name", "user_location", "user_description", "user_created",
                "user_followers", "user_friends", "user_favourites", "user_verified",
                "date", "text", "hashtags", "source", "is_retweet"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(headers).setSkipHeaderRecord(true).build();

        Reader reader = new FileReader(csvFile);

        Iterable<CSVRecord> records = csvFormat.parse(reader);

        for (CSVRecord csvRecord : records) {
            tweetReader.execute(csvRecord);
        }

    }
}
