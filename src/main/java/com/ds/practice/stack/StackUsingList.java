package com.ds.practice.stack;

import com.ds.practice.LinkedList;
import com.ds.practice.Node;

import java.util.Scanner;

public class StackUsingList {

	LinkedList stack;
	Node       currentNode;
	int        stackSize;
	int stackLength = 0;

	public StackUsingList(int stackSize) {
		this.stackSize = stackSize;
		stack = new LinkedList();
	}

	int pop() throws Exception {
		if (stackLength <= 0) {
			throw new Exception("Stack is empty");
		}
		Node n = getNodeAt(stackLength);
		stackLength--;
		return n.getValue();
	}

	void push(int ele) throws Exception {
		if (stackLength <= stackSize) {
			if (currentNode == null) {
				stack.add(ele);
			}
			stackLength++;
		} else {
			throw new Exception("Stack is overflown");
		}
	}

	Node getNodeAt(int index) throws Exception {
		if (index < 0 || index > stackSize) {
			throw new Exception("Stack is underflow/overlow index");
		}
		return stack.getElementAt(index);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int stackSize = sc.nextInt();
		StackUsingList stackUsingList = new StackUsingList(stackSize);
		while (stackSize > 0) {
			stackUsingList.push(stackSize * 4);
			stackSize--;
		}
		stackUsingList.push(90);
		stackUsingList.printStack();
	}

	void printStack() throws Exception {
		int size = stackSize;
		while (size > 0) {
			System.out.print(pop() + ", ");
			size--;
		}
	}
}
