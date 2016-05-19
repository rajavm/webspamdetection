/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;



import de.l3s.boilerpipe.BoilerpipeDocumentSource;
import de.l3s.boilerpipe.document.TextDocument;
import org.apache.xerces.parsers.AbstractSAXParser;
import org.cyberneko.html.HTMLConfiguration;
import org.xml.sax.ContentHandler;

public class BoilerpipeHTMLParser
  extends AbstractSAXParser
  implements BoilerpipeDocumentSource
{
  private BoilerpipeHTMLContentHandler contentHandler;
  
  public BoilerpipeHTMLParser()
  {
    this(new BoilerpipeHTMLContentHandler());
  }
  
  public BoilerpipeHTMLParser(BoilerpipeHTMLContentHandler contentHandler)
  {
    super(new HTMLConfiguration());
    setContentHandler(contentHandler);
  }
  
  protected BoilerpipeHTMLParser(boolean ignore)
  {
    super(new HTMLConfiguration());
  }
  
  public void setContentHandler(BoilerpipeHTMLContentHandler contentHandler)
  {
    this.contentHandler = contentHandler;
    super.setContentHandler(contentHandler);
  }
  
  public void setContentHandler(ContentHandler contentHandler)
  {
    this.contentHandler = null;
    super.setContentHandler(contentHandler);
  }
  
  public TextDocument toTextDocument()
  {
    return this.contentHandler.toTextDocument();
  }
}
