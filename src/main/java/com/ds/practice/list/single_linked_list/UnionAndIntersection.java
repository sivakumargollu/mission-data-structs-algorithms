package com.ds.practice.list.single_linked_list;

import com.ds.practice.list.Node;

public class UnionAndIntersection {

	public Node getUnion(Node head1, Node head2){
		LinkedList list = new LinkedList();
		while (head2 != null){
			list.add(head2.getValue());
			head2 = head2.getNextNode();
		}

		while (head1 != null){
			Integer ele = head1.getValue();
			if(!isExists(head2, ele)){
				list.add(ele);
			}
			head1 = head1.getNextNode();
		}
        return list.getHead();
	}

	public Node getIntersection(Node h1, Node h2){
		LinkedList intersection = new LinkedList();
		while (h1 != null){
			Integer ele = h1.getValue();
			if(isExists(h2, ele)){
				intersection.add(ele);
			}
			h1 = h1.getNextNode();
		}
		return intersection.getHead();
	}

	public boolean isExists(Node head, Integer element) {
		boolean isExists = false;
		while (head != null){
			if(head.getValue().equals(element)){
				isExists = true;
				break;
			}
			head = head.getNextNode();
		}
		return isExists;
	}
}
