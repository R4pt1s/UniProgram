package programm;

import java.util.* ;
import java.io.* ;

public class FileReader
{
	private String input ;
	private Scanner inputReader ;
	
	public FileReader(String input)
	{
		this.input = input  ;		
	}
	
	public boolean initReader()
	{
		try
		{
			File file = new File(input) ;
			Scanner inputReader = new Scanner(file) ; 
			this.inputReader = inputReader ;
			return true ;
		}
	
		catch (FileNotFoundException e)
		{
			System.out.println("Error") ;
			return false ;
		}
	}
	
	public ArrayList<String> readFile()
	{		
		ArrayList<String> arraylst = new ArrayList<String>() ;
		inputReader.nextLine();
		while (inputReader.hasNextLine())
		{
			arraylst.add(inputReader.nextLine()) ;
		}		
		return arraylst ; 
	}
	
	public void closeReader()
	{
		inputReader.close();
	}
}