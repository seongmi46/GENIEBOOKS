<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 화면</title>
<%@include file="/common/include.jspf" %>
<%@include file="/common/header.jspf" %>
<%@include file="/common/include.jspf" %>
<%@include file="/common/cartMenuBar.jspf" %>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
      p { margin:40px 0px; }
      #sangpumjungbo th {
      	background-color: #F2F2F2;
      	height: 60px;
      	text-align: center;
      }
      
      #sangpumgumek td{
      	padding-left: 20px;
      	border-right: 6px dotted LightGray;
      	
      }
      
      #sangpumgumek th {
      	background-color: #F2F2F2;
      	padding-left: 20px;
      	height: 60px;
      	border-right: 6px dotted LightGray;
      	
      	
      }
      
      #sangpumgumek th:last-child{
      	border-right:none;
      }
      
      #sangpumgumek td:last-child{
      	border-right:none;
      }
      #genieIlbanbesong {
      	font-size: 1.5em;
      	color:  #5F0E1F;
      	font-weight: 600;
      }
      
   
	
	//
	.order_bar {
   background-color: #9F5252;
   height: 80px;
   font-size: 40px;
   color: white;
}

.middle{
   vertical-align: middle;
}

.align-left {
   float: right;
}

.order_bar .order-img {
   vertical-align: middle;
   width: 80px;
   height: 80px;
   
}

.space-img {
   vertical-align: middle;
   width: 0;
   height: 0;
   border-left: 40px solid #9F5252;
   border-top: 40px solid transparent;
   border-bottom: 40px solid transparent;
	}

	.order_bar span{
	   display: inline-block;
	}
	a {
	   cursor: pointer;
	}
	
	#btn1 {
		width:300px; height:50px; color:#474747;
		background-color: white;
		border: 0.5px solid lightGray;
		font-weight: bold;
		font-size: 1.2em;
	}
	#btn2 {
		width:300px; height:50px; color:white;
		background-color: #9F5252;
		border:none;
		font-weight: bold;
		font-size: 1.2em;
	}
	
	#lastT th {
		width:1400px;
		padding-left: 20px;
		padding-top: 20px;
		padding-bottom: 20px;
		
	}
	#lastT td {
		padding-left: 20px;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	
	#lastTfirstTh {
		font-size:1.4em;
		font-weight:bold;
		padding-left:20px;
	}
	#lastT2 {
		width:1400px;
		
		
	}
	#lastT2 th {
        border-right: 0.8px solid lightGray;
        padding-left: 20px;
		padding-top: 10px;
		padding-bottom: 10px;
        
    }
    #lastT2 td {
        border-right: 0.8px solid lightGray;
        padding-left: 20px;
		padding-top: 10px;
		padding-bottom: 10px;
    }
    #lastT2 th:last-child{
    	border-right:none;
    }
    #lastT2 td:last-child{
    	border-right:none;
    }
    #lastT2 td {
    	height: 10px;
    	color: #999999;
    }
    
</style>
<script>
	function gobookDetail(){
		/* location.href="bookDetail.jsp?book_no=${}"; */
	}
</script>

</head>


<body>

<br><br>
<hr>
<body>
	<div class="container-fluid mainPage">
    
      <div class="row">
      <!-- 왼쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
        
        <!-- 본문영역 -->
        <div class="col-xl-8 col-md-8 mb-8 bg-light">
        <div class="container-fluid">
               <div class="row">
                   
                   <div class="col-sm-8 order_bar">
                      <div class="align-left">
                        
                        
                     
                     </div>
                  </div>
               </div>
            </div>
	    <div class="row">
        <div class="col">
          <br><br><br>
            <ul class="nav nav-tabs">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#qwe">일반배송(상품갯수)</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#asd">바로드림(상품갯수)</a>
              </li>
              
            </ul>
            <div class="tab-content">
              <div class="tab-pane fade show active" id="qwe">
              	<br>
                <input type="checkbox"> 전체선택 &nbsp;&nbsp;<input type="button" value="삭제">
                <br><br><br><br>
                <input type="checkbox">&nbsp;<a id="genieIlbanbesong">&nbsp;지니일반배송(상품갯수)</a> &nbsp;&nbsp;
                <input type="button" value="바로드림 이동">
                 <br><br>
                 <table border id="sangpumjungbo">
                 	<tr>
                 		<th style="width:800px;">
                 			상품정보
                 		</th>
                 		<th style="width:200px;">
                 			판매가
                 		</th>
                 		<th style="width:200px;">
                 			수량
                 		</th>
                 		<th style="width:200px;">
                 			합계
                 		</th>
                 	</tr>
                 	
					<tr>
						<td style="padding-up:20px; background-color:yellow;">
							<input type="checkbox">
							&nbsp;<img src="/biz/resources/images/pic/심판.jpg" style="width:200px; padding-left:40px; 
									padding-up:70px;">
							<span style="font-weight: bold">&nbsp;&nbsp;&nbsp;[국외도서] 심판</span>
							<span><input type="button" value="새창보기" onclick="gobookDetail()"></span>
							<br><br>
							
						</td>
						<td style="line-height:40px">
					
							<span style="text-decoration:line-through">18,000원(원가) </span><br>
							<span>판매가격[10% ↓]</span><br>
							<span>000P</span>
							
						</td>
						<td style="padding-left:20px">
							<input type="number" value="1" style="width:80px">
							<input type="button" value="변경">
						</td>
						<td style="padding-left:20px">
							00,000원(합계)
						</td>
					</tr>                 	
                 </table>
                 <br>
                 <hr>
                 <br>
                 <input type="checkbox">&nbsp;전체선택&nbsp;&nbsp;<input type="button" value="삭제">
                 <br><br>
                 <table id="sangpumgumek">
              	<tr>
              		<th style="width:600px;">상품금액</th>
              		<th style="width:300px;">배송비</th>
              		<th style="width:200px;">결제 예정금액</th>
              		<th style="width:100px; border-right:none">적립예정</th>
              		<th style="width:200px;">000원P</th>
              	</tr>
              	<tr>
              		<td>00,000원</td>
              		<td>0원(배송비)</td>
              		<td>00,000원(결제예정)</td>
              		<td style="height:80px; padding-top: 20px; padding-bottom:20px; border-right:none">
              			<span>기본적립</span><br>
              			<span>추가적립</span><br>
              			<span>회원혜택</span>
              		</td>
              		<td style="height:80px; padding-top: 20px; padding-bottom:20px">
              			<span>000원P</span><br>
              			<span>0원P</span><br>
              			<span>0원P</span>
              		</td>
              	</tr>
              </table>
              <hr><br>
	              <span style="float:right; padding-left:40px;">
		              <input type="button" value="선물하기" id="btn1" style="border-radius: 10px 10px;">
		              <input type="button" value="주문하기" id="btn2" style="border-radius: 10px 10px;">
	              </span>
              </div>
              
              
              <%-- 바로드림 시작 --%>
              <br>
                <input type="checkbox"> 전체선택 &nbsp;&nbsp;<input type="button" value="삭제">
                <br><br><br><br>
              <div class="tab-pane fade" id="asd">
                <br>
                <input type="checkbox">&nbsp;<a id="genieIlbanbesong">&nbsp;지니일반배송(상품갯수)</a> &nbsp;&nbsp;
                <input type="button" value="바로드림 이동">
                 <br><br>
                 <table border id="sangpumjungbo">
                 	<tr>
                 		<th style="width:800px;">
                 			상품정보
                 		</th>
                 		<th style="width:200px;">
                 			판매가
                 		</th>
                 		<th style="width:200px;">
                 			수량
                 		</th>
                 		<th style="width:200px;">
                 			합계
                 		</th>
                 	</tr>
                 	
					<tr>
						<td style="padding-up:20px">
							<input type="checkbox">
							&nbsp;<img src="../resources/images/pic/bookp.jpg" style="width:200px; padding-left:40px; 
									padding-up:40px;">
							<span style="font-weight: bold">&nbsp;&nbsp;&nbsp;[국외도서] 심판</span>
							<span><input type="button" value="새창보기"></span>
							<br><br>
							
						</td>
						<td style="line-height:40px">
					
							<span style="text-decoration:line-through">18,000원(원가) </span><br>
							<span>판매가격[00% ↓]</span><br>
							<span>000P</span>
							
						</td>
						<td style="padding-left:20px">
							<input type="number" value="1" style="width:80px">
							<input type="button" value="변경">
						</td>
						<td style="padding-left:20px">
							00,000원(합계)
						</td>
					</tr>                 	
                 </table>
                 <br>
                 <hr>
                 <br>
                 <input type="checkbox">&nbsp;전체선택&nbsp;&nbsp;<input type="button" value="삭제">
                 <br><br>
                 <table id="sangpumgumek">
              	<tr>
              		<th style="width:600px;">상품금액</th>
              		<th style="width:300px;">배송비</th>
              		<th style="width:200px;">결제 예정금액</th>
              		<th style="width:100px; border-right:none">적립예정</th>
              		<th style="width:200px;">000원P</th>
              	</tr>
              	<tr>
              		<td>00,000원</td>
              		<td>0원(배송비)</td>
              		<td>00,000원(결제예정)</td>
              		<td style="height:80px; padding-top: 20px; padding-bottom:20px; border-right:none">
              			<span>기본적립</span><br>
              			<span>추가적립</span><br>
              			<span>회원혜택</span>
              		</td>
              		<td style="height:80px; padding-top: 20px; padding-bottom:20px">
              			<span>000원P</span><br>
              			<span>0원P</span><br>
              			<span>0원P</span>
              		</td>
              	</tr>
              </table>
              <hr><br>
	              <span style="float:right; padding-left:40px;">
		              <input type="button" value="선물하기" id="btn1" style="border-radius: 10px 10px;">
		              <input type="button" value="주문하기" id="btn2" style="border-radius: 10px 10px;">
	              </span>
              </div>
              <br><br><br><br>
              </div>
              <br><br><br>
              <hr>
              </div><!-- tabcontent end -->
              
              <%--배송 유의 사항  --%>
              <table id="lastT">
              	<tr>
              		<th id="lastTfirstTh">배송 유의사항 및 이용 혜택 안내</th>
              		<th>
              			<a href=#none id="show" onclick="if(hide.style.display=='none')
              				{hide.style.display='';show.innerText='접기'}
              			else {hide.style.display='none';show.innerText='펼치기'}"
              			style="float:left"
              			>펼치기</a>
              		</th>
              		<th>&nbsp;&nbsp;</th>
              		<th><span style="float:right; padding-right:20px;">
              		<input type="button" value="주문/결제FAQ" style="color:blue; background-color:white"></span></th>
              	</tr>
              	</table>
              	
              	<div id="hide" style="display: none">
              	<table id="lastT2">
              	<tr style="font-weight:bold; font-size: 1.2em">
              		<th>배송 및 배송비</th>
              		<th>해외주문도서</th>
              		<th>바로드림</th>
              		<th>혜택 및 기타안내</th>
              	</tr>
              
              	<tr>
              		<td><a>배송일정</a></td>
              		<td><a>해외주문 유의사항</a></td>
              		<td><a>바로드림 이용 안내</a></td>
              		<td><a>적립예정 통합포인트</a></td>
              	</tr>
              	<tr>
              		<td><a>당일배송 유의사항</a></td>
              		<td><a>해외주문 반품/취소 안내</a></td>
              		<td><a>바로드림 수령예정일 안내</a></td>
              		<td><a>도서 소득공제 안내</a></td>
              	</tr>
              	<tr>
              		<td><a>배송비 안내</a></td>
              		<td>&nbsp;&nbsp;</td>
              		<td><a>바로드림 불가 안내</a></td>
              		<td><a>장바구니 이용 안내</a></td>
              	</tr>
              </table>
              <br><br><br>
              </div>
              
           
        </div><!-- col div end -->
      </div><!-- row div end -->
    
    </div>
     <!-- 오른쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</div>
	
	






<%@include file="/common/footer.jspf" %>
</body>
</html>