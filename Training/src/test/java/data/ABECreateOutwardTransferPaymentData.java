package data;

public class ABECreateOutwardTransferPaymentData {

	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String Charge_type;
	private String waiveChargeRemark;
	private String menu;
	private String PaysysID;
	private String Date;
	private String Amount;
	private String Line1_RI;
	private String CCY;
	private String BIC_BEN;
	private String Network_BEN;
	private String Branch_BEN;
	private String chargeWaiveOption;
	private String Bank_BEN;
	private String serviceTypeID;
	private String countryCode_REM;
	private String Name_BEN;
	private String Name_REM;
	private String Address1_REM;
	private String Address2_REM;
	private String Address1_BEN;
	private String Address2_BEN;
	private String Purpose_Code;
	private String Account_BEN;
	private String Account;
	private String expectedResult;
	private String Pos;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPaysysID() {
		return PaysysID;
	}
	public void setPaysys_ID(String PaysysID) {
		this.PaysysID = PaysysID;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getLine1() {
		return Line1_RI;
	}
	public void setLine1(String Line1_RI) {
		this.Line1_RI = Line1_RI;
	}
	public String getBic_ben() {
		return BIC_BEN;
	}
	public void setBic_ben(String bic_ben) {
		this.BIC_BEN = bic_ben;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getNetwork_ben() {
		return Network_BEN;
	}
	public void setNetwork_ben(String network_ben) {
		this.Network_BEN = network_ben;
	}
	public String getBank_ben() {
		return Bank_BEN;
	}
	public void setBank_ben(String bank_ben) {
		this.Bank_BEN = bank_ben;
	}
	public String getBranch_ben() {
		return Branch_BEN;
	}
	public void setBranch_ben(String branch_ben) {
		this.Branch_BEN = branch_ben;
	}
	public String getName_ben() {
		return Name_BEN;
	}
	public void setName_ben(String name_ben) {
		this.Name_BEN = name_ben;
	}
	public String getAccount_ben() {
		return Account_BEN;
	}
	public void setAccount_ben(String account_ben) {
		this.Account_BEN = account_ben;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		this.Account = account;
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
	public String getPos() {
		return Pos;
	}
	public void setPos(String pos) {
		this.Pos = pos;
	}
	
	public String getName_REM() {
		return Name_REM;
	}
	public void setName_REM(String name_REM) {
		Name_REM = name_REM;
	}
	public String getAddress1_REM() {
		return Address1_REM;
	}
	public void setAddress1_REM(String address1_REM) {
		Address1_REM = address1_REM;
	}
	public String getAddress2_REM() {
		return Address2_REM;
	}
	public void setAddress2_REM(String address2_REM) {
		Address2_REM = address2_REM;
	}
	public String getAddress1_BEN() {
		return Address1_BEN;
	}
	public void setAddress1_BEN(String address1_BEN) {
		Address1_BEN = address1_BEN;
	}
	public String getAddress2_BEN() {
		return Address2_BEN;
	}
	public void setAddress2_BEN(String address2_BEN) {
		Address2_BEN = address2_BEN;
	}
	public String getPurpose_Code() {
		return Purpose_Code;
	}
	public void setPurpose_Code(String purpose_Code) {
		Purpose_Code = purpose_Code;
	}
	
	public String getCharge_type() {
		return Charge_type;
	}
	public void setCharge_type(String charge_type) {
		Charge_type = charge_type;
	}
	public String getChargeWaiveOption() {
		return chargeWaiveOption;
	}
	public void setChargeWaiveOption(String chargeWaiveOption) {
		this.chargeWaiveOption = chargeWaiveOption;
	}
	public String getWaiveChargeRemark() {
		return waiveChargeRemark;
	}
	public void setWaiveChargeRemark(String waiveChargeRemark) {
		this.waiveChargeRemark = waiveChargeRemark;
	}
	public String getServiceTypeID() {
		return serviceTypeID;
	}
	public void setServiceTypeID(String serviceTypeID) {
		this.serviceTypeID = serviceTypeID;
	}
	public String getCountryCode_REM() {
		return countryCode_REM;
	}
	public void setCountryCode_REM(String countryCode_REM) {
		this.countryCode_REM = countryCode_REM;
	}
	@Override
	public String toString() {
		return "ABECreateOutwardTransferPaymentData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", Charge_type=" + Charge_type + ", waiveChargeRemark=" + waiveChargeRemark
				+ ", menu=" + menu + ", PaysysID=" + PaysysID + ", Date=" + Date + ", Amount=" + Amount + ", Line1_RI="
				+ Line1_RI + ", CCY=" + CCY + ", BIC_BEN=" + BIC_BEN + ", Network_BEN=" + Network_BEN + ", Branch_BEN="
				+ Branch_BEN + ", chargeWaiveOption=" + chargeWaiveOption + ", Bank_BEN=" + Bank_BEN
				+ ", serviceTypeID=" + serviceTypeID + ", countryCode_REM=" + countryCode_REM + ", Name_BEN=" + Name_BEN
				+ ", Name_REM=" + Name_REM + ", Address1_REM=" + Address1_REM + ", Address2_REM=" + Address2_REM
				+ ", Address1_BEN=" + Address1_BEN + ", Address2_BEN=" + Address2_BEN + ", Purpose_Code=" + Purpose_Code
				+ ", Account_BEN=" + Account_BEN + ", Account=" + Account + ", expectedResult=" + expectedResult
				+ ", Pos=" + Pos + ", linkedTcid=" + linkedTcid + "]";
	}
}
