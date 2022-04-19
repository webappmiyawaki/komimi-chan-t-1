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
import dto.ProductDTO;
import dto.TalentDTO;

@WebServlet("/PurchasingPageForEach")
public class PurchasingPageForEach extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "purchasingPageForEach.jsp";
		HttpSession session = request.getSession();
		ProcessFind pf = new ProcessFind();
		session.setAttribute("productList",pf.findAnyProductDTOList((TalentDTO)session.getAttribute("talentDTO")));
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("talentDTO", (TalentDTO)request.getAttribute("talentDTO"));
		List<ProductDTO> productCart = new ArrayList<>();
		ProductDTO productDTO = (ProductDTO)request.getAttribute("product");
		if(productDTO!=null) {
			productCart.add(productDTO);
		}
		session.setAttribute("cart", productCart);
		doGet(request, response);
	}

}
