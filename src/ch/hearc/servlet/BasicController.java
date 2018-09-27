package ch.hearc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="basicServlet",
		urlPatterns = "/info/*"
)
public class BasicController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String pathInfo = req.getPathInfo();
		
		PrintWriter out = resp.getWriter();
		
		out.append("<p>ContextPath: " + contextPath + "</p>");
		out.append("<p>ServletPath: " + servletPath + "</p>");
		out.append("<p>PathInfo: " + pathInfo + "</p>");
		
		setContextDateValue();
		
		out.append("<p>Contexte date value: " + getServletContext().getAttribute("date"));
	}

	private void setContextDateValue() {
		Date date = (Date) getServletContext().getAttribute("date");
		getServletContext().setAttribute("date", new Date());
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
