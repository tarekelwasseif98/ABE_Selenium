package utils;

public class Properties {
	public static final String hubUrl = "http://10.10.23.242:4444/wd/hub";
	public static final int minTime = 15;
	public static final int maxTime = 45;
	public static final int sleepTime = 6000;
	public static final String finacleUrl = "https://newwebuat.abe.com.eg:1443/fininfra/ui/SSOLogin.jsp";
	public static final String openIslamicSavingsAccountJson =  "jsonFiles\\" + CSVPaths.openIslamicSavingsAccountCsv.substring(9, CSVPaths.openIslamicSavingsAccountCsv.length()-4) + ".json";
	public static final String verifyIslamicSavingsAccountJson = "jsonFiles\\" + CSVPaths.verifyIslamicSavingsAccountCsv.substring(9, CSVPaths.verifyIslamicSavingsAccountCsv.length()-4) + ".json";
	//public static final String finacleUrl = "https://finwebsit.abe.com.eg:1443/fininfra/ui/SSOLogin.jsp";
	//public static final String finacleUrl = "https://finwebprd.abe.com.eg:1443/fininfra/ui/SSOLogin.jsp";
}