package com.iu.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	@After("execution(* com.iu.s4.transfer.Transfer.taxi())")
	public void cash() {
		System.out.println("====현금 내기====");
	}
	@Around("execution(* com.iu.s4.transfer.Transfer.get*(..))")
	public Object cardCheck(ProceedingJoinPoint join) {
		System.out.println("=== 승차 ===");
		Object obj = null;
		try {
			Object[] args = join.getArgs();
			for (Object object : args) {
				System.out.println(object);
			}
			obj = join.proceed();

		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("=== 하차 ===");
		return obj;
	}

}
