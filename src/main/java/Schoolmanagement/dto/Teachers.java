package Schoolmanagement.dto;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Teachers 
{
	@Id
   private int Tid;
   private String Tname;
   private String subject;
   private int age;
   private String Temail;
   private String Tpwd;
   @ManyToOne
   private Management management;
   @ManyToMany
   private List<Students>students;

public List<Students> getStudents() {
	return students;
}
public void setStudents(List<Students> students) {
	this.students = students;
}
public int getTid() {
	return Tid;
}
public void setTid(int tid) {
	Tid = tid;
}
public String getTname() {
	return Tname;
}
public void setTname(String tname) {
	Tname = tname;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getTemail() {
	return Temail;
}
public void setTemail(String temail) {
	Temail = temail;
}
public String getTpwd() {
	return Tpwd;
}
public void setTpwd(String tpwd) {
	Tpwd = tpwd;
}
public Management getManagement() {
	return management;
}
public void setManagement(Management management) {
	this.management = management;
}
}
