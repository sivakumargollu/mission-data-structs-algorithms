package com.ds.practice;

public class LinkedList {

	Node head;
	Node prev;

	public Node add(Integer value){
		if(head == null){
			head = new Node(value);
			prev = head;

		} else {
			Node n = new Node(value);
			prev.setNextNode(n);
			prev = n;
		}
		return prev;
	}

	public Node remove(Integer value){
		Node head = this.head;
		Node currnetNode = head;
		Node prev = null;
		while (currnetNode != null){
			if(currnetNode.getValue().intValue() == value){
				System.out.println("Removing node " + currnetNode.getValue());
				if(prev == null){
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

	public void printList(Node head){
		Node currNode = head;
		while (currNode != null){
			System.out.print(currNode.getValue() + "-->");
			currNode = currNode.getNextNode();
		}
		System.out.println("");
	}
	static class ArrayLinkedListBuilder {
		int[] elements;

		ArrayLinkedListBuilder add(int[] arr){
			this.elements = arr;
			return this;
		}

		LinkedList build() {
			LinkedList linkedList = new LinkedList();
			for (int element : elements) {
				linkedList.add(element);
			}
			return linkedList;
		}
	}

	public Node getElementAt(int reqIndex){
		int currentIndex = 1;
		Node currentNode = head;
		Node reqNode = null;
		while (currentNode != null){
			if(currentIndex == reqIndex){
				reqNode = currentNode;
				break;
			} else {
				currentNode = currentNode.getNextNode();
				currentIndex++;
			}
		}
		return reqNode;
	}
}
