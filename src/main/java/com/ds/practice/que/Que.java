package com.ds.practice.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//using arrays
public class Que {

	int fronIndex = -1;
	int rearIndex = -1;
	int[] que;
	int size;

	public Que(int size){
		this.size = size;
		this.que = new int[size];
	}

	public void enque(int element) throws Exception {
		if(rearIndex >= size){
			throw new Exception("Que is full");
		}
		que[++rearIndex] = element;
		if(fronIndex < 0){
			fronIndex = rearIndex;
		}
	}

	public int deque() throws Exception {
		if(fronIndex > rearIndex){
			throw new Exception("Que is empty");
		}
		int ele = que[fronIndex];
		fronIndex++;
		return ele;
	}

	public void print() throws Exception {
		int front = fronIndex;
		while (front <= rearIndex) {
			System.out.print(deque() + "<--");
			front++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer size = Integer.parseInt(br.readLine());
		Que que = new Que(size);
		while (size > 0){
			que.enque(size * 5);
			size--;
		}
		que.print();
	}

}
