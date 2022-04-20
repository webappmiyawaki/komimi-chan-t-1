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

import dto.ProductDTO;

@WebServlet("/PurchasingPageForEach")
public class PurchasingPageForEach extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "purchasingPageForEach.jsp";
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");

		HttpSession session = request.getSession();
		List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("talentProductList");

		List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
		if(cart==null) {
			cart= new ArrayList<>();
		}
		if(productId!=null) {
			for(ProductDTO productDTO:productList) {
				if(productDTO.getProductId().equals(productId)) {
					cart.add(productDTO);
					break;
				}
			}
		}
		session.setAttribute("cart",cart);
		doGet(request, response);
	}

}
