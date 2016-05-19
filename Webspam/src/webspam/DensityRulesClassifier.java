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
import de.l3s.boilerpipe.BoilerpipeFilter;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextBlock;
import de.l3s.boilerpipe.document.TextDocument;
import java.util.List;
import java.util.ListIterator;

public class DensityRulesClassifier
  implements BoilerpipeFilter
{
  public static final DensityRulesClassifier INSTANCE = new DensityRulesClassifier();
  
  public static DensityRulesClassifier getInstance()
  {
    return INSTANCE;
  }
  
  public boolean process(TextDocument doc)
    throws BoilerpipeProcessingException
  {
    List<TextBlock> textBlocks = doc.getTextBlocks();
    boolean hasChanges = false;
    
    ListIterator<TextBlock> it = textBlocks.listIterator();
    if (!it.hasNext()) {
      return false;
    }
    TextBlock prevBlock = TextBlock.EMPTY_START;
    TextBlock currentBlock = (TextBlock)it.next();
    TextBlock nextBlock = it.hasNext() ? (TextBlock)it.next() : TextBlock.EMPTY_START;
    
    hasChanges = classify(prevBlock, currentBlock, nextBlock) | hasChanges;
    if (nextBlock != TextBlock.EMPTY_START)
    {
      while (it.hasNext())
      {
        prevBlock = currentBlock;
        currentBlock = nextBlock;
        nextBlock = (TextBlock)it.next();
        hasChanges = classify(prevBlock, currentBlock, nextBlock) | hasChanges;
      }
      prevBlock = currentBlock;
      currentBlock = nextBlock;
      nextBlock = TextBlock.EMPTY_START;
      hasChanges = classify(prevBlock, currentBlock, nextBlock) | hasChanges;
    }
    return hasChanges;
  }
  
  protected boolean classify(TextBlock prev, TextBlock curr, TextBlock next)
  {
    boolean isContent;
   
    if (curr.getLinkDensity() <= 0.333333D)
    {
     // boolean isContent;
      if (prev.getLinkDensity() <= 0.5555560000000001D)
      {
        //boolean isContent;
        if (curr.getTextDensity() <= 9.0F)
        {
        //  boolean isContent;
          if (next.getTextDensity() <= 10.0F)
          {
            //boolean isContent;
            if (prev.getTextDensity() <= 4.0F) {
              isContent = false;
            } else {
              isContent = true;
            }
          }
          else
          {
            isContent = true;
          }
        }
        else
        {
       //   boolean isContent;
          if (next.getTextDensity() == 0.0F) {
            isContent = false;
          } else {
            isContent = true;
          }
        }
      }
      else
      {
       // boolean isContent;
        if (next.getTextDensity() <= 11.0F) {
          isContent = false;
        } else {
          isContent = true;
        }
      }
    }
    else
    {
      isContent = false;
    }
    return curr.setIsContent(isContent);
  }
}
