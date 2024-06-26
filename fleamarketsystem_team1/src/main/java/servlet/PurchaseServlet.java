//作成者小澤
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.MAil;
import bean.Product;
import bean.User;
import dao.GetMailDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Purchase")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";
		try {
			//セッションで"user"を取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			//セッション切れはerror.jspへ
			if (user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "login";
				return;
			}
			//パラメーターからproductidを取得
			String productid = (String) request.getParameter("product_id");

			//購入処理。一件ずつ購入するので受け取ったproductidをもとに処理を進める。
			ProductDAO productDao = new ProductDAO();
			OrderDAO orderDao = new OrderDAO();
			ArrayList<Product> product_list = new ArrayList<Product>();

			Product product = productDao.selectByProduct(productid);
			product_list.add(product);
			orderDao.insert(product);

			request.setAttribute("product_list", product_list);

			GetMailDAO mailDao = new GetMailDAO();

			MAil mail = mailDao.getRegistarMail(productid);

			request.setAttribute("mail", mail);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、購入は出来ません。";
			cmd = "logout";

		} finally {
			// ⑦ エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はbuyConfirm.jspにフォワードする
				cmd = "buy";
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/sendmail").forward(
						request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(
						request, response);
			}

		}

	}
}
