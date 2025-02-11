package com.gn.shopping.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.shopping.vo.Product;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
	    	String url ="jdbc:mariadb://127.0.0.1:3306/shopping_project";
	    	String user="scott";
	    	String pw = "tiger";
	    	conn = DriverManager.getConnection(url,user,pw);
	    	
	    	String sql = "SELECT prod_code,prod_name,prod_price "
	    			+ "FROM sh_product ";
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	
	    	while(rs.next()) {
	    		Product p
	    			= new Product(rs.getInt("prod_code")
	    				, rs.getString("prod_name")
	    				, rs.getInt("prod_price"));
	    		list.add(p);
	    	}
	    	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		RequestDispatcher view 
			= request.getRequestDispatcher("/views/shopping.list.jsp");
		request.setAttribute("resultList", list);
		view.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
