package com.ds.practice.list.single_linked_list;


import java.util.Stack;

public class LinkedList {

	Node head;
	Node prev;
	Integer size=0;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Node add(Integer value) {
		if (head == null) {
			head = new Node(value);
			prev = head;
			size++;

		} else {
			Node n = new Node(value);
			prev.setNextNode(n);
			prev = n;
			size++;
		}
		return prev;
	}

	public Node remove(Integer value) {
		Node head = this.head;
		Node currnetNode = head;
		Node prev = null;
		while (currnetNode != null) {
			if (currnetNode.getValue().intValue() == value) {
				System.out.println("Removing node " + currnetNode.getValue());
				if (prev == null) {
					return currnetNode.getNextNode();
				}
				prev.setNextNode(currnetNode.getNextNode());
				break;
			} else {
				prev = currnetNode;
				currnetNode = currnetNode.getNextNode();
			}
		}
		return head;
	}

	public void printList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.getValue() + "-->");
			currNode = currNode.getNextNode();
		}
		System.out.println("");
	}

	public static class ArrayLinkedListBuilder {
		int[] elements;

		public ArrayLinkedListBuilder add(int[] arr) {
			this.elements = arr;
			return this;
		}

		public LinkedList build() {
			LinkedList linkedList = new LinkedList();
			for (int element : elements) {
				linkedList.add(element);
			}
			return linkedList;
		}
	}

	public Node getElementAt(int reqIndex) {
		int currentIndex = 1;
		Node currentNode = head;
		Node reqNode = null;
		while (currentNode != null) {
			if (currentIndex == reqIndex) {
				reqNode = currentNode;
				break;
			} else {
				currentNode = currentNode.getNextNode();
				currentIndex++;
			}
		}
		return reqNode;
	}

	public Node reverseList(Node node){

		Node nextNode;
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while ((nextNode = node.getNextNode()) != null){
			stack.push(nextNode);
			node = nextNode;
		}

		Node newHead = stack.pop();
		node = newHead;

		while (!stack.isEmpty()){
			Node currentNode = stack.pop();
			node.setNextNode(currentNode);
			node = currentNode;
		}
		//Nullifying previous root to next, To avoid infinit loop
		node.setNextNode(null);
		return newHead;
	}

	//Needs correction.
	//1->2->3->4 to 4->3->2->1
	public Node recuriveReverse(Node currNode){
		if (currNode.getNextNode() != null){
			recuriveReverse(currNode.getNextNode()).setNextNode(currNode);
		} else {
			return currNode;
		}
		return currNode;
	}

	public Node reverseListRec(Node head){
		Node newHead = null;
		Node mayBeLastNode = head;
		while (mayBeLastNode.getNextNode() != null){
			mayBeLastNode = mayBeLastNode.getNextNode();
		}
		newHead = mayBeLastNode;
		Node reverseHead = recuriveReverse(head);
		reverseHead.setNextNode(null);
		return newHead;
	}

	//Checks give linked list is pallendrom or not
	public boolean isPallendrom(Node head) {

		Node middleNode = getMiddleNode(head);
		//Reversing second half of the list
		Node reversedHead = reverseList(middleNode.getNextNode());

		Node h1= head;
		Node rh = reversedHead;
		boolean isPallendrom = true;

		//Checking both parts equal or not
		int i = 0;
		while (rh != null) {
			if (h1.getValue() == rh.getValue()) {
				h1 = h1.getNextNode();
				rh = rh.getNextNode();
			} else {
				isPallendrom = false;
				break;
			}
		}

		middleNode.setNextNode(reverseList(reversedHead));
		return isPallendrom;
	}

	public Node getMiddleNode(Node head){
		if(head == null){
			return head;
		}
		Node singlePointer = head;
		Node doublePointer = head.getNextNode();
		Node middleNode = null;
		//Finding the middle element.
		while (true){
			if(doublePointer == null){
				break;
			}
			singlePointer = singlePointer.getNextNode();
			doublePointer = doublePointer.getNextNode();
			if(doublePointer != null){
				doublePointer = doublePointer.getNextNode();
			}

			if(doublePointer != null){
				doublePointer = doublePointer.getNextNode();
			} else {
				break;
			}
		}
		middleNode = singlePointer;
		return middleNode;
	}
}
