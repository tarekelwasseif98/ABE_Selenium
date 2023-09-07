package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import data.VerifyIslamicSavingsAccountData;

public class VerifyIslamicSavingsAccountCSVReader {
	
	public static List<VerifyIslamicSavingsAccountData> csvReader(String csv) throws CsvValidationException, IOException {
				
		CSVReader reader = new CSVReader(new FileReader(csv));
		List<VerifyIslamicSavingsAccountData> allData = new ArrayList<VerifyIslamicSavingsAccountData>();
		String[] record = null;
		reader.readNext();
		while ((record = reader.readNext()) != null) {
			VerifyIslamicSavingsAccountData data = new VerifyIslamicSavingsAccountData();
			data.setMenu(record[0]);
			data.setUsername(record[1]);
			data.setPassword(record[2]);
			data.setAccountid(record[3]);
			allData.add(data);
		}
		reader.close();
		return allData;
	}
}