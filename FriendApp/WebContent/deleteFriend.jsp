<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>删除该信息？</h1>
       <form action="DeleteFriendServlet" method="post">
       <input type="hidden" name="fid" value="${friend.fid }"/> 
       姓名：${friend.fname }
   性别：${friend.fgender } 
    <input type="submit" value="删除" /> 
       </form>
</body>
</html>