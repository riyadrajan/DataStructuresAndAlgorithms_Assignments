	
package coen352A1;
import java.util.*;

public class Q1 {
	
		private static String getInfixExpression(String input) {
	               
	        //stores operands
	        Stack<String> s1 = new Stack<>();
	        
	        //stores operators
	        Stack<String> s2 = new Stack<>();
	        
	        //splits the string if it has one or more spaces 
	        String[] sub = input.split("\\s+");
	                    
	        for (String value : sub) {
	        	
	        	if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) 
	            {
	                s2.push(value);
	            }
	            
	            //if close parenthesis then pop out 
	            else if (value.equals(")")) 
	            {
	                String operator = s2.pop();
	                String value2 = s1.pop();
	                String value1 = s1.pop();
	                
	                String subExpression = "( " + value1 + " " + operator + " " + value2 + " )";
	                s1.push(subExpression);
	            } 
	            else 
	            {
	                    //push operands
	                    s1.push(value);
	            }
	        }
	        //returns result
	        return s1.pop();
	    }
	 
	       public static void main (String args[]) {
	    	   
	            Scanner scanner =new Scanner(System.in);
	            System.out.print("Enter Expression (With Spaces):");
	            String input = scanner.nextLine();
	            System.out.println("\nThe Result is :"+ getInfixExpression(input));
	            scanner.close();
	        }
	}
	            
	            
	            
	            
	            