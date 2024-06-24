<!-- 作成：畑 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.ArrayList,bean.Product,util.MyFormat"%>

<%
	Product product = (Product)request.getAttribute("product");
	MyFormat format = new MyFormat();
%>
<html lang = "ja">

<head>

<meta charset="UTF-8">

<title>商品購入</title>

<style>
			.title {
				border: 5px solid #66cdaa;
				background-color: #66cdaa;
				padding-top: 20px;
				text-align:center;
			}

</style>
</head>
 <body style="background-color:#f0fff0;">

<h1 class="title">商品購入</h1><br>

<table style="margin:auto; width:850px">
	<tr>
		<td style="text-align: center; width: 80px">[<a href="<%=request.getContextPath()%>/view/memberMenu.jsp">メニュー</a>]
		</td>
		<td style="width:200px">&nbsp;</td>
	</tr>
</table>
<hr style="text-align:center; height:5px; background-color:black">
<br><br>



        <table style="margin: auto">
        
        <%
        if(product != null){
        %>

	<tr>
	<td style = "text-align: center; background-color: #66cdaa; width: 120px">商品名</td>
	<td><%= product.getName() %></td>	
	</tr>

	<tr>
	<td style = "text-align: center; background-color: #66cdaa; width: 120px">価格</td>
	<td><%= product.getPrice() %></td>
	</tr>

	<tr>
	<td style = "text-align: center; background-color: #66cdaa; width: 120px">個数</td>
	<td><%= product.getQuantity() %></td>
	</tr>
	
	<%
        }	
	%>
       </table>

<table style="margin: auto; padding: 100px;">

	<tr style="margin: auto">
		<th><input type="submit" name="email" value="購入確定"></th>
	</tr>

</table>

<hr style="text-align:center; margin-top: -50px ;height:5px; background-color:black; max-width:3000px">
		<table style="margin:auto; border:0; width:950px; text-align:left">
			<tr><td>Copyright (C) 2024 All Rights Reserved.</td></tr>
		</table>
		
</body>
</html>
