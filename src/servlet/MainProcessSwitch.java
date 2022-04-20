package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainProcessSwitch")
public class MainProcessSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		HttpSession session = request.getSession();

        String path= "";
        switch(select) {
        	case "main":
        		path="/Main";
        		break;
        	case "personMyself":
        		path="/PersonMyself";
        		break;
        	case "personOthers":
        		path="/PersonOthers";
        		break;
        	case "managementForOperation":
        		path="/ManagementForOperation";
        		break;
        	case "managementForTalent":
        		path="/ManagementForTalent";
        		break;
        	case "signup":
        		path="/Signup";
        		break;
        	case "talentInfo":
        		path="/TalentInfo";
        		break;
        	case "reset":
        		path="/Reset";
        		break;
        	default:
        		path="/Main";
        		break;
        }
        request.getRequestDispatcher(path).forward(request, response);

	}
}
