<!-- 作成者：竹口 -->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>会員登録</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/login.jsp">[ログイン画面へ]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>会員登録</h2>
				</div>
			</div>
		</div>

		<!-- 会員登録コンテンツ部分 -->
		<div id="main" class="container">
			<!--  入力フォーム -->
			<form action="<%=request.getContextPath()%>/memberRegistration">
				<table class="input-table" align="center">
					<tr>
						<th>ユーザー名</th>
						<td><input type="text" name="user_id"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<th>氏名</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>年齢</th>
						<td><input type="text" name="age"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="email"></td>
					</tr>
				</table>
				<input type="submit" value="登録">
			</form>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>