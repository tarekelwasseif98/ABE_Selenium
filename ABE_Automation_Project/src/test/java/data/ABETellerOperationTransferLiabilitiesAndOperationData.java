package data;

public class ABETellerOperationTransferLiabilitiesAndOperationData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String accountIdCr;
	private String ccyCr;
	private String accountIdDr;
	private String ccyDr;
	private String transactionAmount;
	private String expectedResult;
	private String reference;
	
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
	
	public String getAccountIdCr() {
		return accountIdCr;
	}
	
	public void setAccountIdCr(String accountIdCr) {
		this.accountIdCr = accountIdCr;
	}
	
	public String getCcyCr() {
		return ccyCr;
	}
	
	public void setCcyCr(String ccyCr) {
		this.ccyCr = ccyCr;
	}
	
	public String getAccountIdDr() {
		return accountIdDr;
	}
	
	public void setAccountIdDr(String accountIdDr) {
		this.accountIdDr = accountIdDr;
	}
	
	public String getCcyDr() {
		return ccyDr;
	}
	
	public void setCcyDr(String ccyDr) {
		this.ccyDr = ccyDr;
	}
	
	public String getTransactionAmount() {
		return transactionAmount;
	}
	
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
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

	@Override
	public String toString() {
		return "ABETellerOperationTransferLiabilitiesAndOperationData [tcId=" + tcId + ", summary=" + summary
				+ ", username=" + username + ", password=" + password + ", menu=" + menu + ", accountIdCr="
				+ accountIdCr + ", ccyCr=" + ccyCr + ", accountIdDr=" + accountIdDr + ", ccyDr=" + ccyDr
				+ ", transactionAmount=" + transactionAmount + ", expectedResult=" + expectedResult + ", reference="
				+ reference + "]";
	}
	
	

	
	

}
