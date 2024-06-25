<!-- 作成：内山 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,bean.PurchaseHistory" %>


<!DOCTYPE html>
<html>

	<head>
		<title>purchase_status</title>
		<style>
			.title {
				border: 5px solid #66cdaa;
				background-color: #66cdaa;
				padding-top: 20px;
				text-align:center;
			}
		</style>
	</head>
	
	<body  style="background-color:#f0fff0;">
		
		<%@include file="/common/header.jsp" %>
		<%@include file="/common/userInfo.jsp" %>
		
		<h1 class="title">購入状況</h1>
		
		<table style="margin:auto; width:900px">
		
			<tr>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/view/memberMenu.jsp">メニュー</a>]</td>
				<td style="width:400px">&nbsp;</td>
			</tr>
		
		</table>
		
		<hr style="text-align:center; height:5px; background-color:black">
		<tr><td>&nbsp;</td></tr>
		
		<div style="margin-bottom;250px">
		
			<table style="margin:auto">
				<tr>
					<th style="background-color:#66cdaa; width:200px">商品名</th>
					<th style="background-color:#66cdaa; width:200px">価格</th>
					<th style="background-color:#66cdaa; width:200px">個数</th>
					<th style="background-color:#66cdaa; width:200px">配送状況</th>
					<th style="background-color:#66cdaa; width:200px">入金状況</th>
				</tr>
			<%
			ArrayList<PurchaseHistory> List = (ArrayList<PurchaseHistory>)request.getAttribute("dealing_list");
			
			if (List != null) {
				for (int i=0; i<List.size(); i++) {
					PurchaseHistory PurchaseHistory = (PurchaseHistory)List.get(i);
			%>
			
				<tr>
				<td style="text-align:center; width:200px"><%=PurchaseHistory.getName() %></td>
				<td style="text-aling:center; width:200px"><%=PurchaseHistory.getPrice() %></td>
				<td style="text-align:center; width:200px"><%=PurchaseHistory.getQuantity() %></td>
				<td style="text-align:center; width:200px"><%=PurchaseHistory.getShipment_status() %></td>
				<td style="text-align:center; width:200px"><%=PurchaseHistory.getDeposit_status() %></td>
				</tr>
			
			<%
				}
			} else {
			%>
				<tr><th style="background-color:#66cdaa; width:200px">商品名</th></tr>
				<tr><th style="background-color:#66cdaa; width:200px">価格</th></tr>
				<tr><th style="background-color:#66cdaa; width:200px">個数</th></tr>
				<tr><th style="background-color:#66cdaa; width:200px">配送状況</th></tr>
				<tr><th style="background-color:#66cdaa; width:200px">入金状況</th></tr>
			<%
			}
			%>	
			</table>
		
		</div>
		
		<%@include file="/common/footer.jsp" %>
		
	</body>
	
</html>