<!-- 作成：畑 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,util.MyFormat"%>

<%
MyFormat format = new MyFormat();
%>

<html>
<head>
<meta charset="UTF-8">

<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<title>ユーザー一覧</title>

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
		<h1 class="title">ユーザー一覧</h1>
	</center>

	<div style="margin-bottom: 250px">
		<table style="margin: auto; width: 850px">
			<tr>
				<td style="text-align: center; width: 100px">[<a
					href="<%=request.getContextPath()%>/view/admin_menu.jsp">管理者メニュー</a>]
				</td>
				<td style="text-align: center; width: 60px">[<a
					href="<%=request.getContextPath()%>/saleList">出品一覧</a>]
				</td>
				<td style="text-align: center; width: 60px">[<a
					href="<%=request.getContextPath()%>/soldConfirm">売上確認</a>]
				</td>
				<td style="width: 100px">&nbsp;</td>
				<td style="width: 200px">&nbsp;</td>
			</tr>
		</table>
		<hr style="text-align: center; height: 5px; background-color: black">
		<br>

		<table style="margin: auto; width: 1000px">
			<tr class="c">
				<th class="b" :style="background-color: #85b9e9; width: 80px">ユーザーID</th>
				<th class="b" :style="background-color: #85b9e9; width: 100px">ユーザーネーム</th>
				<th class="b" :style="background-color: #85b9e9; width: 80px">氏名</th>
				<th class="b" :style="background-color: #85b9e9; width: 50px">年齢</th>
				<th class="b" :style="background-color: #85b9e9; width: 120px">住所</th>
				<th class="b" :style="background-color: #85b9e9; width: 120px">メールアドレス</th>
				<th class="b" :style="background-color: #85b9e9; width: 120px">パスワード</th>
				<th class="b" :style="background-color: #85b9e9; width: 120px">取引状況</th>
			</tr>

			<%
			ArrayList<User> list = (ArrayList<User>) request.getAttribute("user_list");
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					User user = (User) list.get(i);
			%>
			<tr class="c">
				<td class="a" :style="text-align: center; width: 200px"><%=user.getUserid()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getUsername()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getName()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getAge()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getAddress()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getEmail()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getPassword()%></td>
				<td class="a" :style="text-align: center; width: 200px"><%=user.getDealing()%></td>

				<%
				}
				} else {
				%>
			
			<tr class="c">
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
				<td class="a" :style="text-align: center; width: 200px">&nbsp;</td>
			</tr>
			<%
			}
			%>

			</div>
		</table>

		<%@include file="/common/footer.jsp"%>

		<script>
			$(function() {
				$(".b:nth-child(odd)").addClass("odd");
				$(".c:nth-child(even)").addClass("even");

				$(".c:not(:first-child)").mouseover(function() {
					$(this).addClass("hover");
				}).mouseout(function() {
					$(this).removeClass("hover");
				});

				$(".a")
						.mouseover(
								function() {
									$(
											".a:nth-child("
													+ ($(".a").index(this)
															% $(".b").length + 1)
													+ ")").addClass("hover");
								})
						.mouseout(
								function() {
									$(
											".a:nth-child("
													+ ($(".a").index(this)
															% $(".b").length + 1)
													+ ")").removeClass("hover");
								});
			});
		</script>
</body>
</html>