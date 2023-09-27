package data;

public class ABE_OpenTUA_TUA_Data {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String cif;
	private String schemeCode;
	private String generalLedgerSubheadCode;
	private String depositPeriod;
	private String initialDepositAmount;
	private String profitCreditAccountId;
	private String repaymentAccountId;
	private String debitAccountId;
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
	
	public String getDepositPeriod() {
		return depositPeriod;
	}
	
	public void setDepositPeriod(String depositPeriod) {
		this.depositPeriod = depositPeriod;
	}
	
	public String getInitialDepositAmount() {
		return initialDepositAmount;
	}
	
	public void setInitialDepositAmount(String initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
	}
	
	public String getProfitCreditAccountId() {
		return profitCreditAccountId;
	}
	
	public void setProfitCreditAccountId(String profitCreditAccountId) {
		this.profitCreditAccountId = profitCreditAccountId;
	}
	
	public String getRepaymentAccountId() {
		return repaymentAccountId;
	}
	
	public void setRepaymentAccountId(String repaymentAccountId) {
		this.repaymentAccountId = repaymentAccountId;
	}
	
	public String getDebitAccountId() {
		return debitAccountId;
	}
	
	public void setDebitAccountId(String debitAccountId) {
		this.debitAccountId = debitAccountId;
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

	@Override
	public String toString() {
		return "ABE_OpenTUA_TUA_Data [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", cif=" + cif + ", schemeCode=" + schemeCode
				+ ", generalLedgerSubheadCode=" + generalLedgerSubheadCode + ", depositPeriod=" + depositPeriod
				+ ", initialDepositAmount=" + initialDepositAmount + ", profitCreditAccountId=" + profitCreditAccountId
				+ ", repaymentAccountId=" + repaymentAccountId + ", debitAccountId=" + debitAccountId
				+ ", expectedResult=" + expectedResult + ", reference=" + reference + ", linkedTcid=" + linkedTcid
				+ "]";
	}
}