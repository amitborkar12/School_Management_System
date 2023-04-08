package Schoolmanagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Management 
{
	@Id
  private int id;
  private String email;
  private String pwd;
  
  @OneToMany
  private List<Students> students;
  
  @OneToMany
  private List<Teachers> teachers;
  
public List<Students> getStudents() {
	return students;
}
public void setStudents(List<Students> students) {
	this.students = students;
}
public List<Teachers> getTeachers() {
	return teachers;
}
public void setTeachers(List<Teachers> teachers) {
	this.teachers = teachers;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
  
}
