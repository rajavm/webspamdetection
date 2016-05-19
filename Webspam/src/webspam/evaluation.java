/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static webspam.contentextraction.content;

/**
 *
 * @author Maheswari
 */
public class evaluation {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        List<String> normal = new ArrayList<String>();
List<String> spam = new ArrayList<String>();
List<String> undecided = new ArrayList<String>();
        String csvFile ="G:\\sem project\\Evaluation\\Result.csv" ;
	BufferedReader br = null;
        
	String line = "";
	String cvsSplitBy = ",";
        int f=0;
        String [] res=new String[11402];
try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                    
                      
			String[] s = line.split(cvsSplitBy);
                       int s2=Integer.parseInt(s[2]);
                       if(s2==1)
                           spam.add(s[1]);
                       else if(s2==0)
                           normal.add(s[1]);
                       else
                           undecided.add(s[1]);
                       }
                      
			
}

catch(Exception e)
{
    System.out.println(e);
}

br.close();
 FileInputStream fstream = new FileInputStream("G:\\sem project\\data set\\webspam-uk2006-2.0\\webspam-uk2006-2.0\\webspam-uk2006-set2-labels.txt");
BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));

String strLine;

//Read File Line By Line
int s=0,n=0,u=0;
while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  String sr[]=strLine.split("\\s+");
  if(sr[1].equals("spam"))
      s++;
  if(sr[1].equals("normal"))
      n++;
  if(sr[1].equals("undecided"))
      u++;
}

//Close the input stream
br1.close();


    }
}
