<%--作成者小澤 --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product"%>
<%
ArrayList<Product> productid_list = (ArrayList<Product>)request.getAttribute("product_list") 
Product product = new Product();
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
				href="<%=request.getContextPath()%>/view/menu.jsp">メニュー</a>]
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
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">価格</td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">種類</td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">個数</td>
		</tr>

		<tr>
			<td
				style="text-align: center; background-color: #66cdaa; width: 120px">備考</td>
		</tr>
		<%-- データ入力 --%>
		<tr>
			<td style="text-align: center; width: 120px"><%=product.getProduct_name%></td>
		</tr>

		<tr>
			<td style="text-align: center; width: 120px"><%=product.getPrice%></td>
		</tr>

		<tr>
			<td style="text-align: center; width: 120px"><%=product.getProduct_kind%></td>
		</tr>

		<tr>
			<td style="text-align: center; width: 120px"><%=product.getQuantity%></td>
		</tr>

		<tr>
			<td style="text-align: center; width: 120px"><%=product.getProduct_description%></td>
		</tr>



	</table>


	<form action="<%=request.getContextPath()%>/Purchase">
		<table style="margin: auto; padding: 100px;">

			<tr style="margin: auto">
				<input type="hidden" name="product_id"
					value="<%=product.getProduc_id%>">
				<th><input type="submit" name="buyConfirm" value="購入"></th>
			</tr>

		</table>
	</form>

</body>
</html>