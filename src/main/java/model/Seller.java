package model;

public class Seller {
	private int ID;
	private String yourname,email,Passwords;
	private long phone;
	
	public int getID() {
	return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getyourname() {
		return yourname;
	}
	public void setName(String yourname) {
		this.yourname = yourname;
	}
	public String getPasswords() {
		return Passwords;
	}
	public void setPasswords(String Passwords) {
		this.Passwords = Passwords;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public long getphone() {
		return phone;
	}
	
	public void setphone(long phone) {
		this.phone = phone;
	}
	



	@Override
	public String toString() {
		return "Seller [ID=" + ID + ", yourname=" + yourname + ", email=" + email + ", phone=" + phone + ", Passwords="
				+ Passwords + "]";
	}

	

}
