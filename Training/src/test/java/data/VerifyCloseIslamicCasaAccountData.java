package data;

public class VerifyCloseIslamicCasaAccountData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String accountId;
	private String expectedResult;
	
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Override
	public String toString() {
		return "VerifyCloseIslamicCasaAccountData Testcase ID: " + tcId + ", Summary: " + summary + ", Username: " + username
				+ ", Password: " + password + ", Menu: " + menu + ", Account ID: " + accountId + ", Expected Result: "
				+ expectedResult;
	}
}