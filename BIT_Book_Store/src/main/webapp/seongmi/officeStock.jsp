<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>


<title>재고관리</title>
<%@include file="officeAdminInclude.jspf"%>
</head>
<body>

	<div id="wrapper">

    <%@include file="adminSideBar.jspf"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

		  
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">지점에 등록된 도서를 조회할 수 있습니다.</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" style="width:100%, cellspacing:0">
                  <thead>
                    <tr>
                      <th>도서번호</th>
                      <th>카테고리</th>
                      <th>제목</th>
                      <th>저자</th>
                      <th>출판사</th>
                      <th>정가</th>
                      <th>판매가</th>
                      <th colspan="3">재고</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="bookList" items="${officeBookList }">
                  	<tr onclick="PopupBookInfo(this)">
                  		<td>${bookList.book_no }</td>
                  		<td>${bookList.category_no }</td>
                  		<td><!-- <a href="#bookInfo" data-toggle="modal"> -->
                  			${bookList.book_name }<!-- </a> --></td>
                  		<td>${bookList.book_writer }</td>
                  		<td>${bookList.book_publisher }</td>
                  		<td>${bookList.book_price }</td>
                  		<td>${bookList.book_saleprice }</td>
                  		<td style="text-align:justify;"><button type="button" class="btn" id="cntMinus" onclick="cntMinus()">-</button>
                  		<span>${bookList.cnt }</span>
                  		<button type="button" class="btn" id="cntPlus" onclick="cntPlus()">+</button></td>
                  		<input type="hidden" value="${bookList.book_info }">
                  		<input type="hidden" value="${bookList.book_published_date }">
                  		<input type="hidden" value="${bookList.book_total_page }">
                  		<input type="hidden" value="${bookList.book_entered_date }">
                  		<input type="hidden" value="${bookList.ebook }">
                  		<input type="hidden" value="${bookList.book_isbn }">
                  		<input type="hidden" value="${bookList.book_img }">
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
<!-- Page level plugins -->
<script src="${pageContext.request.contextPath}/resources/seongmiCss/vendor/datatables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/seongmiCss/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.request.contextPath}/resources/seongmiCss/js/demo/datatables-demo.js"></script>

<script>
$(document).ready(function () {
	document.getElementById("menu_name").innerHTML = "재고관리";
});
</script>
</body>
</html>