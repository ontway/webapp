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
     <form action="AddFriendServlet" method="post">
     姓名：<input type="text" name="fname" value="" /><br/>
     性别：<input type="radio" name="fgender" value="男" />男
     <input type="radio" name="fgender" value="女" />女<br/>
     <input type="hidden" name="username" value="${username }" /><br/>
     <input type="submit" value="添加" />
     </form>
</body>
</html>