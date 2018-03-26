package com.ds.practice.recursion;

import org.junit.Assert;
import org.junit.Test;

public class MaxPallendrom {

	@Test
	public void testMaxPallendrom(){
		problems.interview.MaxPallendrom maxPallendrom = new problems.interview.MaxPallendrom();
		String s = "abbaa";
		String result = maxPallendrom.maxPallendrom(s);
		System.out.println("Max possible pallendrom " + result);
		Assert.assertEquals(result, "abba");
	}

	@Test
	public void testMaxPallendrom2(){
		problems.interview.MaxPallendrom maxPallendrom = new problems.interview.MaxPallendrom();
		String s = "abcdedf";
		String result = maxPallendrom.maxPallendrom(s);
		System.out.println("Max possible pallendrom " + result);
		Assert.assertEquals(result, "");
	}

	@Test
	public void testMaxPallendrom3(){
		problems.interview.MaxPallendrom maxPallendrom = new problems.interview.MaxPallendrom();
		String s = "abcdeffedcbhijklkji";
		String result = maxPallendrom.maxPallendrom(s);
		System.out.println("Max possible pallendrom " + result);
		Assert.assertEquals("bcdeffedcb", result);
	}

	@Test
	public void testMaxPallendrom4(){
		problems.interview.MaxPallendrom maxPallendrom = new problems.interview.MaxPallendrom();
		String s = "a";
		String result = maxPallendrom.maxPallendrom(s);
		System.out.println("Max possible pallendrom " + result);
		Assert.assertEquals("a", result);
	}
}
