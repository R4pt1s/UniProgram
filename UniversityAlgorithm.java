package programm;

//import java.util.* ;
public class UniversityAlgorithm 
{
	private String name ;
	private double grade ;
	private double ects ;
	private int semester ;
	private int overall;
	
	public UniversityAlgorithm(String name , double grade ,double ects, int semester,int overall)
	{
		this.name = name ; 
		this.grade = grade ; 
		this.ects = ects ; 
		this.semester = semester ;
		this.overall = overall ;
	}
	public String getName()
	{
		return name ;
	}
	
	public double getGrade()
	{
		return grade ;
	}
	
	public double getEcts()
	{
		return ects ;
	}

	public double getSemester()
	{
		return semester ;
	}
	
	public int getOverall()
	{
		return overall ;
	}
	
	public String toString()
	{
		String finaloutput = ("Subject:"+name+"   "+grade+"   ECTS:"+ects+"   Semester:"+semester+"    ##"+overall+"") ;
		return finaloutput ;
	}
}