//作成者：竹口

package servlet;

import java.io.IOException;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productRegistration")
public class ProductRegistrationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String error = "";
		String cmd = "";

		try {
			// ProductDAOクラスのオブジェクトを生成
			ProductDAO ProductDaoObj = new ProductDAO();

			// 登録する書籍情報を格納するProductオブジェクトを生成（DTO）
			Product product = new Product();

			// 画面からの入力情報を受け取るためのエンコードを設定し、受け取る			
			String strId = request.getParameter("productid");
			String name = request.getParameter("name");
			String strPrice = request.getParameter("price");
			String strQuantity = request.getParameter("quantity");
			String description = request.getParameter("description");
			String selldate = request.getParameter("selldate");
			
			// ID未入力
			if (strId.equals("")) {
				error = "IDが未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// 商品名未入力
			if (name.equals("")) {
				error = "商品名が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// 価格未入力
			if (strPrice.equals("")) {
				error = "価格が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// ID重複
			int productid = Integer.parseInt(strId);
			if (ProductDaoObj.selectByProduct(productid).getProductid() == productid) {
				error = "入力IDは既に登録済みの為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// 価格の値が不正の場合
			int intPrice;
			try {
				intPrice = Integer.parseInt(strPrice);
			} catch (NumberFormatException e) {
				error = "価格の値が不正の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			
			int quantity = Integer.parseInt(strQuantity);

			// 受け取とった入力情報をProductオブジェクトに格納
			product.setProductid(productid);
			product.setName(name);
			product.setPrice(intPrice);
			product.setQuantity(quantity);
			product.setDescription(description);
			product.setSelldate(selldate);

			// ProductDAOクラスに定義したinsert()メソッドを利用して、Productオブジェクトに格納された書籍データをデータベースに登録する
			ProductDaoObj.insert(product);

			// ListServletへフォワードする。
			request.setAttribute("insertProduct", product);
			request.getRequestDispatcher("/list").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍登録処理は行えませんでした。";
			cmd = "logout";
			return;
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
			cmd = "logout";
			return;
		} finally {
			if (!(error.equals(""))) {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
