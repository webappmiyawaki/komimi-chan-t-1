package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.CreateSample;

@WebServlet("/Reset")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateSample sc = new CreateSample();
		sc.setNum();
		HttpSession session = request.getSession();
		session.setAttribute("input",null);
        session.setAttribute("login", null);
        session.setAttribute("userList", null);
        session.setAttribute("talentList", null);
        session.setAttribute("commentList", null);
		String path = "reset.jsp";
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
	}
}
