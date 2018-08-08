<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Petorial</title>
    <link rel="stylesheet" href="css/photo.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'><!-- 
	<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <div id="all">
        <form id="upload-form" action="/Petorial/WriteServlet" method="post" enctype="multipart/form-data">
            <div id="upload">
                <div id="select">
                    <button class="w3-button" id="select-bt" style="border-top-left-radius:9px; background-color:darkgray;color:white;">img
                    </button>
                    <button class="w3-button" id="select-bt" style="border-top-right-radius:9px;">shop
                    </button>
                </div>
                <div id="preview">
                    <img src="#" id="preview-img" style="width:498px; overflow:hidden;">
                </div>
                <div id="upload-bottom">
                    <div id="img-upload">
                        <input type="file" style="margin: 0 25px;"id="img" name="img" >
                    </div>
                    <div id="upload_contents">
                        <textarea placeholder="text를 입력하세요." name="content" id="up-content"></textarea>
                        <input type="text" id="tag_upload" style="margin: 5px 25px; width:450px;" placeholder="#tag" name="tag">
                    </div>
                </div>
            </div>
            <button type="submit" class="w3-button" id="submit-bt">Upload</button>
        </form>
    </div>
    <%@include file="/menu.jsp" %>
</body>
</html>