package data;

public class ABEVerifySTOData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String mandate;
	private String expectedResult;


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
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public String getMandate() {
		return mandate;
	}
	public void setMandate(String mandate) {
		this.mandate = mandate;
	}
	@Override
	public String toString() {
		return "ABEVerifySTOData [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", mandate=" + mandate + ", expectedResult=" + expectedResult + "]";
	}
	
}