<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sample</title>
<script src="http://d3js.org/d3.v5.min.js"></script>
<script language="JavaScript" src="pie5.js" charset="UTF-8"></script>

<style>
svg { width: 320px; height: 240px; border: 1px solid black; }

.pie {fill : cyan; stroke: black;}
.total { font-size: 9pt; text-anchor :middle;}
.pieNum { font-size:10px; text-anchor: middle;}

</style>
	</head>
	<body>
		<h1>원 그래프 표시</h1>
		<svg id="myGraph"></svg>

		 
	</body>
</html>