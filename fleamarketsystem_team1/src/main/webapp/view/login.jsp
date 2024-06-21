<!-- 作成者：竹口 -->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>ログイン</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

		<!-- コンテンツ(本文) -->
		<div id="main">
			<!-- フォーム送信でLoginServletへ遷移 -->
			<form action="<%=request.getContextPath()%>/login" method="post">
				<table class="login-table">
					<tr>
						<th>ユーザー</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="ログイン">
			</form>
			<a href="<%=request.getContextPath()%>/view/menbe_registration.jsp">
				<input type="submit" value="新規登録はこちらから">
			</a>
		</div>


		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>

</html>