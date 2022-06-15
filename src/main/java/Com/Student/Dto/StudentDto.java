package Com.Student.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="student")
@Component
public class StudentDto {
	@Id
	@Column(name="id")	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	
	
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="mobileno")
	private String mobileno;
	@Column(name="city")
	private String city;
	@Column(name="pincode")
	private String pincode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileno=" + mobileno + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
}
