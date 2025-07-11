package coen352A1;

import java.util.*;

public class Q3 {
	
	Node head;  
    
    // Single element 
    static class Node {  
        int data;
        Node next;  

        // Constructor
        Node(int data) {  
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {  
        Node newNode = new Node(data);  

        if (head == null) {  //check if linked list is empty
            head = newNode;  
        } else {  //if not at end of node
            Node last = head;  
            while (last.next != null) {  
                last = last.next;  
            }
            last.next = newNode;  
        }  
    }  

    // Method to print the LinkedList
    public void printList() {  
        Node currNode = head;  
        System.out.print("LinkedList: ");  

        while (currNode != null) {  
            System.out.print(currNode.data + " ");  
            currNode = currNode.next;  
        }  
        System.out.println();
    }
    
	public int max(){
		
		if (head == null) { //check if linked list is empty
			return 0;
		}
		
		Node position = head; //reference to first node
		int max = position.data;

		//iterate through linked list
		while(position != null) { //until end of list
			//compare node data to max
			if (position.data > max) {
				max = position.data;
				}	
			position = position.next;
		}
		
		return max; 
		
	}
		

	
	public static void main(String[] args ) {
		Q3 list = new Q3();
		list.insert(70);  
        list.insert(700);  
        list.insert(200); 
        
        System.out.println(list.max());
        
	}
}




