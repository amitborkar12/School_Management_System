package Schoolmanagemnt.controlker;

import java.io.IOException;

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

import Schoolmanagement.dto.Students;

@WebServlet("/removestudent")
public class RemoveStudent extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	  int id = Integer.parseInt(req.getParameter("id"));
	  
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("amit");
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction et = em.getTransaction();
	  
	  Students s = em.find(Students.class, id);
	  
	  et.begin();
	  em.remove(s);
	  et.commit();
	  
	   RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	   rd.forward(req, resp);
}
}
