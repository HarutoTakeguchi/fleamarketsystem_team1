<!-- 作成：畑 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<title>会員メニュー</title>
<style>
.title {
	border: 5px solid #66cdaa;
	background-color: #66cdaa;
	padding-top: 20px;
}
*{
	margin:0;
	padding:0;
}
#carouselWrap{
	margin:100px auto;
	width:620px;
	height:135px;
	padding:5px;
	background:url("./images/background.gif");
	position:relative;
}

#carouselPrev{
	position:absolute;
	top:65px;
	left:-40px;
	cursor:pointer;
}
#carouselNext{
	position:absolute;
	top:65px;
	right:70px;
	cursor:pointer;
}
#carouse{
	width:100%;
	height:100%;
	overflow:hidden;
}

#carouselInner ul.column{
	width:605px;
	height:105px;
	padding:15px 0 15px 15px;
	list-style-type:none;
	float:left;
}
#carouselInner ul.column li{
	float:left;
	margin-right:10px;
	display:inline;
}
#carouselInner ul.column li img{
	border:none;
}

img{
width: 100px;
height: 100px;
}
</style>
</head>

<body style="background-color: #f0fff0;">

	<%@ include file="/common/userInfo.jsp"%>
	<p style="text-align: center; font-size: 24px">menu</p>

	<center>
		<h1 class="title">会員メニュー</h1>
	</center>
	<table style="margin: auto;">
		<br>
		<br>
		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/productList">【商品一覧】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/view/productRegistration.jsp">【商品登録】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/purchaseStatus">【購入状況】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/saleStatus">【出品状況】</a></td>
		<tr>
			<td style="text-align: center; width: 200px">&nbsp;</td>
		</tr>
		</tr>

		<tr>
			<td style="font-size: 24px"><a
				href="<%=request.getContextPath()%>/logout">【ログアウト】</a></td>
		</tr>
	</table>

	<div id="carouselWrap">
			<p id="carouselPrev"><img src="./images/btn_prev.gif" alt="前へ"></p>
			<p id="carouselNext"><img src="./images/btn_next.gif" alt="次へ"></p>
			<div id="carouse">
				<div id="carouselInner">
					<ul class="column">
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/toy_racing_car.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/toy_menko.png" alt="menko"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/toy_hakoniwa.png" alt="hakoniwa"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/toy_glass_dome.png" alt="glass_dome"></a></li>
					</ul>
					<ul class="column">
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/syugei_resin_dome_accessory.png" alt="syugei_resin_dome_accessory"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/syugei_glass_dome_herbarium.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/robot_henkei.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/omocha_kendama.png" alt="car"></a></li>
					</ul>
					<ul class="column">
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/game_boardgame.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/game_pinball_machine.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/book_tobidasu_ehon.png" alt="car"></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/airplane_ornithopter.png" alt="car"></a></li>
					</ul>
				</div>
			</div>
		</div>
	<hr
		style="text-align: center; margin-top: 200px; height: 5px; background-color: black; max-width: 3000px">
	<table style="margin: auto; border: 0; width: 950px; text-align: left">
		<tr>
			<td>Copyright (C) 2024 All Rights Reserved.</td>
		</tr>
	</table>
	<script>
	$(function(){
		
		$("#carouselInner").css("width",620*$("#carouselInner ul.column").length+"px");
		$("#carouselInner ul.column:last").prependTo("#carouselInner");
		$("#carouselInner").css("margin-left","-620px");
		
		$("#carouselPrev").click(function(){
			$("#carouselNext,#carouselPrev").hide();
			$("#carouselInner").animate({
				"margin-left" : parseInt($("#carouselInner").css("margin-left"))+620+"px"
			},"slow","swing" , 
			function(){
				$("#carouselInner").css("margin-left","-620px")
				$("#carouselInner ul.column:last").prependTo("#carouselInner");
				$("#carouselNext,#carouselPrev").show();
			});
		});
		
		$("#carouselNext").click(function(){
			$("#carouselNext,#carouselPrev").hide();
			$("#carouselInner").animate({
				"margin-left" : parseInt($("#carouselInner").css("margin-left"))-620+"px"
			},"slow","swing" , 
			function(){
				$("#carouselInner").css("margin-left","-620px");
				$("#carouselInner ul.column:first").appendTo("#carouselInner");
				$("#carouselNext,#carouselPrev").show();
			});
		});
		
		var timerID = setInterval(function(){
			$("#carouselNext").click();
		},5000);
		
		$("#carouselPrev img,#carouselNext img").click(function(){
			clearInterval(timerID);
		});
		
	});
	</script>
</body>
</html>