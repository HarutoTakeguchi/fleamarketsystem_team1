<!-- 作成：後藤 -->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bms.Product"%>
<html lang = "ja">
	<head>
		<title>list</title>
	</head>
	<body>
		<%@include file= "/common/header.jsp" %>
		

		<table style="margin:auto; width:850px">
			<tr>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/view/admin_menu.jsp">メニュー</a>]</td>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/userList">ユーザー一覧</a>]</td>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/saleConfirmation">売上確認</a>]</td>
				<td style="text-align:center; width:508px; font-size:24px;">出品一覧</td>
				<td style="width:80px">&nbsp;</td>
				<td style="width:80px">&nbsp;</td>
			</tr>
		</table>

		<div style="margin-bottom:250px">


			<table style="margin:auto">
				<tr>
					<th style="background-color:#6666ff; width:200px">ユーザーID</th>
					<th style="background-color:#6666ff; width:200px">ユーザーネーム</th>
					<th style="background-color:#6666ff; width:200px">商品名</th>
					<th style="background-color:#6666ff; width:200px">個数</th>
					<th style="background-color:#6666ff; width:200px">金額</th>
					<th style="background-color:#6666ff; width:200px">日付</th>
					<th style="background-color:#6666ff; width:200px">取引状況</th>
				</tr>
				<%
				ArrayList<Book> list =(ArrayList<Book>)request.getAttribute("/list");
				if(list != null){
					for(int i=0;i<list.size();i++){
						Product product = (Product)list.get(i);
				%>
				<tr>
					<td style="text-align:center; width:200px"><%=user.getUserid()%></td>
					<td style="text-align:center; width:200px"><%=user.getUsername()%></td>
					<td style="text-align:center; width:200px"><%=user.getName()%></td>
					<td style="text-align:center; width:200px"><%=user.getQuantity()%></td>
					<td style="text-align:center; width:200px"><%=user.getPrice()%></td>
					<td style="text-align:center; width:200px"><%=user.getSell_date()%></td>
					<td style="text-align:center; width:200px"><%=user.getDealing()%></td>
					
				</tr>
				<%
					}
				}else{
				%>
				<tr>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:250px" colspan="2">&nbsp;</td>
				</tr>
				<%
				}
				%>
			</table>

		</div>

		
		<%@include file= "/common/footer.jsp" %>
		
	</body>
</html>