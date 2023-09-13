package data;

public class VerifyIslamicSavingsAccountData {
	
	private String tcID;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String accountid;
	private String expectedResult;
	private String linkedTCID;
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
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
	
	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getTCID() {
		return tcID;
	}

	public void setTCID(String tCID) {
		tcID = tCID;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getLinkedTCID() {
		return linkedTCID;
	}

	public void setLinkedTCID(String linkedTCID) {
		this.linkedTCID = linkedTCID;
	}
}