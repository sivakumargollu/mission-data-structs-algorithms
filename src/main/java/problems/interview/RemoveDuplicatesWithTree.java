package problems.interview;

public class RemoveDuplicatesWithTree {

	Node root;
	class Node {
		public Node(int val){
			this.value = val;
		}

		int value;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		RemoveDuplicatesWithTree withTree = new RemoveDuplicatesWithTree();
		int[] input = new int[]{100, 45,2,5,4,4,6,7,8,6,7,4,7,10,12,10};
		for(int i=0; i<input.length; i++){
			withTree.addElement(withTree.root, input[i]);
		}
       withTree.printPostOrder(withTree.root);
	}

	Node addElement(Node n, int ele){
		if(n == null){
		  n = new Node(ele);
		  if(root == null){
		  	root = n;
		  }
		  return n;
		}
		if(ele > n.value){
			n.right = addElement(n.right, ele);
		}
		if(ele < n.value){
			n.left = addElement(n.left, ele);
		}
		return n;
	}
	void printInOrder(Node n){
		if(n==null){
			return;
		}
		printInOrder(n.left);
		System.out.print(n.value + ",");
		printInOrder(n.right);
	}

	void printPostOrder(Node n){
		if(n==null){
			return;
		}
		printInOrder(n.left);
		printInOrder(n.right);
		System.out.print(n.value + ",");
	}
}
