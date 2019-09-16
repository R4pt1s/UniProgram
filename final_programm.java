package programm;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;

public class final_programm extends Frame implements WindowListener,ActionListener {

		static JTextField text = new JTextField(10);
        //static JTextField text1 = new JTextField(10);
        static JTextField text1 = new JPasswordField(10);
        //static JTextField text2 = new JTextField(10);
        static JTextField text2 = new JPasswordField(10);
        static JTextField text5 = new JTextField(10);
        JButton confirm;
        JButton exit;
        JLabel username ;
        JLabel password ;
        JLabel result2 ;
        JLabel result1 ;
        JLabel result3 ;
        String keyboard;
        
        private FileReader reader = new FileReader("C:\\Users\\R4pt1s\\Desktop\\example\\MyProgramm\\src\\programm\\Univ.txt");
        private FileReader reader1 = new FileReader("C:\\Users\\R4pt1s\\Desktop\\example\\MyProgramm\\src\\programm\\Uni_failed.txt");

        public static void main(String[] args) {
                new final_programm();
        }
        
        

        public final_programm() {

                JFrame Panel = new JFrame("Programm");

                exit = new JButton("Exit");
                exit.setBounds(240,370,140, 40);
                exit.setFont(new Font("Serif", Font.BOLD, 17));
                exit.setForeground(Color.GREEN);
                exit.setBackground(Color.BLACK);
                exit.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                
                confirm = new JButton("Confirm");
                confirm.setBounds(100,370,140, 40);//100apo aristera deksia ,350 apo pano pros kato ,140 platos box,40 fardos box
                confirm.setFont(new Font("Serif", Font.BOLD, 17));
                confirm.setForeground(Color.GREEN);
                confirm.setBackground(Color.BLACK);
                confirm.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                
                username = new JLabel("Username:");
                username.setBounds(100,50,100,100);
                username.setFont(new Font("Serif", Font.BOLD, 17));
                username.setForeground(Color.GREEN);
                
                password = new JLabel("Password:");
                password.setBounds(100,80,100,100);
                password.setFont(new Font("Serif", Font.BOLD, 17));
                password.setForeground(Color.GREEN);
                
                result2 = new JLabel();
                result2.setBounds(30,140,1000,100);
                result2.setForeground(Color.GREEN);
                
                result1 = new JLabel();
                result1.setBounds(30,220,1000,100);
                result1.setForeground(Color.GREEN);
                
                result3 = new JLabel();
                result3.setBounds(30,300,1000,100);
                result3.setForeground(Color.GREEN);
                
                
                text1.setBounds(180, 90, 150, 25);
                text2.setBounds(180, 115, 150, 25);
                text.setBounds(180, 220, 150, 25);
                text5.setBounds(180, 300, 150, 25);

                result2.setFont(new Font("Serif", Font.ITALIC, 17));
                result1.setFont(new Font("Serif", Font.ITALIC, 17));
                result3.setFont(new Font("Serif", Font.ITALIC, 17));
                //text1.setBounds(10, 10, 10, 10);
                //confirm.setBounds(10, 10, 10, 10);
                Panel.add(username);
                Panel.add(text1);
                //username.setLabelFor(text1);
                
                Panel.add(password);
                Panel.add(text2);
                //password.setLabelFor(text2);
                Panel.add(confirm);
                Panel.add(exit);
                Panel.add(result2);  
                Panel.add(result1); 
                Panel.add(result3); 
                Panel.setSize(620,480);    
                
                Panel.getContentPane().setBackground(Color.BLACK);  
                Panel.setLayout(null);    
        		Panel.setVisible(true);    
        		Panel.setLocationRelativeTo(null);
        		Panel.setResizable(false);
        		Panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
              
                
                exit.addActionListener(new ActionListener(){  
                	public void actionPerformed(ActionEvent e){
                		System.exit(0);
                	 }  
                }); 
                
                confirm.addActionListener(new ActionListener(){  
                	public void actionPerformed(ActionEvent e){
                		
                		
                		String user = "xxxx"; //put your username
                 	    String pass = "xxxx"; // put your password
                 	
                 	    String inpUser = text1.getText();
                 	    String inpPass = text2.getText(); // gets input from user
                 	
                 	    if (inpUser.equals(user) && inpPass.equals(pass)) 
                 	    {
                 	        	result2.setText("// Select degree , select ects , select degree&ects or select 6amino");
	                 	    	Panel.add(text);
	                 	        keyboard = text.getText();
	                 	        text.setVisible(true);
	                 	        Panel.revalidate();
	                 	        Panel.repaint();

		                       	if(reader.initReader())
		                       	{
		                   			FileEditor editor = new FileEditor(reader.readFile());
		                   			reader.closeReader();
		                   			editor.fillHashMap();
		                   			FileWriter writer = new FileWriter("C:\\Users\\R4pt1s\\Desktop\\example\\MyProgramm\\src\\programm\\Final_output_Univ.txt");
		                   			if(writer.initWriter())
		                   			{
		                   				
		                   				if (keyboard.equals(""))
		                   				{
		                   					result2.setText("// Select degree , select ects , select degree&ects or select 6amino");
		                   					//System.out.println("");
		                   				}
		                   				else if (keyboard.equals("degree"))
		                   				{
		                   					result2.setText("// You selected degree");
		                   					//System.out.println("");
		                   					
		                   					writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("Leonidas Raptis");
		               	    				writer.writeFile1("AM : 3322");
		               	    				writer.writeFile1("");
		               	    				writer.writeFile(editor.getScoresOfOverall(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*Your average of grades is :");
		               	    				writer.writeFile2(editor.getAverageOfGrade(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               	    				writer.closeWriter();
		               	    				
		               	    				result1.setVisible(false);
		               	    				text5.setVisible(false);
		               	    				result3.setVisible(true);
		               	    				result3.setText("// Now go check your folders");

		                   				}
	                   					
		                   				else if (keyboard.equals("ects"))
		                   				{
		                   					result2.setText("// You selected ects");
		                   					
		                   					writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("Leonidas Raptis");
		               	    				writer.writeFile1("AM : 3322");
		               	    				writer.writeFile1("");
		               	    				writer.writeFile(editor.getScoresOfOverall(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*Your average of ects is :");
		               	    				writer.writeFile2(editor.getAverageOfEcts(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               	    				writer.closeWriter();
		               	    				
		               	    				result1.setVisible(false);
		               	    				text5.setVisible(false);
		               	    				result3.setVisible(true);
		               	    				result3.setText("// Now go check your folders");
		                   				}
		                   				
		                   				else if (keyboard.equals("degree&ects"))
		                   				{
		                   					result2.setText("// You selected degree&ects");
		                   					
		                   					writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("Leonidas Raptis");
		               	    				writer.writeFile1("AM : 3322");
		               	    				writer.writeFile1("");
		               	    				writer.writeFile(editor.getScoresOfOverall(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*Your average of grades is :");
		               	    				writer.writeFile2(editor.getAverageOfGrade(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*Your average of ects is :");
		               	    				writer.writeFile2(editor.getAverageOfEcts(0));
		               	    				writer.writeFile1("");
		               	    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               	    				writer.closeWriter();
		               	    				
		               	    				result1.setVisible(false);
		               	    				text5.setVisible(false);
		               	    				result3.setVisible(true);
		               	    				result3.setText("// Now go check your folders");
		               	    			}
		                   				
		                   				else if (keyboard.equals("6amino"))
		                   				{
		                   			        Panel.revalidate();
		    	                 	        Panel.repaint();
		                   					Panel.add(text5);
		                   					result1.setVisible(true);
		               	    				text5.setVisible(true);
		                   					String keyboard2 = text5.getText();
		                   					String numberofexamino = keyboard2;
		    	                 
		                   					result1.setText("// You selected 6amino" + " .Now which one do you prefer to see...choose from 1-8");
		                   					
		                   					if (numberofexamino.equals(""))
			                   				{
		                   						
		                   						result1.setText("// You selected 6amino" + " .Now which one do you prefer to see...choose from 1-8");
		                   						//result1.setVisible(false);
		                   						result3.setVisible(false);
		                   						
			                   				}
		                   					
		                   					else if (numberofexamino.equals("1"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 1rst semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(1));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 1rst examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		              
		                   					}
		                   					
		                   					else if (numberofexamino.equals("2"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 2nd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(2));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 2nd examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("3"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 3rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(3));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 3rd examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("4"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 4rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(4));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 4th examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("5"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 5rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(5));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 5th examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("6"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 6rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(6));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 6th examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("7"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 7rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(7));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 7th examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					
		                   					else if (numberofexamino.equals("8"))
		                   					{
		                   						writer.writeFile1("*****Welcome , here you can find your summary*****");	
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("Leonidas Raptis");
		               		    				writer.writeFile1("AM : 3322");
		               		    				writer.writeFile1("");
		               		    				writer.writeFile(editor.getScoresOfOverall(0));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*Your average of grades in the 8rd semester is :");
		               		    				writer.writeFile2(editor.getAverageOfGradeInSemester(8));
		               		    				writer.writeFile1("");
		               		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		               		    				writer.closeWriter();
		               		    				
		               		    				result1.setText("// You are in 9th examino");
		               		    				result3.setVisible(true);
		               		    				result3.setText("// Now go check your folders");
		                   					}
		                   					else 
		                   					{
		                   						result1.setText("// No valid input,try again");
		                   					}
		                   				
		                   				}
		                   				else
		                   				{
		                   					result2.setText("// No valid input,try again");
		                   				}
		                   				
		                       	}
		                   			
		                   			}
		                   			else
		                   			{
		                   				result2.setText("// Error creating file");
		                   				text.setVisible(false);
		                   			}
		                       	
		                       	if(reader1.initReader())
		    		    		{
		    		    			FileEditor editor = new FileEditor(reader1.readFile());
		    		    			reader1.closeReader();
		    		    			editor.fillHashMap();
		    		    			FileWriter writer = new FileWriter("C:\\Users\\R4pt1s\\Desktop\\example\\MyProgramm\\src\\programm\\Final_output_Uni_failed.txt");
		    		    			if(writer.initWriter())
		    		    			{
		    		    				writer.writeFile1("*****Welcome , here you can find your Xrostoumena*****");	
		    		    				writer.writeFile1("");
		    		    				writer.writeFile1("Leonidas Raptis");
		    		    				writer.writeFile1("AM : 3322");
		    		    				writer.writeFile1("");
		    		    				writer.writeFile(editor.getScoresOfOverall(0));
		    		    				writer.writeFile1("");
		    		    				writer.writeFile1("*Your average of ects is :");
		    		    				writer.writeFile2(editor.getAverageOfEcts(0));
		    		    				writer.writeFile1("");
		    		    				writer.writeFile1("**Sum of subjects that you have to give again is : ");
		    		    				writer.writeFile2(editor.getSumOfSubjects(0));
		    		    				writer.writeFile1("");
		    		    				writer.writeFile1("*****Have a nice day , thank you , see you next time bro*****");
		    		    				writer.closeWriter();
		    		    				
		    		    			}
		    		    			else
		    		    			{
		    		    				result2.setText("// No valid input,try again");
		    		    				
		    		    			}
		    		    		}
		    		    		else
		    		    		{
		    		    			result2.setText("// Error creating file");
		    		    			text.setVisible(false);
		    		    		}	
		    		    		
		                       		
                 	        	}
                 	     
	                 	    else {
	                 	    	result2.setText("// Unsuccessful login");
	                 	    	text.setVisible(false);
	                 	    	text5.setVisible(false);
	                 	    	result1.setVisible(false);
	                 	    	result3.setVisible(false);
	                 	        //System.exit(0);
	                 	        return;
	                 	    }
                		
                		
                    }  
                    });  
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
