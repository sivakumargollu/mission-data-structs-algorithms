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

		return mergeLinkedList(left, right, null);

	}

	public Node mergeLinkedList(Node l, Node r, Node merged){
		if(l == null && r != null){
			while (r != null){
				merged.setNextNode(new Node(r.getValue()));
				r = r.getNextNode();
			}
			return merged;
		}

		if(r == null && l != null){
			while (l != null){
				merged.setNextNode(new Node(l.getValue()));
				l = l.getNextNode();
			}
			return merged;
		}

		if(l.getValue() > r.getValue()){
			merged = addValue(merged, r.getValue());
			mergeLinkedList(l, r.getNextNode(), merged);
		} else {
			merged = addValue(merged, l.getValue());
			mergeLinkedList(l.getNextNode(), r, merged);
		}
		return merged;
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
