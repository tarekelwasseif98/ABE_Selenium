package utils;

public class Paths {

	public static final String Create_ACH_OutwardCsv  = "csvFiles\\Create_ACH_Outward.csv";
	public static final String Verify_ACH_Outwardcsv = "csvFiles\\Verify_ACH_Outward.csv";
	public static final String Authorize_ACH_Outwardcsv = "csvFiles\\Authorize_ACH_Outward.csv";
	public static final String Create_ACH_OutwardJson =  "jsonFiles\\" + Create_ACH_OutwardCsv.substring(9, Paths.Create_ACH_OutwardCsv.length()-4) + ".json";
	public static final String Verify_ACH_OutwardJson = "jsonFiles\\" + Verify_ACH_Outwardcsv.substring(9, Paths.Verify_ACH_Outwardcsv.length()-4) + ".json";
	public static final String Authorize_ACH_OutwardJson =  "jsonFiles\\" + Authorize_ACH_Outwardcsv.substring(9, Paths.Authorize_ACH_Outwardcsv.length()-4) + ".json";
	
	public static final String ABECreateACHUSOutwardCsv  = "csvFiles\\ABECreateACHUSOutward.csv";
	public static final String ABEVerifyACHUSOutwardCsv = "csvFiles\\ABEVerifyACHUSOutward.csv";
	public static final String ABEAuthorizeACHUSOutwardCsv = "csvFiles\\ABEAuthorizeACHUSOutward.csv";
	public static final String ABECreateACHUSOutwardJson =  "jsonFiles\\" + ABECreateACHUSOutwardCsv.substring(9, Paths.ABECreateACHUSOutwardCsv.length()-4) + ".json";
	public static final String ABEVerifyACHUSOutwardJson = "jsonFiles\\" + ABEVerifyACHUSOutwardCsv.substring(9, Paths.ABEVerifyACHUSOutwardCsv.length()-4) + ".json";
	public static final String ABEAuthorizeACHUSOutwardJson =  "jsonFiles\\" + ABEAuthorizeACHUSOutwardCsv.substring(9, Paths.ABEAuthorizeACHUSOutwardCsv.length()-4) + ".json";
	
	public static final String ABECreateACHEROutwardCsv  = "csvFiles\\ABECreateACHEROutward.csv";
	public static final String ABEVerifyACHEROutwardCsv = "csvFiles\\ABEVerifyACHEROutward.csv";
	public static final String ABEAuthorizeACHEROutwardCsv = "csvFiles\\ABEAuthorizeACHEROutward.csv";
	public static final String ABECreateACHEROutwardJson =  "jsonFiles\\" + ABECreateACHEROutwardCsv.substring(9, Paths.ABECreateACHEROutwardCsv.length()-4) + ".json";
	public static final String ABEVerifyACHEROutwardJson = "jsonFiles\\" + ABEVerifyACHEROutwardCsv.substring(9, Paths.ABEVerifyACHEROutwardCsv.length()-4) + ".json";
	public static final String ABEAuthorizeACHEROutwardJson =  "jsonFiles\\" + ABEAuthorizeACHEROutwardCsv.substring(9, Paths.ABEAuthorizeACHEROutwardCsv.length()-4) + ".json";
	
	public static final String ABECreateSWIFTOutwardCsv  = "csvFiles\\ABECreateSWIFTOutward.csv";
	public static final String ABEVerifySWIFTOutwardCsv = "csvFiles\\ABEVerifySWIFTOutward.csv";
	public static final String ABEAuthorizeSWIFTOutwardCsv = "csvFiles\\ABEAuthorizeSWIFTOutward.csv";
	public static final String ABECreateSWIFTOutwardJson =  "jsonFiles\\" + ABECreateSWIFTOutwardCsv.substring(9, Paths.ABECreateSWIFTOutwardCsv.length()-4) + ".json";
	public static final String ABEVerifySWIFTOutwardJson = "jsonFiles\\" + ABEVerifySWIFTOutwardCsv.substring(9, Paths.ABEVerifySWIFTOutwardCsv.length()-4) + ".json";
	public static final String ABEAuthorizeSWIFTOutwardJson =  "jsonFiles\\" + ABEAuthorizeSWIFTOutwardCsv.substring(9, Paths.ABEAuthorizeSWIFTOutwardCsv.length()-4) + ".json";
	
	public static final String ABECreateESWIFTOutwardCsv  = "csvFiles\\ABECreateESWIFTOutward.csv";
	public static final String ABEVerifyESWIFTOutwardCsv = "csvFiles\\ABEVerifyESWIFTOutward.csv";
	public static final String ABEAuthorizeESWIFTOutwardCsv = "csvFiles\\ABEAuthorizeESWIFTOutward.csv";
	public static final String ABECreateESWIFTOutwardJson =  "jsonFiles\\" + ABECreateESWIFTOutwardCsv.substring(9, Paths.ABECreateESWIFTOutwardCsv.length()-4) + ".json";
	public static final String ABEVerifyESWIFTOutwardJson = "jsonFiles\\" + ABEVerifyESWIFTOutwardCsv.substring(9, Paths.ABEVerifyESWIFTOutwardCsv.length()-4) + ".json";
	public static final String ABEAuthorizeESWIFTOutwardJson =  "jsonFiles\\" + ABEAuthorizeESWIFTOutwardCsv.substring(9, Paths.ABEAuthorizeESWIFTOutwardCsv.length()-4) + ".json";
	
	public static final String ABECreateSTOCsv  = "csvFiles\\ABECreateSTO.csv";
	public static final String ABEVerifySTOCsv= "csvFiles\\ABEVerifySTO.csv";
	public static final String ABECreateSTOJson =  "jsonFiles\\" + ABECreateSTOCsv.substring(9, Paths.ABECreateSTOCsv.length()-4) + ".json";
	public static final String ABEVerifySTOJson = "jsonFiles\\" + ABEVerifySTOCsv.substring(9, Paths.ABEVerifySTOCsv.length()-4) + ".json";
	
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