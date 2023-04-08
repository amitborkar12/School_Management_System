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
import Schoolmanagement.dto.Teachers;

@WebServlet("/savemanagementdata")
public class SaveManagement extends HttpServlet
{
	   
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   String id = req.getParameter("id");
   String email = req.getParameter("email");
   String password = req.getParameter("password");
   
   Management m = new Management();
   m.setId(Integer.parseInt(id));
   m.setEmail(email);
   m.setPwd(password);
   
   Teachers t = new Teachers();
	  
   List<Teachers> teachers = new ArrayList<Teachers>();
   

   Students s = new Students();
   
   List<Students> students = new ArrayList<Students>();
   m.setStudents(students);
   m.setTeachers(teachers);
   s.setManagement(m);
   t.setManagement(m);
   EntityManagerFactory  emf = Persistence.createEntityManagerFactory("amit");
   EntityManager em = emf.createEntityManager();
   EntityTransaction et = em.getTransaction();
   
   
   et.begin();
   em.persist(m);
   et.commit();
   
   RequestDispatcher rd=req.getRequestDispatcher("Login.html");
   rd.forward(req, resp);
   
}
  public static void main(String[] args) {
	 new Students();
	 new Teachers();
}
}
