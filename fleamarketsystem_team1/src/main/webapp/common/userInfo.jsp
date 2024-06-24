<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%

	User user = (User)session.getAttribute("user");
	
	if (user == null) {
		//セッション切れならerror.jspへフォワード
		request.setAttribute("error", "セッション切れの為、メニュー表示できませんでした。");
		request.setAttribute("cmd", "logout");
		request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		return;
	}

	//権限の設定
	String authority = "";
	if (user.getAuthority().equals("2")) {
		authority = "一般会員";
	} else if (user.getAuthority().equals("1")) {
		authority = "管理者";
	}
%>
	<ul>
		<li>名前: <%=user.getUsername() %></li>
		<li>権限: <%=authority %></li>
	</ul>