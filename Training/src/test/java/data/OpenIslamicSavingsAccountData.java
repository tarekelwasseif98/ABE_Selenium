package data;

import org.testng.annotations.DataProvider;
import utils.CSVReader;
import utils.csvPaths;

public class OpenIslamicSavingsAccountData {
	
	private Object menu;
	private Object username;
	private Object password;
	private Object cif;
	
	public Object getMenu() {
		return menu;
	}

	public void setMenu(Object menu) {
		this.menu = menu;
	}
	
	public Object getUsername() {
		return username;
	}

	public void setUsername(Object username) {
		this.username = username;
	}

	public Object getPassword() {
		return password;
	}

	public void setPassword(Object password) {
		this.password = password;
	}

	public Object getCif() {
		return cif;
	}

	public void setCif(Object cif) {
		this.cif = cif;
	}
	
	@DataProvider (name = "OpenIslamicSavingsAccountDataProvider")
	public Object[][] extractionMethod() throws InterruptedException{
		Object[][] x = CSVReader.csvReader(csvPaths.OISAC_CSV);
	    for(int i=0; i<x.length; i++) {
	    	for(int j=0; j<x.length-3; j++) {
	    		setMenu(x[i][j]);
	        	setUsername(x[i][j+1]);
	        	setPassword(x[i][j+2]);
	        	setCif(x[i][j+3]);
	    }
	 }
		return x;
   }
}