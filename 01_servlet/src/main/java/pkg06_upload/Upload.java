package pkg06_upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Collection;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 50)
// realpath 위치는 ....\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01_servlet 이런 구조

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 업로드 경로 (톰캣 내부 경로)
	    String uploadPath = request.getServletContext().getRealPath("upload");
	    // 프로젝트의 저장되어야 하는 값을은 servletContext에 저장 됨. 
	    File uploadDir = new File(uploadPath);
	    if(!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	    
	    String originalFilename = null;
	    String filesystemName = null;
	    
	    // 첨부된 파일 정보
	    // Header 값을 통해 파일인지 아닌지 확인 -> getPart를 통해 알 수 있다.

	    Collection<Part> parts = request.getParts();
	    for(Part part : parts) {   //array collection
	        //System.out.println(part.getName() + "," + part.getContentType() + "," + part.getSize() + "," + part.getSubmittedFileName()); // name 속성이 출력됨
	        //getContentType이 이미지인 경우 이렇게도 출력 가능
	        //System.out.println(part.getHeader("Content-Disposition")); 
	        
	        if(part.getHeader("Content-Disposition").contains("filename")) {
	            if(part.getSize() > 0) {
	                originalFilename = part.getSubmittedFileName();
	            }
	        }
	        
	        // 전송된 파일의 파일명 만들기
	        if(originalFilename != null) {
	            int point = originalFilename.lastIndexOf(".");
	            String extName = originalFilename.substring(point);
	            String fileName = originalFilename.substring(0, point);
	            filesystemName = fileName + "_" + System.currentTimeMillis() + extName;
	        }

	        // 파일시스템명이 null이 아니라면 저장
	        if(filesystemName != null) {
	            part.write(uploadPath + File.separator + filesystemName);  // File.seperator 서버에 따라 경로 구분자 알아서 처리
	        }
	    }
	    
	    // 응답
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<div><a href=\"/servlet/pkg06_upload/NewFile.html\">입력폼으로 돌아가기</a></div>"); //deployment assembly에서 본 그 경로
	    out.println("<hr>");
	    out.println("<div>첨부파일명 : " + originalFilename + "</div>");
	    out.println("<div>저장파일명 : " + filesystemName +"</div>");
	    out.println("<div>저장경로 : " + uploadPath + "</div>" );
	    out.println("<hr>");
	    
	    File[] files = uploadDir.listFiles();
	    for(File file : files) {
	      String fileName1 = file.getName(); // 파일명_1234567890.jpg
	      String ext = fileName1.substring(fileName1.lastIndexOf("."));
	      String fileName2 = fileName1.substring(0, fileName1.lastIndexOf("_"));
	      out.println("<div><a href=\"/servlet/download?filename=" + URLEncoder.encode(fileName1, "UTF-8") + "\">" + fileName2 + ext + "</a></div>");
	    }
	    
	    out.flush();
	    out.close();
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
