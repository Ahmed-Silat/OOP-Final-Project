import java.io.Serializable;

public class Patients implements Serializable {
	String patientID, userName, fatherName, gender, DOB, doctorName, disease, email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPatientId(String patientId) {
		this.patientID = patientId;
	}

	public String getPatientId() {
		return this.patientID;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return this.gender;
	}

	public void setDOB(String dob) {
		this.DOB = dob;
	}

	public String getDOB() {
		return this.DOB;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String toString() {
		return this.email + "," + this.patientID + "," + this.userName + "," + this.fatherName + "," + this.gender + ","
				+ this.DOB + "," + this.doctorName + "," + this.disease;
	}

	public Patients(String patientId, String username, String fatherName, String gender, String DOB,
			String doctorName) {
		super();
		this.patientID = patientId;
		this.userName = username;
		this.fatherName = fatherName;
		this.gender = gender;
		this.DOB = DOB;
		this.doctorName = doctorName;
	}

	public Patients() {

	}
}
