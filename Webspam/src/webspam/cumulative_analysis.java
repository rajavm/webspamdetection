/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

/**
 *
 * @author Maheswari
 */
import java.io.IOException;
import linkspam.inlink_extraction;
import contentspam.contentfeature_analysis;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
public class cumulative_analysis {
     
    // String g =i
    public static String reslt;
     public static double slinkwt,nlinkwt,sldawt,nldawt;
     public static int depth;
     public static int linkflag,contentflag,ldaflag;
    public static void main(String[] args) throws IOException, MalformedURLException, BoilerpipeProcessingException
    {String k ;
       inlink_extraction i=new inlink_extraction();
        int finaloplink=i.run_inlink("lcd-tv-reviews.co.uk");
        
      k= i.op;
      double slinkwt,nlinkwt;
      slinkwt=i.sbr;
      nlinkwt=i.nbr;
        System.out.println(k);
        System.out.println("spam link weight"+slinkwt);
        System.out.println("normal link weight"+nlinkwt);
        if(finaloplink==1)
            System.out.println("The url is spam");
        else
                      System.out.println("The url is normal");
  
        
        //content features
        contentfeature_analysis c=new contentfeature_analysis();
       int  finalopcontent=c.run_contentfeature("lcd-tv-reviews.co.uk");
        String kc;
        kc=c.op;
        System.out.println(kc);
       int depth=c.cnt;
      
        
    }
    
    public static String runmelink(String url) throws IOException
    {
        String k ;
       inlink_extraction i=new inlink_extraction();
        int finalop=i.run_inlink(url);
      k= i.op;
     linkflag=finalop;
      slinkwt=i.sbr;
      nlinkwt=i.nbr;
        System.out.println(k);      //output of link features
        System.out.println("spam link weight"+slinkwt);         k+="\n\n"+"spam link weight"+slinkwt+"\n";
        System.out.println("normal link weight"+nlinkwt);       k+="normal link weight"+nlinkwt+"\n";
        if(finalop==1)
        { System.out.println("The url is spam");     k+="\nThe url is spam";                               }
        else
        {  System.out.println("The url is normal");     k+="\nThe url is normal";                                     }
        return k;
    }
    
     public static String runmecontent(String url) throws IOException, MalformedURLException, BoilerpipeProcessingException
     {
         contentfeature_analysis c=new contentfeature_analysis();
       int  finalopcontent=c.run_contentfeature(url);
        String kc;
        kc=c.op;
        System.out.println(kc);
        contentflag=finalopcontent;
        depth=c.cnt;
       return kc;
     }
     public static String runmelda(String url) 
     {
         String ldaop;
       
         
        System.out.println("\nTopic Modeling");     ldaop="Topic Modeling\n";
         String csvFile ="G:\\sem project\\output\\lda_output\\output_csv\\new.csv" ;
	BufferedReader br = null;
        String cvsSplitBy=",";
        String appendedurl="G:\\sem project\\output\\lda_dataset\\ldatest\\"+url+".txt";
         try {
		br = new BufferedReader(new FileReader(csvFile));
            String line="";
		while ((line = br.readLine()) != null) 
                {    
                    
			String[] s = line.split(cvsSplitBy);
                        if(s[1].equals(appendedurl))
                        {   
                           
                            int s2=Integer.parseInt(s[2]);
                            Double s3=Double.parseDouble(s[3]);
                             Double s5=Double.parseDouble(s[5]);
                            if(s3==0.5)
                            {
                                System.out.println("undecided");    ldaop+="The url is undecided\n";
                                sldawt=0.5;
                                nldawt=0.5;
                                ldaflag=2;
                            }
                            else if(s2==2)
                            {  System.out.println("normal");       ldaop+="The url is normal\n";
                            sldawt=s5;
                            nldawt=s3;
                            ldaflag=0;
                            
                            }
                            else
                            {  
                                sldawt=s3;
                                nldawt=s5;
                                System.out.println("spam");     ldaop+="The url is spam\n";
                                ldaflag=1;
                            }
                        }
                }
                
                System.out.println("spam Lda weight is "+sldawt);       ldaop+="spam Lda weight is "+sldawt+"\n";
                   System.out.println("normal Lda weight is "+nldawt);     ldaop+="normal Lda weight is "+nldawt+"\n";
        }
        
             
     catch(Exception e)
     {
       System.out.println(e);
     }
      return ldaop;   
     }
     
     public static int analysis(double slink,double nlink,int linkflg,int depth,int contentflg,double slda,double nlda,int ldaflg)
     {
         int res=99999;
         if(ldaflag==2)
        {
            if(linkflag==0 && contentflag==0)
                res=0;
            else if(linkflag==1 && contentflag==1)
                res=1;
            else
                res=2;
            return res;
        }
        
        else if(contentflag==2)
        {
           
            if(linkflag==0 && ldaflag==0)
                res=0;
            else if(linkflag==1 && ldaflag==1)
                res=1;
            else
                res=2;
            return res;
        }
         double result,linkres,ldares,contresult = 0;
         if(linkflg==1)
         {
             linkres=slink*0.5*10;
         }
         else
         {
             linkres=nlink*0.5*1;
         }
          
         if(ldaflg==1)
         {
              ldares=slda*10;
         }
         else
             ldares=nlda*1;
             
         if(contentflg==1) 
         {
             if(depth==1)
                contresult= 0.1*10;
            if(depth==2)
                contresult= 0.2*10;
            if(depth==3)
                contresult= 0.3*10;
            if(depth==4)
                contresult= 0.4*10;
           if(depth==5)
                contresult= 0.5*10;
           if(depth==6)
                contresult= 0.6*10;
         }
       else     //normal
         {
             
            if(depth==1)
                contresult= 0.1*1;
            if(depth==2)
                contresult=0.2*1;
            if(depth==3)
                contresult=0.3*1;
            if(depth==4)
                contresult=0.4*1;
           if(depth==5)
                contresult=0.5*1;
           if(depth==6)
                contresult=0.6*1;
         }
         
      double addedres=linkres+ldares+contresult;    reslt="Calculated link feature value is "+linkres+"\nCalculated content feature value is "+contresult+"\nCalculated LDA value is "+ldares;
                                                     reslt+="\nAnalysing Cumulatively....\n";
                                                     
      if(addedres>=8.5 && addedres<=21)
          res=1;
      else if(addedres>=0.6 && addedres<=1.85)  
          res=0;
      else
          res=2;
         return res;
     }
             
}
