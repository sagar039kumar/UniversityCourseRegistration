package spring.CourseApplication.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courseregistration")
public class Master implements Serializable{

	private static final long serialVersionUID = 453693552059515150L;
	private Long rollno;
	private String universityName;
	private String course  ;
	private String student;
	/*@Transient(TemporalType.DATE)
	@Column (name="createdOn")
	private Date createdOn;*/

	
/*public Date getCreatedOn() {
		//return new Date();
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	*/
	@Id
	@GeneratedValue
	@Column(name="rollno")
	public Long getrollno() {
		return rollno;
	}
	public void setrollno(Long rollno) {
		this.rollno = rollno;
	}
	@Column(name="University")
	public String getuniversityName() {
		return universityName;
	}
	public void setuniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Column(name="course")
	public String getcourse() {
		return course;
	}
	public void setcourse(String course) {
		this.course = course;
	}
	@Column(name="student")
	public String getstudent() {
		return student;
	}
	public void setstudent(String student) {
		this.student = student;
	}

	 
	
}
