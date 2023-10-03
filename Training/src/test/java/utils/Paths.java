package utils;

public class Paths {

	public static final String Create_ACH_OutwardCsv  = "csvFiles\\Create_ACH_Outward.csv";
	public static final String Verify_ACH_Outwardcsv = "csvFiles\\Verify_ACH_Outward.csv";
	public static final String Create_ACH_OutwardJson =  "jsonFiles\\" + Create_ACH_OutwardCsv.substring(9, Paths.Create_ACH_OutwardCsv.length()-4) + ".json";
	public static final String Verify_ACH_OutwardJson = "jsonFiles\\" + Verify_ACH_Outwardcsv.substring(9, Paths.Verify_ACH_Outwardcsv.length()-4) + ".json";
	
	public static final String OpenIslamicCurrentAccountCsv  = "csvFiles\\ABEOpenCurrentAccountMudarabahCAA.csv";
	public static final String VerifyIslamicCurrentAccountCsv = "csvFiles\\ABEVerifyCurrentAccountOpeningMudarabahCAA.csv";
	public static final String OpenIslamicCurrentAccountJson =  "jsonFiles\\" + OpenIslamicCurrentAccountCsv.substring(9, Paths.OpenIslamicCurrentAccountCsv.length()-4) + ".json";
	public static final String VerifyIslamicCurrentAccountJson = "jsonFiles\\" + VerifyIslamicCurrentAccountCsv.substring(9, Paths.VerifyIslamicCurrentAccountCsv.length()-4) + ".json";

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\ABECloseCasaAccountMudarabah.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\ABEVerifyCasaAccountClosureMudarabah.csv";
	public static final String CloseIslamicCasaAccountJson =  "jsonFiles\\" + CloseIslamicCasaAccountCsv.substring(9, Paths.CloseIslamicCasaAccountCsv.length()-4) + ".json";
	public static final String VerifyCloseIslamicCasaAccountJson = "jsonFiles\\" + VerifyCloseIslamicCasaAccountCsv.substring(9, Paths.VerifyCloseIslamicCasaAccountCsv.length()-4) + ".json";

	public static final String OpenOfficeAccountCsv  = "csvFiles\\OpenOfficeAccount.csv";
	public static final String VerifyOfficeAccountCsv  = "csvFiles\\VerifyOfficeAccount.csv";
	public static final String OpenOfficeAccountJson =  "jsonFiles\\" + OpenOfficeAccountCsv.substring(9, Paths.OpenOfficeAccountCsv.length()-4) + ".json";
	public static final String VerifyOfficeAccountJson =  "jsonFiles\\" + VerifyOfficeAccountCsv.substring(9, Paths.VerifyOfficeAccountCsv.length()-4) + ".json";
	
	public static final String OpenTUACsv  = "csvFiles\\ABEOpenTUA.csv";
	public static final String VerifyTUAOpeningCsv  = "csvFiles\\ABEVerifyTUAOpening.csv";
	public static final String OpenTUAJson =  "jsonFiles\\" + OpenTUACsv.substring(9, Paths.OpenTUACsv.length()-4) + ".json";
	public static final String VerifyTUAOpeningJson =  "jsonFiles\\" + VerifyTUAOpeningCsv.substring(9, Paths.VerifyTUAOpeningCsv.length()-4) + ".json";
	
	public static final String CloseTUACsv  = "csvFiles\\ABECloseTUA.csv";
	public static final String VerifyTUAClosureCsv  = "csvFiles\\ABEVerifyTUAClosure.csv";
	public static final String CloseTUAJson =  "jsonFiles\\" + CloseTUACsv.substring(9, Paths.CloseTUACsv.length()-4) + ".json";
	public static final String VerifyTUAClosureJson =  "jsonFiles\\" + VerifyTUAClosureCsv.substring(9, Paths.VerifyTUAClosureCsv.length()-4) + ".json";

}