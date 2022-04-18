package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PersonMyselfProcessSwitch")
public class PersonMyselfProcessSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");

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
