//作成者：竹口

package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bean.Product;
import bean.User;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/productRegistration")
public class ProductRegistrationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String error = "";
		String cmd = "";
		
		// ログインしているユーザーのセッションを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		// 現在の日付を取得
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String sellDate = dtf.format(nowDate);

		try {
			// ProductDAOクラスのオブジェクトを生成
			ProductDAO ProductDaoObj = new ProductDAO();

			// 登録する書籍情報を格納するProductオブジェクトを生成（DTO）
			Product product = new Product();

			// 画面からの入力情報を受け取るためのエンコードを設定し、受け取る			
			String name = request.getParameter("name");
			String strPrice = request.getParameter("price");
			String strQuantity = request.getParameter("quantity");
			String description = request.getParameter("description");
			String category = request.getParameter("category");

			// 商品名未入力
			if (name.equals("")) {
				error = "商品名が未入力の為、商品登録処理は行えませんでした。";
				cmd = "insert";
				return;
			}

			// 価格未入力
			if (strPrice.equals("")) {
				error = "価格が未入力の為、商品登録処理は行えませんでした。";
				cmd = "insert";
				return;
			}
			
			// 個数未入力
			if(strQuantity.equals("")) {
				error="個数が未入力の為、商品登録処理は行えませんでした。";
				cmd="insert";
				return;
			}

			// 価格の値が不正の場合
			int intPrice;
			try {
				intPrice = Integer.parseInt(strPrice);
			} catch (NumberFormatException e) {
				error = "価格の値が不正の為、商品登録処理は行えませんでした。";
				cmd = "insert";
				return;
			}
			
			// 種類未入力
			if (category.equals("")) {
				error = "種類が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			
			// 備考未入力
			if (description.equals("")) {
				error = "備考が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			
			int quantity = Integer.parseInt(strQuantity);

			// 受け取とった入力情報をProductオブジェクトに格納
			product.setUserid(user.getUserid());
			product.setName(name);
			product.setPrice(intPrice);
			product.setQuantity(quantity);
			product.setDescription(description);
			product.setSelldate(sellDate);
			product.setCategory(category);

			// ProductDAOクラスに定義したinsert()メソッドを利用して、Productオブジェクトに格納された書籍データをデータベースに登録する
			ProductDaoObj.insert(product);

			// ProductListServletへ遷移する。
			request.setAttribute("insertProduct", product);
			request.getRequestDispatcher("/productList").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品登録処理は行えませんでした。";
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
