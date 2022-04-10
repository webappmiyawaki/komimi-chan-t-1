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

import dto.CommentDTO;
import dto.LoginDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;


@WebServlet("/PersonMyselfProcessSwitch")
public class PersonMyselfProcessSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		LoginDTO loginDTO = new LoginDTO();
		UserDTO userDTO = new UserDTO();
		TalentDTO talentDTO = new TalentDTO();
		CommentDTO commentDTO = new CommentDTO();
		RequestDTO requestDTO = new RequestDTO();
		List<UserDTO> userList = new ArrayList<>();
		List<TalentDTO> talentList = new ArrayList<>();
		List<CommentDTO> commentList = new ArrayList<>();
		List<RequestDTO> requestList = new ArrayList<>();
        boolean isSampleMaker = true;

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
        	case "personMyselfPurchaseHistory":
        		path="/PersonMyselfPurchaseHistory";
        		break;
        	case "talentInfo":
        		path="/TalentInfo";
        		break;
        }
        request.getRequestDispatcher(path).forward(request, response);

	}
}
