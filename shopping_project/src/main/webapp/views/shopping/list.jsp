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
	<form action="/addToCart" method="post">
		<select name="product">
			<% List<Product> resultList 
				= (List<Product>)request.getAttribute("resultList");
				for(int i = 0 ; i < resultList.size(); i++){ %>
				<option value="<%=resultList.get(i).getProdCode()%>">
					<%=resultList.get(i).getProdName()%>
				</option>	
			<%}%>
		</select>
		<input type="submit" value="추가">
	</form>
</body>
</html>