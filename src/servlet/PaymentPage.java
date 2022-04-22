package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ProductDTO;


@WebServlet("/PaymentPage")
public class PaymentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "paymentPage.jsp";
        response.sendRedirect(path);
//		request.getRequestDispatcher(path).forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String paymentPageAction = request.getParameter("paymentPageAction");
		String productId = request.getParameter("productId");
		HttpSession session = request.getSession();

		//カートから削除
		try{
		if(paymentPageAction.equals("削除")) {
			switch(paymentPageAction) {
			case "削除":
				List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
				cart.removeIf(c->c.getProductId().equals(productId));
				session.setAttribute("cart", cart);
				break;
			default:
				break;
		}
		}
		}catch(Exception e) {
			System.out.println("対処不能");
		}

		doGet(request, response);
	}

}
