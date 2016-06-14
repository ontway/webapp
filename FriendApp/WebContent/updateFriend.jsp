<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>更新朋友信息</h1>
     <form action="UpdateFriendServlet" method="post">
     <input type="hidden" name="fid" value="${friend.fid }"/> 
     <input type="hidden" name="username" value="${username }"/>
         姓名：<input type="text" name="fname" value="${friend.fname }" /><br/>
     性别：<input type="radio" name="fgender" value="男" ${friend.fgender=="男"?"checked":"" } />男
     <input type="radio" name="fgender" value="女" ${friend.fgender=="女"?"checked":"" }/>女<br/>
     
     <input type="submit" value="更新" />
     </form>
</body>
</html>