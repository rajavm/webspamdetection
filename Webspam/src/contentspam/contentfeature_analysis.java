/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contentspam;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 *
 * @author Maheswari
 */
public class contentfeature_analysis {
    public static String op;
    public static int cnt=0;
    public static void main(String[] args) throws IOException, MalformedURLException, BoilerpipeProcessingException
    {
        System.out.println("enter the url");
        String url="";
      
        
        Scanner in=new Scanner(System.in);
         url=in.nextLine();
        url="24shopping.co.uk";
        
        String csvFile ="C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv" ;
	BufferedReader br = null;
        
        boolean spam=false,nonspam=false,undecided=false;
         
	String line = "";
	String cvsSplitBy = ",";
        float HST_1=0,HST_2=0,HST_3=0,HST_4=0,HST_5=0,HST_6 = 0;
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split(cvsSplitBy);
                        if(s[1].equals(url))
                        {   
                            HST_1=Float.parseFloat(s[3]);       //from the training set
                            HST_2=Float.parseFloat(s[4]);
                            HST_3=Float.parseFloat(s[5]);
                            HST_4=Float.parseFloat(s[6]);
                            HST_5=Float.parseFloat(s[7]);
                            HST_6=Float.parseFloat(s[8]);
                        }
                }
        }  
     catch(Exception e)
     {
       System.out.println(e);
     }
  br.close();   
        
       /* SpamDetection s=new SpamDetection();      
       s.run_contentfeatures(url);
        HST_1=s.wordcount;                  //from the calculated value
        HST_2=s.title;
        HST_3=s.averagewordlength;
        HST_4=s.anchortext;
        HST_5=s.visibility;
        HST_6=s.compression;
        
        System.out.println(HST_1);
         System.out.println(HST_2);
          System.out.println(HST_3);
           System.out.println(HST_4);*/
if(HST_6 <= 2.34292)
{   if(HST_5 <= 0.396508)
    {   if(HST_6 <= 1.330097)
        {   if(HST_2 <= 1)
            {   if(HST_1 <= 7)
                {   if(HST_6 <= 0.434783)   {nonspam=true; }
                    else    //HST_6 > 0.434783
                    {   if(HST_2 <= 0) { nonspam=true; }
                        else    //HST_2 > 0
                        {   if(HST_4 <= 0.083333) spam=true; 
                            else nonspam=true; 
                        }   
                    }
                }else    //HST_1 > 7: 
                    nonspam=true;
            }
            else    //HST_2 > 1:
                nonspam=true;
        }
        else      // HST_6 > 1.330097
        {   if(HST_1 <= 165)
            {   if(HST_6 <= 2.098691)
                {   if(HST_4 <= 0.272016)
                    {   if(HST_6 <= 1.89011)
                        {   if(HST_3 <= 6.165517)  nonspam=true; 
                            else    //HST_3 > 6.165517
                            {   if(HST_3 <= 6.692913)
                                {   if(HST_4 <= 0.105769)   nonspam=true; 
                                    else        //HST_4 > 0.105769
                                    {   if(HST_3 <= 6.319588)    spam=true; 
                                        else nonspam=true;  
                                    }
                                }
                                else    //HST_3 > 6.692913: 
                                     spam=true; 
                            }
                        }
                        else    //HST_6 > 1.89011
                        {   if(HST_5 <= 0.105583)
                            {   if(HST_5 <= 0.09305)
                                {   if(HST_5 <= 0.031205)   spam=true; 
                                    else    //HST_5 > 0.031205
                                    {   if(HST_6 <= 1.901099)
                                        {   if(HST_4 <= 0.128205)    spam=true; 
                                            else   nonspam=true;  
                                        }
                                        else    //HST_6 > 1.901099: 
                                            nonspam=true;  
                                    }
                                }
                                else        //HST_5 > 0.09305
                                {   if(HST_2 <= 4) nonspam=true;  
                                    else    //HST_2 > 4
                                    {   if(HST_6 <= 2.018543)
                                        {   if(HST_1 <= 141) undecided=true; 
                                            else spam=true; 
                                        }
                                        else    //HST_6 > 2.018543: 
                                            spam=true; 
                                    }
                                }
                            }
                            else        //HST_5 > 0.105583
                            {   if(HST_3 <= 4.892086)
                                {   if(HST_4 <= 0.00315) spam=true; 
                                    else nonspam=true;  
                                }
                                else    //HST_3 > 4.892086:
                                     nonspam=true;  
                            }
                        }
                    }
                    else    //HST_4 > 0.272016
                    {   if(HST_5 <= 0.129295) nonspam=true;  
                        else    //HST_5 > 0.129295
                        {   if(HST_4 <= 0.486653)
                            {   if(HST_2 <= 7)
                                {   if(HST_3 <= 4.661972)
                                    {   if(HST_1 <= 138)     nonspam=true;  
                                        else     spam=true; 
                                    }
                                    else     nonspam=true;  
                                }
                                else    //HST_2 > 7
                                {   if(HST_1 <= 107)
                                    {   if(HST_1 <= 80)  nonspam=true;  
                                        else     spam=true;
                                    }
                                    else nonspam=true;   
                                }
                            }
                            else        //HST_4 > 0.486653
                            {   if(HST_6 <= 1.934049) spam=true; 
                                else     nonspam=true;  
                            }
                        }
                    }
                }
                else        //HST_6 > 2.098691
                {   if(HST_2 <= 12)
                    {   if(HST_1 <= 93) nonspam=true; 
                        else    //HST_1 > 93
                        {   if(HST_3 <= 5.354515) spam=true; 
                            else    //HST_3 > 5.354515
                            {   if(HST_3 <= 5.692946) nonspam=true; 
                                else    //HST_3 > 5.692946
                                {   if(HST_4 <= 0.72)
                                    {   if(HST_6 <= 2.237589)
                                        {   if(HST_3 <= 5.996226)    spam=true;  
                                            else     nonspam=true; 
                                        }
                                        else  spam=true;  
                                    }
                                    else nonspam=true; 
                                }
                            }
                        }
                    }
                    else       //HST_2 > 12: 
                          spam=true;  
                }
            }
            else        //HST_1 > 165
            {   if(HST_4 <= 0.001091)
                {   if(HST_2 <= 2)
                    {   if(HST_5 <= 0.246221)
                        {   if(HST_1 <= 459)
                            {   if(HST_3 <= 5.55818) nonspam=true; 
                                else spam=true;  
                            }
                            else    spam=true;  
                        }
                        else    /*HST_5 > 0.246221*/     spam=true;  
                    }
                    else    /*HST_2 > 2*/    nonspam=true; 
                }
                else        //HST_4 > 0.001091
                {   if(HST_5 <= 0.030327)
                    {   if(HST_2 <= 9)
                        {   if(HST_3 <= 5.440945)    nonspam=true; 
                            else spam=true;  
                        }
                        else    /*HST_2 > 9*/    spam=true;  
                    }
                    else    //HST_5 > 0.030327
                    {   if(HST_3 <= 5.552381)    nonspam=true; 
                        else        //HST_3 > 5.552381
                        {   if(HST_5 <= 0.064121)
                            {   if(HST_6 <= 2.104828)
                                {   if(HST_6 <= 1.846154)
                                    {   if(HST_3 <= 5.972683) undecided=true; 
                                        else spam=true;  
                                    }
                                    else        //HST_6 > 1.846154
                                    {   if(HST_5 <= 0.061524)
                                        {   if(HST_6 <= 1.889024)
                                            {   if(HST_2 <= 4) spam=true;  
                                                else nonspam=true; 
                                            }
                                            else nonspam=true;  
                                        }
                                        else        //HST_5 > 0.061524
                                        {   if(HST_3 <= 5.936047)
                                            {   if(HST_1 <= 319) spam=true;  
                                                else nonspam=true;  
                                            }
                                            else  undecided=true; 
                                        }
                                    }
                                }
                                else    nonspam=true;  
                            }
                            else    //HST_5 > 0.064121
                            {   if(HST_1 <= 441) nonspam=true;  
                                else    //HST_1 > 441
                                {   if(HST_4 <= 0.038462) spam=true;  
                                    else    //HST_4 > 0.038462
                                    {   if(HST_3 <= 6.1)     nonspam=true;  
                                        else    //HST_3 > 6.1
                                        {   if(HST_2 <= 6   ) spam=true;  
                                            else    //HST_2 > 6
                                            {   if(HST_1 <= 448)     spam=true;  
                                                else nonspam=true;  
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    else        //HST_5 > 0.396508
    {   if(HST_1 <= 422)
        {   if(HST_6 <= 0.382353)    spam=true;  
            else        //HST_6 > 0.382353
            {   if(HST_2 <= 8)   nonspam=true;  
                else    //HST_2 > 8
                {   if(HST_6 <= 2.070913) nonspam=true;  
                    else     spam=true;  
                }
            }
        }
        else        //HST_1 > 422
        {   if(HST_4 <= 0.077113)    nonspam=true;  
            else spam=true;  
        }
    }
}
else            //  HST_6 > 2.34292
{   if(HST_4 <= 0.00641)
    {   if(HST_2 <= 5)
        {   if(HST_1 <= 1584)
            {   if(HST_2 <= 0)
                {   if(HST_3 <= 5.510949)    nonspam=true;  
                    else  spam=true;  
                }
                else        //HST_2 > 0
                {   if(HST_5 <= 0.108292) spam=true;  
                    else        //HST_5 > 0.108292
                    {   if(HST_3 <= 4.505747)    nonspam=true; 
                        else    //HST_3 > 4.505747
                        {   if(HST_2 <= 3)
                            {   if(HST_2 <= 2)
                                {   if(HST_4 <= 0.001647)
                                    {   if(HST_1 <= 319) spam=true;  
                                        else        //HST_1 > 319
                                        {   if(HST_5 <= 0.163023)    spam=true;  
                                            else nonspam=true;  
                                        }
                                    }
                                    else  spam=true;  
                                }
                                else        //HST_2 > 2
                                {   if(HST_3 <= 6.269737)
                                    {   if(HST_1 <= 444) spam=true;  
                                        else    //HST_1 > 444
                                        {   if(HST_3 <= 5.746426) nonspam=true;  
                                            else spam=true;  
                                        }
                                    }
                                    else  nonspam=true;  
                                }
                            }
                            else        //HST_2 > 3
                            {   if(HST_3 <= 5.089744) nonspam=true;  
                                else        //HST_3 > 5.089744
                                {   if(HST_6 <= 2.746655)    nonspam=true;  
                                    else spam=true;  
                                }
                            }
                        }
                    }
                }
            }
            else        //HST_1 > 1584
            {   if(HST_2 <= 4) nonspam=true;  
                else    //HST_2 > 4
                {   if(HST_1 <= 2203) nonspam=true;  
                    else spam=true;  
                }
            }
        }
        else        //HST_2 > 5
        {   if(HST_2 <= 7) nonspam=true;  
            else    //HST_2 > 7
            {   if(HST_6 <= 3.953737)
                {   if(HST_4 <= 0.001647) nonspam=true;  
                    else    //HST_4 > 0.001647
                    {   if(HST_1 <= 2193)
                        {   if(HST_5 <= 0.135849)    nonspam=true;  
                            else spam=true;  
                        }
                        else     nonspam=true;  
                    }
                }
                else    //HST_6 > 3.953737
                        spam=true;  
            }
        }
    }
    else        //HST_4 > 0.00641
    {   if(HST_6 <= 2.904916)
        {   if(HST_4 <= 0.384615)    nonspam=true;  
            else    //HST_4 > 0.384615
            {   if(HST_2 <= 6)
                {   if(HST_1 <= 1111)
                    {   if(HST_5 <= 0.233111)    nonspam=true;  
                        else        //HST_5 > 0.233111
                        {   if(HST_1 <= 590)     spam=true;  
                            else    //HST_1 > 590
                            {   if(HST_4 <= 0.514658)    spam=true;  
                                else     nonspam=true;  
                            }
                        }
                    }
                    else    //HST_1 > 1111
                    {   if(HST_2 <= 0)   spam=true;  
                        else        //HST_2 > 0
                        {   if(HST_5 <= 0.119131)    undecided=true; 
                            else        //HST_5 > 0.119131
                            {   if(HST_3 <= 4.525773)    spam=true;  
                                else        //HST_3 > 4.525773
                                {   if(HST_1 <= 1627)
                                    {   if(HST_1 <= 1301)        nonspam=true;  
                                        else     spam=true;  
                                    }
                                    else    //HST_1 > 1627: 
                                        nonspam=true;  
                                }
                            }
                        }
                    }
                }
                else    //HST_2 > 6
                {   if(HST_1 <= 236)
                    {   if(HST_3 <= 5.919608)    spam=true;  
                        else nonspam=true;  
                    }
                    else    nonspam=true;  
                }
            }
        }
        else    //HST_6 > 2.904916
        {   if(HST_4 <= 0.10628)
            {   if(HST_5 <= 0.106468)
                {   if(HST_1 <= 1204)
                    {   if(HST_3 <= 4.419214)    nonspam=true;  
                        else        //HST_3 > 4.419214
                        {   if(HST_5 <= 0.099286)
                            {   if(HST_2 <= 7)
                                {   if(HST_2 <= 5)   nonspam=true;  
                                    else     spam=true;  
                                }
                                else    /*HST_2 > 7:*/ nonspam=true;  
                            }
                            else    /*HST_5 > 0.099286:*/ spam=true;  
                        }
                    }
                    else    /*HST_1 > 1204*/ nonspam=true;  
                }
                else    /*HST_5 > 0.106468*/ nonspam=true;  
            }
            else        //HST_4 > 0.10628
            {   if(HST_2 <= 6)
                {   if(HST_4 <= 0.807692)
                    {   if(HST_6 <= 3.021146)
                        {   if(HST_4 <= 0.604217)    nonspam=true;  
                            else undecided=true; 
                        }
                        else        //HST_6 > 3.021146
                        {   if(HST_1 <= 2345)
                            {   if(HST_1 <= 389) undecided=true; 
                                else        //HST_1 > 389
                                {   if(HST_2 <= 5)
                                    {   if(HST_4 <= 0.418283)
                                        {   if(HST_2 <= 0)   nonspam=true;  
                                            else    //HST_2 > 0
                                            {   if(HST_5 <= 0.352528)
                                                {   if(HST_2 <= 4)   spam=true;  
                                                    else        //HST_2 > 4
                                                    {   if(HST_1 <= 1305)    spam=true;  
                                                        else nonspam=true;  
                                                    }
                                                }
                                                else    /*HST_5 > 0.352528*/ nonspam=true;  
                                            }
                                        }
                                        else    /*HST_4 > 0.418283*/ nonspam=true;  
                                    }
                                    else        //HST_2 > 5
                                    {   if(HST_1 <= 1199)    spam=true;  
                                        else nonspam=true;  
                                    }
                                }
                            }
                            else        //HST_1 > 2345
                            {   if(HST_2 <= 1)   undecided=true; 
                                else nonspam=true;  
                            }
                        }
                    }
                    else        //HST_4 > 0.807692
                    {   if(HST_5 <= 0.121137)    nonspam=true;  
                        else     spam=true;  
                    }
                }
                else    /*HST_2 > 6*/ nonspam=true;  
            }
        }
    }
}
  if(spam)
            System.out.println("spam");
  if(nonspam)
            System.out.println("nonspam");
  if(undecided)
            System.out.println("undecided");
  
}
    
    
   public int run_contentfeature(String url) throws IOException, MalformedURLException, BoilerpipeProcessingException
   {
       op="";
        features_from_dataset cf=new features_from_dataset();
        //url="24shopping.co.uk";
        System.out.println("\nAnalysing content based features...");        op+="Analysing content based features...\n";
        String csvFile ="C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv" ;
	BufferedReader br = null;
        
        boolean spam=false,nonspam=false,undecided=false;
        float HST_1=0,HST_2=0,HST_3=0,HST_4=0,HST_5=0,HST_6 = 0;
	String line = "";
	String cvsSplitBy = ",";
        int h1=0,h2=0,h3=0,h4=0,h5=0,h6=0;
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split(cvsSplitBy);
                        if(s[1].equals(url))
                        {   
                            HST_1=Float.parseFloat(s[3]);       //from the data set
                            HST_2=Float.parseFloat(s[4]);
                            HST_3=Float.parseFloat(s[5]);
                            HST_4=Float.parseFloat(s[6]);
                            HST_5=Float.parseFloat(s[7]);
                            HST_6=Float.parseFloat(s[8]);
                        }
                }
        }  
     catch(Exception e)
     {
       System.out.println(e);
     }
  br.close(); 
        
       /* SpamDetection s=new SpamDetection();      
       s.run_contentfeatures(url);
        HST_1=s.wordcount;                  //from the calculated value
        HST_2=s.title;
        HST_3=s.averagewordlength;
        HST_4=s.anchortext;
        HST_5=s.visibility;
        HST_6=s.compression;*/
                                                                                                                                                                                                                                                                                                                      //  cf.retun(url);  HST_1=cf.HST_1; HST_2=cf.HST_2; HST_3=cf.HST_3; HST_4=cf.HST_4; HST_5=cf.HST_5; HST_6=cf.HST_6; 
        System.out.println("Number of words "+HST_1);               op+="Number of words "+HST_1+"\n";
        System.out.println("Title length "+HST_2);                  op+="Title length "+HST_2+"\n";
        System.out.println("Average wordlength "+HST_3);            op+="Average wordlength "+HST_3+"\n";
        System.out.println("Amount of anchor text "+HST_4);         op+="Amount of anchor text "+HST_4+"\n";
        System.out.println("Visibility ratio "+HST_5);              op+="Visibility ratio "+HST_5+"\n";
        System.out.println("Compression ratio "+HST_6);             op+="Compression ratio "+HST_6+"\n";
                                                                                                                                                                                                                                                                                                                        cf.retun(url);  HST_1=cf.HST_1; HST_2=cf.HST_2; HST_3=cf.HST_3; HST_4=cf.HST_4; HST_5=cf.HST_5; HST_6=cf.HST_6;                                                                              
        
if(HST_6 <= 2.34292)
{   
    h6++;
    if(HST_5 <= 0.396508)
    {   
        h5++;
        if(HST_6 <= 1.330097)
        {  
            h6++;
            if(HST_2 <= 1)
            {  h2++;
                if(HST_1 <= 7)
                {   h1++;
                    if(HST_6 <= 0.434783)   { h6++; nonspam=true; }
                    else    //HST_6 > 0.434783
                    {   if(HST_2 <= 0) { h2++; nonspam=true; }
                        else    //HST_2 > 0
                        {   if(HST_4 <= 0.083333) {h4++; spam=true; }
                            else nonspam=true; 
                        }   
                    }
                }else    //HST_1 > 7: 
                    nonspam=true;
            }
            else    //HST_2 > 1:
                nonspam=true;
        }
        else      // HST_6 > 1.330097
        {   if(HST_1 <= 165)
            {   h1++;
                if(HST_6 <= 2.098691)
                {   
                    h6++;
                    if(HST_4 <= 0.272016)
                    {   h4++;
                        if(HST_6 <= 1.89011)
                        {   h6++;
                            if(HST_3 <= 6.165517)  {h3++; nonspam=true; }
                            else    //HST_3 > 6.165517
                            {   if(HST_3 <= 6.692913)
                                {   h3++;
                                    if(HST_4 <= 0.105769)  { h4++; nonspam=true; }
                                    else        //HST_4 > 0.105769
                                    {   if(HST_3 <= 6.319588) {   h3++; spam=true; }
                                        else nonspam=true;  
                                    }
                                }
                                else    //HST_3 > 6.692913: 
                                     spam=true; 
                            }
                        }
                        else    //HST_6 > 1.89011
                        {   if(HST_5 <= 0.105583)
                            {   h5++;
                                if(HST_5 <= 0.09305)
                                {   
                                    h5++;
                                    if(HST_5 <= 0.031205)  {   h5++; spam=true; }
                                    else    //HST_5 > 0.031205
                                    {   if(HST_6 <= 1.901099)
                                        {   h6++;
                                            if(HST_4 <= 0.128205)   { h4++; spam=true; }
                                            else   nonspam=true;  
                                        }
                                        else    //HST_6 > 1.901099: 
                                            nonspam=true;  
                                    }
                                }
                                else        //HST_5 > 0.09305
                                {   if(HST_2 <= 4){ h2++; nonspam=true;  }
                                    else    //HST_2 > 4
                                    {   if(HST_6 <= 2.018543)
                                        {   h6++; 
                                            if(HST_1 <= 141) { h1++; undecided=true; }
                                            else spam=true; 
                                        }
                                        else    //HST_6 > 2.018543: 
                                            spam=true; 
                                    }
                                }
                            }
                            else        //HST_5 > 0.105583
                            {   if(HST_3 <= 4.892086)
                                {   h3++;
                                    if(HST_4 <= 0.00315) { h4++; spam=true; }
                                    else nonspam=true;  
                                }
                                else    //HST_3 > 4.892086:
                                     nonspam=true;  
                            }
                        }
                    }
                    else    //HST_4 > 0.272016
                    {   if(HST_5 <= 0.129295) {h5++; nonspam=true;  }
                        else    //HST_5 > 0.129295
                        {   if(HST_4 <= 0.486653)
                            {   h4++;
                                if(HST_2 <= 7)
                                {   h2++;
                                    if(HST_3 <= 4.661972)
                                    {   h3++;
                                        if(HST_1 <= 138)    { h1++; nonspam=true;  }
                                        else     spam=true; 
                                    }
                                    else     nonspam=true;  
                                }
                                else    //HST_2 > 7
                                {   if(HST_1 <= 107)
                                    {   h1++;
                                        if(HST_1 <= 80) { h1++; nonspam=true;  }
                                        else     spam=true;
                                    }
                                    else nonspam=true;   
                                }
                            }
                            else        //HST_4 > 0.486653
                            {   if(HST_6 <= 1.934049) { h6++; spam=true; }
                                else     nonspam=true;  
                            }
                        }
                    }
                }
                else        //HST_6 > 2.098691
                {   if(HST_2 <= 12)
                    {   h2++; 
                        if(HST_1 <= 93) { h1++; nonspam=true; }
                        else    //HST_1 > 93
                        {   if(HST_3 <= 5.354515) {h3++; spam=true; }
                            else    //HST_3 > 5.354515
                            {   if(HST_3 <= 5.692946) { h3++; nonspam=true; }
                                else    //HST_3 > 5.692946
                                {   if(HST_4 <= 0.72)
                                    {   h4++;
                                        if(HST_6 <= 2.237589)
                                        {   h6++;
                                            if(HST_3 <= 5.996226)   { h3++; spam=true;  }
                                            else     nonspam=true; 
                                        }
                                        else  spam=true;  
                                    }
                                    else nonspam=true; 
                                }
                            }
                        }
                    }
                    else       //HST_2 > 12: 
                          spam=true;  
                }
            }
            else        //HST_1 > 165
            {   if(HST_4 <= 0.001091)
                {   h4++;
                    if(HST_2 <= 2)
                    {   h2++;
                        if(HST_5 <= 0.246221)
                        {   
                            h5++;
                            if(HST_1 <= 459)
                            {   h1++;
                                if(HST_3 <= 5.55818) { h3++; nonspam=true; }
                                else spam=true;  
                            }
                            else    spam=true;  
                        }
                        else    /*HST_5 > 0.246221*/     spam=true;  
                    }
                    else    /*HST_2 > 2*/    nonspam=true; 
                }
                else        //HST_4 > 0.001091
                {   if(HST_5 <= 0.030327)
                    {   h5++;
                        if(HST_2 <= 9)
                        {   h2++;
                            if(HST_3 <= 5.440945)  { h3++;  nonspam=true; }
                            else spam=true;  
                        }
                        else    /*HST_2 > 9*/    spam=true;  
                    }
                    else    //HST_5 > 0.030327
                    {   if(HST_3 <= 5.552381)  { h3++; nonspam=true; }
                        else        //HST_3 > 5.552381
                        {   if(HST_5 <= 0.064121)
                            {   h5++;
                                if(HST_6 <= 2.104828)
                                {   h6++;
                                    if(HST_6 <= 1.846154)
                                    {   h6++;
                                        if(HST_3 <= 5.972683){ h3++; undecided=true; }
                                        else spam=true;  
                                    }
                                    else        //HST_6 > 1.846154
                                    {   if(HST_5 <= 0.061524)
                                        {   h5++;
                                            if(HST_6 <= 1.889024)
                                            {   h6++;
                                                if(HST_2 <= 4) {h2++; spam=true;  }
                                                else nonspam=true; 
                                            }
                                            else nonspam=true;  
                                        }
                                        else        //HST_5 > 0.061524
                                        {   if(HST_3 <= 5.936047)
                                            {   h3++;
                                                if(HST_1 <= 319) { h1++; spam=true;  }
                                                else nonspam=true;  
                                            }
                                            else  undecided=true; 
                                        }
                                    }
                                }
                                else    nonspam=true;  
                            }
                            else    //HST_5 > 0.064121
                            {   if(HST_1 <= 441) {h1++; nonspam=true;  }
                                else    //HST_1 > 441
                                {   if(HST_4 <= 0.038462) {h4++; spam=true;  }
                                    else    //HST_4 > 0.038462
                                    {   if(HST_3 <= 6.1)   { h3++; nonspam=true;  }
                                        else    //HST_3 > 6.1
                                        {   if(HST_2 <= 6   ) {h2++; spam=true;  }
                                            else    //HST_2 > 6
                                            {   if(HST_1 <= 448){ h1++;    spam=true;  }
                                                else nonspam=true;  
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    else        //HST_5 > 0.396508
    {   if(HST_1 <= 422)
        {   h1++;
            if(HST_6 <= 0.382353)    {h6++; spam=true;  }
            else        //HST_6 > 0.382353
            {   if(HST_2 <= 8)   {h2++; nonspam=true;  }
                else    //HST_2 > 8
                {   if(HST_6 <= 2.070913) { h6++; nonspam=true; } 
                    else     spam=true;  
                }
            }
        }
        else        //HST_1 > 422
        {   if(HST_4 <= 0.077113)   { h4++; nonspam=true;  }
            else spam=true;  
        }
    }
}
else            //  HST_6 > 2.34292
{   if(HST_4 <= 0.00641)
    {   h4++;
        if(HST_2 <= 5)
        {   h2++;
            if(HST_1 <= 1584)
            {   h1++;
                if(HST_2 <= 0)
                {   h2++;
                    if(HST_3 <= 5.510949)   { h3++; nonspam=true;  }
                    else  spam=true;  
                }
                else        //HST_2 > 0
                {   if(HST_5 <= 0.108292) {h5++; spam=true;  }
                    else        //HST_5 > 0.108292
                    {   if(HST_3 <= 4.505747)   { h3++; nonspam=true; }
                        else    //HST_3 > 4.505747
                        {   if(HST_2 <= 3)
                            {   h2++; 
                                if(HST_2 <= 2)
                                {   h2++;
                                    if(HST_4 <= 0.001647)
                                    {   h4++;
                                        if(HST_1 <= 319) {h1++; spam=true;  }
                                        else        //HST_1 > 319
                                        {   if(HST_5 <= 0.163023)  { h5++; spam=true; } 
                                            else nonspam=true;  
                                        }
                                    }
                                    else  spam=true;  
                                }
                                else        //HST_2 > 2
                                {   if(HST_3 <= 6.269737)
                                    {   h3++;
                                        if(HST_1 <= 444){ h1++; spam=true;  }
                                        else    //HST_1 > 444
                                        {   if(HST_3 <= 5.746426) {h3++; nonspam=true;  }
                                            else spam=true;  
                                        }
                                    }
                                    else  nonspam=true;  
                                }
                            }
                            else        //HST_2 > 3
                            {   if(HST_3 <= 5.089744) {h3++; nonspam=true;  }
                                else        //HST_3 > 5.089744
                                {   if(HST_6 <= 2.746655)  {  h6++; nonspam=true;  }
                                    else spam=true;  
                                }
                            }
                        }
                    }
                }
            }
            else        //HST_1 > 1584
            {   if(HST_2 <= 4){ h2++; nonspam=true; } 
                else    //HST_2 > 4
                {   if(HST_1 <= 2203) {h1++; nonspam=true;  }
                    else spam=true;  
                }
            }
        }
        else        //HST_2 > 5
        {   if(HST_2 <= 7) {h2++; nonspam=true; } 
            else    //HST_2 > 7
            {   if(HST_6 <= 3.953737)
                {   h6++;
                    if(HST_4 <= 0.001647){ h4++; nonspam=true; } 
                    else    //HST_4 > 0.001647
                    {   if(HST_1 <= 2193)
                        {   h1++;
                            if(HST_5 <= 0.135849)  { h5++;  nonspam=true; } 
                            else spam=true;  
                        }
                        else     nonspam=true;  
                    }
                }
                else    //HST_6 > 3.953737
                        spam=true;  
            }
        }
    }
    else        //HST_4 > 0.00641
    {   if(HST_6 <= 2.904916)
        {   h6++;
            if(HST_4 <= 0.384615)    {h4++; nonspam=true;  }
            else    //HST_4 > 0.384615
            {   if(HST_2 <= 6)
                {   h2++;
                    if(HST_1 <= 1111)
                    {   h1++;
                        if(HST_5 <= 0.233111)  {  h5++; nonspam=true;  }
                        else        //HST_5 > 0.233111
                        {   if(HST_1 <= 590)    { h1++; spam=true;  }
                            else    //HST_1 > 590
                            {   if(HST_4 <= 0.514658)  {  h4++; spam=true;  }
                                else     nonspam=true;  
                            }
                        }
                    }
                    else    //HST_1 > 1111
                    {   if(HST_2 <= 0)   {h2++; spam=true;  }
                        else        //HST_2 > 0
                        {   if(HST_5 <= 0.119131)   { h5++; undecided=true; }
                            else        //HST_5 > 0.119131
                            {   if(HST_3 <= 4.525773)  {  h3++; spam=true;  }
                                else        //HST_3 > 4.525773
                                {   if(HST_1 <= 1627)
                                    {   h1++; 
                                        if(HST_1 <= 1301)      { h1++; nonspam=true;  }
                                        else     spam=true;  
                                    }
                                    else    //HST_1 > 1627: 
                                        nonspam=true;  
                                }
                            }
                        }
                    }
                }
                else    //HST_2 > 6
                {   if(HST_1 <= 236)
                    {   h1++;
                        if(HST_3 <= 5.919608)  {  h3++; spam=true;  }
                        else nonspam=true;  
                    }
                    else    nonspam=true;  
                }
            }
        }
        else    //HST_6 > 2.904916
        {   if(HST_4 <= 0.10628)
            {   h4++;
                if(HST_5 <= 0.106468)
                {   h5++;
                    if(HST_1 <= 1204)
                    {   h1++;
                        if(HST_3 <= 4.419214)  { h3++; nonspam=true;  }
                        else        //HST_3 > 4.419214
                        {   if(HST_5 <= 0.099286)
                            {   h5++;
                                if(HST_2 <= 7)
                                {   h2++;
                                    if(HST_2 <= 5)   {h2++; nonspam=true;  }
                                    else     spam=true;  
                                }
                                else    /*HST_2 > 7:*/ nonspam=true;  
                            }
                            else    /*HST_5 > 0.099286:*/ spam=true;  
                        }
                    }
                    else    /*HST_1 > 1204*/ nonspam=true;  
                }
                else    /*HST_5 > 0.106468*/ nonspam=true;  
            }
            else        //HST_4 > 0.10628
            {   if(HST_2 <= 6)
                {   h2++;
                    if(HST_4 <= 0.807692)
                    {   h4++;
                        if(HST_6 <= 3.021146)
                        {   h6++;
                            if(HST_4 <= 0.604217)   { h4++; nonspam=true;  }
                            else undecided=true; 
                        }
                        else        //HST_6 > 3.021146
                        {   if(HST_1 <= 2345)
                            {   h1++;
                                if(HST_1 <= 389) { h1++; undecided=true; }
                                else        //HST_1 > 389
                                {   if(HST_2 <= 5)
                                    {   h2++;
                                        if(HST_4 <= 0.418283)
                                        {   h4++;
                                            if(HST_2 <= 0)  { h2++; nonspam=true; } 
                                            else    //HST_2 > 0
                                            {   if(HST_5 <= 0.352528)
                                                {   h5++;
                                                    if(HST_2 <= 4)  { h2++; spam=true;  }
                                                    else        //HST_2 > 4
                                                    {   if(HST_1 <= 1305) {  h1++; spam=true;  }
                                                        else nonspam=true;  
                                                    }
                                                }
                                                else    /*HST_5 > 0.352528*/ nonspam=true;  
                                            }
                                        }
                                        else    /*HST_4 > 0.418283*/ nonspam=true;  
                                    }
                                    else        //HST_2 > 5
                                    {   if(HST_1 <= 1199) {  h1++; spam=true; } 
                                        else nonspam=true;  
                                    }
                                }
                            }
                            else        //HST_1 > 2345
                            {   if(HST_2 <= 1)  { h2++; undecided=true; }
                                else nonspam=true;  
                            }
                        }
                    }
                    else        //HST_4 > 0.807692
                    {   if(HST_5 <= 0.121137)  {  h5++; nonspam=true;  }
                        else     spam=true;  
                    }
                }
                else    /*HST_2 > 6*/ nonspam=true;  
            }
        }
    }
}
     
     if(h1>=1)
         cnt++;
     if(h2>=1)
         cnt++;
     if(h3>=1)
         cnt++;
     if(h4>=1)
         cnt++;
     if(h5>=1)
         cnt++;
     if(h6>=1)
         cnt++;
     
       System.out.println("Depth is "+cnt);         op+="Depth is "+cnt+"\n";
  if(spam)
  {
      System.out.println("spam");           op+="The url is spam";
      return 1;
  }
  if(nonspam)
  {
      System.out.println("normal");         op+="The url is normal";
      return 0;
  }
  if(undecided)
  {
      System.out.println("undecided");      op+="The url is undecided";
      return 2;
  }
  return 0;
   }
}
