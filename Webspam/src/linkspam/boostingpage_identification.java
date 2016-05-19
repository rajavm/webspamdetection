/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkspam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Maheswari
 */
public class boostingpage_identification {
  public  static String o;
  public static double sbr,nbr=0,n=0,s=0;
    public static int identify(int[] flag,int hostid) throws FileNotFoundException, IOException{
        
        o="";
        String csvFile ="C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv" ;
	BufferedReader br = null;
        
	String line = "";
	String cvsSplitBy = ",";
        int tagg[]=new int[11402];
        for(int p=0;p<11402;p++)
            tagg[p]=0;
       // System.out.println("hello");
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split(cvsSplitBy);
                        if(!s[0].equals("hostid")){
                        int id=Integer.parseInt(s[0]);
                        if(s[2].equals("nonspam"))
                            tagg[id]=1;
                        else if(s[2].equals("spam"))
                            tagg[id]=2;
                        else if(s[2].equals("undecided"))
                            tagg[id]=3;}
                }
        }
     catch(Exception e)
     {
       System.out.println(e);
     }
  br.close();
  
     
        
        FileInputStream fstream = new FileInputStream("G:\\sem project\\data set\\uk-2006-05.hostgraph.txt\\uk-2006-05.hostgraph_weighted.txt");
BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));
int jk=0;
String strLine;
int src;
double sx=0,nx=0;
int g=0;
while ((strLine = br1.readLine()) != null)   {
  // Print the content on the console
  String s[]=strLine.split("\\s+");
   src=Integer.parseInt(s[0]);
  if(flag[src]==1)      //if it is an inlink
  {    
       System.out.println("calculating for inlink "+src);        o+="calculating for inlink"+src+"\n";
       for(int i=2;i<s.length;i++)
       {
         String[] part=s[i].split(":");
        int dest=Integer.parseInt(part[0]);
        if(dest!=hostid)
        {
           if(tagg[dest]==1)    //normal
               nx++;
           else if(tagg[dest]==2)   //spam
               sx++;
          
        }
     }
       if(sx==0 && nx==0)
       {
           System.out.println("0");
           continue;
       }
        g=boostpageratio(sx,nx);
       if(g==1)
       {   jk=1;
           System.out.println("src is boosting hostid");       o+="src is boosting hostid\n";
            System.out.println("given url is spam page");       o+="given url is spam page\n";
             //return g;
       }
     
   }
    sx=0; nx=0;
    }
if(n!=0)
nbr=nbr/n;
if(s!=0)
    sbr=sbr/s;
if(jk!=1)
{     System.out.println("given url is a normal page");       o+="given url is a normal page\n"; }
        return jk;
}
    
public static int boostpageratio(double sx,double nx)
{
    double bx=sx/(sx+nx);
    double c=0.5;                                                                                                                                                                                                                                                                                                       c=0.4;
    System.out.println(bx);     o+=bx+"\n";
    if(bx>=c)
    {
        sbr+=bx;
        s++;
        System.out.println("boosting ratio"+bx);
        return 1;
    }
    else
    {
        nbr+=bx;
        n++;
        return 0;
    }
}
}
