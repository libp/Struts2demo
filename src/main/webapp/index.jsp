<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>

 		<form action="upload" method="post" enctype="multipart/form-data">  
          		  文件：<input type="file" name="myFile">  
            <input type="submit" value="上传">        
        </form> 
</body>
</html>
