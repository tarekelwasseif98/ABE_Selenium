package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderHelper {
    public static String getTestCaseId(String csvFilePath) throws CsvValidationException {
        String testCaseId = "";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            reader.readNext();
            if ((nextLine = reader.readNext()) != null) {
                testCaseId = nextLine[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseId;
    }
    
    //// get column & row and call in page object class
}