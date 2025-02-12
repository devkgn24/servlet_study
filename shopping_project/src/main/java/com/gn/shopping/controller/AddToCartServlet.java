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
import javax.servlet.http.HttpSession;

import com.gn.shopping.vo.Product;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodCode = Integer.parseInt(request.getParameter("product"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
	    	String url ="jdbc:mariadb://127.0.0.1:3306/shopping_project";
	    	String user="scott";
	    	String pw = "tiger";
	    	conn = DriverManager.getConnection(url,user,pw);
	    	
	    	String sql = "SELECT prod_code,prod_name,prod_price "
	    			+ "FROM sh_product "
	    			+ "WHERE prod_code = ?";
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setInt(1, prodCode);
	    	rs = pstmt.executeQuery();
	    	
	    	if(rs.next()) {
	    		p= new Product(rs.getInt("prod_code")
	    				, rs.getString("prod_name")
	    				, rs.getInt("prod_price"));
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
		
		// System.out.println(p.getProdName());
		// key값이 "cart"인 Session 정보 존재 유무 확인
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("cart") == null) {
			List<Product> newList = new ArrayList<Product>();
			newList.add(p);
			session.setAttribute("cart",newList);
			session.setMaxInactiveInterval(60*30);
		}else {
			List<Product> oldList = (List<Product>)session.getAttribute("cart");
			oldList.add(p);
		}
		// 존재하지 않는 경우 List<Product> 형태의 새로운 세션 추가
		// 존재하는 경우 기존 List<Product> 데이터에 항목 추가(add)후 
		// 세션 재설정
		
		response.sendRedirect("/cartList");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
