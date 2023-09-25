package utils;

public class Paths {
	public static final String Create_ACH_OutwardCsv  = "csvFiles\\Create_ACH_Outward.csv";
	public static final String OpenIslamicSavingsAccountCsv  = "csvFiles\\OpenIslamicSavingsAccount.csv";
	public static final String VerifyIslamicSavingsAccountCsv = "csvFiles\\VerifyIslamicSavingsAccount.csv";
	public static final String Create_ACH_OutwardJson =  "jsonFiles\\" + Create_ACH_OutwardCsv.substring(9, Paths.Create_ACH_OutwardCsv.length()-4) + ".json";
	public static final String OpenIslamicSavingsAccountJson =  "jsonFiles\\" + OpenIslamicSavingsAccountCsv.substring(9, Paths.OpenIslamicSavingsAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicSavingsAccountJson = "jsonFiles\\" + VerifyIslamicSavingsAccountCsv.substring(9, Paths.VerifyIslamicSavingsAccountCsv.length()-4) + ".json";
}