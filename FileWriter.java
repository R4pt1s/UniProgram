package programm;

import java.io.* ;
import java.util.* ;

public class FileWriter 
{
	private String input ;
	//private Writer outputStream;
	private PrintWriter outputWriter;
	
	
	public FileWriter(String input)
	{
		this.input = input ;
	}
	
	public boolean initWriter()
	{
		try
		{ 
			FileOutputStream outputStream = new FileOutputStream(input);
			PrintWriter outputWriter = new PrintWriter(outputStream);
			this.outputWriter = outputWriter;
			return true ;
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error ");
			return false ;
		}	
	}
	
	public void  writeFile (ArrayList<UniversityAlgorithm> lst )
	{
		for(int i=0;i<lst.size();i++)
		{
			outputWriter.println(lst.get(i));
		}
	}
	
	public void  writeFile1 (String lst )
	{
		outputWriter.println(lst);
		
	}
	
	public void  writeFile2 (double lst )
	{
		outputWriter.println(lst);
		
	}
	
	public void closeWriter()
	{
		outputWriter.close( );
	}
}