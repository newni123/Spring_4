package com.iu.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	public void getBus(String cardName) {
		System.out.println("=== BUS ===");
		System.out.println("음악 듣기");
		System.out.println("=== BUS ===");
	}

	public void getSubWay(String cardName) {
		System.out.println("=== SUBWAY ===");
		System.out.println("휴대폰 보기");
		System.out.println("=== SUBWAY ===");
	}

	public void taxi() {
		System.out.println("=== TAXI ===");
		System.out.println("기사님과 대화");
		System.out.println("=== TAXI ===");
	}

	public void car() {
		System.out.println("=== My CAR ===");
		System.out.println("운전");
		System.out.println("=== My CAR ===");
	}
}
