package ch.hearc.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(
		name="basicServlet",
		urlPatterns = "/info/*"
)
public class BasicController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//récupération de l'objet permettant d'écrire dans le flux de sortie
		PrintWriter out = resp.getWriter();
		
		//header content length
		resp.setContentLength(1024);
		
		//header content-type
		resp.setContentType("text/html");
		
		//définition d'un header custom
		resp.setHeader("monCustomHeader", "customHeader");
		
		out.append("<p>Hello World</p>");
		
	}
	
}
