package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class CSVReader {
	@DataProvider (name = "data-provider2")
	public static String[][] csvReader(String csv) throws InterruptedException {
	    String[] data= null;
	    String returnObj[][] = null; 
	    String csvFile = csv;	            
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    ArrayList<String> content = new ArrayList<String>();
	    
	    try {
	        br = new BufferedReader(new InputStreamReader(
	  		      new FileInputStream(csvFile), "UTF-8"));
	        int datalength = 0;
	        int listsize =0;
	        while ((line = br.readLine()) != null) {
	            content.add(line);
	        }
	        System.out.println(content);
	        listsize = content.size();
	        datalength = content.get(0).split(cvsSplitBy).length;
	        returnObj = new String[listsize-1][datalength];
	        
	        for (int i = 1; i<listsize; i++) {	            
	            data = content.get(i).split(cvsSplitBy);
	            for (int j=0; j< datalength ; j++) {
	                returnObj[i-1][j] = data[j];
	            }   
	        }    
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return returnObj;
	}
}