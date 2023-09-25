package data;

public class CreateAchOutwardData {

	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String PaysysID;
	private String date;
	private String amount;
	private String line1;
	private String CCY;
	private String bic_ben;
	private String network_ben;
	private String branch_ben;
	private String bank_ben;
	private String name_ben;
	private String account_ben;
	private String account;
	private String expectedResult;
	private String pos;
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
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getBic_ben() {
		return bic_ben;
	}
	public void setBic_ben(String bic_ben) {
		this.bic_ben = bic_ben;
	}
	public String getCCY() {
		return CCY;
	}
	public void setCCY(String cCY) {
		CCY = cCY;
	}
	public String getNetwork_ben() {
		return network_ben;
	}
	public void setNetwork_ben(String network_ben) {
		this.network_ben = network_ben;
	}
	public String getBank_ben() {
		return bank_ben;
	}
	public void setBank_ben(String bank_ben) {
		this.bank_ben = bank_ben;
	}
	public String getBranch_ben() {
		return branch_ben;
	}
	public void setBranch_ben(String branch_ben) {
		this.branch_ben = branch_ben;
	}
	public String getName_ben() {
		return name_ben;
	}
	public void setName_ben(String name_ben) {
		this.name_ben = name_ben;
	}
	public String getAccount_ben() {
		return account_ben;
	}
	public void setAccount_ben(String account_ben) {
		this.account_ben = account_ben;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "CreateAchOutwardData [tcId=" + tcId + ", summary=" + summary + ", username=" + username + ", password="
				+ password + ", menu=" + menu + ", paysys_ID=" + PaysysID + ", date=" + date + ", amount=" + amount
				+ ", line1=" + line1 + ", CCY=" + CCY + ", bic_ben=" + bic_ben + ", network_ben=" + network_ben
				+ ", branch_ben=" + branch_ben + ", bank_ben=" + bank_ben + ", name_ben=" + name_ben + ", account_ben="
				+ account_ben + ", account=" + account + ", expectedResult=" + expectedResult + ", pos=" + pos
				+ ", linkedTcid=" + linkedTcid + "]";
	}
	
	
}
