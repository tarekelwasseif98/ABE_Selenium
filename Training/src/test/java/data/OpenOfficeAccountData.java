package data;

public class OpenOfficeAccountData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String SchemeCode;
	private String CCY;
	private String AccountHeadName;
	private String EODMaxBalance;
	private String GeneralLedgerSubhead;
	private String expectedResult;
	private String reference;
	private String linkedTcid;
	
	public String getTcId() {
		return tcId;
	}
	
	public void setTcId(String tcId) {
		this.tcId = tcId;
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
	
	public String getSchemeCode() {
		return SchemeCode;
	}
	
	public void setSchemeCode(String schemeCode) {
		SchemeCode = schemeCode;
	}
	
	public String getCCY() {
		return CCY;
	}
	
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	
	public String getEODMaxBalance() {
		return EODMaxBalance;
	}
	
	public void setEODMaxBalance(String eODMaxBalance) {
		EODMaxBalance = eODMaxBalance;
	}
	
	public String getGeneralLedgerSubhead() {
		return GeneralLedgerSubhead;
	}
	
	public void setGeneralLedgerSubhead(String generalLedgerSubhead) {
		GeneralLedgerSubhead = generalLedgerSubhead;
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
	
	public String getLinkedTcid() {
		return linkedTcid;
	}
	
	public void setLinkedTcid(String linkedTcid) {
		this.linkedTcid = linkedTcid;
	}
	
	public String getAccountHeadName() {
		return AccountHeadName;
	}
	
	public void setAccountHeadName(String accountHeadName) {
		AccountHeadName = accountHeadName;
	}
	
	@Override
	public String toString() {
		return "OpenOfficeAccountData [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", SchemeCode=" + SchemeCode + ", CCY=" + CCY + ", AccountHeadName="
				+ AccountHeadName + ", EODMaxBalance=" + EODMaxBalance + ", GeneralLedgerSubhead="
				+ GeneralLedgerSubhead + ", expectedResult=" + expectedResult + ", reference=" + reference
				+ ", linkedTcid=" + linkedTcid + "]";
	}
}