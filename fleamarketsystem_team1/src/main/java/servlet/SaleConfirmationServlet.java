/**
 * 作成：内山
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Sale;
import dao.SaleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saleConfirmation")
public class SaleConfirmationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException ,IOException {
		
		String error = "";
		String cmd = "";
		
		try {
			
			//文字コードを設定する
			request.setCharacterEncoding("UTF-8");
			
			//UserDAOをインスタンス化する
			SaleDAO SaleDaoObj = new SaleDAO();
			
			//関連メソッドを呼び出す
			ArrayList<Sale> SaleList = new ArrayList<Sale>();
			SaleList = SaleDaoObj.selectBySales();
			
			//取得したListをリクエストスコープに"user_list"という名前で格納する
			request.setAttribute("sale_list", SaleList);
			
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、売上確認は表示出来ません。";
			cmd = "logout";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				//sold_confirm.jspへ遷移する
				request.getRequestDispatcher("/view/sold_confirm.jsp").forward(request, response);
			} else {
				//error.jspへ遷移する
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}

