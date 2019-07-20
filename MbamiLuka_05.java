import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class reads several lines of infix expressions from an input file, 
 * converting them into their respective postfix expressions by using the
 * convertToPostfix method from the Postfix class.
 * 
 * @author Mbami Luka + Zach Morlan
 *
 */
public class MbamiLuka_05 
{

	public static void main ( String[] args) throws FileNotFoundException 
	{
		Postfix expression;
		
		final String INPUT_FILENAME;				// Name of inputFile
		INPUT_FILENAME = "Project05_Input.txt";
		
		File inputFile = new File (INPUT_FILENAME);	// New input file 
		Scanner input = new Scanner( inputFile);	// Scanner reading file
		
		String div = "_____________________________________________"
				   + "_____________________________________________";
		
		// Print Header and a divider
		System.out.printf ("%-51s %30s\n", "INFIX", "POSTFIX");
		System.out.println (div);
		
		
		// Read each input line and convert to its Postfix expression
		while ( input.hasNextLine())
		{
			String lineRead = input.nextLine();
			String lineFormatted = lineRead.trim();
			
			expression = new Postfix ();
			String exp = expression.convertToPostfix ( lineFormatted);
			
			System.out.printf ( "\n%-52s %37s\n", lineRead, exp);
			System.out.println (div);
			
			
		} // End while loop reading lines
	input.close();
	}

}
