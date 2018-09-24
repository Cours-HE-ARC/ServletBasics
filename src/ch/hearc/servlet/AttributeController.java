package ch.hearc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hearc.servlet.model.Personne;

@WebServlet(
		name="attributeServlet",
		urlPatterns = "/attribute"
)
public class AttributeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Personne p = (Personne)req.getAttribute("personne");
		PrintWriter out = resp.getWriter();
		
		out.append("<p>Personne : " + p.toString() + "</p>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
