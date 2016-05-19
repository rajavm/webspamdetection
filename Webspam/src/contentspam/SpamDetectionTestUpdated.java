package contentspam;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import com.spam.htmltoplain.HtmlToPlainText;

public class SpamDetectionTestUpdated {


	private static float anchortext=0;
	private static float wordtext=0;
	
	private static float percentage;
	
	boilerpipe pp=new boilerpipe();
	//String plainText = pp.content(s);
	public float anchorTagRatioTest(String s,String plainText) 
	{
		          //System.out.println("docmbt"+s);
		 Document doc=Jsoup.parse(s);   //html document page source
                 //System.out.println("docmbt"+doc.toString());
         Elements link=doc.select("a[href]");
      
       for (Element element : link) {           // element is <a href="... " some text </a>
           //System.out.println("ele"+element);
      	String r=element.text();                    //r is some text within ahref tag
           //System.out.println("heloi "+r);
      	r=r.trim();     //remove leading and trailing spaces
        //System.out.println("worls "+r);
      	String trim[]=r.split(" ");
        anchortext=anchortext+trim.length;      //no of words in anchor text
      }   
      
     
	  String[] words=plainText.split("\\s+");   //groups all white spaces as a delimiter
            //System.out.println(words.length);
	  
      for (String element : words) {
		
      	if(element.length()>0)
      	{
          wordtext++;
      	}
      }
	          // System.out.println(wordtext);
	  
      if(anchortext!=0 && wordtext!=0)
      {
      percentage=(float)(anchortext/wordtext);      //number of words in anchor text(all) / total no. of words 
      }
      else
      {
      percentage=0;	
      }
           // System.out.println("amount of Anchor text"+percentage);
     /* percentage=percentage*10;
      percentage=Math.round(percentage);*/
      
      
	  return percentage;	
	}
	
	
	
	
	public float AverageWordLength(String s) throws MalformedURLException, BoilerpipeProcessingException
	{
		
		float wordcount=0;
		float avgword=0;
		float b;
		String q = null;
		 // Document doc=Jsoup.parse(s);
          

          String[] words=s.split("\\s+");
          
          for (String string : words) {
	    
       	   if(string.length()>0)
       	   {
       		wordcount++;   
       		avgword=avgword+string.length();   
   	        }
       	}
          if(avgword>0 && wordcount>0)
          {
          b=(avgword/wordcount);
          }
          else
          {
       	   b=0;
          }
            //System.out.println("Average word length"+b);
         /* if(b>100)
          {
        	  b=99;
          }
          b=b/10;
          b=Math.round(b);*/
       return b;		
	}
	
	public int wordCount(String s) throws MalformedURLException, BoilerpipeProcessingException
	{
		    //Document doc=Jsoup.parse(s);
	      //  String plainText = pp.content(s);
	        String[] words=s.split("\\s+");
	        int len=words.length;
               // System.out.println("Number of words"+len);
	       /* len=len/100;
	        if(len>99)
	        {
	        	len=99;                     
	        }
	        
	        len=len/10;
	        len=Math.round(len);
	        */
	        return len;
	}
	
	
	public int titleLength(String s)
	{
		String b;
		Document doc=Jsoup.parse(s);
        String title=doc.title(); 
            //System.out.println("title is"+title);
        String[] words=title.split("\\s+");        
        int title_len=words.length;
           // System.out.println("Title length "+title_len);
       /* if(title_len>=100)
        {
        	title_len=99;
        }
        title_len=title_len/10;
        title_len=Math.round(title_len);*/
        return title_len;
	}
	
	
	public float visibilityRation(String html,String s) throws MalformedURLException, BoilerpipeProcessingException
	{
		float a,b,c;
		a=html.length();    //total size of the page
	    
		//Document doc=Jsoup.parse(s);
      //  String plainText = pp.content(s);
        b=s.length();
		
        if(a>0 && b>0)
        {
        c=(b/a);
        }
        else
        {
        	c=0;
        }
           // System.out.println("Fraction of visible text"+c);
      /*  c=c/10;
        c=Math.round(c);
      //  c=10-c;*/
        return c;    
	}
	
	
	public float popularRation(ArrayList<String> ar,String s) throws MalformedURLException, BoilerpipeProcessingException
	{
		
		//Document doc=Jsoup.parse(s);
        //String plainText = pp.content(s);
        String[] words=s.split("[\\s*]");

    String a;
    float count=0;
    int flag;
        
    for(int i=0;i<500;i++)
        {
     	String t=ar.get(i);
     	flag=1;
     	for (String string : words) {
				if(string.equals(t))
				{
			    flag=0;
				}
    	        }
     	if(flag==0)
     	{
     		count++;
     	}
        }
    float val;
    if(count>0)
    {
       val=(float)(count/500);
       val=val*100;
    }
    
    else
    {
 	   val=0;
    }		
         //   System.out.println("popular word ratio"+val);
  /*  if(val>=100)
    {
    	val=99;
    }
    
    val=val/10;
    val=Math.round(val);*/
   
		return val;
	}
	
	
	
	public float redunt(String sr) throws MalformedURLException, BoilerpipeProcessingException
	{
		//HtmlToPlainText hm=new HtmlToPlainText();
		
	//	String text = sr;
        float feq=0;
        float num=0;
        float res=0;
		//Document doc=Jsoup.parse(sr);
       // String plainText = pp.content(sr);

        String[] keys = sr.split(" ");
        String[] uniqueKeys;
        int count = 0;
        uniqueKeys = getUniqueKeys(keys);

        for(String key: uniqueKeys)
        {
            if(null == key)
            {
                break;
            }           
            for(String s : keys)
            {
                if(key.equals(s))
                {
                    count++;
                }               
            }
        //    System.out.println("Count of ["+key+"] is : "+count);
            feq++;
            num=count+num;
            count=0;
        }
       /* float f=0;
        for(int i=0;i<uniqueKeys.length && uniqueKeys[i]!=null;i++)
            f++;
        float n=keys.length;
            System.out.println("dsfd"+f/n);*/
        res=feq/num;
	        //   System.out.println("Compression rate"+res);
     /*   res=res*10;
        res=Math.round(res);
        res=10-res;   */
        return res;
	}
	
	
	
	 private static String[] getUniqueKeys(String[] keys)
	    {
	        String[] uniqueKeys = new String[keys.length];

	        uniqueKeys[0] = keys[0];
	        int uniqueKeyIndex = 1;
	        boolean keyAlreadyExists = false;

	        for(int i=1; i<keys.length ; i++)
	        {
	            for(int j=0; j<=uniqueKeyIndex; j++)
	            {
	                if(keys[i].equals(uniqueKeys[j]))
	                {
	                    keyAlreadyExists = true;
	                }
	            }           

	            if(!keyAlreadyExists)
	            {
	                uniqueKeys[uniqueKeyIndex] = keys[i];
	                uniqueKeyIndex++;               
	            }
	            keyAlreadyExists = false;
	        }       
	        return uniqueKeys;
	    }	
}