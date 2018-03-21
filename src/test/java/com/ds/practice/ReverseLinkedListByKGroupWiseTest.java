package com.ds.practice;

import com.ds.practice.list.Node;
import com.ds.practice.list.single_linked_list.LinkedList;
import com.ds.practice.list.single_linked_list.LinkedListUtils;
import com.ds.practice.list.single_linked_list.ReverseLinkedByKGroupWise;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListByKGroupWiseTest {
	ReverseLinkedByKGroupWise groupWise = new ReverseLinkedByKGroupWise();

	@Test
	public void subPartTest() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 35, 4, 56, 2, 47, 1}).build();
		LinkedList list = groupWise.getSubPart(linkedList.getHead(), 1 ,3);
		list.printList(list.getHead());
		list = groupWise.getSubPart(linkedList.getHead(), 4 ,6);
		list.printList(list.getHead());

	}

	@Test
	public void reverseTest() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 35, 4, 56, 2, 47, 1}).build();
		LinkedList list = groupWise.getSubPart(linkedList.getHead(), 1 ,3);
		Node rev = groupWise.reverse(list.getHead());
		list.printList(rev);
		list = groupWise.getSubPart(linkedList.getHead(), 4 ,6);
		rev = groupWise.reverse(list.getHead());
		list.printList(rev);
	}

	@Test
	public void getNodeaAtTest() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 35, 4, 56, 2, 47, 1}).build();
		Node node = groupWise.getNodeAt(linkedList.getHead(), 2);
		Assert.assertEquals(node.getValue().intValue(), 41);
	}

	@Test
	public void testReverseListGroupWise(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 4, 12, 34, 35, 1, 2, 3 }).build();

		ReverseLinkedByKGroupWise kGroupWise = new ReverseLinkedByKGroupWise();
		Node n = kGroupWise.reverse(linkedList.getHead(), 3);
		linkedList.printList(n);
		Assert.assertNotNull(n);

	}


	@Test
	public void testReverseListGroupWise2(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 4, 12, 34, 35, 1, 2, 3, 100, 200 }).build();

		ReverseLinkedByKGroupWise kGroupWise = new ReverseLinkedByKGroupWise();
		Node n = kGroupWise.reverse(linkedList.getHead(), 3);
		linkedList.printList(n);
		//Assert.assertNotNull(n);

	}

	@Test
	public void testReverseListGroupWise3(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 4, 12, 34, 35, 1, 2, 3, 100, 200 }).build();

		ReverseLinkedByKGroupWise kGroupWise = new ReverseLinkedByKGroupWise();
		Node n = kGroupWise.reverse(linkedList.getHead(), 5);
		linkedList.printList(n);
		//Assert.assertNotNull(n);

	}

	@Test
	public void testReverseGroupWiseRecursion(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 4, 12, 34, 35, 1, 2, 100, 200, 12 }).build();

		ReverseLinkedByKGroupWise kGroupWise = new ReverseLinkedByKGroupWise();
		Node n = kGroupWise.reverseKNodesRecursion(linkedList.getHead(), 3);
		linkedList.printList(n);
		Assert.assertNotNull(n);

	}

}
