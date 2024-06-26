/**
 * 作成：内山
 */
package servlet;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		throws ServletException ,IOException {
		
		String error = "";
		String cmd = "";
		
		try {
			
			//文字コードを設定する
			request.setCharacterEncoding("UTF-8");
			
			//パラメータの情報を取得する
			String productid = request.getParameter("productid");
			
			//ProductDAOをインスタンス化
			ProductDAO productDaoObj = new ProductDAO();
			
			// 削除対象の有無のエラーチェック
			if (productDaoObj.selectByProduct(productid).getProductid()==0) {
				error = "削除対象の書籍が存在しない為、書籍削除処理は行えませんでした。";
				cmd = "list";
				return;
			}
			
			//メソッド呼び出し
			productDaoObj.delete(productid);
			
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品削除処理は行えませんでした。";
			cmd = "logout";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				//ProductListServletへ遷移する
				request.getRequestDispatcher("/productList").forward(request, response);
			} else {
				//error.jspへ遷移する
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}


