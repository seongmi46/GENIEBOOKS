<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>


<title>월별매출</title>
<%@include file="officeAdminInclude.jspf"%>
</head>
<script>

	var chartLabels = [];
	var chartData = [];
	
	var today = new Date();
	var year = today.getFullYear();
	
	var startDate = year + '-01-01';
	var endDate = year + '-12-31';
	console.log(startDate + "   " + endDate);
	
	$.getJSON("monthSales.do", {
		startDate : startDate,
		endDate : endDate
	},function(data){
		$('#tbody').html("");
		$.each(data, function(key, value){
			chartLabels.push(value.mm);
			chartData.push(value.monTOT);
			$('#tbody').append("<tr>");
			$('#tbody').append("<td width=50%>" + value.mm + "</td>");
			$('#tbody').append("<td width=50%>" + value.monTOT + "</td>");
			$('#tbody').append("</tr>");
			
		});
		
		lineChartData = {
			labels : chartLabels,
			datasets : [
				{
					label: "월별 매출",
					fillColor : "rbga(151,187,205,0.2)",
					backgroundColor:"#bfdaf9",
	                borderColor: "#80b6f4",
	                pointBorderColor: "#80b6f4",
	                pointBackgroundColor: "#80b6f4",
	                pointHoverBackgroundColor: "#80b6f4",
	                pointHoverBorderColor: "#80b6f4",
	                fill: false,
	                borderWidth: 4,
	                data : chartData
				}
			]
		}
		createChart();
	});

		
		
	function createChart(){
		var ctx = document.getElementById("monthTOTChart").getContext("2d");
		LineChartDemo = Chart.Line(ctx,{
			data : lineChartData,
			option :{
				scales :{
					yAxes :[{
						ticks :{
							beginAtZero: true
						}
					}]
				}
			}
		})
		
	}
	
	function yearSelect(){
		chartLabels = [];
		chartData = [];
		var year = $('#year').val();
		console.log(year);
		startDate = year + '-01-01';
		endDate = year + '-12-31';
		console.log(startDate + "   " + endDate);
		$.getJSON("monthSales.do", {
			startDate : startDate,
			endDate : endDate
		},function(data){
			$('#tbody').html("");
			$.each(data, function(key, value){
				chartLabels.push(value.mm);
				chartData.push(value.monTOT);
				$('#tbody').append("<tr>");
				$('#tbody').append("<td width=50%>" + value.mm + "</td>")
				$('#tbody').append("<td width=50%>" + value.monTOT + "</td>")
				$('#tbody').append("</tr>")
			});
			
			lineChartData = {
				labels : chartLabels,
				datasets : [
					{
						label: "월별 매출",
						fillColor : "rbga(151,187,205,0.2)",
						backgroundColor:"#bfdaf9",
		                borderColor: "#80b6f4",
		                pointBorderColor: "#80b6f4",
		                pointBackgroundColor: "#80b6f4",
		                pointHoverBackgroundColor: "#80b6f4",
		                pointHoverBorderColor: "#80b6f4",
		                fill: false,
		                borderWidth: 4,
		                data : chartData
					}
				]
			}
			createChart();
		});
	}
	

	/*	$.ajax({
			type: 'POST',
			url: 'monthSales.do',
			dataType: "json",
			data: {startDate : startDate,
				   endDate : endDate},
			success: function(result){
				$.each(result, function(inx, obj){
					chartLabels.push(obj.mm);
					chartData.push(obj.monTOT);
				});
				createChart();
				console.log("create Chart");

			}
		});
	});*/
	
	
	
	/*$.getJSON("monthSales.do", function(data){
		$.each(data, function(inx, obj){
			chartLabels.push(obj.mm);
			chartData.push(obj.monTOT);
		});
		createChart();
		console.log("create Chart");
		
	});*/
	
	
	/*var myLineChart = new Chart(ctx, {
		labels : chartLabels,
		datasets : [
			{
				label: "월별 매출",
				fillColor : "rbga(151,187,205,0.2)",
				backgroundColor:"#bfdaf9",
                borderColor: "#80b6f4",
                pointBorderColor: "#80b6f4",
                pointBackgroundColor: "#80b6f4",
                pointHoverBackgroundColor: "#80b6f4",
                pointHoverBorderColor: "#80b6f4",
                fill: false,
                borderWidth: 4,
                data : chartData
			}
		]
	});*/
	
	/*var lineChartData = {
		labels : chartLabels,
		datasets : [
			{
				label: "월별 매출",
				fillColor : "rbga(151,187,205,0.2)",
				backgroundColor:"#bfdaf9",
                borderColor: "#80b6f4",
                pointBorderColor: "#80b6f4",
                pointBackgroundColor: "#80b6f4",
                pointHoverBackgroundColor: "#80b6f4",
                pointHoverBorderColor: "#80b6f4",
                fill: false,
                borderWidth: 4,
                data : chartData
			}
		]
			
	}

	function createChart(){
		var ctx = document.getElementById("monthTOTChart").getContext("2d");
		LineChartDemo = Chart.Line(ctx,{
			data : lineChartData,
			option :{
				scales :{
					yAxes :[{
						ticks :{
							beginAtZero: true
						}
					}]
				}
			}
		})
		
	}
	
	function yearSelect(){
		chartLabels = [];
		chartData = [];
		var year = $('#year').val();
		console.log(year);
		var startDate = year + '-01-01';
		var endDate = year + '-12-31';
		console.log(startDate + "   " + endDate);
		$.ajax({
			type: 'POST',
			url: 'monthSales.do',
			dataType: "json",
			data: {startDate : startDate,
				   endDate : endDate},
			success: function(result){
				$.each(result, function(inx, obj){
					console.log("mm : " + obj.mm + " tot: " + obj.monTOT);
					chartLabels.push(obj.mm);
					chartData.push(obj.monTOT);
				});
				console.log(chartLabels);
				LineChartDemo.destroy();
				createChart();
				console.log("create Chart");

			}
		});
	}*/ 
</script>

<body>

	<div id="wrapper">

    <%@include file="adminSideBar.jspf"%>

    <!-- Content Wrapper -->
    <!-- <div id="content-wrapper" class="d-flex flex-column"> -->

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

		  
          <!-- DataTales Example -->
          <!-- Area Chart -->
            <div class="col-xl-12 col-lg-12"> 
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">월별매출</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </div>
                </div> 
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="monthTOTChart" height="80"></canvas>
                  </div>
                </div>
              </div>
            </div>
            
            
          <!--   <div class="col-xl-12 col-lg-12">  -->
            <div class="card shadow mb-4">
            <div class="card-body">
              <p align="right">
              	<select name="year" id="year" onchange="yearSelect(this)">
              		<option value="2020">2020</option>
              		<option value="2019">2019</option>
              		<option value="2018">2018</option>
              	</select>
              </p>
              <div class="table-responsive">
                <table class="table table-bordered" id="monthSales" style="width:100%, cellspacing:0">
                  <thead>
                    <tr>
                      <th>월</th>
                      <th>매출</th>
                    </tr>
                  </thead>
                  <tbody id="tbody" name="tbody">
                  	<%-- <c:forEach var="monthTOT" items="${monthTOT }">
                  	<tr>
                  		<td>${monthTOT.mm }</td>
                  		<td>${monthTOT.monTOT }</td>
                  	</tr> 
                  	</c:forEach>--%>
                  </tbody>

                </table>
              </div>
            </div>
            <div>
            	
            </div>
          </div>
           <!--  </div> -->

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
	</div>
	<!-- </div> -->

</body>
</html>