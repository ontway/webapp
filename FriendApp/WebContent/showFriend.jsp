<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <c:choose>
         <c:when test="${empty list }">
                             没有满足条件的数据
         </c:when>
         <c:otherwise>
           <table border="1" align="center">
            <tr>
            <th>序号</th><th>姓名</th><th>性别</th><th>编辑</th>
            </tr>
            <c:forEach var="friend" items="${list }" varStatus="s">
            
            <tr>
            <td>${s.count }</td>
            <td>${friend.fname }</td>
            <td>${friend.fgender }</td>
            <td><a href="FriendDetailServlet?fid=${friend.fid }&opcode=u">修改</a>
                <a href="FriendDetailServlet?fid=${friend.fid }&opcode=d">删除</a>
            </td>
            </tr>
             </c:forEach>
           </table>
         </c:otherwise>
           
      </c:choose>
</body>
</html>