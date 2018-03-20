package com.ds.practice.list.single_linked_list;

import com.ds.practice.list.Node;

import java.util.HashSet;

public class LinkedListUtils {

	//1->2->3->4->5->5->6->7
	public Node removeDuplicatesFromSortedList(Node head) {
		Node currentNode = head;
		Node prevNode = null;

		while (currentNode.getNextNode() != null){
			Node currentNext = currentNode.getNextNode();
			if(prevNode != null){
				if(prevNode.getValue().intValue() == currentNode.getValue().intValue()){
					prevNode.setNextNode(currentNext);
					currentNode = currentNode.getNextNode();
					continue;
				}
			}
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return head;
	}



	/**
	 * 1->2->3->1->5->5->3->7->1->2->8
	 * @param head
	 * @return
	 *
	 * Time-complexity - O(n*n)
	 * Removes duplicate element from unsorted list, using two loops
	 */
	public Node removeDuplicates(Node head) {
		Node currentNode = head;
		while (currentNode != null){
			Node nextNode = currentNode.getNextNode();
			Node prev = currentNode;
			while (nextNode != null){
				if(currentNode.getValue().equals(nextNode.getValue())){
					prev.setNextNode(nextNode.getNextNode());
				}
				prev = nextNode;
				nextNode = nextNode.getNextNode();
			}
			currentNode = currentNode.getNextNode();
		}
		return head;
	}

	/**
	 * 1->2->3->1->5->5->3->7->1->2->8
	 * @param head
	 * @return
	 *
	 * Time-complexity - O(n*n)
	 * Removes duplicate elements from unsorted list using Hashing.
	 */
	public Node removeDuplicatesHashing(Node head) {
		HashSet<Integer> elementSet = new HashSet<>();
		Node currentNode = head;
		Node prev = null;
		while (currentNode != null){
			if(elementSet.contains(currentNode.getValue())){
				if(prev == null){
					head = currentNode;
				} else {
					prev.setNextNode(currentNode.getNextNode());
				}
			} else {
				elementSet.add(currentNode.getValue().intValue());
				prev = currentNode;
			}
			currentNode = currentNode.getNextNode();
		}
		return head;
	}

	public Node getMiddleRec(Node head){
          return getNodeAt(head,  getMiddleIndex(head));
	}

	public Integer getMiddleIndex(Node head){
	      Integer length = getLength(head);
		  return  (length % 2 == 0 ) ? (length / 2) : (length / 2) + 1;
	}

	public Integer getLength(Node head){
		Integer length = 0;
		while (head != null){
			length++;
			head = head.getNextNode();
		}
		return length;
	}
	/**
	 *
	 * @param head
	 * @param index
	 * @return
	 */
	public Node getNodeAt(Node head, Integer index){
		if(index <= 0) {
			return null;
		}

		Integer counter = 1;
		Node retNode = null;
		while (head != null){
			if(counter == index){
				retNode = head;
				break;
			}
			head = head.getNextNode();
			counter++;
		}
		return retNode;
	}

	/**
	 *
	 * @param node
	 * @return
	 */
	public Integer lenth4mNode(Node node){
		Integer length = 0;
		while (node != null){
			length++;
			node = node.getNextNode();
		}
		return length;
	}

	public LinkedList merge(Node h1, Node h2){
       LinkedList merged = new LinkedList();
       while(h1 != null && h2 != null){
       	 if(h1.getValue() > h2.getValue()){
       	 	merged.add(h2.getValue());
       	 	h2 = h2.getNextNode();
		 } else if (h1.getValue() <= h2.getValue()){
       	 	merged.add(h1.getValue());
       	 	h1 = h1.getNextNode();
		 }
	   }

	   if(h1 != null){
       	while (h1 != null){
       		merged.add(h1.getValue());
       		h1 = h1.getNextNode();
		}
	   }

	   if(h2 != null){
	   	while ((h2 != null)){
	   		merged.add(h2.getValue());
	   		h2 = h2.getNextNode();
		}
	   }
	   return merged;
	}

	public Node mergeSort(LinkedList list){
		Integer length = getLength(list.head);
		LinkedList linkedList = mergeSort(list, 1, length);
		return linkedList.head;
	}

	private LinkedList mergeSort(LinkedList list, Integer start, Integer end){

		Integer diff = end - start;
		if(diff < 0) {
			return list;
		}
		else if(diff > 1) {
			Integer mid = (end + start) / 2;
			LinkedList fH = mergeSort(list, start, mid);
			LinkedList sH = mergeSort(list, mid+1, end);
			LinkedList mergedList = merge(fH.getHead(),sH.getHead());
			return mergedList;
		}
		else if(diff == 0){
		   Node n = getNodeAt(list.head, start);
		   LinkedList linkedList =  new LinkedList();
		   linkedList.add(n.getValue());
		   return linkedList;
		}
		else {
			Node s = getNodeAt(list.head, start);
			Node e = getNodeAt(list.head, end);
			LinkedList linkedList = new LinkedList();
			if(s.getValue() > e.getValue()){
				linkedList.add(e.getValue());
				linkedList.add(s.getValue());
			} else {
				linkedList.add(s.getValue());
				linkedList.add(e.getValue());
			}
			return linkedList;
		}
	}
}
