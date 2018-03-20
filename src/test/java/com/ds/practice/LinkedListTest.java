package com.ds.practice;

import com.ds.practice.list.single_linked_list.LinkedList;
import com.ds.practice.list.single_linked_list.LinkedListUtils;
import com.ds.practice.list.single_linked_list.Node;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

	LinkedListUtils linkedListUtils = new LinkedListUtils();
	@Test
	public void testLinkedListMiddleElement() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] { 1, 3, 4, 6, 7, 8 }).build();
		Node middleNode = linkedList.getMiddleNode(linkedList.getHead());
		Assert.assertEquals(middleNode.getValue().intValue(), 4);
	}

	@Test
	public void testLinkedListMiddleElement2() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] { 1, 3, 4, 6}).build();
		Node middleNode = linkedList.getMiddleNode(linkedList.getHead());
		Assert.assertEquals(middleNode.getValue().intValue(), 3);
	}

	@Test
	public void testLinkedListMiddleElement3() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1}).build();
		Node middleNode = linkedList.getMiddleNode(linkedList.getHead());
		Assert.assertEquals(middleNode.getValue().intValue(), 1);
	}

	@Test
	public void isListPallendrom() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 3, 4, 6, 4, 3, 1}).build();
		boolean pallendrom = linkedList.isPallendrom(linkedList.getHead());
		Assert.assertTrue(pallendrom);

	}

	@Test
	public void isListPallendrom2() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 3, 4, 6, 4, 3, 1, 7}).build();
		boolean pallendrom = linkedList.isPallendrom(linkedList.getHead());
		Assert.assertTrue(!pallendrom);
	}

	@Test
	public void isListPallendrom3() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1,  1, 1}).build();
		boolean pallendrom = linkedList.isPallendrom(linkedList.getHead());
		Assert.assertTrue(pallendrom);
	}

	@Test
	public void testOriginalListModified() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 3, 4, 6, 4, 3, 1, 7}).build();
		Node oldHead = linkedList.getHead();
		boolean pallendrom = linkedList.isPallendrom(linkedList.getHead());
		Assert.assertTrue(!pallendrom);
		Node newHead = linkedList.getHead();
		while (oldHead.getNextNode() != null && newHead.getNextNode() != null) {
			Assert.assertEquals(oldHead.getValue().intValue(), newHead.getValue().intValue());
			oldHead = oldHead.getNextNode();
			newHead = newHead.getNextNode();
		}
	}

	@Test
	public void testRecursiveReverse(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).build();
		Node reverseHead = linkedList.reverseListRec(linkedList.getHead());
		Assert.assertNotNull(reverseHead);
		Assert.assertEquals(reverseHead.getValue().intValue(), 9);
		Assert.assertEquals(reverseHead.getNextNode().getValue().intValue(), 8);
	}

	@Test
	public void testRecursiveReverse2(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 2, 3, 4, 5,109, 45, 68}).build();
		Node reverseHead = linkedList.reverseListRec(linkedList.getHead());
		Assert.assertNotNull(reverseHead);
		Assert.assertEquals(reverseHead.getValue().intValue(), 68);
		Assert.assertEquals(reverseHead.getNextNode().getValue().intValue(), 45);
	}

	@Test
	public void testRemoveDuplicates(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 7}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node head = linkedListUtils.removeDuplicatesFromSortedList(linkedList.getHead());
		linkedList.printList(head);
		Assert.assertEquals(7, linkedListUtils.lenth4mNode(head).intValue());
	}


	@Test
	public void testRemoveDuplicatesFromUnsortedList(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 2, 1, 3, 2, 5, 3, 4, 6, 6, 4, 1 ,2 ,8 ,9 ,2}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node head = linkedListUtils.removeDuplicates(linkedList.getHead());
		linkedList.printList(head);
		Assert.assertEquals(8, linkedListUtils.lenth4mNode(head).intValue());
	}

	@Test
	public void testRemoveDuplicatesFromUnsortedListHashing(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {1, 2, 1, 3, 2, 5, 3, 4, 6, 6, 4, 1 ,2 ,8 ,9 ,2}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node head = linkedListUtils.removeDuplicatesHashing(linkedList.getHead());
		linkedList.printList(head);
		Assert.assertEquals(8, linkedListUtils.lenth4mNode(head).intValue());
	}

	@Test
	public void getMiddleNodeRecursion(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 20, 30}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		linkedList.printList(linkedList.getHead());
		Node middle = linkedListUtils.getMiddleRec(linkedList.getHead());
		Assert.assertEquals(middle.getValue().intValue(), 20);
	}

	@Test
	public void getMiddleNodeRecursion2(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 20, 30, 40}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		linkedList.printList(linkedList.getHead());
		Node middle = linkedListUtils.getMiddleRec(linkedList.getHead());
		Assert.assertEquals(middle.getValue().intValue(), 20);
	}

	@Test
	public void mergeTest(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {5, 20, 15, 30}).build();
		LinkedList linkedList2 = new LinkedList.ArrayLinkedListBuilder().add(new int[] {2, 13, 23, 25,45}).build();

		LinkedListUtils linkedListUtils = new LinkedListUtils();
		linkedList.printList(linkedList.getHead());
		linkedList2.printList(linkedList2.getHead());

		LinkedList mergedList = linkedListUtils.merge(linkedList.getHead(), linkedList2.getHead());
		mergedList.printList(mergedList.getHead());
	}

	@Test
	public void mergeTest1(){
		LinkedList linkedList = new LinkedList(); //new LinkedList.ArrayLinkedListBuilder().add(new int[] {5, 20, 15, 30}).build();
		LinkedList linkedList2 = new LinkedList.ArrayLinkedListBuilder().add(new int[] {2, 13, 23, 25,45}).build();

		LinkedListUtils linkedListUtils = new LinkedListUtils();
		LinkedList mergedList = linkedListUtils.merge(linkedList2.getHead(), linkedList.getHead());
		mergedList.printList(mergedList.getHead());
	}

	@Test
	public void testMergeSort(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 4, 35}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node node = linkedListUtils.mergeSort(linkedList);
		linkedList.printList(node);
		Assert.assertNotNull(node);
		Assert.assertEquals(node.getValue().intValue(), 4);
	}

	@Test
	public void testMergeSort2(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 35, 4, 56, 2, 47, 1, 100, -12}).build();
		Node n = linkedListUtils.mergeSort(linkedList);
		linkedList.printList(n);
		Assert.assertNotNull(n);
		Assert.assertEquals(n.getValue().intValue(), -12);

	}


	@Test
	public void getNodeAtTest(){
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 41, 35, 4, 56, 2, 47, 1}).build();
		LinkedListUtils linkedListUtils = new LinkedListUtils();
		Node node = linkedListUtils.getNodeAt(linkedList.getHead(), 1);
		Assert.assertNotNull(node);
		Assert.assertEquals(node.getValue().intValue(), 10);

		Node lastNode = linkedListUtils.getNodeAt(linkedList.getHead(), linkedListUtils.getLength(linkedList.getHead()));
		Assert.assertNotNull(lastNode);
		Assert.assertEquals(lastNode.getValue().intValue(), 1);
	}





}
