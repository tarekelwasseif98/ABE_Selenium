package data;

public class ABECreateOfficeAccountFinanceData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String SchemeCode;
	private String ccy;
	private String accountHeadName;
	private String eodMaxBalance;
	private String generalLedgerSubhead;
	private String expectedResult;
	private String reference;
	private String linkedTcId;
	
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
	
	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	
	public String getAccountHeadName() {
		return accountHeadName;
	}
	
	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}
	
	public String getEodMaxBalance() {
		return eodMaxBalance;
	}
	
	public void setEodMaxBalance(String eodMaxBalance) {
		this.eodMaxBalance = eodMaxBalance;
	}
	
	public String getGeneralLedgerSubhead() {
		return generalLedgerSubhead;
	}
	
	public void setGeneralLedgerSubhead(String generalLedgerSubhead) {
		this.generalLedgerSubhead = generalLedgerSubhead;
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
	
	public String getLinkedTcId() {
		return linkedTcId;
	}
	
	public void setLinkedTcid(String linkedTcid) {
		this.linkedTcId = linkedTcid;
	}

	@Override
	public String toString() {
		return "ABE_Create_OfficeAccount_Finance_Data [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", SchemeCode=" + SchemeCode + ", ccy=" + ccy
				+ ", accountHeadName=" + accountHeadName + ", eodMaxBalance=" + eodMaxBalance
				+ ", generalLedgerSubhead=" + generalLedgerSubhead + ", expectedResult=" + expectedResult
				+ ", reference=" + reference + ", linkedTcId=" + linkedTcId + "]";
	}
	
	

	
	

}
