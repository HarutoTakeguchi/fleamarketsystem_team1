<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>goods_sell</title>
		<style>
			.title {
				border: 5px solid #66cdaa;
				background-color: #66cdaa;
				padding-top: 20px;
			}
		</style>
	</head>
	<body  style="background-color:#f0fff0;">
		
		<%@include file="/common/header.jsp" %>
		<%@include file="/common/userinfo.jsp" %>
		
		<h1 class="title">商品出品</h1>
		
		<div style="margin-bottom:250px">
		
			<form action="<%=request.getContextPath() %>/adinMenu">
		
				<h2 style="text-align:center">商品が出品されました</h2>
				
				<tr>
					<td><input type="submit" value="メニューに戻る"></td>
				</tr>
			
			</form>
			
		</div>
		
		<%@include file="/common/footer.jsp" %>
		
	</body>
</html>