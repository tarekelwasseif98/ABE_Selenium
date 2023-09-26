package utils;

public class Paths {
	public static final String OpenIslamicSavingsAccountCsv  = "csvFiles\\OpenIslamicSavingsAccount.csv";
	public static final String VerifyIslamicSavingsAccountCsv = "csvFiles\\VerifyIslamicSavingsAccount.csv";
	public static final String OpenOfficeAccountCsv  = "csvFiles\\OpenOfficeAccount.csv";
	public static final String VerifyOfficeAccountCsv  = "csvFiles\\VerifyOfficeAccount.csv";

	public static final String OpenIslamicSavingsAccountJson =  "jsonFiles\\" + OpenIslamicSavingsAccountCsv.substring(9, Paths.OpenIslamicSavingsAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicSavingsAccountJson = "jsonFiles\\" + VerifyIslamicSavingsAccountCsv.substring(9, Paths.VerifyIslamicSavingsAccountCsv.length()-4) + ".json";
	public static final String OpenOfficeAccountJson =  "jsonFiles\\" + OpenOfficeAccountCsv.substring(9, Paths.OpenOfficeAccountCsv.length()-4) + ".json";
	public static final String VerifyOfficeAccountJson =  "jsonFiles\\" + VerifyOfficeAccountCsv.substring(9, Paths.VerifyOfficeAccountCsv.length()-4) + ".json";

}