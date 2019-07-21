/**
 * This class combines several methods with the end goal 
 * of converting an infix notation to a postfix notation
 * 
 * @author Mbami Luka + Zach Morlan
 *
 */
public class Postfix 
{
		/**
		 * This method checks if a specified character is any of the valid 
		 * BIDMAS operators. 
		 * @param	character
		 * @return	true if the operator is valid + false if otherwise
		 */
	    private boolean isOperator ( char character) 
	    {
	        if ( character == '+' || character == '-' || character == '*' ||
	        		
	        	 character == '/' || character == '^' || character == '(' || 
	        	 
	        	 character == ')' 
	        	)
	        {
	        	return true;
	        }
	        
	        return false;
	    }
	    //*********************************************************************
	    /**
	     * This method returns a value for the specific 
	     * PEMDAS operators. 
	     * @param	   character
	     * @return     1 if the value is + or -
	     * @return	   2 if the value is * or /
         * @return	   3 if the value is ^
	     * @return    -1 if the value is invalid
	    */
	    public int getPrecedence ( char character)
	    {
	        if ( character == '+' || character == '-') 
	        {        
	            return 1;
	        }
	        else if ( character == '*' || character == '/')
	        {
	            return 2;
	        }

	        else if ( character == '^')
	        {
	            return 3;
	        }
	        return -1;
	        
	    } // End getPrecedence
	    
	  //***********************************************************************

	    // Check if the specified character is an operand
	    public static boolean isOperand ( char character) 
	    {
	        if (character >= 'a' && character <= 'z' || 
	        	character >= 'A' && character <= 'Z'
	           )
	        {
	        	return true;
	        }
	        return false;
	    }
	  //***********************************************************************
	    public static boolean operandCheck ( String infix) 
	    {
	    	infix = infix.trim();
		     char first;
	         char second;

	         for(int i = 0; i < infix.length() - 1; i++) {
	            first = infix.charAt(i);
	            second = infix.charAt(i+1);

	            if(isOperand(first) && isOperand(second)){
	               return false;
	            }// End if             
	         }// End for loop 
	         return true;
		   } // End operandCheck
	  //***********************************************************************
	    public String convertToPostfix ( String infix) 
	    {
	        Stack<Character> stack = new Stack<Character>();
	        String postfix = "";
	        
	        char character;

	        for ( int i = 0; i < infix.length(); i++) 
	        {	        	
	        	infix = infix.trim();
	        	
	        	// pick each letter in infix string
	            character = infix.charAt (i);
	            		
	            // Then, check if character is an operand
	            // If so, it will be added to the postfix variable
	            if ( isOperand ( character)) 
	            {
	                postfix += ( character) + " ";
	                	
	            }
	            
	            // if we encounter '(' we push to stack
	            else if ( character == '(') 
	            {
	                stack.push ( character);
	            }
	            
	            // If current character is ‘)’, pop and output from stack
	            // when ‘(‘ is encountered we stop popping.
	            else if ( character == ')') 
	            {

	                while ( !stack.isEmpty() && stack.peek() != '(') 
	                {
	                	postfix += stack.pop() + " ";
	                }
	                if ( !stack.isEmpty() && stack.peek() != '(')
	                {
	                    return null;
	                }
	                else if ( !stack.isEmpty())
	                {
	                    stack.pop();
	                }
	            }
	            
	            else if ( isOperator ( character))
	            {
	                if ( !stack.isEmpty () && 
	                	  getPrecedence ( character) <= 
	                	  getPrecedence ( stack.peek()	)) 
	                {
	                	postfix += ( stack.pop() + " ");
	                }
	                stack.push ( character);
	            }
	        }

	        while ( !stack.isEmpty()) 
	        {
	        	postfix += ( stack.pop() + " ");
	        }
	        return postfix;
	        
	    } // End convertToPostfix
}
