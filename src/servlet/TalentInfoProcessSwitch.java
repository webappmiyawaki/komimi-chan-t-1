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
import sample.CreateSample;


@WebServlet("/TalentInfoProcessSwitch")
public class TalentInfoProcessSwitch extends HttpServlet {
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
        if(isSampleMaker) {

    		//DTO作成用
        	if(true) {
	        	//LoginDTO
	    		CreateSample createSample = new CreateSample(select);
	    		loginDTO = createSample.createLoginDTO();
	    		userDTO = createSample.createUserDTO();
	    		talentDTO = createSample.createTalentDTO();
	    		commentDTO = createSample.createCommentDTO();
	    		requestDTO = createSample.createRequestDTO();
    		}

    		//UserList
    		for(int i=0;i<10;i++) {
    			CreateSample createSample = new CreateSample(select);
    			userList.add(createSample.createUserDTO());
    		}

    		//TalentList
    		for(int i=0;i<10;i++) {
    			CreateSample createSample = new CreateSample(select);
    			talentList.add(createSample.createTalentDTO());
    		}

    		//CommentList
    		for(int i=0;i<10;i++) {
    			CreateSample createSample = new CreateSample(select);
    			commentList.add(createSample.createCommentDTO());
    		}

    		//RequestList
    		for(int i=0;i<10;i++) {
    			CreateSample createSample = new CreateSample(select);
    			requestList.add(createSample.createRequestDTO());
    		}
        }

        session.setAttribute("login", loginDTO);
        session.setAttribute("userDTO", userDTO);
        session.setAttribute("talentDTO", talentDTO);
        session.setAttribute("commentDTO", commentDTO);
        session.setAttribute("requestDTO", requestDTO);
        session.setAttribute("userList", userList);
        session.setAttribute("talentList", talentList);
        session.setAttribute("commentList", commentList);
        session.setAttribute("requestList", requestList);

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
        	case "management":
        		path="/Management";
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
        }
        request.getRequestDispatcher(path).forward(request, response);

	}
}
