package com.ds.practice.stack;

import org.junit.Assert;
import org.junit.Test;

public class SpecialStackTest {

	SpecialStack specialStack = new SpecialStack(10);

	@Test
	public void testSpecialStack() throws Exception {

		Assert.assertTrue(specialStack.isEmpty());
		specialStack.push(5);
		specialStack.push(3);
		specialStack.push(5);
		specialStack.push(10);
		specialStack.push(20);
		specialStack.push(22);
		specialStack.push(100);
		specialStack.push(50);
		specialStack.push(30);
		specialStack.push(200);
		specialStack.push(220);
		Assert.assertEquals(specialStack.getMin().intValue(), 3);
		Integer first = specialStack.pop();
		Assert.assertEquals(first.intValue(), 220);
		Assert.assertEquals(specialStack.getMin().intValue(), 3	);


	}
}
