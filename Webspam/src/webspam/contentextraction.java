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


import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.net.MalformedURLException;
import java.net.URL;
//import de.l3s.boilerpipe.*;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.CanolaExtractor;
import de.l3s.boilerpipe.extractors.DefaultExtractor;
import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
//import tokenizerdriver.TokenizerDriver;

public class contentextraction {
    static int i=1;

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws MalformedURLException, BoilerpipeProcessingException, FileNotFoundException, IOException {
        // TODO code application logic here
  //  URL url = new URL("http://extremes.co.uk");
   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
  
 FileInputStream fstream = new FileInputStream("G:\\sem project\\input\\URL1.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

String strLine;

//Read File Line By Line
while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  System.out.println (strLine);
  content(strLine);
}

//Close the input stream
br.close();
   //c=text.split("\\.");
      //System.out.println("in boil"+c[0]);
   
   
    }
       public static void  content(String url1) throws MalformedURLException, BoilerpipeProcessingException, IOException
        {
           // TokenizerDriver t=new TokenizerDriver();
            url1="http://"+url1;
        URL url = new URL(url1);
         String text="";
   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
        /*try
        {
            InetAddress inetAddress = InetAddress.getByName(url1);
            // show the Internet Address as name/address
            System.out.println(inetAddress.getHostName() + " " + inetAddress.getHostAddress());
        }
        catch (UnknownHostException exception)
        {
            System.err.println("ERROR: Cannot access '" + url1 + "'");
            URL url2 = new URL("https://web.archive.org/web/20070210212645/"+url1);
   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
 
       text = DefaultExtractor.INSTANCE.getText(url2);
   System.out.println(text);
   flag=0;
        }
       
        if(flag==1)
        {*/
    text = DefaultExtractor.INSTANCE.getText(url);
    System.out.println(text);
        
   
   String s=String.valueOf(i);
   
//   c=text.split("\\.");
         //   System.out.println("In boiler"+c);
   File file = new File("G:\\sem project\\output\\spam\\"+s+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
               // t.preprocess(i);
              i++;          
                        
    }

   
}

