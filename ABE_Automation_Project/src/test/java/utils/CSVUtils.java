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
    
    public static int getRowByTcid(String csvFile, String columnName, String testCaseID) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> lines = reader.readAll();
            String[] headers = lines.get(0);
            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(columnName)) {
                    columnIndex = i;
                    break;
                }
            }
            if (columnIndex == -1) {
                System.out.println("Column '" + columnName + "' not found.");
                return -1;
            }
            for (int rowIndex = 1; rowIndex < lines.size(); rowIndex++) {
                String[] row = lines.get(rowIndex);
                if (row[columnIndex].equals(testCaseID)) {
                    System.out.println("Row index found: " + rowIndex);
                    return rowIndex;
                }
            }
            System.out.println("No matching row found for test case ID: " + testCaseID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static int getColumnByColumnName(String csvFilePath, String columnName) throws IOException {
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
    
    public static void insertValueInCsvCell(String csvFile, int rowToUse, int columnToUse, String acid) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		List<String[]> lines = reader.readAll();
		reader.close();
		if(rowToUse < lines.size()) {
		    String[] row = lines.get(rowToUse);
		    row[columnToUse] = "'" + acid;
		    lines.set(rowToUse, row);
		}
		CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
		writer.writeAll(lines,false);
		writer.flush();
		writer.close();
    }
}