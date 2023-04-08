package Schoolmanagemnt.controlker;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Schoolmanagement.dto.Management;
import Schoolmanagement.dto.Students;
import Schoolmanagement.dto.Teachers;

@WebServlet("/selectrole")
public class SelectRole extends HttpServlet
{  
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	 
	   
	   EntityManagerFactory  emf = Persistence.createEntityManagerFactory("amit");
	   EntityManager em = emf.createEntityManager();
	  // EntityTransaction et = em.getTransaction();
	   String role = req.getParameter("role");
	   
	   if(role.equals("management"))
	   {
		   
		   String email =req.getParameter("email");
		   String password = req.getParameter("password");
		   
		   
		   Query q =  em.createQuery("select m from Management m where email=?1  and pwd=?2");
		   q.setParameter(1, email);
		   q.setParameter(2, password);
		   
		   List<Management>management = q.getResultList();
		   if(management.size()>0)
		   {
			   RequestDispatcher rd = req.getRequestDispatcher("Fouroption.html");
			   rd.forward(req, resp);
		   }
		   
		   else
		   {
			   PrintWriter pw = resp.getWriter();
				  pw.write("INVALID CREDENTIALS");
				  RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				  rd.include(req, resp);
				  resp.setContentType("text/html");
		   }
	   }
	   else if(role.equals("student"))
	   {
		   
		   String email =req.getParameter("email");
		   String password =req.getParameter("password");
		   
		   Query q =  em.createQuery("select m from Students m where Semail=?1  and Spwd=?2");
		   q.setParameter(1, email);
		   q.setParameter(2, password);
		   
		   List<Students> students  =q.getResultList();
		   if(students.size()>0)
		   {
			   Students s = students.get(0);
			   
			   HttpSession hs= req.getSession();
			   hs.setAttribute("s", s);
			   
			   RequestDispatcher rd = req.getRequestDispatcher("Studentoptions.html");
			   rd.forward(req, resp);
		   }
		   
		   else
		   {
			   PrintWriter pw = resp.getWriter();
				  pw.write("INVALID CREDENTIALS");
				  RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				  rd.include(req, resp);
				  resp.setContentType("text/html");
		   }
	   }
	   else if(role.equals("teacher"))
	   {
		   String email = req.getParameter("email");
		   String password = req.getParameter("password");
		   
		   Query q = em.createQuery("select m from Teachers m where Temail=?1  and Tpwd=?2");
		   q.setParameter(1, email);
		   q.setParameter(2, password);
		   
		   List<Teachers> teachers = q.getResultList();
		   
		   if(teachers.size()>0)
		   {
			  Teachers t =teachers.get(0);
			  
			  HttpSession hs= req.getSession();
			  hs.setAttribute("t", t);
			  
			  RequestDispatcher  rd = req.getRequestDispatcher("Teachertwooption.html");
			  rd.forward(req, resp);
			  
  		   }
		   else
		   {
			   PrintWriter pw = resp.getWriter();
			   pw.write("INVALID CREDENTIALS");
			   RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			   rd.include(req, resp);
			   resp.setContentType("text/html");
		   }
	   }
}
}
