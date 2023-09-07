package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import data.OpenIslamicSavingsAccountData;

public class OpenIslamicSavingsAccountCSVReader {
	
	public static List<OpenIslamicSavingsAccountData> csvReader(String csv) throws CsvValidationException, IOException {
				
		CSVReader reader = new CSVReader(new FileReader(csv));
		List<OpenIslamicSavingsAccountData> allData = new ArrayList<OpenIslamicSavingsAccountData>();
		String[] record = null;
		reader.readNext();
		while ((record = reader.readNext()) != null) {
			OpenIslamicSavingsAccountData data = new OpenIslamicSavingsAccountData();
			data.setMenu(record[0]);
			data.setUsername(record[1]);
			data.setPassword(record[2]);
			data.setCif(record[3]);
			allData.add(data);
		}
		reader.close();
		return allData;
	}
}
