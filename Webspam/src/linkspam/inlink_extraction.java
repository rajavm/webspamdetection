/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkspam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Maheswari
 */
public class inlink_extraction {
   public static String op;
   public static double sbr,nbr;
    public static void main(String[] args) throws IOException
    {
        System.out.println("enter the url");
        String url="";
      /*  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
             url = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        
        
        Scanner in=new Scanner(System.in);
         url=in.nextLine();
        url="lcd-tv-reviews.co.uk";
        System.out.println("The url is "+url);
String csvFile ="G:\\sem project\\data set\\uk-2006-05.hostnames.txt\\new_hostnames.csv" ;
	BufferedReader br = null;
        
	String line = "";
	String cvsSplitBy = ",";
        int hostid = 0;     //of given url
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split("\\s+");
                        if(s[1].equals(url))
                        {  
                            System.out.println("hostid of given url is"+s[0]);
                            hostid=Integer.parseInt(s[0]);
                            break;
                        }
                }
        }
     catch(Exception e)
     {
       System.out.println(e);
     }
  br.close();
        System.out.println("Exacting inlinks");
  FileInputStream fstream = new FileInputStream("G:\\sem project\\data set\\uk-2006-05.hostgraph.txt\\uk-2006-05.hostgraph_weighted.txt");
BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));

String strLine;
int flag[]=new int[11402];
for(int k=0;k<11402;k++)
    flag[k]=0;


while ((strLine = br1.readLine()) != null)   {
  // Print the content on the console
  String s[]=strLine.split("\\s+");
  for(int i=2;i<s.length;i++)
  {
      String[] part=s[i].split(":");
      int dest=Integer.parseInt(part[0]);
      if(dest==hostid)
      {
          System.out.println(s[0]);
          int inl=Integer.parseInt(s[0]);
          flag[inl]=1;
      }
  }
  
}

br1.close();
boostingpage_identification b=new boostingpage_identification();
int flg=b.identify(flag,hostid);
 //System.out.println(flg);
    }
    
    public static int run_inlink(String url) throws IOException
    {
           op="";
       // url="24shopping.co.uk";
        System.out.println("Analysing Link based features...");     op+="Analysing Link based features\n";
        System.out.println("The url is "+url);                  op+="The url is "+url+"\n";
String csvFile ="G:\\sem project\\data set\\uk-2006-05.hostnames.txt\\new_hostnames.csv" ;
	BufferedReader br = null;
       
	String line = "";
	String cvsSplitBy = ",";
        int hostid = 0;     //of given url
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split("\\s+");
                        if(s[1].equals(url))
                        {  
                            System.out.println("hostid of given url is"+s[0]);          op+="hostid of given url is"+s[0]+"\n";
                            hostid=Integer.parseInt(s[0]);
                            break;
                        }
                }
        }
     catch(Exception e)
     {
       System.out.println(e);
     }
  br.close();
        System.out.println("Extracting inlinks");           op+="Extracting inlinks\n";
  FileInputStream fstream = new FileInputStream("G:\\sem project\\data set\\uk-2006-05.hostgraph.txt\\uk-2006-05.hostgraph_weighted.txt");
BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));

String strLine;
int flag[]=new int[11402];
for(int k=0;k<11402;k++)
    flag[k]=0;


while ((strLine = br1.readLine()) != null)   {
  // Print the content on the console
  String s[]=strLine.split("\\s+");
  for(int i=2;i<s.length;i++)
  {
      String[] part=s[i].split(":");
      int dest=Integer.parseInt(part[0]);
      if(dest==hostid)
      {
          System.out.println(s[0]);         op+=s[0]+"\n";
          int inl=Integer.parseInt(s[0]);
          flag[inl]=1;
      }
  }
  
}

br1.close();
boostingpage_identification b=new boostingpage_identification();

int flg=b.identify(flag,hostid);
op+=b.o;
sbr=b.sbr;
nbr=b.nbr;
       // System.out.println(op);
       // System.out.println(flg);

return flg;
    }
}
