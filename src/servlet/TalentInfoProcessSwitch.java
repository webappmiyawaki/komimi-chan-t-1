package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		TalentDTO talentDTO = new TalentDTO();
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
        	case "purchasingPageForEach":
        		path="/PurchasingPageForEach";
        		break;
        }
        request.getRequestDispatcher(path).forward(request, response);
	}
}
