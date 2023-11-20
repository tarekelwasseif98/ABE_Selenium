package data;

public class ABECloseMudarabahTUAData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String accountId;
	private String closureValueDate;
	private String repaymentAccountId;
	private String expectedResult;
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
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getClosureValueDate() {
		return closureValueDate;
	}

	public void setClosureValueDate(String closureValueDate) {
		this.closureValueDate = closureValueDate;
	}
	
	public String getRepaymentAccountId() {
		return repaymentAccountId;
	}

	public void setRepaymentAccountId(String repaymentAccountId) {
		this.repaymentAccountId = repaymentAccountId;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}
	
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	public String getLinkedTcid() {
		return linkedTcid;
	}
	
	public void setLinkedTcid(String linkedTcid) {
		this.linkedTcid = linkedTcid;
	}

	@Override
	public String toString() {
		return "ABECloseMudarabahTUAData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", accountId=" + accountId + ", closureValueDate="
				+ closureValueDate + ", repaymentAccountId=" + repaymentAccountId + ", expectedResult=" + expectedResult
				+ ", linkedTcid=" + linkedTcid + "]";
	}
}