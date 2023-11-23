package data;

public class ABEDisburseCorporateLoanCorporateLoansData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String accountId;
	private String valueDate;
	private String disbursmentType;
	private String disbursmentAccount;
	private String expectedResult;
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
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getValueDate() {
		return valueDate;
	}
	
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	
	public String getDisbursmentType() {
		return disbursmentType;
	}
	
	public void setDisbursmentType(String disbursmentType) {
		this.disbursmentType = disbursmentType;
	}
	
	public String getDisbursmentAccount() {
		return disbursmentAccount;
	}
	
	public void setDisbursmentAccount(String disbursmentAccount) {
		this.disbursmentAccount = disbursmentAccount;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}
	
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	public String getLinkedTcId() {
		return linkedTcId;
	}
	
	public void setLinkedTcId(String linkedTcId) {
		this.linkedTcId = linkedTcId;
	}

	@Override
	public String toString() {
		return "ABEDisburseCorporateLoanCorporateLoansData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", accountId=" + accountId + ", valueDate="
				+ valueDate + ", disbursmentType=" + disbursmentType + ", disbursmentAccount=" + disbursmentAccount
				+ ", expectedResult=" + expectedResult + ", linkedTcId=" + linkedTcId + "]";
	}
}
	