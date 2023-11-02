package data;

public class ABEVerifyLodgeExportBillsTradeFinanceData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String billId;
	private String expectedResult;
	private String acceptLinkedTcid;
	private String verifyAcceptLinkedTcid;
	private String purchaseLinkedTcid;
	private String verifyPurchaseLinkedTcid;
	private String realizeLinkedTcid;
	private String verifyRealizeLinkedTcid;

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
	
	public String getBillId() {
		return billId;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}
	
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	public String getAcceptLinkedTcid() {
		return acceptLinkedTcid;
	}

	public void setAcceptLinkedTcid(String acceptLinkedTcid) {
		this.acceptLinkedTcid = acceptLinkedTcid;
	}
	
	public String getVerifyAcceptLinkedTcid() {
		return verifyAcceptLinkedTcid;
	}

	public void setVerifyAcceptLinkedTcid(String verifyAcceptLinkedTcid) {
		this.verifyAcceptLinkedTcid = verifyAcceptLinkedTcid;
	}

	public String getPurchaseLinkedTcid() {
		return purchaseLinkedTcid;
	}

	public void setPurchaseLinkedTcid(String purchaseLinkedTcid) {
		this.purchaseLinkedTcid = purchaseLinkedTcid;
	}
	
	public String getVerifyPurchaseLinkedTcid() {
		return verifyPurchaseLinkedTcid;
	}

	public void setVerifyPurchaseLinkedTcid(String verifyPurchaseLinkedTcid) {
		this.verifyPurchaseLinkedTcid = verifyPurchaseLinkedTcid;
	}

	public String getRealizeLinkedTcid() {
		return realizeLinkedTcid;
	}

	public void setRealizeLinkedTcid(String realizeLinkedTcid) {
		this.realizeLinkedTcid = realizeLinkedTcid;
	}
	
	public String getVerifyRealizeLinkedTcid() {
		return verifyRealizeLinkedTcid;
	}

	public void setVerifyRealizeLinkedTcid(String verifyRealizeLinkedTcid) {
		this.verifyRealizeLinkedTcid = verifyRealizeLinkedTcid;
	}

	@Override
	public String toString() {
		return "ABEVerifyLodgeExportBillsTradeFinanceData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", billId=" + billId + ", expectedResult="
				+ expectedResult + ", acceptLinkedTcid=" + acceptLinkedTcid + ", verifyAcceptLinkedTcid="
				+ verifyAcceptLinkedTcid + ", purchaseLinkedTcid=" + purchaseLinkedTcid + ", verifyPurchaseLinkedTcid="
				+ verifyPurchaseLinkedTcid + ", realizeLinkedTcid=" + realizeLinkedTcid + ", verifyRealizeLinkedTcid="
				+ verifyRealizeLinkedTcid + "]";
	}
}