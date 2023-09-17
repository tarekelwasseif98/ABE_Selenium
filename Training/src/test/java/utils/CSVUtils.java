package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtils {
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
    
    public static int getNextEmptyCellIndexByColumnName(String csvFile, String columnName) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = reader.readNext();
            int rowIndex = 0;
            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(columnName)) {
                    columnIndex = i;
                    break;
                }
            }
            if (columnIndex == -1) {
                return columnIndex;
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > columnIndex && nextLine[columnIndex].isEmpty()) {
                	return rowIndex+1;
                }
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return -1;
    }
    
    public static int getColumnIndexByColumnName(String csvFilePath, String columnName) throws IOException {
        FileReader fileReader = new FileReader(csvFilePath);
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());

        int columnIndex = -1;
        String[] header = csvParser.getHeaderMap().keySet().toArray(new String[0]);
        for (int i = 0; i < header.length; i++) {
            if (header[i].equalsIgnoreCase(columnName)) {
                columnIndex = i;
                break;
            }
        }

        csvParser.close();
        return columnIndex;
    }
    
    public static void insertValueInCsvCell(String csvFile, int nextEmptyCellIndex, int columnNameIndex, String acid) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		List<String[]> lines = reader.readAll();
		reader.close();
		if(nextEmptyCellIndex < lines.size()) {
		    String[] row = lines.get(nextEmptyCellIndex);
		    row[columnNameIndex] = "'" + acid;
		    lines.set(nextEmptyCellIndex, row);
		}
		CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
		writer.writeAll(lines,false);
		writer.flush();
		writer.close();
    }
}