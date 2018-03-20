package com.ds.practice.list.single_linked_list;

import com.ds.practice.list.Node;

public class LinkedListMergeSort {

	public Node mergeSort(Node head) {
		if(head == null || head.getNextNode() == null){
			return  head;
		}

		Node middle = getMiddle(head);

		Node nextToMiddle = middle.getNextNode();

		//Cutting linked list into two halfs
		middle.setNextNode(null);

		Node left = mergeSort(head);

		Node right = mergeSort(nextToMiddle);

		return mergeLinkedList(left, right);

	}

	public Node mergeLinkedList(Node l, Node r){
		Node result = null;
		if(l == null){
			return r;
		}
		if(r == null){
			return l;
		}

		if(l.getValue() > r.getValue()){
			result = r;
			result.setNextNode(mergeLinkedList(l, r.getNextNode()));
		} else {
			result = l;
			result.setNextNode(mergeLinkedList(l.getNextNode(), r));
		}
		return result;
	}

	public Node addValue(Node n, Integer value){
		if(n == null){
			return new Node(value);
		} else {
			 Node next = new Node(value);
			 n.setNextNode(next);
			 return next;
		}
	}

	public Node getMiddle(Node head){
		if(head == null) {
			return  null;
		}
		Node slowPtr = head;
		Node fastPtr = head.getNextNode();

		while (fastPtr != null){
			if(fastPtr.getNextNode() != null) {
				fastPtr = fastPtr.getNextNode().getNextNode();
			} else {
				break;
			}
			slowPtr = slowPtr.getNextNode();
		}
		return slowPtr;
	}
}
