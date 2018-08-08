<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Petorial</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
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
        <div id="card_row">
            <div class="cards">
                <form id="cards-form">
                    <div class="profile">
                        <div class="profile_img">
                            <img src="images/profile2.jpg" style="width: 50px;">
                        </div>
                        <div class="name">
                            <h5>daiunii</h5>
                        </div>
                    </div>
                    <div class="picture">
                        <img src="images/ex1.jpg" id="tm_img"">
                    </div>
                    <div class="contents">
                        <p>contents explane sleepy<br>...<br>#graduation #computer_engineering</p>
                    </div>
                    <div class="comments-view">
                    </div>
                    <button class="w3-button" name="comments" id="show-button">Show Comments</button>
                    <div class="comments-insert" style="display: none">
                        <label for="comments">MyId</label>
                        <input type="text" name="comments">
                    </div>
                </form>
            </div>
            <div class="cards">
                <form id="cards-form">
                    <div class="profile">
                        <div class="profile_img">
                            <img src="images/profile2.jpg" style="width: 50px;">
                        </div>
                        <div class="name">
                            <h5>daiunii</h5>
                        </div>
                    </div>
                    <div class="picture">
                        <img src="images/ex2.jpg" id="tm_img">
                    </div>
                    <div class="contents">
                        <p>contents explane sleepy<br>...<br>#graduation #computer_engineering</p>
                    </div>
                    <div class="comments-view">
                    </div>
                    <button class="w3-button" name="comments" id="show-button">Show Comments</button>
                    <div class="comments-insert" style="display: none">
                        <label for="comments">MyId</label>
                        <input type="text" name="comments">
                    </div>
                </form>
            </div>
        </div>
        <div id="card_row">
            <div class="cards">
                <form id="cards-form">
                    <div class="profile">
                        <div class="profile_img">
                            <img src="images/profile2.jpg" style="width: 50px;">
                        </div>
                        <div class="name">
                            <h5>daiunii</h5>
                        </div>
                    </div>
                    <div class="picture">
                        <img src="images/ex3.jpg" id="tm_img"">
                    </div>
                    <div class="contents">
                        <p>contents explane sleepy<br>...<br>#graduation #computer_engineering</p>
                    </div>
                    <div class="comments-view">
                    </div>
                    <button class="w3-button" name="comments" id="show-button">Show Comments</button>
                    <div class="comments-insert" style="display: none">
                        <label for="comments">MyId</label>
                        <input type="text" name="comments">
                    </div>
                </form>
            </div>
            <div class="cards">
                <form id="cards-form">
                    <div class="profile">
                        <div class="profile_img">
                            <img src="images/profile2.jpg" style="width: 50px;">
                        </div>
                        <div class="name">
                            <h5>daiunii</h5>
                        </div>
                    </div>
                    <div class="picture">
                        <img src="images/ex4.jpg" id="tm_img">
                    </div>
                    <div class="contents">
                        <p>contents explane sleepy<br>...<br>#graduation #computer_engineering</p>
                    </div>
                    <div class="comments-view">
                    </div>
                    <button class="w3-button" name="comments" id="show-button">Show Comments</button>
                    <div class="comments-insert" style="display: none">
                        <label for="comments">MyId</label>
                        <input type="text" name="comments">
                    </div>
                </form>
            </div>
        </div>
        </div>
    </div>
    <%@include file="/menu.jsp" %>
</body>
</html>