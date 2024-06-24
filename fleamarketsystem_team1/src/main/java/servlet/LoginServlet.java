//作成者:小澤
package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		User user = new User();

		try {
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");

			//UserDAOをインスタンス化し、ユーザー情報の検索を行う。

			UserDAO userDao = new UserDAO();
			user = userDao.selectByUser(username, password);

			//ユーザー情報のチェック
			if (user.getUserid() == null) {

				error = "入力データが間違っています。";
				cmd = "login";
				return;
			}
			//ユーザー情報がある場合、セッション、スコープにuserという名前で登録する
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//クッキーに入力情報のuseridとpasswordを入力する。
			Cookie userCookie = new Cookie("user", user.getUserid());
			userCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(userCookie);

			Cookie passCookie = new Cookie("password", user.getPassword());
			passCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passCookie);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログイン出来ません。";
			cmd = "login";

		} finally {
			if (error.equals("")) {
				// ユーザー権限によって遷移先を変更する
				if (user.getAuthority().equals("1")) {
					// 1は管理者
					request.getRequestDispatcher("/view/admin_menu.jsp").forward(request, response);
				} else {
					// それ以外（２）は一般ユーザー
					request.getRequestDispatcher("/view/memberMenu.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", error);
				if (cmd.equals("login")) {
					request.getRequestDispatcher("/view/login.jsp").forward(
							request, response);
				} else {
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(
							request, response);
				}
			}
		}
	}
}
