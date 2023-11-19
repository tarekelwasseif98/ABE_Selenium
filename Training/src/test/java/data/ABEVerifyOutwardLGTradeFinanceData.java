package data;

public class ABEVerifyOutwardLGTradeFinanceData {

private String tcId;
private String summary;
private String username;
private String password;
private String menu;	
private String paymentStatus;
private String guaranteeId;
private String expectedResult;




public String getGuaranteeId() {
	return guaranteeId;
}

public void setGuaranteeId(String guaranteeId) {
	this.guaranteeId = guaranteeId;
}

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



public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

@Override
public String toString() {
	return "ABEVerifyOutwardLGTradeFinanceData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
			+ ", password=" + password + ", menu=" + menu + ", paymentStatus=" + paymentStatus + ", guaranteeId="
			+ guaranteeId + ", expectedResult=" + expectedResult + "]";
}





	
}
