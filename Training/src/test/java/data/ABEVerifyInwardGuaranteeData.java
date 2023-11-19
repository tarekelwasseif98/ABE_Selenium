package data;

public class ABEVerifyInwardGuaranteeData {

	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;	

	private String guaranteeNumberReferenceId;
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

	

	public String getGuaranteeNumberReferenceId() {
		return guaranteeNumberReferenceId;
	}

	public void setGuaranteeNumberReferenceId(String guaranteeNumberReferenceId) {
		this.guaranteeNumberReferenceId = guaranteeNumberReferenceId;
	}

	@Override
	public String toString() {
		return "ABEVerifyInwardGuaranteeData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", guaranteeNumberReferenceId="
				+ guaranteeNumberReferenceId + ", expectedResult=" + expectedResult + "]";
	}

	
	
	
	
}
