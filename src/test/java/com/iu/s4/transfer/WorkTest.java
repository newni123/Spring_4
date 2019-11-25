package com.iu.s4.transfer;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.TestAbstractCase;

public class WorkTest extends TestAbstractCase{
	@Inject
	private Work work;

	@Test
	public void getWork() {
		work.goWork();
	}
}
