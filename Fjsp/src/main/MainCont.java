package main;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/main")
public class MainCont extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/main/main.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}
