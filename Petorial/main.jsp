<%@page import="com.hy.dto.UserDTO"%>
<%@page import="com.hy.dao.LikeDAO"%>
<%@page import="com.hy.dao.TagDAO"%>
<%@page import="com.hy.dto.CommentsDTO"%>
<%@page import="com.hy.dto.PhotoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	UserDTO user = (UserDTO) session.getAttribute("userinfo");
	String userid = (String) session.getAttribute("userid");
	List<PhotoDTO> photo = (List<PhotoDTO>) request.getAttribute("photo");
%>
<html>
<head>
    <title>Petorial</title>
    <link rel="stylesheet" href="css/main.css">
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/><!-- 
	<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" /> -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
		LikeDAO likeDao = new LikeDAO();
	  	//if(likeDao.likeCheck(user.getId_no(), tm_no))
	%>
	<!-- <script>
		 function chn() {
			var img1 = 'images/like_on.png';
			var img2 = 'images/like_off.png';
			if(document.getElementById('like-icon').src=img2)
				document.getElementById('like-icon').src = img1;
			else if(document.getElementById('like-icon').src=img1)
				document.getElementById('like-icon').src = img2;
		} -->
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
    <%
    	for(int i =photo.size()-1; i >=0; i--) {
 
    %>
            <div class="cards">
                <div id="cards-form">
                    <div class="profile">
                        <div class="profile_img">
                            <img src="<%=photo.get(i).getTm_userimg() %>" style="width: 50px;">
                        </div>
                        <div class="name">
                            <h5><%=photo.get(i).getTm_nick() %></h5>
                        </div>
                        <a id="kakao-link-btn" href="javascript:sendLink()">
                        	<img src="images/speech-bubble.png"
                        	style="width:30px;height:30px;margin-top:7px;"/></a>
                        <script type='text/javascript'>
					  //<![CDATA[
					    // // 사용할 앱의 JavaScript 키를 설정해 주세요.
					    Kakao.init('fa8067e5a45ccec81f60caf0e1baa778');
					    // // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
					    function sendLink() {
						      Kakao.Link.sendCustom({
						        templateId: 6856,
						        templateArgs: {
						          <%-- 'url' : ''+'<%=photo.get(i).getTm_img() %>' --%>
						          'title': '제목 영역입니다.',
						          'description': '설명 영역입니다.'
						        }
						      });
						    }
					  //]]>
					</script>	
                    </div>
                    <div class="picture">
                        <img src="<%=photo.get(i).getTm_img() %>" style="height: 400px; width: 398px; margin-left:0.5px;">
                    </div>
                    <div class="contents">
                        <p><%=photo.get(i).getTm_content() %></p>
                    </div>
                    <div style="position:absolute;top:628px;color:darkgray;font-size:0.65em;margin-left:8px;background-color:white;">[ Tag ]</div>
                    <div style="position:absolute;top:669px;color:darkgray;font-size:0.65em;margin-left:8px;background-color:white;">[ Comments ]</div>
                    <form id="likeForm" action="/Petorial/LikePushServlet" method="POST">
	                    <div class="heart">
	                    	<input type="hidden" name="tm_no" value="<%=photo.get(i).getTm_no() %>">
	                    	<Button type="submit"><img src="images/like_on.png" id="like-icon" name="like"></Button>
	                    	<p id="cnt"><%=photo.get(i).getLikes().size() %></p>
	                    </div>
                    </form>
                    <div style="float:left;height:40px;width:399px;border-top: dotted 1px darkgray;">
                    <% for(int j=0; j<photo.get(i).getTags().size(); j++) { %>
                    	<a href="#" id="card_tag" name="search" style="float:left;font-size:0.9em;">
                    		<%=photo.get(i).getTags().get(j).getTg_tag() %>
                    	</a>
                   	<% } %>
                    </div>
                               
                
                    <div class="comments" style="display:unset">
	                    	<%
                    		for(int j=photo.get(i).getComments().size()-1; j>=0; j--) {
                    		%>
	                    	<div id="comments-out">
	                    		<label><%=photo.get(i).getComments().get(j).getCm_nick() %></label>
		                    	<p>&nbsp;:&nbsp;&nbsp;<%=photo.get(i).getComments().get(j).getCm_text() %></p>
	                    	</div>
	                    	<%
                    		}
	                    	%>
	                </div>
	                <form id="comments-form" action="/Petorial/CommentsServlet" method="POST">
                    <div class="comments-insert">
	                    	<input type="hidden" name="tm_no" value="<%=photo.get(i).getTm_no() %>">
	                        <input type="text" name="comment" id="input-text" maxlength="30">
	                        <button><img src="images/enter-arrow.png"id="input-bt"></button>
	                </div>
	                </form>
                </div>
            </div>
            <%} %>    
    </div>
    <%@include file="/menu.jsp" %>
</body>
</html>