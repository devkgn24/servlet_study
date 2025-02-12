<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.gn.shopping.vo.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
	<%
		List<Product> list = new ArrayList<Product>();
		if(session != null && session.getAttribute("cart") != null){
			list = (List<Product>)session.getAttribute("cart");
		}
	%>
	<% if(list == null || list.isEmpty()){%>
		<p>장바구니가 비어 있습니다.</p>
	<% } else{
		for(int i = 0 ; i < list.size() ; i++){%>
		<p><%= list.get(i).getProdCode() +" : " 
			+ list.get(i).getProdName() + " : " 
			+ list.get(i).getProdPrice()+"원"%></p>
	<% }
	  } %>
</body>
</html>