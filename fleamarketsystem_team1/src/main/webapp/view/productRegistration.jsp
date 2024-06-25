<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>商品登録登録</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>
		<%@ include file="/common/userInfo.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>

						<li><a
							href="<%=request.getContextPath()%>/view/memberMenu.jsp">[メニュー]</a></li>

					</ul>


					<!-- ページタイトル -->
					<div id="page_title">
						<center>
							<h2>商品登録</h2>
						</center>
					</div>
				</div>
			</div>
		</div>

		<div id="main" class="container">

			<!--  入力フォーム -->
			<form action="<%=request.getContextPath()%>/productRegistration">
				<table class="input-table" align="center">
					<tr>
						<th>商品名</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>種類</th>
						<td><select name="category">
								<option value="">-- 商品の種類を選択してください --</option>
								<option value="a">ゲイム・おもちゃ・グッズ</option>
								<option value="b">本・雑誌・漫画</option>
								<option value="c">ファッション</option>
								<option value="d">スポーツ</option>
								<option value="e">ベビー・キッズ</option>
								<option value="f">ホビー・楽器・アート</option>
								<option value="g">チケット</option>
								<option value="h">CD・DVD・ブルーレイ</option>
								<option value="i">生活家電・空調</option>
								<option value="j">アウトドア・釣り・旅行用品</option>
								<option value="k">コスメ・美容</option>
								<option value="l">食品・飲料・酒</option>
								<option value="m">家具・インテリア</option>
						</select></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<th>個数</th>
						<td><input type="text" name="quantity"></td>
					</tr>
					<tr>
						<th>備考</th>
						<td><textarea rows="5" cols="50" name="description"></textarea></td>
					</tr>
				</table>
				<center>
					<input type="submit" value="出品">
				</center>
			</form>



		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>