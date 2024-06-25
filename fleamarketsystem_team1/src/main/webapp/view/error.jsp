<!-- 作成者　石井 -->
<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>エラー画面</title>
</head>
<body>
	<!-- header共通化 -->
	<%@ include file="/common/header.jsp"%>
	<hr
		style="text-align: center; height: 5px; background-color: blue; width: auto">

	<!-- 各Servletからエラーメッセージとコマンドを受け取る。 -->
	<%
	String error = (String) request.getAttribute("error");
	String cmd =   (String) request.getAttribute("cmd");
	%>
	<div style="text-align: center">
		<table>
			<p>●●エラー●●</p>
			<%=error%><br>
			<%
			if(cmd.equals("member_registration.jsp")){
			%>
			<a href="view/member_registration.jsp">登録画面に戻る</a>
			<%
			}else if(cmd.equals("menu.jsp")){
			%>
			<a href="view/menu.jsp">メニューへ戻る</a>
			<%
			}else{
			%>
			<a href="<%=request.getContextPath()%>/view/login.jsp">ログイン画面へ</a>
			<%
			}
			%>

		</table>

		<!--footer共通化 -->
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>