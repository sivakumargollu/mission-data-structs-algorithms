package com.ds.practice.SuffixPrefix;

import java.io.IOException;
import java.util.HashMap;

public class Trie {

	TrieNode rootNode;
	class TrieNode {
		HashMap<Character, TrieNode> child;
		boolean eow;

		public TrieNode(){
			child = new HashMap<Character, TrieNode>();
			eow = false;
		}
	}

	public Trie() {
		rootNode = new TrieNode();
	}
	public TrieNode addWord(String word){
		TrieNode currentNode = rootNode;
		for (char c : word.toCharArray()) {
			if(currentNode.child.get(c) != null){
				currentNode = currentNode.child.get(c);
			} else {
				currentNode.child.put(c, new TrieNode());
				currentNode = currentNode.child.get(c);
			}
		}
		currentNode.eow = true;
		return currentNode;
	}

	public boolean search(String word){

		TrieNode currentNode = rootNode;
		if(currentNode == null){
			return false;
		}
		for (char c : word.toCharArray()) {
			if( currentNode.child.get(c) == null){
				return false;
			} else {
				currentNode = currentNode.child.get(c);
			}
		}
		return currentNode.eow;
	}

	public boolean prefixSearch(String prefix) {
		TrieNode currentNode = rootNode;
		boolean prefixExists = true;
		if(currentNode == null){
			return false;
		}
		for (char c : prefix.toCharArray()) {
			if(currentNode.child.get(c) == null){
				prefixExists = false;
			} else {
				currentNode = currentNode.child.get(c);
			}
		}
		return prefixExists;
	}

	public static void main(String[] args) throws IOException {

		Trie trie = new Trie();
		String[] words = new String[]{"abcd", "abgl", "cdf", "abcde", "lmn"};
		String[] searchWords = new String[]{"cdf","lmn", "abg"};
		String[] prefixSearch = new String[]{"ab", "lm", "df"};

		for (String word : words) {
			trie.addWord(word);
		}

		for (String searchWord : searchWords) {
			System.out.println(searchWord + " search : " + trie.search(searchWord));
		}

		for (String search : prefixSearch) {
			System.out.println(search + " search : " + trie.prefixSearch(search));
		}
	}
}
