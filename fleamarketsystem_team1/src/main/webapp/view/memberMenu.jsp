<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>会員メニュー</title>
<style>
.title {
	border: 5px solid #66cdaa;
	background-color: #66cdaa;
	padding-top: 20px;
}
</style>
</head>

<body style="background-color: #f0fff0;">

	<%@ include file="/common/userInfo.jsp"%>
	<!-- 		
<p  style="text-align:center; font-size:24px">menu</p>
			<div style="margin-left: 80%; width: 100%;">
				<div>
						<th>名前:</th>
						<td><%= user.getUserid()%></td>
				</div>
				<div>
						<th>権限:</th>
						<% if (user.getAuthority().equals("2")){ %>
						<td>管理者</td>
						
						<% }else{ %>
						<td>一般</td>
						<% } %>
				</div>
			</div>
			-->

	<center>
		<h1 class="title">会員メニュー</h1>
	</center>
	<table style="margin: auto;">
		<br>
		<br>
		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/productList">【商品一覧】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/view/productRegistration.jsp">【商品登録】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/purchaseStatus">【購入状況】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>//saleStatus">【出品状況】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/logout">【ログアウト】</a></td>
		</tr>
	</table>

	<hr
		style="text-align: center; margin-top: 200px; height: 5px; background-color: black; max-width: 3000px">
	<table style="margin: auto; border: 0; width: 950px; text-align: left">
		<tr>
			<td>Copyright (C) 2024 All Rights Reserved.</td>
		</tr>
	</table>

</body>
</html>