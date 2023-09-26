package utils;

public class Paths {

	public static final String OpenIslamicCurrentAccountCsv  = "csvFiles\\OpenIslamicCurrentAccount.csv";
	public static final String VerifyIslamicCurrentAccountCsv = "csvFiles\\VerifyIslamicCurrentAccount.csv";
	public static final String OpenIslamicCurrentAccountJson =  "jsonFiles\\" + OpenIslamicCurrentAccountCsv.substring(9, Paths.OpenIslamicCurrentAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicCurrentAccountJson = "jsonFiles\\" + VerifyIslamicCurrentAccountCsv.substring(9, Paths.VerifyIslamicCurrentAccountCsv.length()-4) + ".json";

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\CloseIslamicCasaAccount.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\VerifyCloseIslamicCasaAccount.csv";
	public static final String CloseIslamicCasaAccountJson =  "jsonFiles\\" + CloseIslamicCasaAccountCsv.substring(9, Paths.CloseIslamicCasaAccountCsv.length()-4) + ".json";
	public static final String VerifyCloseIslamicCasaAccountJson = "jsonFiles\\" + VerifyCloseIslamicCasaAccountCsv.substring(9, Paths.VerifyCloseIslamicCasaAccountCsv.length()-4) + ".json";

}