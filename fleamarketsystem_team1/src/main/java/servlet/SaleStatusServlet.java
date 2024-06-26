//作成者：畑

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saleStatus")
public class SaleStatusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "";
		String cmd = "";

		try {
			
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");
			
			String user_id = request.getParameter("user_id");
			
			// ① Sale_statusDAOをインスタンス化する
			ProductDAO ProductDaoObj = new ProductDAO();

			// ②関連メソッドを呼び出し、戻り値としてSale_statusオブジェクトのリストを取得する
			ArrayList<Product> list = ProductDaoObj.selectBySale(user_id);

			// ③②で取得したListをリクエストスコープに"sale_status_list"という名前で格納する
			request.setAttribute("sale_status_list",list);

		} catch (IllegalStateException e) {
			
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "logout";
			
		} finally {
			
			// ④ エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はlist.jspにフォワード
				request.getRequestDispatcher("/view/sale_status.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				
			}
		}
	}
}
