package data;

public class ABEDisburseMurabahaAccountMurabahaFinancingData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String murabahaAccountId;
	private String valueDate;
	private String creditAccountId;
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
	
	public String getMurabahaAccountId() {
		return murabahaAccountId;
	}
	
	public void setMurabahaAccountId(String murabahaAccountId) {
		this.murabahaAccountId = murabahaAccountId;
	}
	
	public String getValueDate() {
		return valueDate;
	}
	
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	
	public String getCreditAccountId() {
		return creditAccountId;
	}
	
	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
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
		return "ABEDisburseMurabahaAccountMurabahaFinancingData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", murabahaAccountId=" + murabahaAccountId
				+ ", valueDate=" + valueDate + ", creditAccountId=" + creditAccountId + ", expectedResult="
				+ expectedResult + ", linkedTcid=" + linkedTcid + "]";
	}
}