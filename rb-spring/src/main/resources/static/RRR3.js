
$(document).ready(function() {
    var radarOptions = {

        responsive: true,

    	//Boolean - If we show the scale above the chart data
    	scaleOverlay : true,

    	//Boolean - If we want to override with a hard coded scale
    	scaleOverride : true,

    	//** Required if scaleOverride is true **
    	//Number - The number of steps in a hard coded scale
    	scaleSteps : 5,
    	//Number - The value jump in the hard coded scale
    	scaleStepWidth : 1,
    	//Number - The centre starting value
    	scaleStartValue : 0,

    	//Boolean - Whether to show lines for each scale point
    	scaleShowLine : true,

    	//String - Colour of the scale line
    	scaleLineColor : "#999",

    	//Number - Pixel width of the scale line
    	scaleLineWidth : 0.5,

    	//Boolean - Whether to show labels on the scale
    	scaleShowLabels : false,

    	//Interpolated JS string - can access value
    	scaleLabel : "<%=value%>",

    	//String - Scale label font declaration for the scale label
    	scaleFontFamily : "'Arial'",

    	//Number - Scale label font size in pixels
    	scaleFontSize : 12,

    	//String - Scale label font weight style
    	scaleFontStyle : "normal",

    	//String - Scale label font colour
    	scaleFontColor : "#666",

    	//Boolean - Show a backdrop to the scale label
    	scaleShowLabelBackdrop : true,

    	//String - The colour of the label backdrop
    	scaleBackdropColor : "#999",

    	//Number - The backdrop padding above & below the label in pixels
    	scaleBackdropPaddingY : 2,

    	//Number - The backdrop padding to the side of the label in pixels
    	scaleBackdropPaddingX : 2,

    	//Boolean - Whether we show the angle lines out of the radar
    	angleShowLineOut : true,

    	//String - Colour of the angle line
    	angleLineColor : "#999",

    	//Number - Pixel width of the angle line
    	angleLineWidth : 1,

    	//String - Point label font declaration
    	pointLabelFontFamily : "'Arial'",

    	//String - Point label font weight
    	pointLabelFontStyle : "normal",

    	//Number - Point label font size in pixels
    	pointLabelFontSize : 10,

    	//String - Point label font colour
    	pointLabelFontColor : "#1eb6a7",

    	//Boolean - Whether to show a dot for each point
    	pointDot : true,

    	//Number - Radius of each point dot in pixels
    	pointDotRadius : 5,

    	//Number - Pixel width of point dot stroke
    	pointDotStrokeWidth : 8,

    	//Boolean - Whether to show a stroke for datasets
    	datasetStroke : true,

    	//Number - Pixel width of dataset stroke
    	datasetStrokeWidth : 1,

    	//mouse hover show value
    	pointHitDetectionRadius: 20,

    	//Boolean - Whether to fill the dataset with a colour
    	datasetFill : true,

    	//Boolean - Whether to animate the chart
    	animation : true,

    	//Number - Number of animation steps
    	animationSteps : 60,

    	//String - Animation easing effect
    	animationEasing : "easeOutQuart",

    	//Function - Fires when the animation is complete
    	onAnimationComplete : null,

    	

    }
    
    

    // what the hell test
    // Radar Data

    var radarData = {
    	labels : ["A","B","C","D", "E"],
    	datasets : [
    		{
    		    label: "User Feedback",
    		    fillColor: "rgba(87, 167, 134, 0.2)",
                strokeColor: "rgba(87, 167, 134, 1)",
                pointColor: "rgba(87, 167, 134, 1)",
                pointStrokeColor: "rgba(255, 255, 255, 0)",
                pointHighlightFill: "rgba(87, 167, 134, 0.7)",
                pointHighlightStroke: "rgba(87, 167, 134, 1)",
    			data : [0,0,0,0,0],
    		},
    	]
    }

    //Get the context of the Radar Chart canvas element we want to select
    var ctx = document.getElementById("radarChart").getContext("2d");

    // Create the Radar Chart
    var myRadarChart = new Chart(ctx).Radar(radarData, radarOptions);

    function getElementPosition(obj) {
    	  var curleft = 0, curtop = 0;
    	  if (obj.offsetParent) {
    	    do {
    	      curleft += obj.offsetLeft;
    	      curtop += obj.offsetTop;
    	    } while (obj = obj.offsetParent);
    	      return { x: curleft, y: curtop };
    	  }
    	  return undefined;
    	};

    	function getEventLocation(element,event){
    	  // Relies on the getElementPosition function.
    	  var pos = getElementPosition(element);

    	  return {
    	    x: (event.pageX - pos.x),
    	    y: (event.pageY - pos.y)
    	  };
    	};

    	function pointDistance(point1, point2) {
    	  return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    	};

    	//Get the context of the Radar Chart canvas element we want to select
    	var ctx = document.getElementById("radarChart").getContext("2d");

    	// Create the Radar Chart
    	var myRadarChart = new Chart(ctx).Radar(radarData, radarOptions);

    	$("#radarChart").click(function (evt) {
    	  var eventLocation = getEventLocation(this,evt); 
    	  var activePoints = myRadarChart.getPointsAtEvent(evt);
    	  var eventLocDistToCenter = pointDistance({x: myRadarChart.scale.xCenter, y: myRadarChart.scale.yCenter}, eventLocation);
    	  var activePointDistToCenter = pointDistance({x: myRadarChart.scale.xCenter, y: myRadarChart.scale.yCenter}, activePoints[0]);

    	  if (eventLocDistToCenter < activePointDistToCenter) {
    	    
    		  activePoints[0].value -= Math.round((activePointDistToCenter - eventLocDistToCenter)/47);
    	    console.log("이벤트 : " + Math.round(eventLocDistToCenter/47))
    	    console.log("액티브 : " + Math.round(activePointDistToCenter/47))
    	    console.log("마이너스 값 : " +	Math.round((activePointDistToCenter - eventLocDistToCenter)/47));
    	  } else {
    	   
    		  activePoints[0].value += Math.round((eventLocDistToCenter - activePointDistToCenter)/47);
    	    console.log("이벤트 : " + Math.round(eventLocDistToCenter/47))
    	    console.log("액티브 : " + Math.round(activePointDistToCenter/47))
    	    console.log("플러스 값 : " + Math.round((eventLocDistToCenter - activePointDistToCenter)/47))
    	    
    	  }

    	  myRadarChart.update();
    	});

        
        //var button1 = document.getElementById("button1");
        
      
       
    	 
        $('#button1').on('click', function() {
        
        	console.log("A 는 : " + myRadarChart.datasets[0].points[0].value);
        	console.log("B 는 : " + myRadarChart.datasets[0].points[1].value);
        	console.log("C 는 : " + myRadarChart.datasets[0].points[2].value);
        	console.log("D 는 : " + myRadarChart.datasets[0].points[3].value);
        	console.log("E 는 : " + myRadarChart.datasets[0].points[4].value);
        	
         });

    	
});