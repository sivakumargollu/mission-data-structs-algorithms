package com.ds.practice.stack;

import com.ds.practice.que.Que;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackUsingQue {

	int stackSize;
	Que que;
	int stackLength = 0;

	public StackUsingQue(int stackSize) {
		this.stackSize = stackSize;
		que = new Que(stackSize * 11);
	}

	public void push(int ele) throws Exception {
		if (stackLength > stackSize) {
			throw new Exception("Stack is full");
		}
		que.enque(ele);
		for (int i = 0; i < stackLength; i++) {
			que.enque(que.deque());
		}
		stackLength++;
	}

	public int pop() throws Exception {
		if (stackLength <= 0) {
			throw new Exception("Stack is empty");
		}
		int ele = que.deque();
		stackLength--;
		return ele;
	}

	public void print() throws Exception {
		int size = stackLength;
		while (size > 0) {
			System.out.print(pop() + " <-- ");
			size--;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer size = Integer.parseInt(br.readLine());
		StackUsingQue stackUsingQue = new StackUsingQue(size);
		while (size > 0) {
			stackUsingQue.push(size * 10);
			size--;
		}
		stackUsingQue.print();
	}
}
