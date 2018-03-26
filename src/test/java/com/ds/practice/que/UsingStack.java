package com.ds.practice.que;

import org.junit.Assert;
import org.junit.Test;

public class UsingStack {

	QueUsingStack queUsingStack = new QueUsingStack(10);
	QueUsingStackDequeCostly dequeCostly = new QueUsingStackDequeCostly(10);

	@Test
	public void queUsingStackLengthTest() throws Exception {
		queUsingStack = new QueUsingStack(10);

		queUsingStack.enque(10);
		queUsingStack.enque(20);
		queUsingStack.enque(30);
		queUsingStack.enque(40);

		Assert.assertEquals(queUsingStack.length.intValue(), 4);
	}

	@Test
	public void queUsingStackDequeTest() throws Exception {

		queUsingStack = new QueUsingStack(10);

		queUsingStack.enque(10);
		queUsingStack.enque(20);
		queUsingStack.enque(30);
		queUsingStack.enque(40);

		Assert.assertEquals(queUsingStack.length.intValue(), 4);

		Assert.assertEquals(queUsingStack.deque().intValue(), 10);
		Assert.assertEquals(queUsingStack.deque().intValue(), 20);
		Assert.assertEquals(queUsingStack.deque().intValue(), 30);
		Assert.assertEquals(queUsingStack.deque().intValue(), 40);

	}

	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhenDequeEmptyQue() throws Exception {
		queUsingStack = new QueUsingStack(10);

		queUsingStack.enque(10);
		Assert.assertEquals(queUsingStack.length.intValue(), 1);
		Integer sv = queUsingStack.deque();
		Assert.assertEquals(sv.intValue(), 10);
		sv = queUsingStack.deque();
	}

	@Test
	public void queUsingStackLengthTestDequeCostly() throws Exception {

		dequeCostly = new QueUsingStackDequeCostly(10);

		dequeCostly.enque(10);
		dequeCostly.enque(20);
		dequeCostly.enque(30);
		dequeCostly.enque(40);

		Assert.assertEquals(dequeCostly.length.intValue(), 4);
	}

	@Test
	public void queUsingStackDequeTestDequeCostly() throws Exception {

		dequeCostly = new QueUsingStackDequeCostly(10);

		dequeCostly.enque(10);
		dequeCostly.enque(20);
		dequeCostly.enque(30);
		dequeCostly.enque(40);

		Assert.assertEquals(dequeCostly.length.intValue(), 4);

		Assert.assertEquals(dequeCostly.deque().intValue(), 10);
		Assert.assertEquals(dequeCostly.deque().intValue(), 20);
		Assert.assertEquals(dequeCostly.deque().intValue(), 30);
		Assert.assertEquals(dequeCostly.deque().intValue(), 40);

	}

	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhenDequeEmptyQueDequeCostly() throws Exception {
		dequeCostly = new QueUsingStackDequeCostly(10);
		dequeCostly.enque(10);
		Assert.assertEquals(dequeCostly.length.intValue(), 1);
		Integer sv = dequeCostly.deque();
		Assert.assertEquals(sv.intValue(), 10);
		sv = dequeCostly.deque();
	}
}
