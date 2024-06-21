//　作成者：後藤侑哉
package servlet;


import java.io.IOException;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 商品情報確認に関する処理をおこなうサーブレットクラス
 
 *
 */
@WebServlet("/productInformation")
public class ProductInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			request.setCharacterEncoding("UTF-8");

			String name = request.getParameter("name");
			cmd = request.getParameter("cmd");
			
			ProductDAO productdao= new ProductDAO();

			Product product = productdao.selectByProduct(name);

			// 詳細情報のエラーチェック
			if (product.getName() == null) {
				error = "表示対象の商品が存在しない為、詳細情報は表示出来ませんでした。";
				cmd = "goods_list";
			}

			// 取得したproductをリクエストスコープに"product"という名前で格納する
			request.setAttribute("product", product);

		} catch (IllegalStateException e) {
			if (cmd.equals("goods_information")) {
				error = "DB接続エラーの為、商品情報は表示出来ませんでした。";
				cmd = "goods_list";
				}
			
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
					request.getRequestDispatcher("/view/goods_information.jsp").forward(request, response);
					
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