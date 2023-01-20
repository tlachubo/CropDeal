package com.cropdeal.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Admin")
	public class Admin {
		@Id
		private String adminId;
		private String adminName;
		private String adminEmail;
		private String adminContactNo;

		
		public Admin() {
			
		}


		public Admin(String adminId, String adminName, String adminEmail, String adminContactNo) {
			super();
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminEmail = adminEmail;
			this.adminContactNo = adminContactNo;
		}


		public String getAdminId() {
			return adminId;
		}


		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}


		public String getAdminName() {
			return adminName;
		}


		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}


		public String getAdminEmail() {
			return adminEmail;
		}


		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}


		public String getAdminContactNo() {
			return adminContactNo;
		}


		public void setAdminContactNo(String adminContactNo) {
			this.adminContactNo = adminContactNo;
		}


}
