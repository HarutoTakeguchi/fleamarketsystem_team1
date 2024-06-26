<%-- 作成：畑 --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.SaleList,util.MyFormat"%>

<%
MyFormat format = new MyFormat();
%>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<title>出品一覧</title>

<style>
.title {
	border: 5px solid #85b9e9;
	background-color: #85b9e9;
	padding-top: 20px;
	text-align: center;
}

table {
	margin: 100px auto;
}

.odd {
	background: #444444;
}

th {
	background: #222222;
	color: white;
}

th, td {
	padding: 5px;
	font-size: small;
}

.even {
	background: #F2F2F2;
}

.hover {
	background: #B2D8FF;
}
</style>
</head>
<body style="background-color: #f0f8ff;">
	<%@include file="/common/header.jsp"%>
	<center>
		<h1 class="title">出品一覧</h1>
	</center>
	<table style="margin: auto; width: 850px">
		<tr>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/view/admin_menu.jsp">メニュー</a>]
			</td>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/userList">ユーザー一覧</a>]
			</td>
			<td style="text-align: center; width: 80px">[<a
				href="<%=request.getContextPath()%>/soldConfirm">売上確認</a>]
			</td>
			<td style="width: 80px">&nbsp;</td>
			<td style="width: 80px">&nbsp;</td>
		</tr>
	</table>
	<hr style="text-align: center; height: 5px; background-color: black">
	<br>
	<div style="margin-bottom: 250px">

		<div class="sale_list">
			<table style="margin: auto; width: 1000px">
				<tr>
					<th :style="background-color: #85b9e9; width: 80px">ユーザーID</th>
					<th :style="background-color: #85b9e9; width: 200px">ユーザーネーム</th>
					<th :style="background-color: #85b9e9; width: 120px">商品名</th>
					<th :style="background-color: #85b9e9; width: 50px">個数</th>
					<th :style="background-color: #85b9e9; width: 80px">金額</th>
					<th :style="background-color: #85b9e9; width: 80px">日付</th>
					<th :style="background-color: #85b9e9; width: 90px">取引状況</th>
				</tr>
				<%
				ArrayList<SaleList> list = (ArrayList<SaleList>) request.getAttribute("salelist");
				if (list != null) {
					for (SaleList salelist : list) {
				%>
				<tr>
					<td :style="text-align: center; width: 200px"><%=salelist.getUserid()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getUsername()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getProductname()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getQuantity()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getPrice()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getSelldate()%></td>
					<td :style="text-align: center; width: 200px"><%=salelist.getDealing()%></td>

				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
					<td :style="text-align: center; width: 200px">&nbsp;</td>
				</tr>
				<%
				}
				%>
			</table>

		</div>
	</div>


	<%@include file="/common/footer.jsp"%>

	<script>
		$(function() {
			$(".sale_list th:nth-child(odd)").addClass("odd");
			$(".sale_list tr:nth-child(even)").addClass("even");

			$(".sale_list tr:not(:first-child)").mouseover(function() {
				$(this).addClass("hover");
			}).mouseout(function() {
				$(this).removeClass("hover");
			});

			$(".sale_list td")
					.mouseover(
							function() {
								$(
										".sale_list td:nth-child("
												+ ($(".sale_list td").index(
														this)
														% $(".sale_list th").length + 1)
												+ ")").addClass("hover");
							})
					.mouseout(
							function() {
								$(
										".sale_list td:nth-child("
												+ ($(".sale_list td").index(
														this)
														% $(".sale_list th").length + 1)
												+ ")").removeClass("hover");
							});
		});
	</script>
</body>
</html>