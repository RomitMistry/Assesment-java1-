package model;

public class customermodel {
          private String yourname,Passwords;
          private String email;
          private long phone;
          private int ID;
		public String getYourname() {
			return yourname;
		}
		public void setYourname(String yourname) {
			this.yourname = yourname;
		}
		public String getPasswords() {
			return Passwords;
		}
		public void setPasswords(String passwords) {
			Passwords = passwords;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		@Override
		public String toString() {
			return "customermodel [yourname=" + yourname + ", Passwords=" + Passwords + ", email=" + email + ", phone="
					+ phone + ", ID=" + ID + "]";
		}
         
          
	
	

		
	
		
		
          
          
          

}
