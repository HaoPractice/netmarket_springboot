$(window, document, undefined)
		.ready(
				function() {

					function validateEmail() {
						var inputAddr = $("#regAccount").val();
						if (inputAddr.trim() == "") {
							$("#validateEmailMsg").hide();
						} else if (!isEmailAddr(inputAddr)) {
							$("#validateEmailMsg").show();
							$("#validateEmailMsg").text("error email addr")
							$("#validateEmailMsg").css("color", "red")
						} else {
							validateByServer(inputAddr);
						}
					}

					function validateByServer(addr) {
						$.get("api/account/isValidEmail", {
							m : addr
						}, function(result) {
							if (result.data) {
								$("#validateEmailMsg").show();
								$("#validateEmailMsg").text("valid email addr")
								$("#validateEmailMsg").css("color", "green")
							} else {
								$("#validateEmailMsg").show();
								$("#validateEmailMsg").text(
										"email had been used")
								$("#validateEmailMsg").css("color", "red")
							}
						});
					}

					function isEmailAddr(email) {
						var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
						var isValidEmail = re.test(email);
						return isValidEmail;
					}
					function validatePwd() {

						var pwd1 = $("#regPassword").val();
						var pwd2 = $("#regPassword2").val();
						if (pwd1 != pwd2) {
							$("#validatePwdMsg").show();
							$("#validatePwdMsg").text("两次输入密码必须相等");
							$("#validatePwdMsg").css("color", "red");
							return false;
						} else {
							$("#validatePwdMsg").hide();
							return true;
						}
					}

					function doRegister() {
						var inputAddr = $("#regAccount").val();
						if (inputAddr.trim() == "") {
							$("#validateRegMsg").show();
							$("#validateRegMsg").text("请输入邮箱");
							$("#validateRegMsg").css("color", "red")
							return false;
						} else if (!isEmailAddr(inputAddr)) {
							$("#validateRegMsg").show();
							$("#validateRegMsg").text("邮箱输入有误")
							$("#validateRegMsg").css("color", "red")
							return false;
						} 
						var pwd1 = $("#regPassword").val();
						var pwd2 = $("#regPassword2").val();
						
						if(pwd1 != pwd2){
							$("#validateRegMsg").show();
							$("#validateRegMsg").text("两次输入密码必须相等");
							$("#validateRegMsg").css("color", "red");
							
							return false;
						} else if(pwd1 == ""){
							$("#validateRegMsg").show();
							$("#validateRegMsg").text("密码不能为空");
							$("#validateRegMsg").css("color", "red");
							return false;
						}
						
						var nickname = $('#nickname').val();
						var username = $('#regAccount').val();
						var password = $('#regPassword').val();
						var obj = {};
						obj.bindMail = username;
						obj.username = nickname;
						obj.password = password;

						obj = JSON.stringify(obj);
						$.ajax({
							url : "api/regist",
							data : obj,
							type : "post",
							contentType : "application/json",
							success : function(result) {
								for ( var key in result) {
									console.log(key+":"+result.key)
								}
								if (result.code == 0) {
									requestLogin(username,password);
								} else {
									$("#validateRegMsg").show();
									$("#validateRegMsg").text(result.msg);
									$("#validateRegMsg").css("color", "red")
								}
							}
						});
						return false;
					}
					function requestLogin(username,password){
						
						
						
						location.href = "index";
					}
					
					$("#regAccount").bind("change", validateEmail);
					$("#regPassword2").bind("change", validatePwd);
					$("#doReg").bind("click", doRegister);
				})