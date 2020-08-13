package linkedlist;

import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
	}
	
	
}
public class LinkedListImpl {
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
       head = null;
       System.out.println("Enter the elements to be inserted at beginning of linked list ");
       for(int i = 0; i < n; i++) {
    	   insertAtBeginning(sc.nextInt());
    	   print();
       }
       System.out.println("Enter the element to be deleted ");
       int del = sc.nextInt();
       deleteWithValue(del);
       print();
       sc.close();
	}
	private static void print() {
		Node temp = head;
		
		while(temp != null) {
			System.out.println("data is changed"+ temp.data);
			temp = temp.next;
		}
	}
	
	private static void insertAtBeginning ( int data) {
		
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
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
	
	private static void deleteWithValue ( int data) {
		if(head == null) return;
		Node temp = head;
		if(temp.data == data) {
			temp = temp.next;
			head = temp;
			return;
		}
		
		
		while(temp.next != null) {
			if(temp.next.data == data) {
				temp.next = temp.next.next;
				return;
			}

			temp = temp.next;
		}
		
		
	}

}
