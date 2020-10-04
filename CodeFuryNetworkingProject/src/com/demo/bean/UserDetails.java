package com.demo.bean;

import java.awt.image.BufferedImage;
import java.util.Date;


	
	public class UserDetails {

		
		private String uEmail;
		private String uFullName;   //User full name
		private String uName;       //User handle
		private String uPass;
		private String uMob;
		private String uGender;
		private Date ubDate;
		private String uAddress;
		private String uCity;
		private String uState;
		public UserDetails(String uEmail, String uFullName, String uMob, String uCity) {
			super();
			this.uEmail = uEmail;
			this.uFullName = uFullName;
			this.uMob = uMob;
			this.uCity = uCity;
		}
		private String uCountry;
		private String uCompany;
		private BufferedImage uImage;
		private int uId;
		private String supportQn;
		private String supportAns;

		//Default Constructor
	
		public UserDetails() {
			super();
		}
		
		//Parameterized constructor
		
		public UserDetails(String uemail, String ufullName, String uname, String upass, String umob, String ugender, Date ubdate,
				String uaddress, String ucity, String ustate, String ucountry, String ucompany, BufferedImage uimage,
				int uid, String supportQn, String supportAns) {
			super();
			
			this.uEmail = uemail;
			this.uFullName = ufullName;
			this.uName = uname;
			this.uPass = upass;
			this.uMob = umob;
			this.uGender = ugender;
			this.ubDate = ubdate;
			this.uAddress = uaddress;
			this.uCity = ucity;
			this.uState = ustate;
			this.uCountry = ucountry;
			this.uCompany = ucompany;
			this.uImage = uimage;
			this.uId = uid;
			this.supportQn = supportQn;
			this.supportAns = supportAns;
		}

		//Tostring method
		@Override
		public String toString() {
			
			return "User [uemail=" + uEmail + ", ufullName=" + uFullName + ", uname=" + uName + ", upass=" + uPass
					+ ", umob=" + uMob + ", ugender=" + uGender + ", ubdate=" + ubDate + ", uaddress=" + uAddress
					+ ", ucity=" + uCity + ", ustate=" + uState + ", ucountry=" + uCountry + ", ucompany=" + uCompany
					+ ", uimage=" + uImage + ", uid=" + uId + ", supportQn=" + supportQn + ", supportAns=" + supportAns
					+ "]";
		}

		//Getters and setters
		public String getUemail() {
			
			return uEmail;
		}

		public void setUemail(String uemail) {
			
			this.uEmail = uemail;
		}

		public String getUfullName() {
		
			return uFullName;
		}

		public void setUfullName(String ufullName) {
			
			this.uFullName = ufullName;
		}

		public String getUname() {
			
			return uName;
		}

		public void setUname(String uname) {
			
			this.uName = uname;
		}

		public String getUpass() {
			
			return uPass;
		}

		public void setUpass(String upass) {
			
			this.uPass = upass;
		}

		public String getUmob() {
			
			return uMob;
		}

		public void setUmob(String umob) {
			
			this.uMob = umob;
		}

		public String getUgender() {
			
			return uGender;
		}

		public void setUgender(String ugender) {
			
			this.uGender = ugender;
		}

		public Date getUbdate() {
			
			return ubDate;
		}

		public void setUbdate(Date ubdate) {
			
			this.ubDate = ubdate;
		}

		public String getUaddress() {
			
			return uAddress;
		}

		public void setUaddress(String uaddress) {
			
			this.uAddress = uaddress;
		}

		public String getUcity() {
			
			return uCity;
		}

		public void setUcity(String ucity) {
		
			this.uCity = ucity;
		}

		public String getUstate() {
			
			return uState;
		}

		public void setUstate(String ustate) {
			
			this.uState = ustate;
		}

		public String getUcountry() {
			
			return uCountry;
		}

		public void setUcountry(String ucountry) {
			
			this.uCountry = ucountry;
		}

		public String getUcompany() {
			
			return uCompany;
		}

		public void setUcompany(String ucompany) {
			
			this.uCompany = ucompany;
		}

		public BufferedImage getUimage() {
			
			return uImage;
		}

		public void setUimage(BufferedImage uimage) {
			
			this.uImage = uimage;
		}

		public int getUid() {
			
			return uId;
		}

		public void setUid(int uid) {
			
			this.uId = uid;
		}

		public String getSupportQn() {
			return supportQn;
		}
		public void setSupportQn(String supportQn) {
			this.supportQn = supportQn;
		}
		public String getSupportAns() {
			return supportAns;
		}
		public void setSupportAns(String supportAns) {
			this.supportAns = supportAns;
		}
		
		
	}


