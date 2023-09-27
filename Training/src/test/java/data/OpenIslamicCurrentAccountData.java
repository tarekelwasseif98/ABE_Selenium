package data;

public class OpenIslamicCurrentAccountData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String cif;
	private String schemeCode;
	private String generalLedgerSubheadCode;
	private String expectedResult;
	private String reference;
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

	public String getGeneralLedgerSubheadCode() {
		return generalLedgerSubheadCode;
	}

	public void setGeneralLedgerSubheadCode(String generalLedgerSubheadCode) {
		this.generalLedgerSubheadCode = generalLedgerSubheadCode;
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

	@Override
	public String toString() {
		return "OpenIslamicCurrentAccountData Testcase ID: " + tcId + ", Summary: " + summary + ", Username: " + username
				+ ", Password: " + password + ", Menu: " + menu + ", CIF ID: " + cif + ", Scheme Code: " + schemeCode
				+ ", General Ledger Subhead Code: " + generalLedgerSubheadCode + ", Expected Result: " + expectedResult
				+ ", Linked Testcase ID: " + linkedTcid;
	}
}