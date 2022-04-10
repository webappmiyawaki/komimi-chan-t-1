package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDTO;

@WebServlet("/SignupForUserInfo")
public class SignupForUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		UserDTO userDTO = new UserDTO();

		String path = "/WEB-INF/jsp/signupForUserInfo.jsp";
		switch(select) {
		case "成功":
			userDTO = UserDTO.builder().userId("test").userName("test").build();
			break;
		case "失敗":
			userDTO = UserDTO.builder().build();
			break;
			default:
				break;
		}
        session.setAttribute("userDTO", userDTO);
		response.sendRedirect(path);
//        request.getRequestDispatcher(path).forward(request, response);
	}
}
