package com.demo.bean;

	import java.awt.image.BufferedImage;
	import java.util.Date;

	public class User {
		
		private String uemail;
		private String ufullName;   //User full name
		private String uname;       //User handle
		private String upass;
		private String umob;
		private String ugender;
		private Date ubdate;
		private String uaddress;
		private String ucity;
		private String ustate;
		private String ucountry;
		private String ucompany;
		private BufferedImage uimage;
		private int uid;
		private String supportQn;
		private String supportAns;
		
		//Default Constructor
		public User() {
			super();
		}

		//Parameterized constructor
		public User(String uemail, String ufullName, String uname, String upass, String umob, String ugender, Date ubdate,
				String uaddress, String ucity, String ustate, String ucountry, String ucompany, BufferedImage uimage,
				int uid, String supportQn, String supportAns) {
			super();
			this.uemail = uemail;
			this.ufullName = ufullName;
			this.uname = uname;
			this.upass = upass;
			this.umob = umob;
			this.ugender = ugender;
			this.ubdate = ubdate;
			this.uaddress = uaddress;
			this.ucity = ucity;
			this.ustate = ustate;
			this.ucountry = ucountry;
			this.ucompany = ucompany;
			this.uimage = uimage;
			this.uid = uid;
			this.supportQn = supportQn;
			this.supportAns = supportAns;
		}
		
		//Parameterized Constructor for add to block user list in data-access layer
		public User(int uid, String uemail) {
			super();
			this.uemail = uemail;
			this.uid = uid;
		}
		
		//Tostring method
		@Override
		public String toString() {
			return "User [uemail=" + uemail + ", ufullName=" + ufullName + ", uname=" + uname + ", upass=" + upass
					+ ", umob=" + umob + ", ugender=" + ugender + ", ubdate=" + ubdate + ", uaddress=" + uaddress
					+ ", ucity=" + ucity + ", ustate=" + ustate + ", ucountry=" + ucountry + ", ucompany=" + ucompany
					+ ", uimage=" + uimage + ", uid=" + uid + ", supportQn=" + supportQn + ", supportAns=" + supportAns
					+ "]";
		}

		//Getters and setters
		public String getUemail() {
			return uemail;
		}

		public void setUemail(String uemail) {
			this.uemail = uemail;
		}

		public String getUfullName() {
			return ufullName;
		}

		public void setUfullName(String ufullName) {
			this.ufullName = ufullName;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getUpass() {
			return upass;
		}

		public void setUpass(String upass) {
			this.upass = upass;
		}

		public String getUmob() {
			return umob;
		}

		public void setUmob(String umob) {
			this.umob = umob;
		}

		public String getUgender() {
			return ugender;
		}

		public void setUgender(String ugender) {
			this.ugender = ugender;
		}

		public Date getUbdate() {
			return ubdate;
		}

		public void setUbdate(Date ubdate) {
			this.ubdate = ubdate;
		}

		public String getUaddress() {
			return uaddress;
		}

		public void setUaddress(String uaddress) {
			this.uaddress = uaddress;
		}

		public String getUcity() {
			return ucity;
		}

		public void setUcity(String ucity) {
			this.ucity = ucity;
		}

		public String getUstate() {
			return ustate;
		}

		public void setUstate(String ustate) {
			this.ustate = ustate;
		}

		public String getUcountry() {
			return ucountry;
		}

		public void setUcountry(String ucountry) {
			this.ucountry = ucountry;
		}

		public String getUcompany() {
			return ucompany;
		}

		public void setUcompany(String ucompany) {
			this.ucompany = ucompany;
		}

		public BufferedImage getUimage() {
			return uimage;
		}

		public void setUimage(BufferedImage uimage) {
			this.uimage = uimage;
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
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