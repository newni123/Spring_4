package com.iu.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
@Component
public class Card {

	public void cash(ProceedingJoinPoint join) {
		System.out.println("==== 현금 내기 ====");
	}
	public Object cardCheck(ProceedingJoinPoint join) { // 얘가 Advice / 매개변수로 오는거 : getBus..getSubway등
		System.out.println("====승차 전 카드 찍기====");
		Object obj = null;
		try {
			Object[] args =join.getArgs();
			for(Object object:args)
			{
				System.out.println(object);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====하차 전 카드 찍기====");
		return obj;
	}
}
