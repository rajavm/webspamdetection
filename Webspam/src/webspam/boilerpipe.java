/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.naming.NamingException;

/**
 *
 * @author Maheswari
 */
public class boilerpipe {
    public static void main(String[] args) throws MalformedURLException, BoilerpipeProcessingException, IOException
    {
        
       
 //URL url = new URL("http://web.archive.org/web/007cleaningagent.co.uk ");
       // URL url = new URL("http://web.archive.org/web/adhesiveuk.ronniebou.co.uk ");
        try{
        URL url=new URL("https://www.google.co.in/pollution");
   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
 
   String text = DefaultExtractor.INSTANCE.getText(url);
   System.out.println(text);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
          /*URL u = new URL("http://adhesiveuk.ronniebou.co.uk"); 
    HttpURLConnection huc =  (HttpURLConnection)  url.openConnection(); 
    huc.setRequestMethod("GET"); 
    huc.connect(); 
        System.out.println( huc.getResponseCode());
*/
 /*String host = "http://adhesiveuk.ronniebou.co.uk";
        try
        {
            InetAddress inetAddress = InetAddress.getByName(host);
            // show the Internet Address as name/address
            System.out.println(inetAddress.getHostName() + " " + inetAddress.getHostAddress());
        }
        catch (UnknownHostException exception)
        {
            System.err.println("ERROR: Cannot access '" + host + "'");
            URL url = new URL("https://web.archive.org/web/20070210212645/http://theweb.co.uk");
   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
 
      String text = DefaultExtractor.INSTANCE.getText(url);
   System.out.println(text);*/
        }
            } 
 
    

