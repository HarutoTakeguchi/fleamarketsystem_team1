//作成者：竹口

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.User;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String error = "";
		String cmd = "";

		try {

			// ① UserDAOをインスタンス化する
			UserDAO UserDAOObj = new UserDAO();

			// ②関連メソッドを呼び出し、戻り値としてUserオブジェクトのリストを取得する
			ArrayList<User> userList = UserDAOObj.selectAll();

			// ③②で取得したListをリクエストスコープに"book_list"という名前で格納する
			request.setAttribute("user_list", userList);

		} catch (IllegalStateException e) {
			error = "DB接続エラー。";
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
			} else {

				// ④list.jspにフォワード
				request.getRequestDispatcher("/view/user_list.jsp").forward(request, response);
			}
		}
	}
}
