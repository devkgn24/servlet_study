package com.gn.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

@WebServlet("/boardCreateEnd")
public class BoardCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCreateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 전달된 데이터를 담을 바구니
		Board b = new Board();
		Attach a = new Attach();
		
		// 2. 파일 업로드할 경로 설정
		String path = "C:\\upload\\board";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 3. 파일을 업로드할 저장 공간 정보 셋팅
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(dir);
		// byte -> KB -> MB -> GB -> TB
		// 1024 -> 1KB * 1024 -> 1MB * 10
		factory.setSizeThreshold(1024*1024*10);
		
		// 4. 요청을 통해 전달된 데이터 읽어오기
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(int i = 0 ; i < items.size() ; i++) {
				FileItem fileItem = items.get(i);
				if(fileItem.isFormField()) {
					// (1) 파일이 아닌 폼 내부 요소
					System.out.println(fileItem.getFieldName());
				} else {
					// (2) 파일 형태의 폼 요소
					System.out.println(fileItem.getName());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
