package utils;

public class Paths {

	public static final String Create_ACH_OutwardCsv  = "csvFiles\\Create_ACH_Outward.csv";
	public static final String Verify_ACH_Outwardcsv = "csvFiles\\Verify_ACH_Outward.csv";
	public static final String Authorize_ACH_Outwardcsv = "csvFiles\\Authorize_ACH_Outward.csv";
	public static final String Create_ACH_OutwardJson =  "jsonFiles\\" + Create_ACH_OutwardCsv.substring(9, Paths.Create_ACH_OutwardCsv.length()-4) + ".json";
	public static final String Verify_ACH_OutwardJson = "jsonFiles\\" + Verify_ACH_Outwardcsv.substring(9, Paths.Verify_ACH_Outwardcsv.length()-4) + ".json";
	public static final String Authorize_ACH_OutwardJson =  "jsonFiles\\" + Authorize_ACH_Outwardcsv.substring(9, Paths.Authorize_ACH_Outwardcsv.length()-4) + ".json";
	
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

	public static final String CloseIslamicCasaAccountCsv  = "csvFiles\\ABECloseCasaAccountMudarabah.csv";
	public static final String VerifyCloseIslamicCasaAccountCsv = "csvFiles\\ABEVerifyCasaAccountClosureMudarabah.csv";
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
	
	public static final String DisburseMurabahaAccountCsv  = "csvFiles\\ABEDisburseMurabahaAccountMurabahaFinancing.csv";
	public static final String VerifyMurabahaAccountDisbursementCsv  = "csvFiles\\ABEVerifyMurabahaAccountDisbursementMurabahaFinancing.csv";
	public static final String DisburseMurabahaAccountJson =  "jsonFiles\\" + DisburseMurabahaAccountCsv.substring(9, Paths.DisburseMurabahaAccountCsv.length()-4) + ".json";
	public static final String VerifyMurabahaAccountDisbursementJson =  "jsonFiles\\" + VerifyMurabahaAccountDisbursementCsv.substring(9, Paths.VerifyMurabahaAccountDisbursementCsv.length()-4) + ".json";
	
	public static final String PayoffMurabahaAccountCsv  = "csvFiles\\ABEPayoffMurabahaAccountMurabahaFinancing.csv";
	public static final String VerifyMurabahaAccountPayoffCsv  = "csvFiles\\ABEVerifyMurabahaAccountPayoffMurabahaFinancing.csv";
	public static final String PayoffMurabahaAccountJson =  "jsonFiles\\" + PayoffMurabahaAccountCsv.substring(9, Paths.PayoffMurabahaAccountCsv.length()-4) + ".json";
	public static final String VerifyMurabahaAccountPayoffJson =  "jsonFiles\\" + VerifyMurabahaAccountPayoffCsv.substring(9, Paths.VerifyMurabahaAccountPayoffCsv.length()-4) + ".json";
	
	public static final String OpenCorporateLoanCsv  = "csvFiles\\ABEOpenCorporateLoanCorporateLoans.csv";
	public static final String VerifyCorporateLoanCsv  = "csvFiles\\ABEVerifyCorporateLoanCorporateLoans.csv";
	public static final String OpenCorporateLoanJson =  "jsonFiles\\" + OpenCorporateLoanCsv.substring(9, Paths.OpenCorporateLoanCsv.length()-4) + ".json";
	public static final String VerifyCorporateLoanJson =  "jsonFiles\\" + VerifyCorporateLoanCsv.substring(9, Paths.VerifyCorporateLoanCsv.length()-4) + ".json";
	
	public static final String LodgeExportBillsCsv  = "csvFiles\\ABELodgeExportBillsTradeFinance.csv";
	public static final String VerifyLodgeExportBillsCsv  = "csvFiles\\ABEVerifyLodgeExportBillsTradeFinance.csv";
	public static final String LodgeExportBillsJson =  "jsonFiles\\" + LodgeExportBillsCsv.substring(9, Paths.LodgeExportBillsCsv.length()-4) + ".json";
	public static final String VerifyLodgeExportBillsJson =  "jsonFiles\\" + VerifyLodgeExportBillsCsv.substring(9, Paths.VerifyLodgeExportBillsCsv.length()-4) + ".json";
	
	public static final String AcceptExportBillsCsv  = "csvFiles\\ABEAcceptExportBillsTradeFinance.csv";
	public static final String VerifyAcceptExportBillsCsv  = "csvFiles\\ABEVerifyAcceptExportBillsTradeFinance.csv";
	public static final String AcceptExportBillsJson =  "jsonFiles\\" + AcceptExportBillsCsv.substring(9, Paths.AcceptExportBillsCsv.length()-4) + ".json";
	public static final String VerifyAcceptExportBillsJson =  "jsonFiles\\" + VerifyAcceptExportBillsCsv.substring(9, Paths.VerifyAcceptExportBillsCsv.length()-4) + ".json";
	
	public static final String PurchaseExportBillsCsv  = "csvFiles\\ABEPurchaseExportBillsTradeFinance.csv";
	public static final String VerifyPurchaseExportBillsCsv  = "csvFiles\\ABEVerifyPurchaseExportBillsTradeFinance.csv";
	public static final String PurchaseExportBillsJson =  "jsonFiles\\" + PurchaseExportBillsCsv.substring(9, Paths.PurchaseExportBillsCsv.length()-4) + ".json";
	public static final String VerifyPurchaseExportBillsJson =  "jsonFiles\\" + VerifyPurchaseExportBillsCsv.substring(9, Paths.VerifyPurchaseExportBillsCsv.length()-4) + ".json";
	
	public static final String RealizeExportBillsCsv  = "csvFiles\\ABERealizeExportBillsTradeFinance.csv";
	public static final String VerifyRealizeExportBillsCsv  = "csvFiles\\ABEVerifyRealizeExportBillsTradeFinance.csv";
	public static final String RealizeExportBillsJson =  "jsonFiles\\" + RealizeExportBillsCsv.substring(9, Paths.RealizeExportBillsCsv.length()-4) + ".json";
	public static final String VerifyRealizeExportBillsJson =  "jsonFiles\\" + VerifyRealizeExportBillsCsv.substring(9, Paths.VerifyRealizeExportBillsCsv.length()-4) + ".json";
	
	public static final String ABETellerOperationTransferLiabilitiesAndOperationCsv  = "csvFiles\\ABETellerOperationTransferLiabilitiesAndOperation.csv";
	public static final String ABETellerOperationTransferLiabilitiesAndOperationJson =  "jsonFiles\\" + ABETellerOperationTransferLiabilitiesAndOperationCsv.substring(9, Paths.ABETellerOperationTransferLiabilitiesAndOperationCsv.length()-4) + ".json";
	
}