package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProcessFind;
import dto.LoginDTO;
import dto.TalentDTO;
import dto.UserDTO;
import model.LoginCheck;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		String userId = request.getParameter("userId");
		String userPass= request.getParameter("userPass");

		HttpSession session = request.getSession();
		LoginDTO loginDTO = LoginDTO.builder()
				.id(userId)
				.password(userPass)
				.build();

		List<TalentDTO> talentList = new ArrayList<>();

		UserDTO userDTO = new UserDTO();
		LoginCheck loginCheck = new LoginCheck();
		loginDTO = loginCheck.isLoginDTO(loginDTO);
		ProcessFind pf = new ProcessFind();
		String path="";
		if(loginDTO!=null) {
			switch(loginDTO.getUserType()) {
			case GENERAL:
				path= "/MainProcessSwitch";
				break;
			case TALENT_MANAGER:
				path= "/ManagementForTalent";
				break;
			case OPERATION_MANAGER:
				path= "/ManagementForOperation";
				break;
			}
			userDTO = pf.findPersonMyself(loginDTO);
		}else {
        	path= "login.jsp";
        	loginDTO = LoginDTO.builder().build();
        	talentList=null;
//			response.sendRedirect(path);
		}

		session.setAttribute("login", loginDTO);
		session.setAttribute("userDTO", userDTO);
        session.setAttribute("talentList", talentList);
		request.getRequestDispatcher(path).forward(request, response);


//		if(loginDTO.getUserType()!=null) {
//			path= "/MainProcessSwitch";
//			session.setAttribute("login", loginDTO);
//	        session.setAttribute("talentList", talentList);
//	        request.getRequestDispatcher(path).forward(request, response);
//        }else {
//        	path= "login.jsp";
//        	loginDTO = LoginDTO.builder().build();
//        	session.setAttribute("login", loginDTO);
//	        session.setAttribute("talentList", null);
//			response.sendRedirect(path);
//        }


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
