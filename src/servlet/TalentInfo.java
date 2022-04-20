package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProcessFind;

@WebServlet("/TalentInfo")
public class TalentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "talentInfo.jsp";
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String talentId= request.getParameter("talentDTO");
		HttpSession session = request.getSession();
		ProcessFind pf = new ProcessFind();
		session.setAttribute("talentDTO", pf.findTalentDTO(talentId));
		session.setAttribute("commentTalentList", pf.findCommentTalentList(talentId));
		session.setAttribute("talentProductList",pf.findAnyProductDTOList(talentId));
		doGet(request, response);
	}
}
