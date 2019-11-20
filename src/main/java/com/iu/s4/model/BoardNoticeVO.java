package com.iu.s4.model;

import java.util.List;

public class BoardNoticeVO extends BoardVO {

	private List<NoticeFilesVO> files;

	public List<NoticeFilesVO> getFiles() {
		return files;
	}

	public void setFiles(List<NoticeFilesVO> files) {
		this.files = files;
	}

}
