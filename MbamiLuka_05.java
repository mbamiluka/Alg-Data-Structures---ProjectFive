import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class reads several lines of infix expressions from an input file,
 * converting them into their respective postfix expressions by using the
 * convertToPostfix method from the Postfix class.
 * 
 * Cynosure - An object at the focal point of attention; 
 * Or, something that is used as a guide
 * 
 * "No matter where you go remember the road that will lead you home"
 * - Zanda Zakuza
 * 
 * @author Mbami Luka + Zach Morlan
 *
 */
public class MbamiLuka_05 
{
	public static void main ( String[] args) throws FileNotFoundException 
	{
		
		Postfix expression;								// Postfix instance

		final String INPUT_FILENAME; 					// Name of inputFile
		INPUT_FILENAME = "Project05_Input.txt";
		
		final String OUTPUT_FILENAME; 					// Name of outputFile
		OUTPUT_FILENAME = "Project05_Output.txt";
		
		File inputFile = new File ( INPUT_FILENAME); 	// New input file
		Scanner input = new Scanner ( inputFile); 		// Input file scanner
		
		File outputFile = new File ( OUTPUT_FILENAME);	// Output file
		PrintWriter output = new PrintWriter ( outputFile);
		
		// below is a divider for neatly formatting output
		String div = "_____________________________________________" + 
					 "_____________________________________________" ;
		

		// Print Header and a divider - INFIX & POSTFIX
		System.out.printf ( "%-51s %35s\n", "INFIX", "POSTFIX");
		System.out.println ( div);
		
		output.printf ( "%-51s %35s\n", "INFIX", "POSTFIX");
		output.println ( div);

		// Read each input line and convert to its Postfix expression
		while  ( input.hasNextLine ( )) 
		{
			String lineRead = input.nextLine ( );	// Line read from inputFile

			expression = new Postfix ( );			
			String postfix;							// Postfix expression

			if ( parenthesesIsBalanced ( lineRead)) 
			{
				postfix = expression.convertToPostfix ( lineRead);
				
				// Check if two or more operands are adjacent
				if ( expression.isAdjacentOperand ( lineRead) == true)
				{
					postfix = "None - Adjacent operands";
				}				
			} 
			else 
			{
				postfix = "None - Uneven number of parentheses";
				
			}
			

			System.out.printf ( "\n%-52s %37s\n", lineRead, postfix);
			System.out.println ( div);
			
			output.printf ( "\n%-52s %37s\n", lineRead, postfix);
			output.println ( div);

		} // End while loop reading lines

		input.close ( );
		output.close ( );

	} // End main

	// *************************************************************************
	/**
     * Method checks to see if the number of parentheses 
     * in the infix are the same amount
     * @param	String infix
     * @return	true if even amount of both parentheses
     */
	public static boolean parenthesesIsBalanced ( String infix) 
	{
		int left = 0;
		int right = 0;

		for  ( int i = 0; i < infix.length ( ); i++) 
		{
			if  ( infix.charAt ( i) == '(') 
			{

				left++;

			} // End if
			if  ( infix.charAt ( i) == ')') 
			{

				right++;

			} // End if
			
		} // End for loop
		if  ( left == right) 
		{

			return true;

		} // End if
		else 
		{

			return false;

		} // End else
	} // End parenthesesCheck
	
	//*****************************************************************************

}
