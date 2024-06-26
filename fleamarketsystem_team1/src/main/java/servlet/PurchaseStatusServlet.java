//作成者小澤
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.PurchaseHistory;
import dao.PurchaseHistoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/purchaseStatus")
public class PurchaseStatusServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		
		String error= "";
		String cmd = "";
		try{
		
			PurchaseHistoryDAO purchasehistorydao = new PurchaseHistoryDAO();
		
		ArrayList<PurchaseHistory> dealingList = purchasehistorydao .selectByPurchase();
		
		request.setAttribute("dealing_list", dealingList);
		
	}catch (IllegalStateException e) {
		error = "DB接続エラーの為、購入状況表示は行えませんでした。";
		cmd = "menu";
	} finally {
		// エラーの有無でフォワード先を呼び分ける
		if (error.equals("")) {
			// エラーが無い場合はbuy_status.jspにフォワード
			request.getRequestDispatcher("/view/purchase_status.jsp").forward(request,
					response);
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


