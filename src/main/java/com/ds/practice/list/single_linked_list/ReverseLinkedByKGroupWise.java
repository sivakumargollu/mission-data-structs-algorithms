package com.ds.practice.list.single_linked_list;

import com.ds.practice.list.Node;

import java.util.Queue;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * Example:
 Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 Output:  3->2->1->6->5->4->8->7->NULL.

 Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 Output:  5->4->3->2->1->8->7->6->NULL.
 */
public class ReverseLinkedByKGroupWise {

	public Node reverse(Node head, Integer k) {
		Integer len = length(head);

		if(k > len) {
			System.out.println("Can't perform group reverse");
			return head;
		}

		Integer groups = len / k;
		java.util.LinkedList<Node> que = new java.util.LinkedList<>();
		Integer counter = 0;
		Node newHead = null;

		while (counter < groups){
			Integer start = (counter * k) + 1;
			Integer end = (counter + 1) * k;
			LinkedList subPart = getSubPart(head, start, end);
			Node revNode = reverse(subPart.getHead());
			que.add(revNode);
			counter++;
		}

	    Node current = que.poll();
		newHead = current;

		while (!que.isEmpty()) {
			Node currentLast = getNodeAt(current, k);
			currentLast.setNextNode(que.poll());
			current = currentLast.getNextNode();
		}
		//Hadling remainder part, n = 11, k=3, then 3*3 9 elements will process
		//To process remaining elements i.e 10, 11 position below logic works
		Integer start = (counter * k) + 1;
		Integer end = (counter * k) + (len % k);
		getNodeAt(current, k).setNextNode(reverse(getSubPart(head, start, end).getHead()));
		
		return newHead;
	}

	public Integer length(Node head) {
		Integer length = 0;
		while (head != null){
			length++;
			head = head.getNextNode();
		}
		return length;
	}

	public Node getNodeAt(Node head, Integer k){
		while (k-- > 1 && head.getNextNode() != null){
			head = head.getNextNode();
		}
		return head;
	}

	public LinkedList getSubPart(Node head, Integer start, Integer end) {
		Node startNode = getNodeAt(head, start);
		Integer length = end - start;
		LinkedList linkedList = new LinkedList();
		while (length >= 0) {
			linkedList.add(startNode.getValue());
			startNode = startNode.getNextNode();
			length--;
		}
		return linkedList;
	}

	public Node reverse(Node head){
		if(head == null){
			return head;
		}
		Stack<Node> stack = new Stack<>();
		Node current = head;
		while (current !=null){
			stack.push(current);
			current = current.getNextNode();
		}
		Node newHead = stack.pop();
		current = newHead;

		while (!stack.isEmpty()){
			Node currentNxt = stack.pop();
			current.setNextNode(currentNxt);
			current = currentNxt;
		}
		current.setNextNode(null);
		return newHead;
	}

	public Node reverseKNodesRecursion(Node head, Integer k){
		if(head == null){
			return head;
		}

		Integer counter = 1;
		Node prev = null;
		Node current = head;
		Node next = null;

		while (counter <= k && current != null){
			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
			counter++;
		}
		 head.setNextNode(reverseKNodesRecursion(current, k));
		return prev;
	}

	/**
	 *
	 * @param head
	 * @param k
	 * @return
	 *
	 * Reverses the list by alternative K nodes
	 */
	public Node reverseAltKnodes(Node head, Integer k){
		if(head == null){
			return head;
		}

		Integer counter = 1;
		Integer counter2 = 1;
		Node prev = null;
		Node current = head;
		Node next = null;

		while (counter <= k && current != null){
			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
			counter++;
		}

		head.setNextNode(current);
		current = head.getNextNode();
		while (counter2 < k && current != null){
			current = current.getNextNode();
			counter2++;
		}
		if(current != null)
		  current.setNextNode(reverseAltKnodes(current.getNextNode(), k));
		return prev;
	}
}
