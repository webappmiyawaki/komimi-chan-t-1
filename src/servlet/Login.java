package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProcessFind;
import dto.CommentDTO;
import dto.HistoryDTO;
import dto.LoginDTO;
import dto.ProductDTO;
import dto.TalentDTO;
import dto.UserDTO;
import model.LoginCheck;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		String userName = request.getParameter("userName");
		String userPass= request.getParameter("userPass");

		HttpSession session = request.getSession();
		LoginDTO loginDTO = LoginDTO.builder()
				.name(userName)
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
			talentList=pf.findAllTalentDTOList();
		}else {
        	path= "login.jsp";
        	loginDTO = null;
        	talentList=null;
//			response.sendRedirect(path);
			request.getRequestDispatcher(path).forward(request, response);
		}

		Map<String,TalentDTO>talentMap=new HashMap<>();
		String key="";
		for(TalentDTO talentDTO:talentList) {
			talentMap.put(talentDTO.getTalentId(),talentDTO);
		}
		Map<String,TalentDTO>myTalentMap=talentMap;

		UserDTO myUserDTO = new UserDTO();
		UserDTO othersUserDTO = new UserDTO();

		CommentDTO commentDTO = new CommentDTO();
		List<UserDTO> userList = new ArrayList<>();
		List<UserDTO> personOthersList = new ArrayList<>();
		List<CommentDTO> commentList = new ArrayList<>();

		List<UserDTO> myUserList = new ArrayList<>();
		List<TalentDTO> myTalentList = new ArrayList<>();
		List<CommentDTO> myCommentList = new ArrayList<>();

		List<UserDTO> othersUserList = new ArrayList<>();
		List<TalentDTO> othersTalentList = new ArrayList<>();
		List<CommentDTO> othersCommentList = new ArrayList<>();

		//自分のタレントリストを作成
		myUserDTO = userDTO;
		myTalentList.add(pf.findTalentDTO(myUserDTO.getUserFavoriteTalent01()));
		myTalentList.add(pf.findTalentDTO(myUserDTO.getUserFavoriteTalent02()));
		myTalentList.add(pf.findTalentDTO(myUserDTO.getUserFavoriteTalent03()));
		myTalentList.add(pf.findTalentDTO(myUserDTO.getUserFavoriteTalent04()));
		myTalentList.add(pf.findTalentDTO(myUserDTO.getUserFavoriteTalent05()));

		myUserDTO.setUserFavoriteTalentList(myTalentList);
		myUserDTO.setCommentDTOList(pf.findCommentDTOList(myUserDTO));


//		ProcessFind pf = new ProcessFind();
//		talentList=pf.findAllTalentDTOList();
//		userList=pf.findAllPersonOthersList();
//		personOthersList=pf.findAllPersonOthersList();
		personOthersList=pf.findPersonOthersList();
//		productList=pf.findAllProductDTOList();
//		commentList=pf.findAllCommentDTOList();
		myUserDTO.setHistoryDTOList(pf.findAnyHistoryDTOList(myUserDTO));
		List<ProductDTO>historyProductDTOList = new ArrayList<>();
		for(HistoryDTO historyDTO:myUserDTO.getHistoryDTOList()) {
			historyProductDTOList.add(pf.findAnyProductDTO(historyDTO.getProductId()));
		}
		myUserDTO.setProductDTOList(historyProductDTOList);
		//****使わなくなる
        session.setAttribute("commentDTO", commentDTO);
        session.setAttribute("userList", userList);
        session.setAttribute("personOthersList", personOthersList);
        session.setAttribute("talentList", talentList);
        session.setAttribute("commentList", commentList);
        //********

        //****ここ使う***
        session.setAttribute("myUserList", myUserList);
        session.setAttribute("myTalentList", myTalentList);
        session.setAttribute("myCommentList", myCommentList);

        session.setAttribute("othersUserList", othersUserList);
        session.setAttribute("othersTalentList", othersTalentList);
        session.setAttribute("othersCommentList", othersCommentList);

		session.setAttribute("login", loginDTO);
		session.setAttribute("userDTO", userDTO);
		session.setAttribute("myUserDTO", myUserDTO);
        session.setAttribute("myTalentMap", myTalentMap);
      //*******

		request.getRequestDispatcher(path).forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
