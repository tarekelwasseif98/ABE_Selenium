package data;

public class CreateAchOutwardData {

	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String PaysysID;
	private String Date;
	private String Amount;
	private String Line1_RI;
	private String CCY;
	private String BIC_BEN;
	private String Network_BEN;
	private String Branch_BEN;
	private String Bank_BEN;
	private String Name_BEN;
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
	@Override
	public String toString() {
		return "CreateAchOutwardData [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", paysys_ID=" + PaysysID + ", date=" + Date + ", amount=" + Amount
				+ ", line1=" + Line1_RI + ", CCY=" + CCY + ", bic_ben=" + BIC_BEN + ", network_ben=" + Network_BEN
				+ ", branch_ben=" + Branch_BEN + ", bank_ben=" + Bank_BEN + ", name_ben=" + Name_BEN + ", account_ben="
				+ Account_BEN + ", account=" + Account + ", expectedResult=" + expectedResult + ", pos=" + Pos
				+ ", linkedTcid=" + linkedTcid + "]";
	}
	
	
}
