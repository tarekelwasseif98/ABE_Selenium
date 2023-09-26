package data;

public class OpenIslamicSavingsAccountData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String cif;
	private String expectedResult;
	private String reference;
	private String linkedTcid;
	
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
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

	public String getLinkedTCID() {
		return linkedTcid;
	}

	public void setLinkedTCID(String linkedTCID) {
		this.linkedTcid = linkedTCID;
	}

	@Override
	public String toString() {
		return "OpenIslamicSavingsAccountData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", cif=" + cif + ", expectedResult=" + expectedResult
				+ ", reference=" + reference + ", linkedTcid=" + linkedTcid + "]";
	}
}