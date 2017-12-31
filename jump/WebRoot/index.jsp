<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JUMP!</title>
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-control" content="no-cache">
	<meta http-equiv="Cache" content="no-cache">  
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var clickcount = 1;
	var x1 = 0;
	var y1 = 0;
		function zuobiao(event)
	{
		x=event.clientX;
		y=event.clientY;

		xmlHttp = createXMLHttpRequest();  
		var url = "jump";  
		xmlHttp.open("POST", url, true);  
		/* xmlHttp.onreadystatechange = getStatusBack; */  
		xmlHttp.setRequestHeader("Content-Type",  "application/x-www-form-urlencoded;");  
		if(clickcount%2!=0){
			x1 = x;
			y1 = y;
			clickcount++;
		}
		else{
			//发送获取到的两个坐标到servlet
			xmlHttp.send("x1="+x1+"&y1="+y1+"&x2="+x+"&y2="+y);
			//5s后刷新页面
			setTimeout("window.location.reload()",5000);
		}	
		
    }
    function createXMLHttpRequest() {  
    var xmlHttp;  
    if (window.XMLHttpRequest) {  
        xmlHttp = new XMLHttpRequest();  
        if (xmlHttp.overrideMimeType)  
            xmlHttp.overrideMimeType('text/xml');  
    } else if (window.ActiveXObject) {  
        try {  
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  
        } catch (e) {  
            try {  
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  
            } catch (e) {  
            }  
        }  
    }  
    return xmlHttp;  
}  
	</script>
  </head>
  
  <body>
	<!-- 此处width参数根据Constants自行调节 -->
  	<img  src="./1.png" width="23%" OnMouseDown="zuobiao(event)">

    
  </body>
</html>
