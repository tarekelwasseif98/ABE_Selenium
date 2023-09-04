package data;

import org.testng.annotations.DataProvider;

import utils.CSVReader;
import utils.csvPaths;

public class VerifyIslamicSavingsAccountData {
	
	private Object menu;
	private Object username;
	private Object password;
	private Object accountid;
	
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
	
	public Object getAccountid() {
		return accountid;
	}

	public void setAccountid(Object accountid) {
		this.accountid = accountid;
	}

	@DataProvider (name = "VerifyIslamicSavingsAccountDataProvider")
	public Object[][] extractionMethod() throws InterruptedException{
		Object[][] x = CSVReader.csvReader(csvPaths.VISAO_CSV);
	    for(int i=0; i<x.length; i++) {
	    	for(int j=0; j<x.length-3; j++) {
	    		setMenu(x[i][j]);
	        	setUsername(x[i][j+1]);
	        	setPassword(x[i][j+2]);
	        	setAccountid(x[i][j+3]);
	    }
	 }
		return x;
   }
}