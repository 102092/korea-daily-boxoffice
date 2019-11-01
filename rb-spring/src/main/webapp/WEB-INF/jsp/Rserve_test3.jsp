<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sun.org.apache.xml.internal.security.utils.Base64" %>
<%@ page import="com.review.wiki.RWordCloude" %>
<html>

<style>
  @font-face {font-family: "Koverwatch"; src: url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.eot"); src: url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.eot?#iefix") format("embedded-opentype"), url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.woff2") format("woff2"), url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.woff") format("woff"), url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.ttf") format("truetype"), url("//db.onlinewebfonts.com/t/1f00b50091b5a28cccf7b552ceefc8cd.svg#Koverwatch") format("svg"); }
</style>

   <body>
  <h1>WordCloude3</h1>  
<%
RWordCloude con = new RWordCloude();
%>

<img src="data:image/jpg;base64, <%=Base64.encode(con.returnRImg())%>"/>

<h2> testtt </h2>
</body>
</html>


<%-- 
R console (RGUI) 에서 미리 실행시켜야 작동
library(Rserve)

Rserve(FALSE,port=6311,args='--RS-encoding utf8 --no-save --slave --encoding utf8  --internet2')

Rserve(args="--RS- encoding utf8")

Rserve(FALSE,port=6311,args='--RS-encoding utf8 --no-save --slave --encoding utf8')

--%>