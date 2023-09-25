package utils;

public class Paths {
	public static final String OpenIslamicSavingsAccountCsv  = "csvFiles\\OpenIslamicSavingsAccount.csv";
	public static final String VerifyIslamicSavingsAccountCsv = "csvFiles\\VerifyIslamicSavingsAccount.csv";
	public static final String OpenIslamicSavingsAccountJson =  "jsonFiles\\" + OpenIslamicSavingsAccountCsv.substring(9, Paths.OpenIslamicSavingsAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicSavingsAccountJson = "jsonFiles\\" + VerifyIslamicSavingsAccountCsv.substring(9, Paths.VerifyIslamicSavingsAccountCsv.length()-4) + ".json";
	
	public static final String OpenIslamicCurrentAccountCsv  = "csvFiles\\OpenIslamicCurrentAccount.csv";
	public static final String VerifyIslamicCurrentAccountCsv = "csvFiles\\VerifyIslamicCurrentAccount.csv";
	public static final String OpenIslamicCurrentAccountJson =  "jsonFiles\\" + OpenIslamicCurrentAccountCsv.substring(9, Paths.OpenIslamicCurrentAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicCurrentAccountJson = "jsonFiles\\" + VerifyIslamicCurrentAccountCsv.substring(9, Paths.VerifyIslamicCurrentAccountCsv.length()-4) + ".json";

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\OpenIslamicCurrentAccount.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\VerifyIslamicCurrentAccount.csv";
	public static final String CloseIslamicCasaAccountJson =  "jsonFiles\\" + CloseIslamicCasaAccountCsv.substring(9, Paths.CloseIslamicCasaAccountCsv.length()-4) + ".json";
	public static final String VerifyCloseIslamicCasaAccountJson = "jsonFiles\\" + VerifyCloseIslamicCasaAccountCsv.substring(9, Paths.VerifyCloseIslamicCasaAccountCsv.length()-4) + ".json";

}