<!-- 作成者：竹口 -->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<title>会員登録</title>
<style>
.title {
	border: 5px solid #66cdaa;
	background-color: orange;
	padding-top: 20px;
}

#container {
	width: 600px;
	margin: 0 auto;
	padding: 20px;
	background: white;
}

h1 {
	margin-top: 20px;
	font-size: large;
	color: #7CADB6;
}

dl dt {
	border-left: 5px solid #7CADB6;
	border-bottom: 1px solid #7CADB6;
	font-size: small;
	margin: 0;
	padding: 5px;
}

dl dt span {
	color: red;
	font-weight: bold;
}

dl dd {
	font-size: small;
	margin: 0;
	padding: 10px;
}

dl dd input {
	position: relative;
	z-index: 2;
}

dl dd label {
	position: relative;
	padding: 5px 5px 5px 25px;
	margin: 0 5px 0 -25px;
	margin-left: -25px;
	position: relative;
	z-index: 1;
}

dl dd.error input, dl dd.error textarea, dl dd.error label {
	background: #FFCCCC;
}

* html dl dd.error label {
	background: none;
}

*+html dl dd.error label {
	background: none;
}

dl dd p.error {
	margin: 0;
	color: red;
	font-weight: bold;
	margin-bottom: 1em;
}
</style>
</head>
<body style="background: darkgray">

	<!-- ヘッダー部分 -->
	<%@ include file="/common/header.jsp"%>

	<!-- ナビゲーション  -->
	<div id="nav">
		<ul>
			<li><a href="<%=request.getContextPath()%>/view/login.jsp">[ログイン画面]</a></li>
		</ul>
	</div>

	<!-- ページタイトル -->
	<div id="page_title">
		<center>
			<h2>会員登録</h2>
		</center>
	</div>

	<!-- 会員登録コンテンツ部分 -->
	<div id="container">
		<!--  入力フォーム -->
		<form action="<%=request.getContextPath()%>/memberRegistration">
			<dl>
				<dt>
					ユーザー名<span>※</span>
				</dt>
				<dd>
					<input type="text" name="user_name" size="80"
						class="validate required">
				</dd>
				<dt>
					パスワード<span>※</span>
				</dt>
				<dd>
					<input type="text" name="password" size="80"
						class="validate required">
				</dd>
				<dt>
					氏名<span>※</span>
					</th>
				<dd>
					<input type="text" name="name" size="80" class="validate required">
				</dd>
				<dt>
					年齢<span>※</span>
					</th>
				<dd>
					<input type="text" name="age" size="80" class="validate required">
				</dd>
				<dt>
					住所<span>※</span>
					</th>
				<dd>
					<input type="text" name="address" size="80"
						class="validate required">
				</dd>
				<dt>
					メールアドレス<span>※</span>
					</th>
				<dd>
					<input type="text" name="email" size="80" class="validate required">
				</dd>
			</dl>
			<p>
			<center>
				<input type="submit" value="登録">
			</center>
			</p>
		</form>
	</div>

	<!-- フッター部分 -->
	<%@ include file="/common/footer.jsp"%>

	</div>
	<script>
		$(function() {
			$("form")
					.submit(
							function() {

								//エラーの初期化
								$("p.error").remove();
								$("dl dd").removeClass("error");

								$(
										"input[type='text'].validate,textarea.validate")
										.each(
												function() {

													//必須項目のチェック
													if ($(this).hasClass(
															"required")) {
														if ($(this).val() == "") {
															$(this)
																	.parent()
																	.prepend(
																			"<p class='error'>必須項目です</p>");
														}
													}

													//数値のチェック
													if ($(this).hasClass(
															"number")) {
														if (isNaN($(this).val())) {
															$(this)
																	.parent()
																	.prepend(
																			"<p class='error'>数値のみ入力可能です</p>");
														}
													}

													//メールアドレスのチェック
													if ($(this)
															.hasClass("mail")) {
														if ($(this).val()
																&& !$(this)
																		.val()
																		.match(
																				/.+@.+\..+/g)) {
															$(this)
																	.parent()
																	.prepend(
																			"<p class='error'>メールアドレスの形式が異なります</p>");
														}
													}

													//メールアドレス確認のチェック
													if ($(this).hasClass(
															"mail_check")) {
														if ($(this).val()
																&& $(this)
																		.val() != $(
																		"input[name="
																				+ $(
																						this)
																						.attr(
																								"name")
																						.replace(
																								/^(.+)_check$/,
																								"$1")
																				+ "]")
																		.val()) {
															$(this)
																	.parent()
																	.prepend(
																			"<p class='error'>メールアドレスと内容が異なります</p>");
														}
													}

												});

								//ラジオボタンのチェック
								$("input[type='radio'].validate.required")
										.each(
												function() {

													if ($("input[name="
															+ $(this).attr(
																	"name")
															+ "]:checked").length == 0) {
														$(this)
																.parent()
																.prepend(
																		"<p class='error'>選択してください</p>");
													}
												});

								//チェックボックスのチェック
								$(".checkboxRequired")
										.each(
												function() {
													if ($(":checked", this).length == 0) {
														$(this)
																.prepend(
																		"<p class='error'>選択してください</p>");
													}
												});

								// その他項目のチェック
								$(".validate.add_text")
										.each(
												function() {
													if ($(this).prop("checked")
															&& $(
																	"input[name="
																			+ $(
																					this)
																					.attr(
																							"name")
																					.replace(
																							/^(.+)$/,
																							"$1_text")
																			+ "]")
																	.val() == "") {
														$(this)
																.parent()
																.prepend(
																		"<p class='error'>その他の項目を入力してください。</p>");
													}
												});

								//エラーの際の処理
								if ($("p.error").length > 0) {
									$('html,body').animate(
											{
												scrollTop : $("p.error:first")
														.offset().top - 40
											}, 'slow');
									$("p.error").parent().addClass("error");
									return false;
								}
							});
		});
	</script>
</body>
</html>