package com.ds.practice.list;


public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] { 1, 3, 4, 6, 7, 10, 12, 34, 56, 18, 7, 45, 32, 33 }).build();
		linkedList.printList(linkedList.head);
	}

}
