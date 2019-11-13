package com.iu.s4.util;

public class Pager {
	private Integer curPage; // 현재 페이지 번호
	private Integer perPage; // 불러올때 글의 개수
	private String kind; // 검색 종류
	private String search; // 검색어
	// DB
	private Integer startRow; // 시작rownum
	private Integer lastRow; // 끝 rownum
	
	// View(Jsp)
	private Integer startNum; // 시작 번호
	private Integer lastNum; // 끌 번호
	private Integer curBlock; 
	// ↑ 현재 블럭 번호  |1|2|3|4|5| 다음>(1번째블럭) <이전 |6|7|8|9|10|(2번째블럭) 괄호 안에 있는거  현재 6페이지면 2번째블럭
	private Integer totalBlock; // 전체 블럭 개수 
	
	public Pager() {
		perPage = 10; // 한 블럭당 글이 10개씩 표기
	}

	public Integer getCurPage() {
		if (curPage == null || curPage == 0) // 디폴트 값 지정
			curPage = 1;
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if (perPage == null || perPage == 0) // 디폴트 값 지정
			perPage = 10;
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) // null값이면 기본페이지도 안뜨기 때문에 null이 아닌 빈문자열로 default값 설정
			search = "";
		return search;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	public void makeRow() {
		startRow = (this.getCurPage() - 1) * this.getPerPage() + 1; // 그냥 멤버변수로 호출하면 Null값이 들어 갈수도 있으니까 꼭 메서드 형식으로
		lastRow = this.getCurPage() * this.getPerPage();
	}

	public void makePage(int totalCount) {
		// 2. totalPage 구하기
		int totalPage = totalCount / this.getPerPage();
		if(totalCount % getPerPage() != 0)
			totalPage++;
		// 3. totalBlock
		int perBlock = 5; // 한번에 보여 지는 블럭 수
		totalBlock = totalPage/perBlock; // 전체 블럭 수
		if(totalPage % perBlock != 0)
			totalBlock++;
		// 4. curPage로 curBlock 구하기
		curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage() % perBlock != 0)
			curBlock++;
		// 5. curBlock으로 startNum, lastNum
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		if(curBlock == totalBlock)
			lastNum = totalPage;
		
	}



}
