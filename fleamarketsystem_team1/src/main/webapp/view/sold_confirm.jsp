<%--作成者小澤 --%>
<%@page contentType = "text/html; charset=UTF-8"%>
<%@page import = "java.util.ArrayList,bean.Sale,util.MyFormat" %>
<%
ArrayList<Sale> sale_list = (ArrayList<Sale>) request.getAttribute("sale_list");
		MyFormat format = new MyFormat();
%>
<html>
	<head>
		<title>売上確認</title>
		<style>
			.title {
				border: 5px solid #85b9e9;
				background-color: #85b9e9;
				padding-top: 20px;
				text-align:center;
			}

		</style>
	</head>
	<body style="background-color:#f0f8ff;">
		<h1 class="title">売上確認</h1>


		<table style="margin:auto; width:850px">
			<tr>
				<td style="text-align:center; width:100px">[<a href="">管理者メニュー</a>]</td>	
				<td style="text-align:center; width:100px">[<a href="">ユーザー一覧</a>]</td>	
				<td style="text-align:center; width:60px">[<a href="">出品一覧</a>]</td>
				<td style="width:100px">&nbsp;</td>
				<td style="width:200px">&nbsp;</td>
			</tr>
		</table>
		<hr style="text-align:center; height:5px; background-color:black">
		<br>

		<table style="margin:auto; width:1000px">
			<tr>
				<th style="background-color:#85b9e9; width:80px">ユーザーID</th>
				<th style="background-color:#85b9e9; width:120px">商品名</th>
				<th style="background-color:#85b9e9; width:50px">個数</th>
				<th style="background-color:#85b9e9; width:80px">金額</th>
				<th style="background-color:#85b9e9; width:80px">日付</th>
				<th style="background-color:#85b9e9; width:90px">システム利用料</th>
			</tr>
				<%
				if(sale_list != null){
					for(int i=0; i<sale_list.size(); i++){
						Sale sales = (Sale)sale_list.get(i);
				%>
			
			<tr>
			<td style="text-align:center; width:100px"><%=sales.getUser_id() %></td>
			<td style="text-align:center; width:100px"><%=sales.getName() %></td>
			<td style="text-align:center; width:100px"><%=sales.getQuantity()%></td>
			<td style="text-align:center; width:100px"><%=sales.getPrice() %></td>
			<td style="text-align:center; width:100px"><%=sales.getSold_date() %></td>
			<td style="text-align:center; width:100px"><%=sales.getPrice() %>*0.1</td>
			</tr>
			<%
				}
			} else {
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
			

		
	</body>
</html>