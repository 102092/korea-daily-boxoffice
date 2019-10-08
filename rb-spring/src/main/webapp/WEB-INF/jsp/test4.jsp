<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/ >
		<title>Smoothed D3.js Radar Chart</title>

		<!-- Google fonts -->
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300" rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="https://rawgit.com/tpreusse/radar-chart-d3/master/src/radar-chart.css">
		
		<!-- D3.js -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="http://d3js.org/d3.v5.min.js"></script>
 	    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
  		
		
		
		<style>
			.radar-chart .area {
  fill-opacity: 0.7;
}
.radar-chart.focus .area {
  fill-opacity: 0.3;
}
.radar-chart.focus .area.focused {
  fill-opacity: 0.9;
}
.area.germany, .germany .circle {
  fill: #FFD700;
  stroke: none;
}
.area.argentina, .argentina .circle {
  fill: #ADD8E6;
  stroke: none;
}
			
		</style>
	
	</head>
	<body>

	<div class="chart-container"></div>
<script>
RadarChart.draw(".chart-container", data);
</script>

	</body>
</html>