<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문관리페이지</title>
<%@include file="officeAdminInclude.jspf"%>
</head>
<body>
<div id="wrapper">
    <%@include file="adminSideBar.jspf"%>
    
<div id="content-wrapper" class="d-flex flex-column">
	<!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">지점에 들어온 주문을 조회할 수 있습니다.</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>주문번호</th>
                      <th>주문하위번호</th>
                      <th>아이디</th>
                      <th>이름</th>
                      <th>연락처</th>
                      <th>주문날짜</th>
                      <th>책제목</th>
                      <th>판매가</th>
                      <th>수량</th>
                      <th>판매금액</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="order" items="${orderList }">
                  	<tr>
                  		<td>${order.order_no }</td>
                  		<td><a href="../orderDetailShow.do">${order.order_b_no }</a></td>
                  		<td>${order.order_user_id }</td>
                  		<td>${order.order_recv_name }</td>
                  		<td>${order.order_recv_phone }</td>
                  		<td>${order.order_date }</td>
                  		<td>${order.book_name }</td>
                  		<td>${order.book_saleprice }</td>
                  		<td>${order.order_b_cnt }</td>
                  		<td>${order.book_saleprice * order.order_b_cnt }</td>
                  	</tr>
                  </c:forEach>
                  </tbody>
                  
                    
                    
                </table>
              </div>
            </div>
            <div>
            	
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>

</div>

<div class="modal fade" id="orderInfo">
	<div class="modal-dialog">
		<div class="modal-content">
		<div class="modal-header" class="center">
			<h4 id="book_name">
			<!-- <button type="button" class="close" data-dismiss="modal">×</button> -->
			</h4>
		</div>
		<div class="modal-body">
		<table class="table">
			<tr>
				<td rowspan="5" width=30%><img id="book_img"></td>
				<th width=30% class="center">번호</th>
				<td width=40%><p id="book_no"></p></td>
			</tr>
		</table>
		</div>
		
		<div class="modal-footer">
		<input type="hidden" id="book_no_text">
          <button type="button" class="btn btn-info" onclick="bookModify()">Modify</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
		</div>
	</div>
</div>


  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/seongmiCss/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/resources/seongmiCss/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/seongmiCss/js/demo/datatables-demo.js"></script>

<script>
$(document).ready(function () {
	document.getElementById("menu_name").innerHTML = "주문내역조회";
});
</script>
</body>
</html>