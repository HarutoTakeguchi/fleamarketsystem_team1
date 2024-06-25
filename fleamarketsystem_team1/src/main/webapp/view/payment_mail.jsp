<%@page contentType="text/html; charset=UTF-8"%>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>入金メール</title>
<style>
.title {
border: 5px solid #66cdaa;
background-color: #66cdaa;
padding-top: 20px;

}

</style>
</head>
<body style="background-color:#f0fff0;">
<center><h1 class="title">入金メール</h1><br></center>

 <table style="margin: auto">


<h3 style="text-align: center;">入金しました。</h3>

</table>

<table style="margin: auto; padding: 100px;">

<tr style="margin: auto">
<th><a href ="<%=request.getContextPath()%>/view/purchase_status.jsp">戻る</a></th>
</tr>

</table>


</body>
</html>