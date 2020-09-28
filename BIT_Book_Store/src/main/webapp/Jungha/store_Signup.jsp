<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지점 회원가입</title>
<%@include file="/common/include.jspf"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signup.css">
</head>
<body>
	<div class="container-fluid mainPage">
	<%@include file="/common/header.jspf"%>
	<%@include file="/common/menuBar.jspf"%>
    <div class="row">
       <!-- 왼쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
        
        <!-- 본문영역 -->
        <div class="col-xl-8 col-md-8 mb-8 bg-light">

	<form action="" name="signup_frm">
		<h3>지점 회원가입</h3>
		<hr>
		<table>
			<tr>
				<td>
					<table class="table table-borderless">
						<tr>
							<th>비밀번호</th>
							<td>
								<div class="condition" id="pwd_check"></div>
								<input type="password" name="pwd" id="pwd">
							</td>
						</tr>
						<tr>
							<th>비밀번호 재입력</th>
							<td>
								<div class="condition" id="pwd_check2"></div>
								<input type="password" name="pwd2" id="pwd2">
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<div class="input-group-append">
									<input type="text" id="email_f" placeholder="이메일을 입력해주세요">
										<div class="input-group-text">@</div>
										<input type="text" id="email_b" size="17">
										<select id="email_select">
											<option value=0 selected>직접입력</option>
											<option value="gmail.com">gmail.com</option>
											<option value="naver.com">naver.com</option>
											<option value="nate.com">nate.com</option>
											<option value="daum.net">daum.net</option>
											<option value="hanmail.net">hanmail.net</option>
										</select>
										<input type="button" id="checkEmail" onclick="check_email()" value="인증코드 전송">
								</div>
								<div id="email_certification"></div>
								<span class="condition" id="emailResult"></span><br>
								<label><input type="checkbox" name="email_receive" value="1">이메일 수신 여부</label>
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>
								<select>
									<option value="02">02</option>
									<option value="051">051</option>
									<option value="053">053</option>
									<option value="032">032</option>
									<option value="062">062</option>
									<option value="042">042</option>
									<option value="052">052</option>
									<option value="044">044</option>
									<option value="031">031</option>
									<option value="033">033</option>
									<option value="043">043</option>
									<option value="041">041</option>
									<option value="063">063</option>
									<option value="061">061</option>
									<option value="054">054</option>
									<option value="055">055</option>
									<option value="064">064</option>
								</select>
								-<input type="number" name="phone4" min="0" max="4">
								-<input type="number" name="phone5" min="0" max="4">
							</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>
								<input type="date" name="birthday_year">
							</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<input type="number" id="zip_code" name="zip_code" disabled placeholder="우편번호"  max="5">
								<input type="button" value="우편번호 검색" onclick="search_address()" class="btn btn-secondary btn-sm">
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<input type="text" id="addr" name="addr" disabled placeholder="도로명 주소" size="60">
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<input type="text" id="lot_addr" name="lot_addr" onfocus="this.select()" placeholder="상세주소" size="60">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table id="terms">	
						<tr>
							<td colspan="2">
								<label><input type="checkbox" id="checkAll" value="all">모든 약관에 동의합니다.</label>
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<label><input type="checkbox" id="terms1" value="terms1" class="terms">이용약관</label>
								<a href="#" class="link" onclick="window.open('/biz/Jungha/detail/Terms_of_Use.jsp', 'blank', 'width=700, height=400, top=200, left=100, toolbar=no, menubar=no, scrollbars=yes, resizable=yes')">약관 전체보기</a>		
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<label><input type="checkbox" id="terms2" value="terms2" class="terms">커뮤니티 이용약관</label>
								<a href="#" class="link" onclick="window.open('/biz/Jungha/detail/Terms_of_CommunityUse.jsp', 'blank', 'width=700, height=400, top=200, left=100, toolbar=no, menubar=no, scrollbars=yes, resizable=yes')">약관 전체보기</a>				
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<label><input type="checkbox" id="terms3" value="terms3" class="terms">개인 정보 수집 및 이용</label>		
								<a href="#" class="link" onclick="window.open('/biz/Jungha/detail/Use_of_personal_information.jsp', 'blank', 'width=700, height=400, top=200, left=100, toolbar=no, menubar=no, scrollbars=yes, resizable=yes')">내용보기</a>		
							</td>
						</tr>
					</table>
				</td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" class="btn btn-outline-danger">
				</td>
			</tr>
		</table>
	</form>
	
	</div>
      <!-- 오른쪽 사이드바 -->
        <div class="col-xl-2 col-md-2 mb-2"></div>
    </div>
</div>
<%@include file="/common/footer.jspf"%>
</body>
</html>