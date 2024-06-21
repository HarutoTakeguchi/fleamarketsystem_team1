<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

	<head>
		<title>adminMenu</title>
		<style>
			.title {
				border: 5px solid #85b9e9;
				background-color: #85b9e9;
				padding-top: 20px;
				
			}
		</style>
	</head>
	
	<body  style="background-color:#f0f8ff;">
	
		<%@include file="/common/header.jsp" %>
		<%@include file="/common/userinfo.jsp" %>
		
		<h1 class="title">管理者メニュー</h1>
		
		<hr style="text-align:center; height:5px; background-color:black">
		
		<div style="margin-bottom:250px">
		
			<table style="margin:auto; border:0">
			
				<tr><td><a href="fleamarketsystem_team1/view/userList.jsp">ユーザー一覧</a></td></tr>
				<tr><td>&nbsp;</td></tr>
				
				<tr><td><a href="fleamarketsystem_team1/view/sale_list.jsp">出品一覧</a></td></tr>
				<tr><td>&nbsp;</td></tr>
				
				<tr><td><a href="fleamarketsystem_team1/view/sold_cofirm.jsp">売上確認</a></td></tr>
				<tr><td>&nbsp;</td></tr>
				
				<tr><td><a href="fleamarketsystem_team1/logout">ログアウト</a></td></tr>
				<tr><td>&nbsp;</td></tr>
				
			</table>
			
		</div>
		
		<%@include file="/common/footer.jsp" %>
		
	</body>
</html>