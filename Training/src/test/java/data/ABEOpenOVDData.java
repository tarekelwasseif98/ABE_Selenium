package data;

public class ABEOpenOVDData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String cif;
	private String schemeCode;
	private String currency;
	private String entityId;
	private String entityId1;
	private String cifType;
	private String documentDate;
	private String expiryDate;
	private String tenor;
	private String types;
	private String dropdownMenu;
	private String collateralCode;
	private String modifyLoan;
	private String apportionedAmount;
	private String withdrawal;
	
	
	private String expectedResult;
	private String reference;
	private String linkedTcid2;
	private String linkedTcid;
	
	public String getTCID() {
		return tcId;
	}

	public void setTCID(String tCID) {
		tcId = tCID;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getentityId() {
		return entityId;
	}

	public void setentityID(String entityId) {
		this.entityId= entityId;
	}
	
	
	
	public String getEntityId1() {
		return entityId1;
	}

	public void setEntityId1(String entityId1) {
		this.entityId1 = entityId1;
	}

	
	

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLinkedTCID() {
		return linkedTcid;
	}

	public void setLinkedTCID(String linkedTCID) {
		this.linkedTcid = linkedTCID;
	}

	
	public String getLinkedTCID2() {
		return linkedTcid2;
	}

	public void setLinkedTCID2(String linkedTCID2) {
		this.linkedTcid2 = linkedTCID2;
	}
	

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;

}
	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}
	
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	
	public String getDropdownMenu() {
		return dropdownMenu;
	}

	public void setDropdownMenu(String dropdownMenu) {
		this.dropdownMenu = dropdownMenu;
	}
	

	public String getCollateralCode() {
		return collateralCode;
	}

	public void setCollateralCode(String collateralCode) {
		this.collateralCode = collateralCode;
	}

	

	public String getModifyLoan() {
		return modifyLoan;
	}

	public void setModifyLoan(String modifyLoan) {
		this.modifyLoan = modifyLoan;
	}

		
	
	public String getApportionedAmount() {
		return apportionedAmount;
	}

	public void setApportionedAmount(String apportionedAmount) {
		this.apportionedAmount = apportionedAmount;
	}

	public String getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}

	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	

	public String getCifType() {
		return cifType;
	}

	public void setCifType(String cifType) {
		this.cifType = cifType;
	}

	@Override
	public String toString() {
		return "ABEOpenOVDData [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", cif=" + cif + ", schemeCode=" + schemeCode + ", currency=" + currency
				+ ", entityId=" + entityId + ", entityId1=" + entityId1 + ", cifType=" + cifType + ", documentDate="
				+ documentDate + ", expiryDate=" + expiryDate + ", tenor=" + tenor + ", types=" + types
				+ ", dropdownMenu=" + dropdownMenu + ", collateralCode=" + collateralCode + ", modifyLoan=" + modifyLoan
				+ ", apportionedAmount=" + apportionedAmount + ", withdrawal=" + withdrawal + ", expectedResult="
				+ expectedResult + ", reference=" + reference + ", linkedTcid2=" + linkedTcid2 + ", linkedTcid="
				+ linkedTcid + "]";
	}

		
	
	
}
