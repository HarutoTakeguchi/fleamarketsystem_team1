<%--
作成：小澤
修正：石井
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Product, util.MyFormat"%>
<%
Product product = (Product) request.getAttribute("product");
MyFormat format = new MyFormat();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品情報</title>
<style>
.title { 
	border: 5px solid #66cdaa;
	background-color: #66cdaa;
	padding-top: 20px;
}
</style>

</head>
<body style="background-color: #f0fff0;">
	<center>
		<h1 class="title">商品情報</h1>
		<br>
	</center>

	<table style="margin: auto; width: 850px">
		<tr>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/view/memberMenu.jsp">メニュー</a>]
			</td>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/productList">商品一覧</a>]
			</td>
			<td style="width: 200px">&nbsp;</td>
		</tr>

	</table>
	<hr style="text-align: center; height: 5px; background-color: black">
	<br>
	<br>


	<table style="margin: auto">

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">商品名</td>
			<td style="text-align: center; width: 120px"><%=product.getName()%></td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">価格</td>
			<td style="text-align: center; width: 120px"><%=product.getPrice()%></td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">種類</td>
			<td style="text-align: center; width: 120px"><%=product.getCategory()%></td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">個数</td>
			<td style="text-align: center; width: 120px"><%=product.getQuantity()%></td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">備考</td>
			<td style="text-align: center; width: 120px"><%=product.getDescription()%></td>
		</tr>
		<%-- データ入力 --%>
	</table>


	<form action="<%=request.getContextPath()%>/Purchase" method="post">
		<table style="margin: auto; padding: 100px;">

			<tr style="margin: auto">
				<input type="hidden" name="product_id"
					value="<%=product.getProductid()%>">
				<th><input type="submit" name="buyConfirm" value="購入"></th>
			</tr>

		</table>
	</form>

</body>
</html>