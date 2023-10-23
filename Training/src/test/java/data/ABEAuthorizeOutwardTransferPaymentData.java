package data;

public class ABEAuthorizeOutwardTransferPaymentData {

	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String Pos;
	private String expectedResult;
	private String paysysID;
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
	public String getPos() {
		return Pos;
	}
	public void setPos(String pos) {
		Pos = pos;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public String getPaysysID() {
		return paysysID;
	}
	public void setPaysysID(String paysysID) {
		this.paysysID = paysysID;
	}
	@Override
	public String toString() {
		return "AuthorizeACHOutwardData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", Pos=" + Pos + ", expectedResult=" + expectedResult
				+ ", paysysID=" + paysysID + "]";
	}
	
}

