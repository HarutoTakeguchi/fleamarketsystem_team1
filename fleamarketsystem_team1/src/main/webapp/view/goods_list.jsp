<!-- 商品一覧画面 -->
<!-- 作成者　石井 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Book"%>
<html>
<head>
<title>商品一覧画面</title>
</head>
<body>
	<!-- header共通化 -->
	<%@ include file="/common/header.jsp"%>
	<hr
		style="text-align: center; height: 5px; background-color: blue; width: auto">

	<table style="margin: auto; width: 850px">
		<tr>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">メニュー</a>]
			</td>
			<td style="text-align: center; width: 508px; font-size: 24px;">商品一覧</td>
			<td style="width: 80px">&nbsp;</td>
			<td style="width: 80px">&nbsp;</td>
		</tr>
	</table>

	<hr
		style="text-align: center; height: 2px; background-color: black; width: auto">
	<div style="margin-bottom: 250px">

		<table style="margin: auto">
			<tr>
				<th style="background-color: #6666ff; width: 200px">商品名</th>
				<th style="background-color: #6666ff; width: 200px">商品情報</th>
			</tr>
			<%
			ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("Product_list");
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Product product = (Product) list.get(i);
			%>
			<tr>
				<td style="text-align: center; width: 200px"><%=product.getName()%></td>
				<td style="text-align: center; width: 200px"><%=product.getDescription()%></td>
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