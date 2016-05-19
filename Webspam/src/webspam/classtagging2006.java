/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static webspam.contentextraction.content;
/**
 *
 * @author Maheswari
 */
public class classtagging2006 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
	

  FileInputStream fstream = new FileInputStream("G:\\sem project\\data set\\webspam-uk2006-2.0\\webspam-uk2006-2.0\\webspam-uk2006-set1-labels.txt");
BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));

String strLine;
String[] r=new String[6];

//Read File Line By Line
List<String> normal = new ArrayList<String>();
List<String> spam = new ArrayList<String>();
List<String> undecided = new ArrayList<String>();

while ((strLine = br1.readLine()) != null)   {
  // Print the content on the console
  String s[]=strLine.split("\\s+");

  if(s[1].equals("normal"))
      normal.add(s[0]);
  else if(s[1].equals("spam"))
      spam.add(s[0]);
  else if(s[1].equals("undecided"))
      undecided.add(s[0]);
}

br1.close();
//Close the input stream




String csvFile ="C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv" ;
	BufferedReader br = null;
        
	String line = "";
	String cvsSplitBy = ",";
        int f=0;
        String fin="";
try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                    
                       if(f==1)
                       {
			String[] s = line.split(cvsSplitBy);
                        System.out.println(s[0]);
                       
                        if(normal.contains(s[1]))
                            s[2]="nonspam";
                        else if(spam.contains(s[1]))
                            s[2]="spam";
                        else if(undecided.contains(s[1]))
                            s[2]="undecided";
                        for(int j=0;j<s.length;j++)
                        {
                            fin+=s[j];
                            fin+=",";
                        }
                        fin+="\n";
                        
                           
                       }
                       else
                           fin=line+"\n";
                       f=1;
			
}
}
catch(Exception e)
{
    System.out.println(e);
}

br.close();
FileWriter writer = new FileWriter("C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv");
       // System.out.println(fin);
  writer.append(fin);
   writer.flush();
writer.close();
         
        
       




}
}