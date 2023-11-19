package procedures;



	import org.openqa.selenium.WebDriver;


	import data.ABEModifyOVDData;
	import pageobjects.ABEModifyOVDPage;
	import utils.FinacleFieldsUtils;
public class ABEModifyOVDProcedures {

public static void ModifyOverDraftAccountByMaker(WebDriver driver, ABEModifyOVDData data) throws Exception {
ABEModifyOVDPage ModifyOverDraftAccountBeforeVerificationPage = new ABEModifyOVDPage(driver);
ModifyOverDraftAccountBeforeVerificationPage.sendKeysSearchBarTextField(data.getMenu())
                                            .switchFormAreaFrame()										
                                             .sendKeysAccountIdTextField(data.getAccountId2())
                                             .pressGoButton();
                                             FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();                                        
                                            if(data.getTypes() != null && data.getTypes().equals(FinacleFields.TYPESSECURED)){
	                                             if(data.getExpiryDate() != null) {                                            	 
	    ModifyOverDraftAccountBeforeVerificationPage.modifyExpiryDateField(data.getExpiryDate())
	                                                .pressSubmitButton();
	                                            	 
	                                             }else {
	                                                    
	    ModifyOverDraftAccountBeforeVerificationPage.pressFrequencyButton()
	                                                .modifyFrequencyMonthField(data.getFrequencyMonth())
	                                                .modifyFrequencyDayField(data.getFrequencyDay());
		                                             }}
                                            
                                            if(data.getTypes().equals(FinacleFields.TYPESUNSECURED) && data.getDropdownMenu().equals(FinacleFields.DRAWINGPOWERINDICATORPARENT)){         
                                            
       ModifyOverDraftAccountBeforeVerificationPage.selectFromDropdownMenu(data.getDropdownMenu())
                                                   .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
                                                   .sendkeysDrawingPowerField(data.getDrawingPowerPrecentage())
                                                   .pressSubmitButton2();
                                              }else if(data.getTypes().equals(FinacleFields.TYPESUNSECURED) && data.getDropdownMenu()!= FinacleFields.DRAWINGPOWERINDICATORPARENT) {
      ModifyOverDraftAccountBeforeVerificationPage.selectDrawingPowerOptions(data.getDropdownMenu());
			
			}
	
	
}

	}
	