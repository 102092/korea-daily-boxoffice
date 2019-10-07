<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sample</title>
<script src="http://d3js.org/d3.v5.min.js"></script>
<%--<script src="../WEB_INF/js/pie5.js"></script> --%>
<script>
window.addEventListener("load",function(){
	
	var svgHeight = 240;	// SVG ����� ����
	var svgWidth = 320;		//SVG ����� ����
	var dataSet = [50,30,12,5,3];	//������ ��, ������ ��Ÿ�� 
	var color = d3.scaleOrdinal(d3.schemeCategory10);	//D3.js�� �غ��� ǥ�� ��
	
	/*
	 * 	var colorScale_1 = d3.schemeCategory10;
	 *  var colorScale_2 = schemeCategory20;
	 *  var colorScale_3 = d3.schemeCategory20b;
	 *  var colorScale_4 = d3.schemeCategory20c
	 */
	
	// �� �׷����� ��ǥ���� ����ϴ� �޼���
	var pie = d3.pie().value(function(d,i){return d;})	// �� �׷��� ���̾ƿ�
	
	// �� �׷����� �ܰ�,���� ���� (���׷��� ������ = outer, ���Ӹ������ ����� ������ inner�� ����)
	var arc = d3.arc().innerRadius(40).outerRadius(100);
	
	//�� �׷��� �׸���
	
	var pieElements = d3.select("#myGraph")
	.selectAll("g")	// path ��� ����
	.data(pie(dataSet))
	.enter()
	.append("g")// g�� ���
	.attr("transform", "translate("+svgWidth/2+", "+svgHeight/2+")")
	
	//������ �߰�
	pieElements // ������ ����ŭ �ݺ�
	.append("path") // ������ ����ŭ rect ��Ұ� �߰���
	.attr("class", "pie") // CSSŬ���� ����
	.style("fill",function(d,i){
		return color(i);	//ǥ�� 10�� �� ���� ��ȯ
	})
	
	
	
	.transition()
	.duration(200)
	.delay(function(d,i){	// �׸� �� �׷����� �ð��� ��߳��� ǥ��
		return i*200;
	})
	.ease(d3.easeLinear) //  �������� ���ϸ��̼� ���������� ����
	// �ð��� ���� ������ ��ȯ��Ű������ �ð��� ���� �Ӽ����� ��ȭ��Ű��
	.attrTween("d",function(d,i){	// ���� ó��
		var interpolate = d3.interpolate(
				//�� �κ��� ���� ����
		{	startAngle : d.startAngle, endAngle : d.startAngle },
				//�� �κ��� ���� ����
		{	startAngle : d.startAngle, endAngle : d.endAngle }
	);
		return function(t){	//t�� �ð�
			return arc(interpolate(t));	//�ð��� ���� ó��
		}
			
	})
	
	//�հ�� ���� ǥ��	
	var textElements = d3.select("#myGraph")
	.append("text")
	.attr("class", "total")
	.attr("transform", "translate("+svgWidth/2+", " +(svgHeight/2+5)+")")
	.text("�հ� : " + d3.sum(dataSet))	//�հ�ǥ��
	
	// ���ڸ� ��ä���� ����� ǥ��
	pieElements
	.append("text")
	.attr("class","pieNum")
	.attr("transform", function(d,i){
		return "translate("+arc.centroid(d)+")";	//��ä���� �߽�����
	})
	.text(function(d,i){
		return d.value;	// �� ǥ��
	});
	
	
});	// addEventListener() end




</script>
<style>
svg { width: 320px; height: 240px; border: 1px solid black; }

.pie {fill : cyan; stroke: black;}
.total { font-size: 9pt; text-anchor :middle;}
.pieNum { font-size:10px; text-anchor: middle;}

</style>
	</head>
	<body>
		<h1>�� �׷��� ǥ��</h1>
		<svg id="myGraph"></svg>

		 
	</body>
</html>