<!-- 石井　作成 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product"%>

<%
ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("sale_status_list");
%>
<html>
<head>
<title>出品状況画面</title>
<style>
.title {
	border: 5px solid #66cdaa;
	background-color: #66cdaa;
	padding-top: 20px;
	text-align: center;
}
</style>
</head>
<body style="background-color: #f0fff0;">
	<!-- header共通化 -->
	<%@ include file="/common/header.jsp"%>

	<table style="margin: auto; width: 850px">
		<tr>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/view/memberMenu.jsp">メニュー</a>]
			</td>

			<h1 class="title">出品状況画面</h1>
			<td style="width: 80px">&nbsp;</td>
			<td style="width: 80px">&nbsp;</td>
		</tr>
	</table>

	<hr
		style="text-align: center; height: 2px; background-color: black; width: auto">
	<br>
	<div style="margin-bottom: 250px">
		<form action="<%=request.getContextPath()%>/deliveryMail" method="get">
			<table style="margin: auto">
				<tr>
					<th style="background-color: #66cdaa; width: 200px">商品ID</th>
					<th style="background-color: #66cdaa; width: 200px">商品名</th>
					<th style="background-color: #66cdaa; width: 200px">商品情報</th>
					<th style="background-color: #66cdaa; width: 200px">配送確定</th>
				</tr>
				<%
				if (list != null) {
					for (Product product : list) {
				%>
				<tr>
					<!-- Order.java(Bean) -->
					<!-- 商品名、発送状況、商品情報、配送確定を出力する -->
					<!-- 商品名と商品情報はproduct(Bean)に、発送状況と配送確定がOrderedItem(Bean)にあるのが問題 -->
					<td style="text-align: center; width: 200px"><%=product.getProductid()%></td>
					<td style="text-align: center; width: 200px"><%=product.getName()%></td>
					<!-- 商品名 -->
					<td style="text-align: center; width: 200px">[<a
						href="<%=request.getContextPath()%>/productInfo?productId=<%=product.getProductid()%>">商品情報</a>]
					</td>
					<!-- 商品情報 -->

					<td style="margin: auto; width: 200px"><input type="submit"
						name="productPurchase" value="配送確定"></td>
					<!-- 配送確定 -->
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px" colspan="2">&nbsp;</td>
				</tr>
				<%
				}
				%>

			</table>
		</form>

	</div>

	<!--footer共通化 -->
	<%@ include file="/common/footer.jsp"%>
</body>
</html>