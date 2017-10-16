<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 2017/10/13
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<h1>上传成功 ~ ~ ~ ~ </h1>
<h3>用户名: ${username}</h3>
<h3>密码: ${password}</h3>

<h3>取action属性,直接按属性名获取</h3>
用户名: <s:property value="username"/>
密码: <s:property value="password"/>

<hr>

<h3>取Request中的属性集合的某个key值</h3>
<s:property value="#attr.request_username"/>

<h3>取application中map的某个key值, 需要加application的前缀</h3>
<s:property value="#application.application_username"/>

<h3>取session中map的某个key值, 需要加session的前缀</h3>
<s:property value="#session.session_username"/>

<h3>取parameter中map的某个key值, 需要加parameter的前缀</h3>
<s:property value="#parameters.username"/>

<hr>
<h1>先通过set标签更改username常量的值, 再调用property获取一下它的值
没有定义scope时, 默认认为是request域中</h1>
<s:set var="username" value="'拉拉'" />
<s:property value="#username"/>

<h1>先通过set标签更改session中的添加一个username属性</h1>
<s:set var="username" value="'张三'" scope="session"/>
<s:property value="#session.username"/>

<h1>先通过set标签在application中的属性添加一个username属性, 如果value对应的值没有用单引号包裹起来, 则默认认为是一个变量,
去Action属性集合中查找有没有定义该变量</h1>
<s:set var="username" value="'李四'" scope="application"/>
<s:property value="#application.username"/>

<hr>

<h1>取request, session, application中属性同名对象</h1>
<s:property value="#attr.name"/><br>
<s:property value="#session.name"/><br>
<s:property value="#application.name"/><br>

<h3>#号构建map对象</h3>
<s:set name="foobar" value="#{'foo1':'吃饭','foo2':'睡觉'}"/>
<s:property value="#foobar['foo1']"/>

<h1>%{}将大括号中的内容认为是ognl表达式</h1>
<s:property value="%{姓名}"/>

<h3>输出一个list集合</h3>
<s:property value="{'吃饭','睡觉','打豆豆'}"/>
</body>
</html>