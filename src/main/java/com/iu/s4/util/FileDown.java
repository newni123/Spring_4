package com.iu.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s4.model.NoticeFilesVO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoticeFilesVO noticeFilesVO = (NoticeFilesVO) model.get("file");
		String board = (String) model.get("board");
		System.out.println("Fname : " + noticeFilesVO.getFname());
		System.out.println("Oname : " + noticeFilesVO.getOname());
		System.out.println("board : " + board);
		String realPath = request.getSession().getServletContext().getRealPath("resources/upload/" + board);
		System.out.println(realPath);

		File file = new File(realPath, noticeFilesVO.getFname());
		
		// 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 파일의 크기
		response.setContentLength((int)file.length());
		// 다운로드 시 파일 이름 인코딩
		String fileName = URLEncoder.encode(noticeFilesVO.getOname(),"UTF-8");
		// header 설정 
		response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//outputStream
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		os.close();
		fi.close();
		
	}

}
