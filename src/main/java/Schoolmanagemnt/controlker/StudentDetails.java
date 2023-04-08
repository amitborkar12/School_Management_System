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
import Schoolmanagement.dto.Students;

@WebServlet("/studentdetail")
public class StudentDetails extends HttpServlet
{
  

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   String id = req.getParameter("id");
	   String name = req.getParameter("name");
	   String dob = req.getParameter("dob");
	   String cno = req.getParameter("cno");
	   String email = req.getParameter("email");
	   String password = req.getParameter("password");
	   
	   Students s = new Students();
	   s.setSid(Integer.parseInt(id));
	   s.setSname(name);
	   s.setDob(dob);
	   s.setScno(Integer.parseInt(cno));
	   s.setSemail(email);
	   s.setSpwd(password);
       
	   List<Students>students = new ArrayList<Students>();
	   students.add(s);
	   
	   
	   
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("amit");
	   EntityManager em =  emf.createEntityManager();
	   EntityTransaction et = em.getTransaction();
	   
	   et.begin();
	   em.persist(s);
	   et.commit();
	   
	   RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	   rd.forward(req, resp);
	   
}
  
	
	
}

