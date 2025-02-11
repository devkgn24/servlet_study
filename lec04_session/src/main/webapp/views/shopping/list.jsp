<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.gn.shopping.vo.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<% List<Product> resultList 
		= (List<Product>)request.getAttribute("resultList");
		for(int i = 0 ; i < resultList.size(); i++){ %>
			
			
	<% }%>
</body>
</html>