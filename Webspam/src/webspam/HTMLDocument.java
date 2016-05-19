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
import de.l3s.boilerpipe.sax.InputSourceable;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.InputSource;

public class HTMLDocument
  implements InputSourceable
{
  private Charset charset;
  private byte[] data;
  
  public HTMLDocument(byte[] data, Charset charset)
  {
    this.data = data;
    this.charset = charset;
  }
  
  public HTMLDocument(String data)
  {
    Charset cs = Charset.forName("utf-8");
    this.data = data.getBytes(cs);
    this.charset = cs;
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public InputSource toInputSource()
  {
    InputSource is = new InputSource(new ByteArrayInputStream(this.data));
    is.setEncoding(this.charset.name());
    
    return is;
  }
  
  public void encodeImageTagsAsText()
  {
    String htmlDataString = new String(this.data);
    htmlDataString = encodeImageTagsAsText(htmlDataString, this.charset.name());
    byte[] htmlData = htmlDataString.getBytes();
    this.data = htmlData;
  }
  
  public static String encodeImageTagsAsText(String htmlDataString, String encoding)
  {
    ArrayList<String> images = new ArrayList();
    
    Pattern PAT_IMAGE_TAG = Pattern.compile("<img (.*?)[/]?>");
    boolean repeat = true;
    while (repeat)
    {
      repeat = false;
      Matcher matcher = PAT_IMAGE_TAG.matcher(htmlDataString);
      if (matcher.find())
      {
        repeat = true;
        String imageAttributes = matcher.group(1);
        try
        {
          imageAttributes = URLEncoder.encode(imageAttributes, encoding);
        }
        catch (UnsupportedEncodingException e)
        {
          e.printStackTrace();
          imageAttributes = URLEncoder.encode(imageAttributes);
        }
        String encodedImageTag = "#img#" + imageAttributes + "#/img#";
        if (!images.contains(encodedImageTag))
        {
          images.add(encodedImageTag);
          
          htmlDataString = matcher.replaceFirst(encodedImageTag);
        }
        else
        {
          htmlDataString = matcher.replaceFirst("");
        }
      }
    }
    return htmlDataString;
  }
  
  public void restoreTextEncodedImageTags()
  {
    String htmlDataString = new String(this.data);
    htmlDataString = restoreTextEncodedImageTags(htmlDataString, this.charset.name());
    byte[] htmlData = htmlDataString.getBytes();
    this.data = htmlData;
  }
  
  public static String restoreTextEncodedImageTags(String htmlDataString, String encoding)
  {
    Pattern PAT_IMAGE_TAG = Pattern.compile("#img#(.*?)#/img#");
    boolean repeat = true;
    while (repeat)
    {
      repeat = false;
      Matcher matcher = PAT_IMAGE_TAG.matcher(htmlDataString);
      if (matcher.find())
      {
        repeat = true;
        String imageAttributes = matcher.group(1);
        try
        {
          imageAttributes = URLDecoder.decode(imageAttributes, encoding);
        }
        catch (UnsupportedEncodingException e)
        {
          e.printStackTrace();
          imageAttributes = URLDecoder.decode(imageAttributes);
        }
        String decodedImageTag = "<img " + imageAttributes + ">";
        
        htmlDataString = matcher.replaceFirst(decodedImageTag);
      }
    }
    return htmlDataString;
  }
  
  public void encodeEscapedCharsAsText()
  {
    String htmlDataString = new String(this.data);
    htmlDataString = encodeEscapedCharsAsText(htmlDataString, this.charset.name());
    byte[] htmlData = htmlDataString.getBytes();
    this.data = htmlData;
  }
  
  public static String encodeEscapedCharsAsText(String htmlDataString, String encoding)
  {
    Pattern PAT_ESC_CHAR = Pattern.compile("&#(.*?);");
    boolean repeat = true;
    while (repeat)
    {
      repeat = false;
      Matcher matcher = PAT_ESC_CHAR.matcher(htmlDataString);
      if (matcher.find())
      {
        repeat = true;
        String escChar = matcher.group(1);
        try
        {
          escChar = URLEncoder.encode(escChar, encoding);
        }
        catch (UnsupportedEncodingException e)
        {
          e.printStackTrace();
          escChar = URLEncoder.encode(escChar);
        }
        String encodedEscChar = "#esc#" + escChar + "#/esc#";
        
        htmlDataString = matcher.replaceFirst(encodedEscChar);
      }
    }
    return htmlDataString;
  }
  
  public void restoreTextEncodedEscapedChars()
  {
    String htmlDataString = new String(this.data);
    htmlDataString = restoreTextEncodedEscapedChars(htmlDataString, this.charset.name());
    byte[] htmlData = htmlDataString.getBytes();
    this.data = htmlData;
  }
  
  public static String restoreTextEncodedEscapedChars(String htmlDataString, String encoding)
  {
    Pattern PAT_ESC_CHAR = Pattern.compile("#esc#(.*?)#/esc#");
    boolean repeat = true;
    while (repeat)
    {
      repeat = false;
      Matcher matcher = PAT_ESC_CHAR.matcher(htmlDataString);
      if (matcher.find())
      {
        repeat = true;
        String escChar = matcher.group(1);
        try
        {
          escChar = URLDecoder.decode(escChar, encoding);
        }
        catch (UnsupportedEncodingException e)
        {
          e.printStackTrace();
          escChar = URLDecoder.decode(escChar);
        }
        String decodedEscChar = "&#" + escChar + ";";
        
        htmlDataString = matcher.replaceFirst(decodedEscChar);
      }
    }
    return htmlDataString;
  }
}
