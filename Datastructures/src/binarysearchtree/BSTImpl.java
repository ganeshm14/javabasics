package binarysearchtree;

import java.util.Scanner;

public class BSTImpl {
	class Tree{
		int data;
		Tree left;
		Tree right;
		Tree(int data){
			this.data = data;
		}
	}
    Tree root;
    
	public static void main(String[] args) {
		BSTImpl bst = new BSTImpl();
		System.out.println("Enter the number of elements");
	       Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();
	       System.out.println("Enter the elements to be inserted");
	       for(int i = 0; i < n; i++) {
	    	   bst.insertBST(sc.nextInt());
	       }
	       System.out.println("The elements are : ");
	       bst.printInOrder();
	       System.out.println("Enter the element to search ");
	       System.out.println("element is "+ bst.search(sc.nextInt()));
	       
	       System.out.println("Enter the element to deleted ");
	       bst.delete(sc.nextInt());
	       System.out.println("The elements are : ");
	       bst.printInOrder();
	       System.out.println("pre order The elements are : ");
	       bst.printPreOrder();
	       sc.close();
	}
	
	void insertBST(int data) {
		root = insertBST(root,data);
	}
	
	private Tree insertBST(Tree root,int data) {
		if(root == null) {
			root = new Tree(data);
			return root;
		}
		if(data <= root.data) {
			root.left = insertBST(root.left,data);
		}
		else {
			root.right = insertBST(root.right,data);
		}
		return root;
	}
	
	void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Tree root) {
		if(root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.println("data "+root.data);
		printInOrder(root.right);
	}
	
	void printPreOrder() {
		printPreOrder(root);
	}
	
	private void printPreOrder(Tree root) {
		if(root == null) {
			return;
		}

		System.out.println("data "+root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	int search(int data) {
		Tree node = search(root, data);
		if(node != null) {
			return node.data;
		}
		return -1;
	}
	Tree search(Tree root, int data) {
		if(root == null) {
			return null;
		}
		if(data == root.data) {
			return root;
		}
		if(data <= root.data) {
			return search(root.left,data);
		}else {
			return search(root.right,data);
		}
	}
	
	void delete(int data) {
		root = delete(root,data);
		
	}
	
	Tree delete(Tree root, int data) {
		
		if(root == null) {
			return null;
		}
		
		if(data < root.data) {
			System.out.println("left "+root.data);
			root.left = delete(root.left,data);
		}else if(data > root.data){
			System.out.println("right "+root.data);
			root.right = delete(root.right,data);
		}
		else {
			System.out.println("inside else "+root.data);
			if(root.left == null) {
				System.out.println("inside else root left "+root.data);
				return root.right;
			}
			else if(root.right == null) {
				System.out.println("inside else root right "+root.data);
				return root.left;
			}
			
//			root.data = findMin(root.right);
//			System.out.println("root data "+root.data);
//			root.right = delete(root.right,root.data);
//			System.out.println("root data after root right "+root.right.data);
			
			
			root.data = findMax(root.left);
			
			root.left = delete(root.left,root.data);
		}
		System.out.println("root data final block "+root.data);
		return root;
	}
	
	int findMax(Tree root) {
		int max = root.data;
		while(root.right != null) {
			max = root.right.data;
			root = root.right;
		}
		System.out.println("inside max "+max);
		return max;
	}

	
	int findMin(Tree root) {
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		System.out.println("inside min "+min);
		return min;
	}

}
