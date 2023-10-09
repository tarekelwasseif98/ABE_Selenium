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

	public static final String ABECreateCASACurrentAccountLiabilitiesAndOperationCsv  = "csvFiles\\ABECreateCASACurrentAccountLiabilitiesAndOperation.csv";
	public static final String ABECreateCASACurrentAccountLiabilitiesAndOperationJson = "jsonFiles\\" + ABECreateCASACurrentAccountLiabilitiesAndOperationCsv.substring(9, Paths.ABECreateCASACurrentAccountLiabilitiesAndOperationCsv.length()-4) + ".json";
	public static final String ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv  = "csvFiles\\ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperation.csv";
	public static final String ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationJson = "jsonFiles\\" + ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv.substring(9, Paths.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv.length()-4) + ".json";

	public static final String ABECreateCASASavingsAccountLiabilitiesAndOperationCsv  = "csvFiles\\ABECreateCASASavingsAccountLiabilitiesAndOperation.csv";
	public static final String ABECreateCASASavingsAccountLiabilitiesAndOperationJson = "jsonFiles\\" + ABECreateCASASavingsAccountLiabilitiesAndOperationCsv.substring(9, Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv.length()-4) + ".json";
	public static final String ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv  = "csvFiles\\ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperation.csv";
	public static final String ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationJson = "jsonFiles\\" + ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv.substring(9, Paths.ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv.length()-4) + ".json";

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\CloseIslamicCasaAccount.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\VerifyCloseIslamicCasaAccount.csv";
	public static final String CloseIslamicCasaAccountJson =  "jsonFiles\\" + CloseIslamicCasaAccountCsv.substring(9, Paths.CloseIslamicCasaAccountCsv.length()-4) + ".json";
	public static final String VerifyCloseIslamicCasaAccountJson = "jsonFiles\\" + VerifyCloseIslamicCasaAccountCsv.substring(9, Paths.VerifyCloseIslamicCasaAccountCsv.length()-4) + ".json";

	public static final String ABECreateOfficeAccountFinanceCsv  = "csvFiles\\ABECreateOfficeAccountFinance.csv";
	public static final String ABEVerifyOfficeAccountFinanceCsv  = "csvFiles\\ABEVerifyOfficeAccountFinance.csv";
	public static final String ABECreateOfficeAccountFinanceJson =  "jsonFiles\\" + ABECreateOfficeAccountFinanceCsv.substring(9, Paths.ABECreateOfficeAccountFinanceCsv.length()-4) + ".json";
	public static final String ABEVerifyOfficeAccountFinanceJson =  "jsonFiles\\" + ABEVerifyOfficeAccountFinanceCsv.substring(9, Paths.ABEVerifyOfficeAccountFinanceCsv.length()-4) + ".json";

	public static final String OpenTUACsv  = "csvFiles\\ABEOpenTUA.csv";
	public static final String VerifyTUAOpeningCsv  = "csvFiles\\ABEVerifyTUAOpening.csv";
	public static final String OpenTUAJson =  "jsonFiles\\" + OpenTUACsv.substring(9, Paths.OpenTUACsv.length()-4) + ".json";
	public static final String VerifyTUAOpeningJson =  "jsonFiles\\" + VerifyTUAOpeningCsv.substring(9, Paths.VerifyTUAOpeningCsv.length()-4) + ".json";
	
	public static final String CloseTUACsv  = "csvFiles\\ABECloseTUA.csv";
	public static final String VerifyTUAClosureCsv  = "csvFiles\\ABEVerifyTUAClosure.csv";
	public static final String CloseTUAJson =  "jsonFiles\\" + CloseTUACsv.substring(9, Paths.CloseTUACsv.length()-4) + ".json";
	public static final String VerifyTUAClosureJson =  "jsonFiles\\" + VerifyTUAClosureCsv.substring(9, Paths.VerifyTUAClosureCsv.length()-4) + ".json";
	
	public static final String OpenMurabahaAccountCsv  = "csvFiles\\ABEOpenMurabahaAccountMurabahaFinancing.csv";
	public static final String VerifyMurabahaAccountOpeningCsv  = "csvFiles\\ABEVerifyMurabahaAccountOpeningMurabahaFinancing.csv";
	public static final String OpenMurabahaAccountJson =  "jsonFiles\\" + OpenMurabahaAccountCsv.substring(9, Paths.OpenMurabahaAccountCsv.length()-4) + ".json";
	public static final String VerifyMurabahaAccountOpeningJson =  "jsonFiles\\" + VerifyMurabahaAccountOpeningCsv.substring(9, Paths.VerifyMurabahaAccountOpeningCsv.length()-4) + ".json";
	
	public static final String ABETellerOperationTransferLiabilitiesAndOperationCsv  = "csvFiles\\ABETellerOperationTransferLiabilitiesAndOperation.csv";
	public static final String ABETellerOperationTransferLiabilitiesAndOperationJson =  "jsonFiles\\" + ABETellerOperationTransferLiabilitiesAndOperationCsv.substring(9, Paths.ABETellerOperationTransferLiabilitiesAndOperationCsv.length()-4) + ".json";
	
}