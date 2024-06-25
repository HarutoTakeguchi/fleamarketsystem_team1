//作成者：石井
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

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String error = ""; //エラーメッセージ用変数
		String cmd = "";//遷移先を区別するパラメータ

		try {
			//productのオブジェクトを引数として、ProductDAOをインスタンス化を行い、関連メソッドを呼び出す
			//productオブジェクトのリストを取得する
			//ProductDAOのオブジェクトを生成
			ProductDAO productDao = new ProductDAO();
			ArrayList<Product> productList = new ArrayList<Product>();
			productList = productDao.selectAll();

			//取得したListをリクエストスコープにbook_listという名前で格納する
			request.setAttribute("product_list", productList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行なえませんでした。";
			cmd = "logout";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				//list.jspにフォワードする
				request.getRequestDispatcher("/view/goods_list.jsp").forward(request, response);
			} else {
				//error.jspにフォワードする
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}