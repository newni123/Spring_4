package com.iu.s4.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {

	@Inject
	private Transfer transfer;

	public void goWork() {
		transfer.getBus("Samsung");
		transfer.getSubWay("Kakao");
		transfer.taxi();
	}

	public void goTaxi() {
		transfer.taxi();
	}
}