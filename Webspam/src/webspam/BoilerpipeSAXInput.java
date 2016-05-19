/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;



import de.l3s.boilerpipe.BoilerpipeInput;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class BoilerpipeSAXInput
  implements BoilerpipeInput
{
  private final InputSource is;
  
  public BoilerpipeSAXInput(InputSource is)
    throws SAXException
  {
    this.is = is;
  }
  
  public TextDocument getTextDocument()
    throws BoilerpipeProcessingException
  {
    return getTextDocument(new BoilerpipeHTMLParser());
  }
  
  public TextDocument getTextDocument(BoilerpipeHTMLParser parser)
    throws BoilerpipeProcessingException
  {
    try
    {
      parser.parse(this.is);
    }
    catch (IOException e)
    {
      throw new BoilerpipeProcessingException(e);
    }
    catch (SAXException e)
    {
      throw new BoilerpipeProcessingException(e);
    }
    return parser.toTextDocument();
  }
}
