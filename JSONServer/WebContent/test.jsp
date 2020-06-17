<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%String strName= request.getParameter("name"); %>
<%String strAddress= request.getParameter("address"); %>
<%
out.println("{\"customers\": ["
+"{\"name\":\""+strName+"\", \"address\":\""+strAddress+"\"},"
+"{\"name\":\"ccc\", \"address\":\"ddd\"},"
+"{\"name\":\"eee\", \"address\":\"fff\"}"
+"]}");
%>