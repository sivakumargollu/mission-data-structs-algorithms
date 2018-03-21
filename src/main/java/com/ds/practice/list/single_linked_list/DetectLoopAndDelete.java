package com.ds.practice.list.single_linked_list;

import com.ds.practice.list.Node;

import java.util.HashSet;

public class DetectLoopAndDelete {

	public boolean detectLoop(Node head){

		Node root = head;
		if(head == null){
			return false;
		}

		HashSet<Integer> nodeHashSet = new HashSet<>();
		Node prev = null;
		boolean loopExists = false;
		while (head != null){
			if(!nodeHashSet.contains(head.getValue())){
				nodeHashSet.add(head.getValue());
			} else {
				System.out.println("Loop exists at " + head.getValue());
				loopExists = true;
				break;
			}
			prev = head;
			head = head.getNextNode();
		}
		prev.setNextNode(null); //breaking loop
		print(root);
		return loopExists;
	}

	public void print(Node node){
		while (node != null){
			System.out.print(node.getValue() + " -> ");
			node = node.getNextNode();
		}
	}
}
