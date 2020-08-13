package linkedlist;

import java.util.Scanner;

public class CycleLinkedList {
	static Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Enter the number of elements");
	       Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();
	       System.out.println("Enter the elements to be inserted");
	       for(int i = 0; i < n; i++) {
	    	   insertAtEnd(sc.nextInt());
	    	   print();
	       }
	       sc.close();
	       //createCycle();
	       System.out.println("Cycle exists"+isCycleExists());
	       
	}
	private static void createCycle() {
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
	}
	private static void print() {
		Node temp = head;
		
		while(temp != null) {
			System.out.println("data "+ temp.data);
			temp = temp.next;
		}
	}
	private static void insertAtEnd(int data) {
		
		if(head == null) {
			head = new Node(data);
			head.next = null;
			return;
		}
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		Node temp1 = new Node(data);
		temp.next = temp1;
	}
	
	private static boolean isCycleExists() {
		Node temp = head;
		
		Node fast = temp.next;
		Node slow = temp;
		
		while(fast != null && fast.next != null && slow != null) {
			
			if(fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

}
