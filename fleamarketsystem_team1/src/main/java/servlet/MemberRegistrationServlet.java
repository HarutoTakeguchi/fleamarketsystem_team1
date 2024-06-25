
//作成者：石井
//会員登録
package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memberRegistration")
public class MemberRegistrationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response) 
			throws ServletException ,IOException{	

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		String error = ""; //エラーメッセージ用変数
		String cmd = "";//フォワード先を区別するパラメータ

		try {
			//取得したパラメータのエラーチェック
			//各パラメータの取得

			String user_name = request.getParameter("user_name"); //ユーザーネーム取得
			String password = request.getParameter("password");//パスワード取得
			String name = request.getParameter("name");	//本名取得
			String StrAge = request.getParameter("age");	//年齢取得
			String address = request.getParameter("address");//住所取得
			String email = request.getParameter("email");//メールアドレス取得

			//ユーザーネーム空チェック
			if(user_name.equals("") || user_name.equals(" ")||user_name.equals("  ")) {
				error = "ユーザーネームが未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}

			//パスワード空チェック
			if(password.equals("") || password.equals(" ")||password.equals("  ")) {
				error = "パスワードが未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}

			

			//本名空チェック
			if(name.equals("") || name.equals(" ")||name.equals("  ")) {
				error = "本名が未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}


			//年齢空チェック
			if(StrAge.equals("") || StrAge.equals(" ")||StrAge.equals("  ")) {
				error = "年齢が未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}

			//priceをint型に
			int age = Integer.parseInt(StrAge);

		

			//住所空チェック
			if(address.equals("") || address.equals(" ")||address.equals("  ")) {
				error = "住所が未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}

			//メールアドレス空チェック
			if(email.equals("") || email.equals(" ")||email.equals("  ")) {
				error = "メールアドレスが未入力の為、会員登録処理は行えませんでした。";
				cmd = "member_registration.jsp";
				return;
			}


			//userのオブジェクトを生成し、各setterメソッドを利用する。(エラーが無い場合)
			User user = new User();
			UserDAO userDao = new UserDAO();

			user.setPassword(password);
			user.setUsername(user_name);
			user.setName(name);
			user.setAddress(address);
			user.setAge(age);
			user.setEmail(email);

			//Userのオブジェクトを引数として、UserDAOをインスタンス化を行い、関連メソッドを呼び出す
			userDao.insert(user);

		}catch(NumberFormatException e) {
			error = "年齢の値が不正の為、会員登録処理は行えませんでした。";
			cmd = "member_registration.jsp";
		}catch(Exception e) {
			error  = "DB接続エラーの為、書籍登録処理は行えませんでした。";
			cmd = "logout";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/memberMenu.jsp").forward(request, response);
			}else {
				request.setAttribute("cmd",cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
