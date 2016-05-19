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
import de.l3s.boilerpipe.BoilerpipeExtractor;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class ExtractorBase
  implements BoilerpipeExtractor
{
  public String getText(String html)
    throws BoilerpipeProcessingException
  {
    try
    {
      return getText(new BoilerpipeSAXInput(new InputSource(new StringReader(html))).getTextDocument());
    }
    catch (SAXException e)
    {
      throw new BoilerpipeProcessingException(e);
    }
  }
  
  public String getText(InputSource is)
    throws BoilerpipeProcessingException
  {
    try
    {
      return getText(new BoilerpipeSAXInput(is).getTextDocument());
    }
    catch (SAXException e)
    {
      throw new BoilerpipeProcessingException(e);
    }
  }
  
  public String getText(URL url)
    throws BoilerpipeProcessingException
  {
    try
    {
      return getText(HTMLFetcher.fetch(url).toInputSource());
    }
    catch (IOException e)
    {
      throw new BoilerpipeProcessingException(e);
    }
  }
 
  public String getText(Reader r)
    throws BoilerpipeProcessingException
  {
    return getText(new InputSource(r));
  }
  
  public String getText(TextDocument doc)
    throws BoilerpipeProcessingException
  {
    process(doc);
    return doc.getContent();
  }
}
