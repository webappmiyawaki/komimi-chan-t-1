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
import sample.CreateSample;

@WebServlet("/LoginProcessSwitch")
public class LoginProcessSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		LoginDTO loginDTO = new LoginDTO();
		List<TalentDTO> talentList = new ArrayList<>();
        boolean isSampleMaker = true;
        if(isSampleMaker) {

    		//DTO作成用
        	if(true) {
	        	//LoginDTO
	    		CreateSample createSample = new CreateSample(select);
	    		loginDTO = createSample.createLoginDTO();
    		}

    		ProcessFind pf = new ProcessFind();
    		talentList=pf.findAllTalentDTOList();

        }

        session.setAttribute("login", loginDTO);
        session.setAttribute("talentList", talentList);

        String path= "";
        switch(select) {
        	case "main":
        		path="/Main";
        		break;
        	case "management":
        		path="/Management";
        		break;
        }
        request.getRequestDispatcher(path).forward(request, response);

	}

}
