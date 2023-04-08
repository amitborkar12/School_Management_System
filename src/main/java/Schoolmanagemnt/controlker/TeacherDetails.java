package Schoolmanagemnt.controlker;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Schoolmanagement.dto.Management;
import Schoolmanagement.dto.Teachers;

@WebServlet("/teacherdetail")
public class TeacherDetails extends HttpServlet
{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String id = req.getParameter("id");
	  String name = req.getParameter("name");
	  String subject = req.getParameter("subject");
	  String age = req.getParameter("age");
	  String email = req.getParameter("email");
	  String password = req.getParameter("password");
	  
	  Teachers t = new Teachers();
	  t.setTid(Integer.parseInt(id));
	  t.setTname(name);
	  t.setSubject(subject);
	  t.setAge(Integer.parseInt(age));
	  t.setTemail(email);
	  t.setTpwd(password);
	  
	  List<Teachers>teachers = new ArrayList<Teachers>();
	  teachers.add(t);
	  
	    
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("amit");
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction et = em.getTransaction();
	  
	  et.begin();
	  em.persist(t);
	  et.commit();
	  
	  RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	  rd.forward(req, resp);
			  
}
  public static void main(String[] args) {
	new Teachers();
}
}
