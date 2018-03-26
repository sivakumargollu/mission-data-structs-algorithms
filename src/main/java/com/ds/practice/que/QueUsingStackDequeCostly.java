package com.ds.practice.que;

import com.ds.practice.stack.StackUsingList;

public class QueUsingStackDequeCostly {

	Integer length = 0;
	StackUsingList stack1;
	StackUsingList stack2;

	public QueUsingStackDequeCostly(Integer size){
		stack1 = new StackUsingList(size);
		stack2 = new StackUsingList(size);
	}

	public void enque(Integer value) throws Exception {
		stack1.push(value);
		length++;
	}

	public Integer deque() throws Exception {
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		length--;
		return stack2.pop();
	}

	public boolean isEmpty() {
		return length == 0;
	}
}
