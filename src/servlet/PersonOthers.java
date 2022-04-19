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
import dto.TalentDTO;
import dto.UserDTO;

@WebServlet("/PersonOthers")
public class PersonOthers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "personOthers.jsp";
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String personOthersID = request.getParameter("personOthersID");
		HttpSession session = request.getSession();
		ProcessFind pf = new ProcessFind();
		UserDTO personOthersDTO = pf.findPersonOthers(personOthersID);
		session.setAttribute("personOthersDTO",personOthersDTO);

		//自分のタレントリストを作成
		List<TalentDTO> othersTalentList = new ArrayList<>();
		othersTalentList.add(pf.findTalentDTO(personOthersDTO.getUserFavoriteTalent01()));
		othersTalentList.add(pf.findTalentDTO(personOthersDTO.getUserFavoriteTalent02()));
		othersTalentList.add(pf.findTalentDTO(personOthersDTO.getUserFavoriteTalent03()));
		othersTalentList.add(pf.findTalentDTO(personOthersDTO.getUserFavoriteTalent04()));
		othersTalentList.add(pf.findTalentDTO(personOthersDTO.getUserFavoriteTalent05()));

		personOthersDTO.setUserFavoriteTalentList(othersTalentList);
		personOthersDTO.setCommentDTOList(pf.findCommentDTOList(personOthersDTO));

		doGet(request, response);
	}
}
