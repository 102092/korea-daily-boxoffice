<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>

<head>
    <meta charset="utf-8" />
</head>
<style>
    @font-face {
        font-family: 'overwatch';
        src: url('fonts/koverwatch.woff2');
    }
</style>

<body>
    <script src="https://d3js.org/d3.v3.min.js"></script>
    <script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js" type="text/JavaScript"></script>
    <script>
        var width = 960,
            height = 500

        var svg = d3.select("body").append("svg")
            .attr("width", width)
            .attr("height", height);
        d3.csv("worddata.csv", function (data) {
            showCloud(data)
            setInterval(function(){
                 showCloud(data)
            },2000) 
        });
        //scale.linear: �������� �����Ϸ� ǥ��ȭ�� ��Ų��. 
        //domain: �������� ����, �Է� ũ��
        //range: ǥ���� ����, ��� ũ�� 
        //clamp: domain�� ������ �Ѿ ���� ���Ͽ� domain�� �ִ밪���� ������Ų��.
        wordScale = d3.scale.linear().domain([0, 100]).range([0, 150]).clamp(true);
        var keywords = ["�ڸ���", "Ʈ���̼�", "����"]
        var svg = d3.select("svg")
                    .append("g")
                    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")

        function showCloud(data) {
            d3.layout.cloud().size([width, height])
                //Ŭ���� ���̾ƿ��� ������ ����
                .words(data)
                .rotate(function (d) {
                    return d.text.length > 3 ? 0 : 90;
                })
                //�����Ϸ� �� �ܾ��� ũ�⸦ ����
                .fontSize(function (d) {
                    return wordScale(d.frequency);
                })
                //Ŭ���� ���̾ƿ��� �ʱ�ȭ > end�̺�Ʈ �߻� > ����� �Լ� �۵�  
                .on("end", draw)
                .start();

            function draw(words) { 
                var cloud = svg.selectAll("text").data(words)
                //Entering words
                cloud.enter()
                    .append("text")
                    .style("font-family", "overwatch")
                    .style("fill", function (d) {
                        return (keywords.indexOf(d.text) > -1 ? "#fbc280" : "#405275");
                    })
                    .style("fill-opacity", .5)
                    .attr("text-anchor", "middle") 
                    .attr('font-size', 1)
                    .text(function (d) {
                        return d.text;
                    }); 
                cloud
                    .transition()
                    .duration(600)
                    .style("font-size", function (d) {
                        return d.size + "px";
                    })
                    .attr("transform", function (d) {
                        return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                    })
                    .style("fill-opacity", 1); 
            }
        }
    </script>
</body>

</html>