
public class User {
	String firstName, lastName, gender, DOB, date, month, year, email, password, rePassword;

	public void setFirstName(String param) {
		this.firstName = param;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String param) {
		this.lastName = param;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setGender(String param) {
		this.gender = param;
	}

	public String getGender() {
		return this.gender;
	}

	public void setDate(String param) {
		this.date = param;
	}

	public void setMonth(String param) {
		this.month = param;
	}

	public void setYear(String param) {
		this.year = param;
	}

	private String getDOB() {
		return this.date + "-" + this.month + "-" + this.year;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String param) {
		this.password = param;
	}

	public String getPassword() {
		return this.password;
	}

	public void setConfirmPassword(String param) {
		this.rePassword = param;
	}

	public String getConfirmPassword() {
		return this.rePassword;
	}

	public String toString() {
		return this.firstName + "," + this.lastName + "," + this.gender + "," + this.getDOB() + "," + this.email + ","
				+ this.password;
	}
}
