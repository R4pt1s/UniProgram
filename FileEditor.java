package programm;

//import java.io.* ;
import java.util.* ;


public class FileEditor
{
	private HashMap<Integer,ArrayList<UniversityAlgorithm>> scores = new HashMap<Integer,ArrayList<UniversityAlgorithm>>() ;
	private HashMap<Integer,ArrayList<UniversityAlgorithm>> scores1 = new HashMap<Integer,ArrayList<UniversityAlgorithm>>() ;
	private ArrayList<String> lines = new ArrayList<String>(); 
	
	
	
	
	public FileEditor(ArrayList<String> lines)
	{	
		this.lines = lines ;
	}
	
	public void fillHashMap()
	{
		for(int i=0;i<lines.size();i++)
		{
			String line = lines.get(i).trim();
			String[] part = line.split(";") ; 
			String Lesson = part[0].trim(); // 
			double Degree = Double.parseDouble(part[1].trim());     
			double Ects = Double.parseDouble(part[2].trim());
			int Semester = Integer.parseInt(part[3].trim()); 
			int  Overall = Integer.parseInt(part[4].trim());
			
			
			
			UniversityAlgorithm Scoress = new UniversityAlgorithm(Lesson,Degree,Ects,Semester,Overall);
			UniversityAlgorithm Scoress1 = new UniversityAlgorithm(Lesson,Degree,Ects,Semester,Overall);
			if(scores.containsKey(Overall))
			{
				ArrayList<UniversityAlgorithm> exampl = scores.get(Overall) ;
				exampl.add(Scoress);
				scores.put(Overall, exampl);
			}
			else 
			{
				ArrayList<UniversityAlgorithm> examp2 = new ArrayList<UniversityAlgorithm>();
				examp2.add(Scoress);
				scores.put(Overall, examp2);
			}
			
			if(scores1.containsKey(Semester))
			{
				ArrayList<UniversityAlgorithm> examp3 = scores1.get(Semester) ;
				examp3.add(Scoress1);
				scores1.put(Semester, examp3);
			}
			else 
			{
				ArrayList<UniversityAlgorithm> examp4 = new ArrayList<UniversityAlgorithm>();
				examp4.add(Scoress1);
				scores1.put(Semester, examp4);
			}
		}
	}
	
	public ArrayList<UniversityAlgorithm> getScoresOfOverall(int overall)
	{
		ArrayList<UniversityAlgorithm> ex = new ArrayList<UniversityAlgorithm>() ;
		return scores.get(overall);
	}
	/*
	public ArrayList<UniversityAlgorithm> getScoresOfSemester(int semester)
	{
		ArrayList<UniversityAlgorithm> ex1 = new ArrayList<UniversityAlgorithm>() ;
		return scores1.get(semester);
	} */
	
	public double getAverageOfGrade(int overall)  
	{
		double logos = 0.0 ;
		double b = 0.0;
		ArrayList<UniversityAlgorithm> ex = new ArrayList<UniversityAlgorithm>() ;
		ex = scores.get(overall);
		for(int i=0;i<ex.size();i++)	
		{				
			logos = logos + ex.get(i).getGrade();
		}	
		b = logos/ex.size() ;
		return b;
	}
	
	public double getAverageOfGradeInSemester(int semester)  
	{
		double logos = 0.0 ;
		double b = 0.0;
		ArrayList<UniversityAlgorithm> ex1 = new ArrayList<UniversityAlgorithm>() ;
		ex1 = scores1.get(semester);
		for(int i=0;i<ex1.size();i++)	
		{				
			logos = logos + ex1.get(i).getGrade();
		}	
		b = logos/ex1.size() ;
		return b ;
	}
	
	
	public double getAverageOfEcts(int overall)  // meso oro ects
	{
		double logos = 0.0 ;
		ArrayList<UniversityAlgorithm> ex = new ArrayList<UniversityAlgorithm>() ;
		ex = scores.get(overall);
		for(int i=0;i<ex.size();i++)
		{				
			logos = logos + ex.get(i).getEcts();
		}
		return logos;
	}
	
	public int getSumOfSubjects(int overall) 
	{
		int logos = 0;
		ArrayList<UniversityAlgorithm> ex = new ArrayList<UniversityAlgorithm>() ;
		ex = scores.get(overall);			
		logos = ex.size() ;
		return logos;
	}
}