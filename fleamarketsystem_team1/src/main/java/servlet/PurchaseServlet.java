//作成者小澤
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Product;
import bean.User;
import dao.OrderDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import util.SendMail;
import util.SendMail;

@WebServlet("/Purchase")
public class PurchaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";
		try {
			//セッションで"user"を取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
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
			OrderDAO orderDao= new OrderDAO();
			ArrayList<Product> product_list = new ArrayList<Product>();
			
			Product product = productDao.selectByProduct(productid);
			product_list.add(product);
			orderDao.insert(product);
			
			request.setAttribute("product_list", product_list);
			
			//購入の確認メール送信
			SendMail sendMail = new SendMail();
			sendMail.setFromInfo("system.project.team43@kanda-it-school-system.com", "フリーマーケットシステム");
			sendMail.setRecipients(user.getEmail());
			sendMail.setSubject("商品のご購入ありがとうございます。");//表示する文を記入
			sendMail.setText(user.getName()
					+ "様\\n\\n本のご購入ありがとうございます。n以下内容でご注文を受け付けましたので、ご連絡致します。\n");
			sendMail.setText(product.getPrice()+ "円\n\nまたのご利用よろしくお願いします。");
			sendMail.forwardMail();
			
		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、購入は出来ません。";
			cmd = "logout";

		} finally {
			// ⑦ エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はbuyConfirm.jspにフォワードする
				request.getRequestDispatcher("/view/buy_Email.jsp").forward(
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
