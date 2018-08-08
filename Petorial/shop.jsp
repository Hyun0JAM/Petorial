<%@page import="com.hy.dto.CommentsDTO"%>
<%@page import="com.hy.dto.PhotoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String userid = (String) session.getAttribute("userid");
	List<PhotoDTO> photo = (List<PhotoDTO>) session.getAttribute("photo");
%>
<html>
<head>
    <title>Petorial</title>
    <link rel="stylesheet" href="css/shop.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script>
		function chn() {
			var img1 = 'images/like_on.png';
			document.getElementById('like-icon').src = img1;
		}
	</script>
</head>
<body>
	<div id="top">
        <div id="top-bar">
            <div class="top-menu">
                <img src="images/pawprint.png">
            </div>
            <center>
                <div class="top-search">
                <form action="/Petorial/TimelineServlet" method="POST">
                    <input type="text" id="search" name="search" placeholder="Search">
                    <button type="submit" style="width:20px;height:20px;">
                    	<img src="images/magnifier.png" id="search-icon">
                    </button>
                </form>
                </div>
            </center>
            <div class="top-menu">
                <a href="/Petorial/MyPageServlet"><img src="images/profile.png" id="menu-icon"></a>
                <a href="login.jsp"><img src="images/logout.png" id="menu-icon"></a>
            </div>
        </div>
    </div>
    <div id="all" style="width:1000px;">
    	<form id="shop_card_form" style="margin:30px auto;float:left;">
			<div id="shop_card_left">
				<img src="images/petstuff.jpg<%-- <%=shop.get(i).getSh_img%> --%>" id="stuff-img">
			</div>
			<div id="shop_card_right">
				<div id="stuff-title" class="shop_card_group">애완견 목줄 팝니다.<%-- <%=shop.get(i).getSh_title%> --%>
				</div>
				<div id="like-icon" class="shop_card_group"><img src="images/like_off.png" id="like_icon" style="width:30px;height:30px;"">
				</div>
		        <div id="stuff-price" class="shop_card_group">$100
		        </div>
				<div id="stuff-explane" class="shop_card_group">explane....
				</div>
	    	</div>
		</form>
		<form id="shop_card_form" style="margin:30px auto;float:left;">
			<div id="shop_card_left">
				<img src="images/petstuff.jpg<%-- <%=shop.get(i).getSh_img%> --%>" id="stuff-img">
			</div>
			<div id="shop_card_right">
				<div id="stuff-title" class="shop_card_group">애완견 목줄 팝니다.<%-- <%=shop.get(i).getSh_title%> --%>
				</div>
				<div id="like-icon" class="shop_card_group"><img src="images/like_off.png" id="like_icon" style="width:30px;height:30px;"">
				</div>
		        <div id="stuff-price" class="shop_card_group">$100
		        </div>
				<div id="stuff-explane" class="shop_card_group">explane....
				</div>
	    	</div>
		</form>
	</div>
    <%@include file="/menu.jsp" %>
</body>
</html>