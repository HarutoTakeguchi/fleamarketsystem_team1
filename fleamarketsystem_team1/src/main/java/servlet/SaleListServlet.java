//作成者：畑

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.SaleList;
import dao.SaleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 管理者メニューにおいて、出品されている商品とその出品者、取引状況を一覧表示するサーブレットクラス
 */
@WebServlet("/saleList")
public class SaleListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");
			
			// ① BookDAOをインスタンス化する
			SaleDAO SaleDaoObj = new SaleDAO();

			// ②関連メソッドを呼び出し、戻り値としてBookオブジェクトのリストを取得する
			ArrayList<SaleList> salelist = SaleDaoObj.selectAll();

			// ③②で取得したListをリクエストスコープに"book_list"という名前で格納する
			request.setAttribute("salelist",salelist);

		} catch (IllegalStateException e) {
			
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "logout";
			
		} finally {
			
			// ④ エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はlist.jspにフォワード
				request.getRequestDispatcher("/view/sale_list.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				
			}
		}
	}
}
