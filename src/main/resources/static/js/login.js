$(window, document, undefined)
		.ready(
				function() {
					function validateAccount() {
						var account = $("#account").val();
						if(account == ""){
							$("#validateLoginMsg").show();
							$("#validateLoginMsg").text("请输入账号");
							$("#validateLoginMsg").css("color", "red")
						}
						
					}
					
					function doLogin() {
						console.log("aaaaaaaaaaaaaaaaaa")
						var loginAccount = $('#account').val();
						if (loginAccount.trim() == "") {
							$("#validateLoginMsg").show();
							$("#validateLoginMsg").text("请输入账号");
							$("#validateLoginMsg").css("color", "red")
							return false;
						}
						var password = $('#password').val();

						if (password == "") {
							$("#validateLoginMsg").show();
							$("#validateLoginMsg").text("密码不能为空");
							$("#validateLoginMsg").css("color", "red");
							return false;
						}

						requestLogin(loginAccount, password);
						return false;
					}
					function requestLogin(loginAccount, password) {
						var obj = {};
						obj.loginAccount = loginAccount;
						obj.pwd = password;
						console.log("“dd”")
//						obj = JSON.stringify(obj);
						$.ajax({
							url : "api/login/",
							data : obj,
							type : "post",
							contentType : "application/x-www-form-urlencoded", // 重要！不以json格式接收时，post时用该content-Type
							success : function(result) {
								for ( var key in result) {
									console.log(key + ":" + result.key)
								}
								if (result.code == 0) {
									location.href = "index";
								} else {
									$("#validateLoginMsg").show();
									$("#validateLoginMsg").text(result.result.message);
									$("#validateLoginMsg").css("color", "red")
								}
							}
						});
					}
					$("#account").bind("change", validateAccount);
					$("#doLogin").bind("click", doLogin);
				})