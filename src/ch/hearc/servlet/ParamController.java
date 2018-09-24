package ch.hearc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="paramServlet",
		urlPatterns = "/param"
)
public class ParamController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String params = req.getParameter("test");
		PrintWriter out = resp.getWriter();
		
		out.append("<p>paramètre [test]: " + params + "</p>");
		
		showParamaters(out, req);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	private void showParamaters(PrintWriter out, HttpServletRequest req) {
		
		Enumeration<String> parameterNames = req.getParameterNames();
		
		 while (parameterNames.hasMoreElements()) {
			 String paramName = parameterNames.nextElement();
			 String paramLine = "<p>Paramètre: "  + paramName;
			
			 String[] paramValues = req.getParameterValues(paramName);
			 
			 for (int i = 0; i < paramValues.length; i++) {
				 String paramValue = paramValues[i];
				 paramLine += ", valeur: " + paramValue + "</p>";
				 out.print(paramLine);
			 }
		 }

	}
}
