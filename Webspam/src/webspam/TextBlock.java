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
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class TextBlock
  implements Cloneable
{
  boolean isContent = false;
  private CharSequence text;
  Set<String> labels = null;
  int offsetBlocksStart;
  int offsetBlocksEnd;
  int numWords;
  int numWordsInAnchorText;
  int numWordsInWrappedLines;
  int numWrappedLines;
  float textDensity;
  float linkDensity;
  BitSet containedTextElements;
  private int numFullTextWords = 0;
  private int tagLevel;
  private static final BitSet EMPTY_BITSET = new BitSet();
  public static final TextBlock EMPTY_START = new TextBlock("", EMPTY_BITSET, 0, 0, 0, 0, -1);
  public static final TextBlock EMPTY_END = new TextBlock("", EMPTY_BITSET, 0, 0, 0, 0, 2147483647);
  
  public TextBlock(String text)
  {
    this(text, null, 0, 0, 0, 0, 0);
  }
  
  public TextBlock(String text, BitSet containedTextElements, int numWords, int numWordsInAnchorText, int numWordsInWrappedLines, int numWrappedLines, int offsetBlocks)
  {
    this.text = text;
    this.containedTextElements = containedTextElements;
    this.numWords = numWords;
    this.numWordsInAnchorText = numWordsInAnchorText;
    this.numWordsInWrappedLines = numWordsInWrappedLines;
    this.numWrappedLines = numWrappedLines;
    this.offsetBlocksStart = offsetBlocks;
    this.offsetBlocksEnd = offsetBlocks;
    initDensities();
  }
  
  public boolean isContent()
  {
    return this.isContent;
  }
  
  public boolean setIsContent(boolean isContent)
  {
    if (isContent != this.isContent)
    {
      this.isContent = isContent;
      return true;
    }
    return false;
  }
  
  public String getText()
  {
    return this.text.toString();
  }
  
  public int getNumWords()
  {
    return this.numWords;
  }
  
  public int getNumWordsInAnchorText()
  {
    return this.numWordsInAnchorText;
  }
  
  public float getTextDensity()
  {
    return this.textDensity;
  }
  
  public float getLinkDensity()
  {
    return this.linkDensity;
  }
  
  public void mergeNext(TextBlock other)
  {
    if (!(this.text instanceof StringBuilder)) {
      this.text = new StringBuilder(this.text);
    }
    StringBuilder sb = (StringBuilder)this.text;
    sb.append('\n');
    sb.append(other.text);
    
    this.numWords += other.numWords;
    this.numWordsInAnchorText += other.numWordsInAnchorText;
    
    this.numWordsInWrappedLines += other.numWordsInWrappedLines;
    this.numWrappedLines += other.numWrappedLines;
    
    this.offsetBlocksStart = Math.min(this.offsetBlocksStart, other.offsetBlocksStart);
    
    this.offsetBlocksEnd = Math.max(this.offsetBlocksEnd, other.offsetBlocksEnd);
    
    initDensities();
    
    this.isContent |= other.isContent;
    if (this.containedTextElements == null) {
      this.containedTextElements = ((BitSet)other.containedTextElements.clone());
    } else {
      this.containedTextElements.or(other.containedTextElements);
    }
    this.numFullTextWords += other.numFullTextWords;
    if (other.labels != null) {
      if (this.labels == null) {
        this.labels = new HashSet(other.labels);
      } else {
        this.labels.addAll(other.labels);
      }
    }
    this.tagLevel = Math.min(this.tagLevel, other.tagLevel);
  }
  
  private void initDensities()
  {
    if (this.numWordsInWrappedLines == 0)
    {
      this.numWordsInWrappedLines = this.numWords;
      this.numWrappedLines = 1;
    }
    this.textDensity = (this.numWordsInWrappedLines / this.numWrappedLines);
    this.linkDensity = (this.numWords == 0 ? 0.0F : this.numWordsInAnchorText / this.numWords);
  }
  
  public int getOffsetBlocksStart()
  {
    return this.offsetBlocksStart;
  }
  
  public int getOffsetBlocksEnd()
  {
    return this.offsetBlocksEnd;
  }
  
  public String toString()
  {
    return "[" + this.offsetBlocksStart + "-" + this.offsetBlocksEnd + ";tl=" + this.tagLevel + "; nw=" + this.numWords + ";nwl=" + this.numWrappedLines + ";ld=" + this.linkDensity + "]\t" + (this.isContent ? "CONTENT" : "boilerplate") + "," + this.labels + "\n" + getText();
  }
  
  public void addLabel(String label)
  {
    if (this.labels == null) {
      this.labels = new HashSet(2);
    }
    this.labels.add(label);
  }
  
  public boolean hasLabel(String label)
  {
    return (this.labels != null) && (this.labels.contains(label));
  }
  
  public boolean removeLabel(String label)
  {
    return (this.labels != null) && (this.labels.remove(label));
  }
  
  public Set<String> getLabels()
  {
    return this.labels;
  }
  
  public void addLabels(Set<String> l)
  {
    if (l == null) {
      return;
    }
    if (this.labels == null) {
      this.labels = new HashSet(l);
    } else {
      this.labels.addAll(l);
    }
  }
  
  public void addLabels(String... l)
  {
    if (l == null) {
      return;
    }
    if (this.labels == null) {
      this.labels = new HashSet();
    }
    for (String label : l) {
      this.labels.add(label);
    }
  }
  
  public BitSet getContainedTextElements()
  {
    return this.containedTextElements;
  }
  
  protected Object clone()
  {
    TextBlock clone;
    try
    {
      clone = (TextBlock)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new RuntimeException(e);
    }
    if ((this.text != null) && (!(this.text instanceof String))) {
      clone.text = new StringBuilder(this.text);
    }
    if ((this.labels != null) && (!this.labels.isEmpty())) {
      clone.labels = new HashSet(this.labels);
    }
    if (this.containedTextElements != null) {
      clone.containedTextElements = ((BitSet)this.containedTextElements.clone());
    }
    return clone;
  }
  
  public int getTagLevel()
  {
    return this.tagLevel;
  }
  
  public void setTagLevel(int tagLevel)
  {
    this.tagLevel = tagLevel;
  }
}
