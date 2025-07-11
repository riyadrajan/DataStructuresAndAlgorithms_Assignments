package coen352A1;
import java.util.*;
import java.io.*;

public class Q2 {  
    // Head of the Linked List
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
    
    public void DeleteRange(int start, int end){
    	//figure out how to access start index
    	//what is the method for deleting a node?
    	// perform delete method until end index
    	//check if start and end are out of bound 
    	//so get length of linked list
    	Node temp = head;
		Node prev = null;
		
    	int length = getLength();
    	if (start < 0 || start >= length ) {
    		System.out.println("start length out of bounds");
    		return;
    	} else if (end < 0 || end >= length) {
    		System.out.println("end length out of bounds");
    		return;
    	} else if (end < start ) {
    		System.out.println("end length out of bounds");
    		return;
    	} else if (head == null) {
    		return;
    	}
    	
    	
    	//move temp up to the start node
    	for (int i = 0; temp != null && i < start; i++) {
            prev = temp;
    		temp = temp.next;
        }
    	
    	//now delete the nodes
    	if (prev == null) {
            for (int i = start; temp != null && i <= end; i++) {
                temp = temp.next;
            }
            head = temp; // Move head to the new start
        } else {
            // Delete nodes in the range
            for (int i = start; temp != null && i <= end; i++) {
                temp = temp.next;
            }
            prev.next = temp; // Connect the previous node to the new start
        }

    	
    	//iterate and delete nodes here
		//move to start node  
    	
    	
    	
    	
    }
    
    public int getLength() {  
        int count = 0;
        Node last = head;  

        while (last != null) {  
            count++;  
            last = last.next;  
        }  

        return count;  
    }


    // Main method to test the linked list
    public static void main(String[] args) {  
        Q2 list = new Q2();  // Create LinkedList object
        
        list.insert(1);  
        list.insert(2);  
        list.insert(3);  
//        list.insert(4);
//        list.insert(5);
//        list.insert(6);
        System.out.println(list.getLength());
        list.printList();  // Expected Output: LinkedList: 1 2 3 
        list.DeleteRange(0, 1);
        list.printList();
    }  
}
