package data;

public class ABEPurchaseExportBillsTradeFinanceData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String billId;
	private String mixedBillId1;
	private String mixedBillId2;
	private String limitIdPrefix;
	private String limitIdSuffix;
	private String billPurchaseAccountId;
	private String billPurchaseAmount;
	private String valueDate;
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
	
	public String getBillId() {
		return billId;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public String getMixedBillId1() {
		return mixedBillId1;
	}
	
	public void setMixedBillId1(String mixedBillId1) {
		this.mixedBillId1 = mixedBillId1;
	}
	
	public String getMixedBillId2() {
		return mixedBillId2;
	}
	
	public void setMixedBillId2(String mixedBillId2) {
		this.mixedBillId2 = mixedBillId2;
	}
	
	public String getLimitIdPrefix() {
		return limitIdPrefix;
	}
	
	public void setLimitIdPrefix(String limitIdPrefix) {
		this.limitIdPrefix = limitIdPrefix;
	}
	
	public String getLimitIdSuffix() {
		return limitIdSuffix;
	}
	
	public void setLimitIdSuffix(String limitIdSuffix) {
		this.limitIdSuffix = limitIdSuffix;
	}
	
	public String getBillPurchaseAccountId() {
		return billPurchaseAccountId;
	}
	
	public void setBillPurchaseAccountId(String billPurchaseAccountId) {
		this.billPurchaseAccountId = billPurchaseAccountId;
	}
	
	public String getBillPurchaseAmount() {
		return billPurchaseAmount;
	}
	
	public void setBillPurchaseAmount(String billPurchaseAmount) {
		this.billPurchaseAmount = billPurchaseAmount;
	}
	
	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
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
		return "ABEPurchaseExportBillsTradeFinanceData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", billId=" + billId + ", mixedBillId1="
				+ mixedBillId1 + ", mixedBillId2=" + mixedBillId2 + ", limitIdPrefix=" + limitIdPrefix
				+ ", limitIdSuffix=" + limitIdSuffix + ", billPurchaseAccountId=" + billPurchaseAccountId
				+ ", billPurchaseAmount=" + billPurchaseAmount + ", valueDate=" + valueDate + ", expectedResult="
				+ expectedResult + ", linkedTcid=" + linkedTcid + "]";
	}
}