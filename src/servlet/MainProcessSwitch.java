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
import dto.CommentDTO;
import dto.TalentDTO;
import dto.UserDTO;

@WebServlet("/MainProcessSwitch")
public class MainProcessSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		CommentDTO commentDTO = new CommentDTO();
		List<UserDTO> userList = new ArrayList<>();
		List<TalentDTO> talentList = new ArrayList<>();
		List<CommentDTO> commentList = new ArrayList<>();
        boolean isSampleMaker = true;
        if(isSampleMaker) {

    		//DTO作成用
//        	if(true) {
//	        	//LoginDTO
//	    		CreateSample createSample = new CreateSample(select);
//	    		commentDTO = createSample.createCommentDTO();
//    		}

    		//UserList
//    		for(int i=0;i<10;i++) {
//    			CreateSample createSample = new CreateSample(select);
//    			userList.add(createSample.createUserDTO());
//    		}

    		//TalentList
//    		for(int i=0;i<10;i++) {
//    			CreateSample createSample = new CreateSample(select);
//    			talentList.add(createSample.createTalentDTO());
//    		}
    		ProcessFind pf = new ProcessFind();
    		talentList=pf.findAllTalentDTOList();
    		userList=pf.findAllPersonOthersList();
    		//CommentList
//    		for(int i=0;i<10;i++) {
//    			CreateSample createSample = new CreateSample(select);
//    			commentList.add(createSample.createCommentDTO());
//    		}

    		commentList=pf.findAllCommentDTOList();

        }

        session.setAttribute("commentDTO", commentDTO);
        session.setAttribute("userList", userList);
        session.setAttribute("talentList", talentList);
        session.setAttribute("commentList", commentList);

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
        		path="/WEB-INF/jsp/ManagementForOperation";
        		break;
        	case "managementForTalent":
        		path="/WEB-INF/jsp/ManagementForTalent";
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
