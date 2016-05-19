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
import java.util.List;

public class TextDocument
{
  final List<TextBlock> textBlocks;
  String title;
  
  public TextDocument(List<TextBlock> textBlocks)
  {
    this(null, textBlocks);
  }
  
  public TextDocument(String title, List<TextBlock> textBlocks)
  {
    this.title = title;
    this.textBlocks = textBlocks;
  }
  
  public List<TextBlock> getTextBlocks()
  {
    return this.textBlocks;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getContent()
  {
    return getText(true, false);
  }
  
  public String getText(boolean includeContent, boolean includeNonContent)
  {
    StringBuilder sb = new StringBuilder();
    for (TextBlock block : getTextBlocks()) {
      if (block.isContent() ? 
        includeContent : 
        


        includeNonContent)
      {
        sb.append(block.getText());
        sb.append('\n');
      }
    }
    return sb.toString();
  }
  
  public String debugString()
  {
    StringBuilder sb = new StringBuilder();
    for (TextBlock tb : getTextBlocks())
    {
      sb.append(tb.toString());
      sb.append('\n');
    }
    return sb.toString();
  }
}
