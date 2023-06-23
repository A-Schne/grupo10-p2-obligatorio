package CSVResources;

import org.apache.commons.csv.CSVRecord;

public interface CSVTweetReader {

    public void execute(CSVRecord record) throws Exception;

}
