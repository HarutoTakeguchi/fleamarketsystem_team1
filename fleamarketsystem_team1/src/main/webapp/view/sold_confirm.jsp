<%--作成者小澤 --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Sale,util.MyFormat"%>
<%
MyFormat format = new MyFormat();
%>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<title>売上確認</title>
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
		<h1 class="title">売上確認</h1>
	</center>

	<div style="margin-bottom: 250px">
		<table style="margin: auto; width: 850px">
			<tr>
				<td style="text-align: center; width: 100px">[<a
					href="<%=request.getContextPath()%>/view/admin_menu.jsp">管理者メニュー</a>]
				</td>
				<td style="text-align: center; width: 100px">[<a
					href="<%=request.getContextPath()%>/userList">ユーザー一覧</a>]
				</td>
				<td style="text-align: center; width: 60px">[<a
					href="<%=request.getContextPath()%>/saleList">出品一覧</a>]
				</td>
				<td style="width: 100px">&nbsp;</td>
				<td style="width: 200px">&nbsp;</td>
			</tr>
		</table>
		<hr style="text-align: center; height: 5px; background-color: black">
		<br>

		<div class="sold_confirm">
			<table style="margin: auto; width: 1000px">
				<tr>
					<th class="a" :style="background-color: #85b9e9; width: 80px">ユーザーID</th>
					<th class="a" :style="background-color: #85b9e9; width: 120px">商品名</th>
					<th class="a" :style="background-color: #85b9e9; width: 50px">個数</th>
					<th class="a" :style="background-color: #85b9e9; width: 80px">金額</th>
					<th class="a" :style="background-color: #85b9e9; width: 80px">日付</th>
					<th class="a" :style="background-color: #85b9e9; width: 90px">システム利用料</th>
				</tr>
				<%
				ArrayList<Sale> sale_list = (ArrayList<Sale>) request.getAttribute("sale_list");
				if (sale_list != null) {
					for (int i = 0; i < sale_list.size(); i++) {
						Sale sales = (Sale) sale_list.get(i);
				%>

				<tr>
					<td style="text-align: center; width: 100px"><%=sales.getUser_id()%></td>
					<td style="text-align: center; width: 100px"><%=sales.getName()%></td>
					<td style="text-align: center; width: 100px"><%=sales.getQuantity()%></td>
					<td style="text-align: center; width: 100px"><%=sales.getPrice()%></td>
					<td style="text-align: center; width: 100px"><%=sales.getSold_date()%></td>
					<td style="text-align: center; width: 100px"><%=sales.getPrice()%>*0.1</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
				</tr>

				<%
				}
				%>
			</table>
		</div>

		<%@include file="/common/footer.jsp"%>

		<script>
			$(function() {
				$(".sold_confirm th:nth-child(odd)").addClass("odd");
				$(".sold_confirm tr:nth-child(even)").addClass("even");

				$(".sold_confirm tr:not(:first-child)").mouseover(function() {
					$(this).addClass("hover");
				}).mouseout(function() {
					$(this).removeClass("hover");
				});

				$(".sold_confirm  td")
						.mouseover(
								function() {
									$(
											".sold_confirm  td:nth-child("
													+ ($(".sold_confirm  td")
															.index(this)
															% $(".sold_confirm  th").length + 1)
													+ ")").addClass("hover");
								})
						.mouseout(
								function() {
									$(
											".sold_confirm  td:nth-child("
													+ ($(".sold_confirm  td")
															.index(this)
															% $(".sold_confirm  th").length + 1)
													+ ")").removeClass("hover");
								});
			});
		</script>
</body>
</html>