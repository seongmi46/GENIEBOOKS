<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@include file="/common/include.jspf"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signup.css">
<script>
	var availID = 0;
	var idChecked = 0;

	$().ready(function(){
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")){
				$(".terms").each(function(){
					$(this).prop("checked", true);
				});
			} else {
				$(".terms").each(function(){
					$(this).prop("checked", false);
				});
			}
		});
		
		$(".terms").click(function(){
			if($(".terms:checked").length == 3){
				$("#checkAll").prop("checked", true);
			} else {
				$("#checkAll").prop("checked", false);
			}
		});
		
		$("#email_select").click(function(){
			if($("#email_select option:selected").val() == "0"){
				$("#email_b").prop("disabled", false);
				$("#email_b").val("");
			} else {
				$("#email_b").prop("disabled", true);
				$("#email_b").val($("#email_select option:selected").val());
			}
		});
		
		$("#id").blur(function(){
			var id = $("#id").val();
			var regType1 = /^[A-Za-z0-9!@#$%^*+=-_]*$/;
			
			if(id.length < 5){
				$("#id_check").text("아이디를 5자 이상 입력해주세요.");
				availID = 0;
				idChecked = 0;
			}else if (!regType1.test(id)) { 
				$("#id_check").text("아이디는 알파벳 대소문자와 숫자, !@#$%^*+=-_로 이루어져야 합니다.");
				idChecked = 0;
				availID = 0;
			}else {
				$("#id_check").text("사용 가능한 아이디입니다. 중복 체크를 해주세요.");
				availID = 1;
				idChecked = 0;
			}
			
			if(availID == 0){
				$("#duplicate_check").prop("disabled", true);
			}else {
				$("#duplicate_check").prop("disabled", false);
			}
			
		});
		
		$("#pwd").blur(function(){
			var pwd = $("#pwd").val();
			var num = pwd.search(/[0-9]/g);
			var eng = pwd.search(/[a-z]/ig);
			var spe = pwd.search(/[!@#$%^*+=-_]/gi);
			
			if(pwd.length < 8 || pwd.length > 20){
				$("#pwd_check").text("8자리 이상 20자리 이내로 입력해주세요.");
				$("#pwd").val("");
				$("#pwd2").val("");
			} else if (pwd.search(/\s/)!= -1){
				$("#pwd_check").text("비밀번호는 공백 없이 입력해주세요.");
				$("#pwd").val("");
				$("#pwd2").val("");
			} else if (num < 0 || eng < 0 || spe < 0){
				$("#pwd_check").text("영문, 숫자, 특수문자(!@#$%^*+=-_)를 혼합하여 입력해주세요.");
				$("#pwd").val("");
				$("#pwd2").val("");
			} else {
				$("#pwd_check").text("사용 가능한 비밀번호 입니다.");
				$("#pwd2").val("");
			}
		});
		
		$("#pwd2").blur(function(){
			var pwd = $("#pwd").val();
			var pwd2 = $("#pwd2").val();
			
			if(pwd == pwd2){
				$("#pwd_check2").text("비밀번호가 일치합니다.");
			} else {
				$("#pwd_check2").text("비밀번호가 일치하지 않습니다.");
				$("#pwd2").val("");
			}
			
		});
		
	});
	
	function checkId(){
		//var id = $("#id").val();
		$.ajax({
			url: "../ID_Check.do",
			type : "POST",
			dataType: "text",
			contentType : "text/plain; charset=utf-8;",
			data : $("#id").val(),

			success: function(data){
				if(data == 1){
					$("#checkIdResult").text("이미 사용 중인 아이디입니다.");
					idChecked = 0;
				}else{
					$("#checkIdResult").text("사용가능한 아이디입니다.");
					$("#id_check").text("");
					idChecked = 1;
				}
				
			},
			error : function(){
				alert("[예외발생]");
			}
		});
	}
	
	function check_email() {
		var email_f = $("#email_f").val().trim();
		var email_b = $("#email_b").val().trim();
		
		if(email_f != "" && email_b != ""){
			var email =  email_f + '@' + email_b;
			console.log("email : " + email);
			
			var key; //인증키
			var bool = true;
			
			if(bool) {
				$.ajax({
					url: "../emailAuth.do",
					type : "POST",
					dataType: "text",
					contentType : "text/plain; charset=utf-8;",
					data : email,
		
					success: function(result){
						alert("인증번호가 발송되었습니다!");
						key = result;
						bool = false;
					},
					error : function(){
						alert("[예외발생]");
					}
				}); //ajax
				
				$("#email_certification").addClass("input-group-text");
				var text = '<b>인증코드 입력 :&nbsp;&nbsp;</b>'
					+'<input type="text" id="cer_num" placeholder="인증코드 입력">'
					+'<input type="button" id="getCernum" value="확인">'
				$("#email_certification").html(text);
				
				$("#getCernum").click(function(){
					var userContent = $("#cer_num").val();
					console.log("userContent : " + userContent);
					
					if(userContent == key){
						$("#emailResult").text("인증되었습니다!");
						//나중에 비활성화 넣기
					} else {
						$("#emailResult").text("인증번호가 틀렸습니다!");
					}
				});
				
			} else {
				
			}
		} else {
			alert("이메일을 입력해주세요!");
		}
	}
	
	//우편번호검색 API
	function search_address() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                console.log("시작");

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = data.roadAddress; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                addr += extraAddr;

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zip_code').value = data.zonecode;
                document.getElementById('addr').value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('lot_addr').focus();
            }
        }).open();
    }
	
	
</script>
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
		<h3>회원가입</h3>
		<hr>
		<table>
			<tr>
				<td>
					<table class="table table-borderless">
						<tr>
							<th>이름</th>
							<td>
								<input type="text" name="name" placeholder="이름을 입력해주세요">
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>
								<div class="condition" id="id_check"></div>
								<input type="text" id="id" name="id" placeholder="아이디를 입력해주세요">
								<input type="button" id="duplicate_check" onclick="checkId()" disabled value="아이디 중복 체크">
								<span class="condition" id="checkIdResult"></span>
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
							<th>휴대전화</th>
							<td>
								<input type="number" name="phone1" min="0" max="4">-
								<input type="number" name="phone1" min="0" max="4">-
								<input type="number" name="phone3" min="0" max="4">
								<br>
								<label><input type="checkbox" name="sms_receive" value="1">문자 수신 여부</label>
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