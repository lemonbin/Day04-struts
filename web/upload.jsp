<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 2017/10/13
  Time: 上午9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<h1>上传单个文件</h1>
<form action="singleUpload.action" enctype="multipart/form-data" method="post">
    选择单个文件<input type="file" name="photo"><br>
    <input type="submit" value="上传">
</form>
<h1>上传多个文件</h1>
<form action="moreUpload.action" enctype="multipart/form-data" method="post">
    选择多个文件<input type="file" name="photos" multiple><br>
    <input type="submit" value="上传">
</form>
<s:actionerror/>
</body>
</html>
