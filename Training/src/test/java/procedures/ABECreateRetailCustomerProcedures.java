package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateRetailCustomerData;
import pageobjects.ABECreateRetailCustomerPage;
import utils.FinacleFieldsUtils;

public class ABECreateRetailCustomerProcedures {

	public static void CreateRetailCustomer(WebDriver driver, ABECreateRetailCustomerData data) throws Exception {
		ABECreateRetailCustomerPage ABECreateRetailCustomerPage = new ABECreateRetailCustomerPage(driver);
		ABECreateRetailCustomerPage.sendKeysSearchBarTextField(data.getMenu())
				.openRetailCustomerFristPage(data.getDocType(), data.getDocNumber());
		if (data.getDocType().equalsIgnoreCase(FinacleFieldsUtils.PASSPORTID)) {
			ABECreateRetailCustomerPage.fillBasicDetailsPASSPORT(data.getDOB())
					.enterARCustomerName(data.getFirstARname(), data.getMidARname(), data.getLastARname())
					.enterENCustomerName(data.getFirstENname(), data.getMidENname(), data.getLastENname())
					.enterNationalityOfCustomer(data.getNationalityCustomer())
					.editIDsummary(data.getCountryOfIssueSummary(), data.getIssueDateIDSummary(),
							data.getExpiryDateIDSummary())
					.addAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorate(),
							data.getCountry())
					.addPhoneAndEmailSummary(data.getPhoneNumber()).continueBasicDetailsButton()
					.fillPersonalDetails(data.getMotherMaidenName(), data.getMotherFirstname());
			
			if(data.getEmployed().equalsIgnoreCase("N")){
				ABECreateRetailCustomerPage.fillEmploymentDetails();
				}else if (data.getEmployed().equalsIgnoreCase("Y")){
					ABECreateRetailCustomerPage.selectBankEmployeeRadioButton(data.getBankEmployeeID());
					}

			if (data.getResidencyStatus().equalsIgnoreCase("Resident:Foreign National")) {
				ABECreateRetailCustomerPage.fillResidentialDetails(data.getResidencyStatus(), data.getResindencExpiry(),
						data.getResidenceCountry()).continueOtherDetailsButton();
			}
			ABECreateRetailCustomerPage.addSegmentTypeRetailCustomer(data.getSegment(), data.getSubSegment())
					.saveAndEnrich().saveCIF(data.getLinkedTcid());
			
			//ENRICH
		ABECreateRetailCustomerPage.proceedtoEnrich().generalDetailsOption(data.getCountry()).bankStatmentDetails().EmailDetails(data.getEmail())
		.continueBasicDetails();
		
		
		}

	}

}