package Schoolmanagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Students
{
	@Id
  private int Sid;
  private String Sname;
  private String dob;
  private int Scno;
  private String Semail;
  private String Spwd;
  @ManyToOne
  private Management management; 
  
  @ManyToMany
  private List<Teachers>teachers;
  
  
public List<Teachers> getStudents() {
	return teachers;
}
public void setStudents(List<Teachers> teachers) {
	this.teachers = teachers;
}
public int getSid() {
	return Sid;
}
public Management getManagement() {
	return management;
}
public void setManagement(Management management) {
	this.management = management;
}
public void setSid(int sid) {
	Sid = sid;
}
public String getSname() {
	return Sname;
}
public void setSname(String sname) {
	Sname = sname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public int getScno() {
	return Scno;
}
public void setScno(int scno) {
	Scno = scno;
}
public String getSemail() {
	return Semail;
}
public void setSemail(String semail) {
	Semail = semail;
}
public String getSpwd() {
	return Spwd;
}
public void setSpwd(String spwd) {
	Spwd = spwd;
}
  
}