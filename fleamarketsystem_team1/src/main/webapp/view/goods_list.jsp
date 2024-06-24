<!-- 商品一覧画面 -->
<!-- 作成者　石井 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product,util.MyFormat"%>

<%
ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("product_list");
MyFormat format = new MyFormat();
%>

<html>
<head>
<title>商品一覧画面</title>
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

	<h1 class="title">商品一覧</h1>

	<table style="margin: auto; width: 850px">
		<tr>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/view/memberMenu.jsp">メニュー</a>]
			</td>
			<form class="inline-block"
				action="<%=request.getContextPath()%>/productList">
				<input type="submit" value="全件表示">
			</form>
			<td style="width: 200px">&nbsp;</td>
		</tr>
	</table>
	<hr style="text-align: center; height: 5px; background-color: black">
	<br>

	<div style="margin-bottom: 250px">

		<table style="margin: auto; width: 800px">
			<tr>
				<th style="background-color: #66cdaa; width: 200px">商品名</th>
				<th style="background-color: #66cdaa; width: 400px">商品情報</th>
				<th style="background-color: #66cdaa; width: 200px">削除</th>
			</tr>
			<%
			if (productList != null) {
				for (Product product : productList) {
			%>
			<tr>
				<td style="text-align: center; width: 200px">
				<a href="<%=request.getContextPath()%>/productInfo?name=<%=product.getName()%>cmd=detail">
				<%=product.getName()%></a></td>
				<td style="text-align: center; width: 200px"><%=product.getDescription()%></td>
				<td style="text-align: center; width: 70px"><a
					href="<%=request.getContextPath()%>/delete?productid=<%=product.getProductid()%>">削除</a>
				</td>
			</tr>
			<%
				}
			} else {
			%>
			<tr>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 250px" colspan="2">&nbsp;</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

	<!--footer共通化 -->
	<%@ include file="/common/footer.jsp"%>
</body>
</html>