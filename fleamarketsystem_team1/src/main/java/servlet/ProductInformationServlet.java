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
@WebServlet("/productInfo")
public class ProductInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String error = "";
		String cmd = "";

		try {
			
			//文字コードを設定する
			request.setCharacterEncoding("UTF-8");
			
			//パラメータを取得する
			String name = request.getParameter("name");
			cmd = request.getParameter("cmd");
			
			//ProductDAOをインスタンス化する
			ProductDAO productdao= new ProductDAO();
			
			//関連メソッドを呼び出して戻り値としてProductオブジェクトを取得する
			Product product = productdao.selectByProduct(name);

			// 詳細情報のエラーチェック
			if (product.getName() == null) {
				error = "表示対象の商品が存在しない為、詳細情報は表示出来ませんでした。";
				cmd = "goods_list";
				return;
			}

			// 取得したproductをリクエストスコープに"product"という名前で格納する
			request.setAttribute("product", product);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品情報は表示出来ませんでした。";
			cmd = "logout";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。";
			cmd = "menu";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				//エラーが無い場合はproduct_purchase.jspにフォワードする
				request.getRequestDispatcher("/view/product_purchase.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}