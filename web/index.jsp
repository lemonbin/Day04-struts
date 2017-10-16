<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 2017/10/13
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="upload.jsp">单(多)文件上传</a><br>

  <a href="download.action?fileName=4ec2d5628535e5dd05f20f5171c6a7efcf1b6266.jpg">点击下载</a><br>
  <a href="download.action?fileName=书店.jpeg">点击下载书店.jpeg</a><br>
  <a href="login.jsp">登录界面</a><br>
  <s:actionerror/>
  <s:fielderror/>
  </body>
</html>
