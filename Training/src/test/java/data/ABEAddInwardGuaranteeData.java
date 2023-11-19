package data;

public class ABEAddInwardGuaranteeData {
	
		private String tcId;
		private String summary;
		private String username;
		private String password;
		private String menu;
		private String cif;
		private String currency;
		
		private String guaranteeType;
		private String expiryDate;
		private String claimDate;
		
		private String guaranteeAmount;
		private String name;
		private String address;
		
		private String rulesdropdown;

		private String expectedResult;
		private String guaranteeNumberReference;
		private String linkedTcid1;
		
		
		
		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getTcId() {
			return tcId;
		}

		public void setTcId(String tcId) {
			this.tcId = tcId;
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

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getGuaranteeType() {
			return guaranteeType;
		}

		public void setGuaranteeType(String guaranteeType) {
			this.guaranteeType = guaranteeType;
		}

		public String getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}

		public String getClaimDate() {
			return claimDate;
		}

		public void setClaimDate(String claimDate) {
			this.claimDate = claimDate;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGuaranteeAmount() {
			return guaranteeAmount;
		}

		public void setGuaranteeAmount(String guaranteeAmount) {
			this.guaranteeAmount = guaranteeAmount;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRulesdropdown() {
			return rulesdropdown;
		}

		public void setRulesdropdown(String rulesdropdown) {
			this.rulesdropdown = rulesdropdown;
		}

		public String getExpectedResult() {
			return expectedResult;
		}

		public void setExpectedResult(String expectedResult) {
			this.expectedResult = expectedResult;
		}

	
		public String getLinkedTcid1() {
			return linkedTcid1;
		}

		public void setLinkedTcid1(String linkedTcid1) {
			this.linkedTcid1 = linkedTcid1;
		}

		

		public String getGuaranteeNumberReference() {
			return guaranteeNumberReference;
		}

		public void setGuaranteeNumberReference(String guaranteeNumberReference) {
			this.guaranteeNumberReference = guaranteeNumberReference;
		}

		@Override
		public String toString() {
			return "ABEAddInwardGuaranteeData [tcId=" + tcId + ", summary=" + summary + ", username=" + username
					+ ", password=" + password + ", menu=" + menu + ", cif=" + cif + ", currency=" + currency
					+ ", guaranteeType=" + guaranteeType + ", expiryDate=" + expiryDate + ", claimDate=" + claimDate
					+ ", guaranteeAmount=" + guaranteeAmount + ", name=" + name + ", address=" + address
					+ ", rulesdropdown=" + rulesdropdown + ", expectedResult=" + expectedResult
					+ ", guaranteeNumberReference=" + guaranteeNumberReference + ", linkedTcid1=" + linkedTcid1 + "]";
		}
		
		
		
		
		
		
}
