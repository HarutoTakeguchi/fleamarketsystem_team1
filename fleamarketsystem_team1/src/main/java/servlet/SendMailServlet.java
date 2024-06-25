package servlet;

import java.io.IOException;

import bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SendMail;

@WebServlet("/sendmail")
public class SendMailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//try,cacth文は後ほど挿入予定
		String cmd = (String)request.getAttribute("cmd");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(cmd.equals("buy")) {
		
		
	//購入の確認メールを出品者に送信
	SendMail sendMail = new SendMail();
	sendMail.setFromInfo("system.project.team43@kanda-it-school-system.com", "フリーマーケットシステム");
	//ここで出品者のEmailが欲しい
	sendMail.setRecipients(user.getEmail());
	sendMail.setSubject("出品されてました商品が購入されました。");
	//ここで出品者のユーザーネームが欲しい。
	sendMail.setText(user.getName()
			+ "様\\n\\nが出品されていました商品をご購入いたしました。\n入金をご確認次第発送していただきたいため、"
			+ "ご準備のほどよろしくお願いいたします。\nご利用いただきありがとうございます。");
	sendMail.forwardMail();
	
	//配送されたことを確認するメール、ifのカッコ内には遷移前の画面からコマンドを引き継いだものを判別する。
	}else if(cmd.equals("")){
		SendMail sendMail = new SendMail();
		sendMail.setFromInfo("system.project.team43@kanda-it-school-system.com", "フリーマーケットシステム");
		//ここで購入者のメールアドレスが欲しい
		sendMail.setRecipients(user.getEmail());
		sendMail.setSubject("購入された商品が発送されました。");
		//ここで購入者のユーザーネームが欲しい
		sendMail.setText(user.getName()
				+ "様\\n\\n購入されました商品が発送されました。\n、"
				+ "\nご利用いただきありがとうございます。"+"\n\nまたのご利用お待ちしております。");
		sendMail.forwardMail();
	}
}
}