package servlet;

import java.io.IOException;

import bean.MAil;
import bean.User;
import dao.GetMailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SendMail;

@WebServlet("/sendmail")
public class SendMailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        String cmd = "";
        String cmd3 = request.getParameter("cmd3");
        String cmd2 = (String) request.getAttribute("cmd2");
        MAil Mail = new MAil(); 

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            GetMailDAO getMailDAO = new GetMailDAO();

            // 出品者へのメール
            if (cmd2 != null) {
            	 String productid = (String) request.getAttribute("productid");
            	 String mail = getMailDAO.getRegistarMail(productid).getMail();
                SendMail sendMail = new SendMail();
                sendMail.setFromInfo("system.project.team43@kanda-it-school-system.com", "フリーマーケットシステム");
                sendMail.setRecipients(mail);
                sendMail.setSubject("出品されてました商品が購入されました。");
                sendMail.setText("出品されていました商品をご購入いたしました。\n入金をご確認次第発送していただきたいため、"
                        + "ご準備のほどよろしくお願いいたします。\nご利用いただきありがとうございます。");
                sendMail.forwardMail();
                request.getRequestDispatcher("/view/buy_Email.jsp").forward(request, response);
                return;
            }

            // 購入者へのメール
            if (cmd3 != null) {
                String orderno = (String) request.getParameter("orderno");
                String mail =getMailDAO.getMailByOrderNo(orderno).getMail();
                SendMail sendMail = new SendMail();
                sendMail.setFromInfo("system.project.team43@kanda-it-school-system.com", "フリーマーケットシステム");
                sendMail.setRecipients(mail);
                sendMail.setSubject("購入された商品が発送されました。");
                sendMail.setText("購入されました商品が発送されました。\n"
                        + "ご利用いただきありがとうございます。\n\nまたのご利用お待ちしております。");
                sendMail.forwardMail();
                request.getRequestDispatcher("/view/Shipment_mail.jsp").forward(request, response);
                return;
            }

        } catch (IllegalStateException e) {
            error = "DB接続エラーの為、送信出来ません。";
            cmd = "logout";
        } catch (Exception e) {
            error = "予期せぬエラーが発生しました。";
            cmd = "menu";
        } finally {
            if (!error.equals("")) {
                request.setAttribute("error", error);
                request.setAttribute("cmd", cmd);
                request.getRequestDispatcher("/view/error.jsp").forward(request, response);
            }
        }
    }
}