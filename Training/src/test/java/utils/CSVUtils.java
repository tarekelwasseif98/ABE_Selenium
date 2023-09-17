package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtils {
	
    public static void clearColumnByIndex(String filePath, int columnIndex) throws IOException, CsvException {
        List<String[]> lines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            lines = reader.readAll();
        }
        
        for (int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i);
            if (columnIndex < line.length) {
                line[columnIndex] = "";
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(lines);
        }
    }
    
    public static void clearColumnByName(String filePath, String columnName) throws IOException, CsvException {
        List<String[]> lines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            lines = reader.readAll();
        }
      
        int columnIndex = -1;
        String[] header = lines.get(0);
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
      
        if (columnIndex != -1) {
            for (int i = 1; i < lines.size(); i++) {
                String[] line = lines.get(i);
                if (columnIndex < line.length) {
                    line[columnIndex] = "";
                }
            }
        }
      
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(lines);
        }
    }
    
    public static int getNextEmptyCellIndex(String filePath, int columnIndex) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            int rowIndex = 0;
            while ((nextLine = reader.readNext()) != null) {          	
                if (columnIndex < nextLine.length && nextLine[columnIndex].isEmpty()) {
                    return rowIndex;
                }
                rowIndex++;
            }
        }
        return -1;
    }
    
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
}