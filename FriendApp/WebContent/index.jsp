<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     ${msg }
    <h1>欢迎你：${username }</h1>
              请选择操作：<hr/>
    1.添加好友<br/>
    <a href="addFriend.jsp">添加好友</a><hr/>
    2.查询好友<br/>
    <form action="FindFriendServlet" method="post" target="_blank">
    <input type="text" name="condition" value="" />
    <select name="type">
     <option value="1">查询全部</option>
     <option value="2">按姓名查询</option>
     <option value="3">按姓氏查询</option>
    </select>
     <input type="submit" value="查询"/>
    </form>
</body>
</html>