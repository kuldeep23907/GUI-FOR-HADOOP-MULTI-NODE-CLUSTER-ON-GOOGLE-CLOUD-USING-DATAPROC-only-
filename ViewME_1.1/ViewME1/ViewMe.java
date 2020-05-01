//<applet code="ViewMe" width="500"  height="100" ></applet>
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.sql.*;


class runhadoop extends Panel implements ActionListener
{
	JButton javafile,inputfile,run,projectfolder;
	JLabel inputfolder,outputfolder,namefields;
	JTextField javafile1,inputfile1,inputfolder1,outputfolder1,namefields1,projectfolder1,status;
	GridLayout gl=new GridLayout(7,2);
        String[] javalist;
String titu2;
	
	runhadoop()
	{
		setLayout(gl);

                projectfolder=new JButton("Enter the project folder name");
		javafile=new JButton("Click here to choose javafile");
		inputfile=new JButton("Click here to choose input file");
		run=new JButton("Run Hadoop");
		inputfolder=new JLabel("Write input folder name");
		outputfolder=new JLabel("write output folder name");
		namefields=new JLabel("Write name of field");
		javafile1=new JTextField(150);
		inputfile1=new JTextField(150);
		inputfolder1=new JTextField(150);
		outputfolder1=new JTextField(150);
                projectfolder1=new JTextField(150);
		namefields1=new JTextField(150);
            status=new JTextField(150);
		status.setText("Status here");
		javafile.addActionListener(this);
		inputfile.addActionListener(this);
		run.addActionListener(this);
		javafile.setSize(200,30);
   add(projectfolder);
add(projectfolder1);
		add(javafile);
		add(javafile1);
		add(inputfile);
		add(inputfile1);
		add(inputfolder);
		add(inputfolder1);
		add(outputfolder);
		add(outputfolder1);
		add(namefields);
		add(namefields1);
		add(run);
                add(status);
		
		
		
		
		
		
	}
	
		public void actionPerformed(ActionEvent ae)
{
	String name=ae.getActionCommand();
	if(name.equals("Click here to choose javafile"))
	{
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
   JDialog dialog = new JDialog();  
   chooser.showOpenDialog(dialog);
   File ob=chooser.getSelectedFile();
   String titu=ob.getName();
   System.out.println(titu);
titu2="";   
for(int i=0;i<titu.length();i++)
{
if(titu.charAt(i)!='.')
titu2=titu2+titu.charAt(i);
else
break;
}
   
   System.out.println(titu2);
   String nnn=ob.getPath();
   javafile1.setText(nnn);
   //javafile1.setText(javalist[0]);
	}
	else if(name.equals("Click here to choose input file"))
	{
		JFileChooser chooser1 = new JFileChooser(new File(System.getProperty("user.dir")));
		JDialog dialog1 = new JDialog();  
   chooser1.showOpenDialog(dialog1);
   File ob1=chooser1.getSelectedFile();
   String titu1=ob1.getName();
   String nnn1=ob1.getPath();
   inputfile1.setText(nnn1);
	}
         else if (name.equals("Run Hadoop"))
{
System.out.println("in run");
String javapath=javafile1.getText();
String inputpath=inputfile1.getText();
String inputdir=inputfolder1.getText();
String outputdir=outputfolder1.getText();
String projectfoldern=projectfolder1.getText();
String namefieldlist=namefields1.getText();
namefieldlist=namefieldlist;
outputdir=outputdir;

namefieldlist=namefieldlist+"-"+titu2+"-"+outputdir+"fileoutput";

String cmd="./.execute "+" "+titu2+" "+javapath+" "+inputpath + " "+ inputdir+" "+outputdir+" "+projectfoldern+" "+namefieldlist;
String result="Successful : Output is following\n";

try{
status.setText("running");
Process p = Runtime.getRuntime().exec(cmd);

p.waitFor();
status.setText("run stopped");
    BufferedReader reader = 
         new BufferedReader(new InputStreamReader(p.getInputStream()));

    String line = "";			
    while ((line = reader.readLine())!= null) {
	result=result+line+"\n";
       // System.out.println(result);
    }

JOptionPane.showConfirmDialog(null,result);
JOptionPane.showMessageDialog(null,"Output has been saved as Excel and Text file\n Thank you");
JTextArea jta=new JTextArea();
jta.append(result);
JButton tryn=new JButton("Printer");
Object[] options = {"yes",
            "No,e"};
int n=JOptionPane.showOptionDialog(tryn,
                                           "Print the result ? ",
                                           "Result",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

if (n == JOptionPane.YES_OPTION) {
    try{
jta.print();
}
catch(Exception e)
{
}
}
else if (n == JOptionPane.NO_OPTION) {
    JOptionPane.showMessageDialog(null,"You can access result as file has been saved");
}
else {
JOptionPane.showMessageDialog(null,"No option selected");
    // the user closed the dialog without clicking an button
}

}
catch(Exception e){}

/*try{
cmd="cat "+outputdir+"fileoutput";
Process p1 = Runtime.getRuntime().exec(cmd);
    p1.waitFor();

    BufferedReader reader1 = 
         new BufferedReader(new InputStreamReader(p1.getInputStream()));

    String line1 = "";	
      String result1="";		
    while ((line1 = reader1.readLine())!= null) {
	result1=result1+line1+"\n";
        System.out.println(result1);
    }


}
catch(Exception e){}*/

}
		
}
	
	
}


class learnhadoop extends Panel implements ActionListener
{
	JButton search;
	JLabel field1;
	JTextField input;
	//GridLayout gl=new GridLayout(3,1);
   String valueslist="",folderlist="",filelist="";
int len;
JLabel[] jlfinal;JTextField[] jtffinal;JButton[] jbfinal;
String projectfoldername;
	
	learnhadoop(JButton jj,JLabel ll,JTextField tt)
	{
//setLayout(gl);
		//search=new JButton("Search Project");
		//field1=new JLabel("Enter your project name");
		//input=new JTextField(30);
                //search.addActionListener(this);
		//add(field1);
                //add(input);
		//add(search);
add(jj);
add(ll);
add(tt);

		
		
	}


learnhadoop(String prname)
{
projectfoldername=prname;
//setLayout(gl);
JTextField jtf=new JTextField(50);	
//JLabel newc=new JLabel("hello");
//add(jtf);
//add(newc);

String line;
String lino="",username="";
String cmd1="whoami";
try{
//status.setText("running");
Process p = Runtime.getRuntime().exec(cmd1);

p.waitFor();
//status.setText("run stopped");
    BufferedReader reader = 
         new BufferedReader(new InputStreamReader(p.getInputStream()));

    lino = "";			
    while ((lino = reader.readLine())!= null) {
	username=username+lino;
       // System.out.println(result);
    }
}
catch(Exception e)
{}



try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("/home/"+username+"/cloud/ViewME/"+prname+"/values.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                valueslist=valueslist+line+"\n";
				
                
            }   

            bufferedReader.close();         
        }
        catch(Exception ex) {
                          
        }


try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("/home/"+username+"/cloud/ViewME/"+prname+"/values2.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                folderlist=folderlist+line+"\n";
                
            }   
System.out.println(folderlist);
            // Always close files.
            bufferedReader.close();         
        }
        catch(Exception ex) {
                          
        }

try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("/home/"+username+"/cloud/ViewME/"+prname+"/values3.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                filelist=filelist+line+"\n";
              
            }   
System.out.println(filelist);
            // Always close files.
            bufferedReader.close();         
        }
        catch(Exception ex) {
                          
        }
		
		jtf.setText(valueslist+filelist+folderlist);

String[] valueslistfinal=valueslist.split("\n");
len=valueslistfinal.length;
System.out.println("lenght"+len);
for(int i=0;i<len;i++)
System.out.println("jj");	
jlfinal=new JLabel[len];
 jtffinal=new JTextField[len];
jbfinal=new JButton[len];
//jlfinal=new JLabel[len];

for(int i=0;i<len;i++)
{
jlfinal[i]=new JLabel();
jtffinal[i]=new JTextField(50);
jbfinal[i]=new JButton();
//add(jlfinal);
jlfinal[i].setText("Search by "+valueslistfinal[i]);
jbfinal[i].setLabel((i+1)+" - Click here");
add(jlfinal[i]);
add(jtffinal[i]);
add(jbfinal[i]);
jbfinal[i].addActionListener(this);
}


}





        
public void actionPerformed(ActionEvent ae)
{
System.out.println("into it");
String name=ae.getActionCommand();
String[] folderlistfinal=folderlist.split("\n");
String[] filelistfinal=filelist.split("\n");
String result="";
for(int i=0;i<len;i++)
{
String valu=(i+1)+" - Click here";

if(name.equals(valu))
{
String content=jtffinal[i].getText();
System.out.println("matched"+content+projectfoldername+folderlistfinal[i]+filelistfinal[i]);
String cmd="./.result "+" "+projectfoldername+" "+folderlistfinal[i]+" "+filelistfinal[i]+" "+content;
//String line="";
try{
//status.setText("running");
Process p = Runtime.getRuntime().exec(cmd);

p.waitFor();
//status.setText("run stopped");
    BufferedReader reader = 
         new BufferedReader(new InputStreamReader(p.getInputStream()));

    String line = "";			
    while ((line = reader.readLine())!= null) {
	result=result+line+"\n";
       // System.out.println(result);
    }

JOptionPane.showMessageDialog(null,result);
System.out.println(result);
}
catch(Exception e){}

}


}

        

}


}
public class ViewMe extends Frame implements ActionListener,WindowListener
{
	
	Panel frame1=new Panel();
	Button runhd,learnhd;
	CardLayout gl=new CardLayout();
	runhadoop r=new runhadoop();
        JButton passon=new JButton("Search Project");
  
JLabel passon1=new JLabel("Enter the name of Project Folder");
JTextField passon2=new JTextField(30);
	learnhadoop l=new learnhadoop(passon,passon1,passon2);
	
	String[] javalist;
	ViewMe()
	{

		
      setLayout(null);setSize(1000,1000);     
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
		//setLayout(fl);
		frame1.setLayout(gl);
		frame1.add(r,"runhadoop");
		frame1.add(l,"learnhadoop");
		runhd=new Button("Run");
		learnhd=new Button("Learn");
		runhd.addActionListener(this);
		learnhd.addActionListener(this);
passon.addActionListener(this);
                runhd.setBounds(440,20,50,20);
                learnhd.setBounds(510 ,20,50,20);
                frame1.setBounds(180,100,630,630);
		add(runhd);
		add(learnhd);
		add(frame1);
        addWindowListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
{
	String name=ae.getActionCommand();
	if(name.equals("Run"))
		gl.show(frame1,"runhadoop");
	else if(name.equals("Learn"))
{              // l.update("ho gya");
                //BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
    
		gl.show(frame1,"learnhadoop");
}
else if(name.equals("Search Project"))
{
String prname=passon2.getText();
learnhadoop l2=new learnhadoop(prname);
frame1.add(l2,"learnhadoop2");
gl.show(frame1,"learnhadoop2");


		
}
}

public void windowClosing(WindowEvent we)
	{
		this.setVisible(false);
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent we)
	{
	}
	public void windowActivated(WindowEvent we)
	{
	}
	
	public void windowDeiconified(WindowEvent we)
	{
	}
	public void windowIconified(WindowEvent we)
	{
	}
	public void windowClosed(WindowEvent we)
	{
	}
	public void windowOpened(WindowEvent we)
	{
	}


public static void main(String ar[]) 
{
new ViewMe();
}

}
