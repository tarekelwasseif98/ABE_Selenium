package utils;

public class Paths {

	public static final String Create_ACH_OutwardCsv  = "csvFiles\\Create_ACH_Outward.csv";
	public static final String Verify_ACH_Outwardcsv = "csvFiles\\Verify_ACH_Outward.csv";
	public static final String Authorize_ACH_Outwardcsv = "csvFiles\\Authorize_ACH_Outward.csv";
	public static final String Create_ACH_OutwardJson =  "jsonFiles\\" + Create_ACH_OutwardCsv.substring(9, Paths.Create_ACH_OutwardCsv.length()-4) + ".json";
	public static final String Verify_ACH_OutwardJson = "jsonFiles\\" + Verify_ACH_Outwardcsv.substring(9, Paths.Verify_ACH_Outwardcsv.length()-4) + ".json";
	public static final String Authorize_ACH_OutwardJson =  "jsonFiles\\" + Authorize_ACH_Outwardcsv.substring(9, Paths.Authorize_ACH_Outwardcsv.length()-4) + ".json";
	
	public static final String OpenIslamicCurrentAccountCsv  = "csvFiles\\OpenIslamicCurrentAccount.csv";
	public static final String VerifyIslamicCurrentAccountCsv = "csvFiles\\VerifyIslamicCurrentAccount.csv";
	public static final String OpenIslamicCurrentAccountJson =  "jsonFiles\\" + OpenIslamicCurrentAccountCsv.substring(9, Paths.OpenIslamicCurrentAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicCurrentAccountJson = "jsonFiles\\" + VerifyIslamicCurrentAccountCsv.substring(9, Paths.VerifyIslamicCurrentAccountCsv.length()-4) + ".json";

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\CloseIslamicCasaAccount.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\VerifyCloseIslamicCasaAccount.csv";
	public static final String CloseIslamicCasaAccountJson =  "jsonFiles\\" + CloseIslamicCasaAccountCsv.substring(9, Paths.CloseIslamicCasaAccountCsv.length()-4) + ".json";
	public static final String VerifyCloseIslamicCasaAccountJson = "jsonFiles\\" + VerifyCloseIslamicCasaAccountCsv.substring(9, Paths.VerifyCloseIslamicCasaAccountCsv.length()-4) + ".json";

	public static final String OpenOfficeAccountCsv  = "csvFiles\\OpenOfficeAccount.csv";
	public static final String VerifyOfficeAccountCsv  = "csvFiles\\VerifyOfficeAccount.csv";
	public static final String OpenOfficeAccountJson =  "jsonFiles\\" + OpenOfficeAccountCsv.substring(9, Paths.OpenOfficeAccountCsv.length()-4) + ".json";
	public static final String VerifyOfficeAccountJson =  "jsonFiles\\" + VerifyOfficeAccountCsv.substring(9, Paths.VerifyOfficeAccountCsv.length()-4) + ".json";
	
	public static final String OpenTUACsv  = "csvFiles\\ABE_OpenTUA_TUA.csv";
	public static final String VerifyTUAOpeningCsv  = "csvFiles\\ABE_VerifyTUAOpening_TUA.csv";
	public static final String OpenTUAJson =  "jsonFiles\\" + OpenTUACsv.substring(9, Paths.OpenTUACsv.length()-4) + ".json";
	public static final String VerifyTUAOpeningJson =  "jsonFiles\\" + VerifyTUAOpeningCsv.substring(9, Paths.VerifyTUAOpeningCsv.length()-4) + ".json";

}