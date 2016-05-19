package contentspam;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//import com.spam.test.SpamDetectionTestUpdated;

public class SpamDetection {
	
	
	static Document doc;
	static String url;
	static String document_String;
	
	static float wordcount;
	static float averagewordlength;
	static float anchortext;
	static float title;
	static float visibility;
	static float compression;
	static float pratio;
	
	public static void main(String args[]) throws IOException, MalformedURLException, BoilerpipeProcessingException
	{
		
		 String line;
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the URL of the Site that you need to perform the test");
	
	SpamDetectionTestUpdated sp=new SpamDetectionTestUpdated();
	
	url=sc.nextLine();
        url="http://extremes.co.uk";
	System.out.println("The Application is Performing the Test");
	System.out.println("The URL is :"+url);
	 doc=Jsoup.connect(url).get();
		document_String=doc.toString();
        boilerpipe pp=new boilerpipe();
	String plainText = pp.content(url);
               // String plainText = new String(Files.readAllBytes(Paths.get("G:\\sem project\\output\\content\\3.txt")));
       /*  FileReader fr1=new FileReader(new File("G:\\sem project\\output\\content\\3.txt"));
             String plainText="";
                    char[] buf=new char[500000];
                    
                        fr1.read(buf);
                       // System.out.println(buf);
                        for(int i=0;buf[i]!='\0';i++)
                            plainText+=buf[i];
        */
        wordcount=sp.wordCount(plainText);
            //System.out.println("count"+wordcount);
        //System.out.println("Word Count Rating:"+(wordcount+1));
        averagewordlength=sp.AverageWordLength(plainText);
        // System.out.println("Average Word Length Rating:"+(averagewordlength+1));
        
        anchortext=sp.anchorTagRatioTest(document_String,plainText);
        // System.out.println("Anchor Text Rating:"+(anchortext+1));
        title=sp.titleLength(document_String);
         //System.out.println("Title Rating:"+(title+1));
        visibility=sp.visibilityRation(document_String,plainText);
        //System.out.println("Visibility Rating:"+(visibility+1));
        compression=sp.redunt(plainText);
        //System.out.println("Compression Rating:"+(compression+1));
    
	}
        
        public void run_contentfeatures(String url) throws IOException, MalformedURLException, BoilerpipeProcessingException
        {
             String line;
	
	//Scanner sc=new Scanner(System.in);
	//System.out.println("Enter the URL of the Site that you need to perform the test");
	
	SpamDetectionTestUpdated sp=new SpamDetectionTestUpdated();
	
	
        //url="http://web.archive.org/web/money.independent.co.uk";
	url="http://web.archive.org/web/"+url;
       // System.out.println("The Application is Performing the Test");
	System.out.println("The URL is :"+url);
	 doc=Jsoup.connect(url).get();
		document_String=doc.toString();
        boilerpipe pp=new boilerpipe();
	String plainText = pp.content(url);
               // String plainText = new String(Files.readAllBytes(Paths.get("G:\\sem project\\output\\content\\3.txt")));
       /*  FileReader fr1=new FileReader(new File("G:\\sem project\\output\\content\\3.txt"));
             String plainText="";
                    char[] buf=new char[500000];
                    
                        fr1.read(buf);
                       // System.out.println(buf);
                        for(int i=0;buf[i]!='\0';i++)
                            plainText+=buf[i];
        */
        wordcount=sp.wordCount(plainText);
            //System.out.println("count"+wordcount);
        //System.out.println("Word Count Rating:"+(wordcount+1));
        averagewordlength=sp.AverageWordLength(plainText);
        // System.out.println("Average Word Length Rating:"+(averagewordlength+1));
        
        anchortext=sp.anchorTagRatioTest(document_String,plainText);
        // System.out.println("Anchor Text Rating:"+(anchortext+1));
        title=sp.titleLength(document_String);
         //System.out.println("Title Rating:"+(title+1));
        visibility=sp.visibilityRation(document_String,plainText);
        //System.out.println("Visibility Rating:"+(visibility+1));
        compression=sp.redunt(plainText);
        }
}
