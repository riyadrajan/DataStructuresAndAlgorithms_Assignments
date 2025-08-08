package A3;
import java.io.*;
import java.util.Scanner;


public class A3_5 {
    //symbol table with BST implementation
    private static class BST<Key extends Comparable<Key>, Value> {
        private Node root;
        
        private class Node {
            Key key;
            Value val;
            Node left, right;
            int size;
            Node(Key key, Value val, int size) {
                this.key = key;
                this.val = val;
                this.size = size;
            }
        }
        
        public int size() {
            return size(root);
        }
        
        private int size(Node x) {
            return (x == null) ? 0 : x.size;
        }
        
        public Value get(Key key) { //calls other get function
            return get(root, key); //searches for a specific key and returns the associated value
        }
        
        private Value get(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return get(x.left, key);
            else if (cmp > 0) return get(x.right, key);
            else return x.val;
        }
        
        public void put(Key key, Value val) { // calls other put function
            root = put(root, key, val);
        }
        
        private Node put(Node x, Key key, Value val) {
            if (x == null) return new Node(key, val, 1);
            
            int cmp = key.compareTo(x.key);
            
            if (cmp < 0) {
            	x.left = put(x.left, key, val);
            }
            else if (cmp > 0) {
            	x.right = put(x.right, key, val);
            }
            else {
            	x.val = val;
            }
            x.size = 1 + size(x.left) + size(x.right); 
            return x;
        }
    }

    public static void main(String[] args) {
        BST<String, Double> st = new BST<>();
        st.put("A+", 4.33);
        st.put("A", 4.00);
        st.put("A-", 3.67);
        st.put("B+", 3.33);
        st.put("B", 3.00);
        st.put("B-", 2.67);
        st.put("C+", 2.33);
        st.put("C", 2.00);
        st.put("C-", 1.67);
        st.put("D", 1.00);
        st.put("F", 0.00);

        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int count = 0;
        
        System.out.println("Enter letter grades separated by a comma and no spaces (A+,A,A-, ... ,C-,D,F): ");
       //Sample input A+,A-,B-,C 
        
        while (true) {
            String all_grades = scanner.nextLine();
            if (all_grades.trim().isEmpty()) break; //accepts grade inputs until blank line (press enter twice)
            String[] grades = all_grades.split(",");
            for (String grade : grades) {
                Double score = st.get(grade); //gets the associated numerical grade value
                if (score != null) { 
                    total += score;
                    count++;
                } else {
                    System.out.println("Invalid grade: " + grade);
                }
            }
        }
        scanner.close();

        if (count > 0) {
            double gpa = total / count;
            System.out.printf("Your GPA is: %.2f%n", gpa);
        } else {
            System.out.println("No valid grades entered.");
        }
    }
    
}


