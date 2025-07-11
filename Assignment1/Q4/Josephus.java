package coen352A1;

import java.util.*;

public class Josephus {
	//Q4
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        //input for N and M
	        System.out.print("Enter number of people (N): ");
	        int N = scanner.nextInt();

	        System.out.print("Enter step count (M): ");
	        int M = scanner.nextInt();

	        scanner.close();

	        //queue for the people in the circle
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < N; i++) {
	            queue.add(i); // Add people 0 to N-1 to the queue
	        }

	        System.out.print("Elimination order: ");
	        
	        while (queue.size() > 1) {
	            // Skip M-1 people and remove the Mth person
	            for (int i = 1; i < M; i++) {
	                queue.add(queue.poll()); // Move first person to the back
	            }
	            // Remove the Mth person
	            System.out.print(queue.poll() + " ");
	        }

	        // The last remaining person
	        System.out.println("\nJosephus should sit at position: " + queue.peek());
	    }
	}

