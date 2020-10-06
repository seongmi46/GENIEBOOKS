<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head> 
<meta charset="utf-8"> 
<title>메인화면</title>
<%@include file="/common/include.jspf"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link rel="stylesheet" href="../resources/raeCss/css/header.css">
<link rel="stylesheet" href="../resources/raeCss/css/footer.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
	.bestSeller > ul {list-style: none;}
	.newRelease > ul {list-style: none;}
	.steadySeller > ul {list-style: none;}
	.bestSeller > ul > li {float: left;}
	.steadySeller > ul > li {float: left;}
	.bigFont {font-size: 2em;}
	.midFont {font-size: 1.5em; margin-top: 8px;}
	.bestSellerBook {width: 800px; height: 600px; margin: auto;}
	.steadySellerBook {width: 800px; height: 600px; margin: auto;}
	.newReleaseBook {width: 800px; height: 600px; margin: auto;}
	td {width: 800px;}
</style> 
<script> 

	$(document).ready(function(){ 
	    var main = $('.bxslider').bxSlider({ 
		    mode: 'fade', 
		    auto: true,	//자동으로 슬라이드 
		    controls : true,	//좌우 화살표	
		    autoControls: true,	//stop,play 
		    pager:true,	//페이징 
		    pause: 5000, 
		    autoDelay: 0,	
		    slideWidth: 800, //이미지 박스 크기설정
		    speed: 1000, 
		    stopAutoOnclick:true 
		}); 

		$(".bx-stop").click(function(){	// 중지버튼 눌렀을때 
		    main.stopAuto(); 
		    $(".bx-stop").hide(); 
		    $(".bx-start").show(); 
		    return false; 
		}); 
	
		$(".bx-start").click(function(){	//시작버튼 눌렀을때 
		    main.startAuto(); 
		    $(".bx-start").hide(); 
		    $(".bx-stop").show(); 
		    return false; 
		}); 
	
		  $(".bx-start").hide();	//onload시 시작버튼 숨김. 
	}); 

</script> 

</head> 
<body> 
<%@include file="/common/header.jspf"%>
<%@include file="/common/menuBar.jspf"%>
<%@include file="/common/bookClass.jspf"%>
<div class="container-fluid mainPage">
    <div class="row">
       <!-- 왼쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
        
        <!-- 본문영역 -->
        <div class="col-xl-8 col-md-8 mb-8 bg-light">

	<!-- 메인화면- 이달의 추천 도서 -->
    <div>
        <ul class="bxslider">
        	<!-- 나중에 이미지마다 링크 연결해야됨 -->
            <li><a href="#"><img src="../resources/raeCss/images/sample01.jpg" width="800" height="400"></a></li>
            <li><a href="#"><img src="../resources/raeCss/images/sample02.jpg" width="800" height="400"></a></li>
            <li><a href="#"><img src="../resources/raeCss/images/sample03.jpg" width="800" height="400"></a></li>
            <li><a href="#"><img src="../resources/raeCss/images/sample04.jpg" width="800" height="400"></a></li>
        </ul>
    </div>
    <br>

	<!-- 메인화면 - 베스트셀러 -->
	<div class="bestSellerMenu">
		<div class="bestSeller">
			<ul>
				<li class="bigFont"><a href="bestMonth.jsp">베스트셀러</a>&nbsp;</li>  <!-- 베스트셀러 창으로 가는 링크 -->
				<li class="midFont"><a href="#">국내도서</a>&nbsp;|&nbsp;</li>  <!-- 국내도서 베스트셀러 목록 보여주기 (베스트셀러 창으로 가는건 아님) -->
				<li class="midFont"><a href="#">외국도서</a>&nbsp;|&nbsp;</li> <!-- 외국도서 베스트셀러 목록 보여주기 (베스트셀러 창으로 가는건 아님) -->
				<li class="midFont"><a href="#">ebook</a></li>  <!-- ebook 베스트셀러 목록 보여주기 (베스트셀러 창으로 가는건 아님) -->
			</ul>
		</div>	
		<br><br>
		
		<div class="bestSellerBook">
			<table border>
				<tr>
					<td><a href="#"><img src="../resources/raeCss/images/여름.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/고도를기다리며.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/노생거사원.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/폭풍의언덕.jpg" width="150"></a></td>
				</tr>
			</table>
			<br><br>
			<table border>
				<tr>
					<td><a href="#"><img src="../resources/raeCss/images/달과6펜스.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/싯다르타.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/에마.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/자기만의방.jpg" width="150"></a></td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 메인화면 - 신간도서 -->
	<div class="newReleaseMenu">
		<div class="newRelease">
			<ul>
				<li class="bigFont"><a href="newBook.jsp">신간도서</a></li>
			</ul>
		</div>
		
		<div class="newReleaseBook">
			<table border>
				<tr>
					<td><a href="#"><img src="../resources/raeCss/images/다른방식으로보기.jpg" width="200"
					></a></td>  <!-- 메인 신간도서 (크기 좀 크게) -->
					<td><a href="#"><img src="../resources/raeCss/images/스토너.jpg" width="150"></a></td>  
					<td><a href="#"><img src="../resources/raeCss/images/아침에는죽음을.jpg" width="150"></a></td>  
					<td><a href="#"><img src="../resources/raeCss/images/타인의고통.jpg" width="150"></a></td>  
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 메인화면 - 스테디셀러 -->
	<div class="steadySellerMenu">
		<div class="steadySeller">
			<ul>
				<li class="bigFont"><a href="steady.jsp">스테디셀러</a>&nbsp;</li>  <!-- 스테디셀러 창으로 가는 링크 -->
				<li class="midFont"><a href="#">국내도서</a>&nbsp;|&nbsp;</li>  <!-- 국내도서 스테디셀러 목록 보여주기 (스테디셀러 창으로 가는건 아님) -->
				<li class="midFont"><a href="#">외국도서</a>&nbsp;|&nbsp;</li> <!-- 외국도서 스테디셀러 목록 보여주기 (스테디셀러 창으로 가는건 아님) -->
				<li class="midFont"><a href="#">ebook</a></li>  <!-- ebook 스테디셀러 목록 보여주기 (스테디셀러 창으로 가는건 아님) -->
			</ul>
		</div>	
		<br><br>
		
		<div class="steadySellerBook">
			<table border>
				<tr>
					<td><a href="#"><img src="../resources/raeCss/images/레몬.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/비행운.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/예감은틀리지않는다.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/보건교사안은영.jpg" width="150"></a></td>
				</tr>
			</table>
			<br><br>
			<table border>
				<tr>
					<td><a href="#"><img src="../resources/raeCss/images/모순.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/당신이남긴증오.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/날씨가좋으면.jpg" width="150"></a></td>
					<td><a href="#"><img src="../resources/raeCss/images/빛의과거.jpg" width="150"></a></td>
				</tr>
			</table>
		</div>
	</div>







      	</div>
      
      <!-- 오른쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
    </div>
    
</div>


<div>
<%@include file="/common/footer.jspf"%>
</div>
</body> 
</html>