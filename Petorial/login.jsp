<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   Cookie[] cookie = request.getCookies();
   String cid = ""; 
   if(cookie != null) {
      for(int i=0; i<cookie.length; i++) {
         if(cookie[i].getName().trim().equals("cid")) {
            cid = cookie[i].getValue();
         }
      }
   }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Petorial</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <script>
            function login(){
                document.getElementById('login-form').style.display="";
                document.getElementById('register-form').style.display="none";
                document.getElementById('forgot-password-form').style.display="none";
            }
            function register(){
                document.getElementById('register-form').style.display="";
                document.getElementById('login-form').style.display="none";
                document.getElementById('forgot-password-form').style.display="none";
            }
            function forgot(){
                document.getElementById('login-form').style.display="none";
                document.getElementById('forgot-password-form').style.display="";
                document.getElementById('register-form').style.display="none";
            }
        </script>
</head>
<body>
<center>
    <div id="login_logo" style="margin-top:140px;">
        <img src="images/dog_cat.png" style="height:200px;width: 200px; margin-bottom:50px;"></img>
    </div>
</center>
<!-- LOGIN FORM -->
<center>
    <div class="login-form-1">
        <form id="login-form" class="text-left" style="display: unset;" action="/Petorial/LoginServlet" method="POST">
            <div class="logo">login</div>
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="lg_username" class="sr-only">E-mail</label><br>
                        <input type="text" class="form-control" id="lg_username" name="email" value="<%=cid %>">
                    </div>
                    <div class="form-group">
                        <label for="lg_password" class="sr-only">Password</label>
                        <input type="password" class="form-control" id="lg_password" name="pw">
                    </div>
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" id="lg_remember" name="remember" <%if(cid.length()>1) out.println("checked"); %>>
                        <label for="lg_remember">remember</label>
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right">Go!</i></button>
            </div>
            <div class="etc-login-form">
                <p>forgot your password? <a href="javascript:forgot()">click here</a></p>
                <p>new user? <a href="javascript:register()">create new account</a></p>
            </div>
            <a id="custom-login-btn" href="javascript:loginWithKakao()">
				<img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="300"/>
			</a>
			<script type='text/javascript'>
			  //<![CDATA[
			    // 사용할 앱의 JavaScript 키를 설정해 주세요.
			    Kakao.init('fa8067e5a45ccec81f60caf0e1baa778');
			    function loginWithKakao() {
			      // 로그인 창을 띄웁니다.
			      Kakao.Auth.login({
			        success: function(authObj) {
			        	location.href= "/Petorial/TimelineServlet"
			        },
			        fail: function(err) {
			          alert(JSON.stringify(err));
			        }
			      });
			    };
			  //]]>
			</script>
        </form>
    </div>
    </div>
    <!--register Form-->
    <div class="login-form-1">
        <form id="register-form" class="text-left" style="display: none; margin-top: -10px;" action="/Petorial/RegistServlet" method="POST" enctype="multipart/form-data">
            <div class="logo">register</div>
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                	<div class="form-group">
                        <input type="file" class="form-control" id="image" name="image" style="margin-left: 10px;">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="reg_username" name="email" placeholder="email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="reg_password" name="pw" placeholder="password">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="reg_password_confirm" name="pwcheck" placeholder="confirm password">
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" id="reg_email" name="birth" placeholder="birth">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="reg_fullname" name="nickname" placeholder="Nick_name">
                    </div>
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" class="" id="reg_agree" name="reg_agree">
                        <label for="reg_agree">i agree with <a href="#">terms</a></label>
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right">Go!</i></button>
            </div>
            <div class="etc-login-form">
                <p>already have an account?</p>
                <a href="javascript:login()">login here</a>
            </div>
        </form>
    </div>

    <div class="login-form-1">
        <form id="forgot-password-form" class="text-left" style="display: none">
            <div class="logo">forgot password</div>
            <div class="etc-login-form">
                <p>When you fill in your registered email address, you will be sent instructions on how to reset your password.</p>
            </div>
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="fp_email" class="sr-only">Email address</label>
                        <input type="text" class="form-control" id="fp_email" name="fp_email" placeholder="email address">
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right">Go!</i></button>
            </div>
            <div class="etc-login-form">
                <p>already have an account?</p> <a href="javascript:login()">login here</a>
                <p>new user? <a href="javascript:register();">create new account</a></p>
            </div>
        </form>
    </div>
    </div>
</center>
</div>
        <!--<footer>
            <p>Petorial<br>졸업작품_웹디자인<br>20131284 컴퓨터공학과 최현영</p>
        </footer>-->

</body>