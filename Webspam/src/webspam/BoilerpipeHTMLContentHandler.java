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


import de.l3s.boilerpipe.document.TextBlock;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.labels.LabelAction;
import de.l3s.boilerpipe.sax.DefaultTagActionMap;
import de.l3s.boilerpipe.sax.TagAction;
import de.l3s.boilerpipe.sax.TagActionMap;
import de.l3s.boilerpipe.util.UnicodeTokenizer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class BoilerpipeHTMLContentHandler
  implements ContentHandler
{
  private final Map<String, TagAction> tagActions;
  private String title = null;
  static final String ANCHOR_TEXT_START = "$<";
  static final String ANCHOR_TEXT_END = ">$";
  StringBuilder tokenBuffer = new StringBuilder();
  StringBuilder textBuffer = new StringBuilder();
  int inBody = 0;
  int inAnchor = 0;
  int inIgnorableElement = 0;
  int tagLevel = 0;
  int blockTagLevel = -1;
  boolean sbLastWasWhitespace = false;
  private int textElementIdx = 0;
  private final List<TextBlock> textBlocks = new ArrayList();
  private String lastStartTag = null;
  private String lastEndTag = null;
  private Event lastEvent = null;
  private int offsetBlocks = 0;
  private BitSet currentContainedTextElements = new BitSet();
  private boolean flush = false;
  boolean inAnchorText = false;
  LinkedList<LinkedList<LabelAction>> labelStacks = new LinkedList();
  LinkedList<Integer> fontSizeStack = new LinkedList();
  
  public void recycle()
  {
    this.tokenBuffer.setLength(0);
    this.textBuffer.setLength(0);
    
    this.inBody = 0;
    this.inAnchor = 0;
    this.inIgnorableElement = 0;
    this.sbLastWasWhitespace = false;
    this.textElementIdx = 0;
    
    this.textBlocks.clear();
    
    this.lastStartTag = null;
    this.lastEndTag = null;
    this.lastEvent = null;
    
    this.offsetBlocks = 0;
    this.currentContainedTextElements.clear();
    
    this.flush = false;
    this.inAnchorText = false;
  }
  
  public BoilerpipeHTMLContentHandler()
  {
    this(DefaultTagActionMap.INSTANCE);
  }
  
  public BoilerpipeHTMLContentHandler(TagActionMap tagActions)
  {
    this.tagActions = tagActions;
  }
  
  public void endDocument()
    throws SAXException
  {
    flushBlock();
  }
  
  public void endPrefixMapping(String prefix)
    throws SAXException
  {}
  
  public void ignorableWhitespace(char[] ch, int start, int length)
    throws SAXException
  {
    if (!this.sbLastWasWhitespace)
    {
      this.textBuffer.append(' ');
      this.tokenBuffer.append(' ');
    }
    this.sbLastWasWhitespace = true;
  }
  
  public void processingInstruction(String target, String data)
    throws SAXException
  {}
  
  public void setDocumentLocator(Locator locator) {}
  
  public void skippedEntity(String name)
    throws SAXException
  {}
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startPrefixMapping(String prefix, String uri)
    throws SAXException
  {}
  
  public void startElement(String uri, String localName, String qName, Attributes atts)
    throws SAXException
  {
    this.labelStacks.add(null);
    
    TagAction ta = (TagAction)this.tagActions.get(localName);
    if (ta != null)
    {
      if (ta.changesTagLevel()) {
        this.tagLevel += 1;
      }
     // this.flush = (ta.start(this, localName, qName, atts) | this.flush);
    }
    else
    {
      this.tagLevel += 1;
      this.flush = true;
    }
    this.lastEvent = Event.START_TAG;
    this.lastStartTag = localName;
  }
  
  public void endElement(String uri, String localName, String qName)
    throws SAXException
  {
    TagAction ta = (TagAction)this.tagActions.get(localName);
    if (ta != null) {
    //  this.flush = (ta.end(this, localName, qName) | this.flush);
    } else {
      this.flush = true;
    }
    if ((ta == null) || (ta.changesTagLevel())) {
      this.tagLevel -= 1;
    }
    if (this.flush) {
      flushBlock();
    }
    this.lastEvent = Event.END_TAG;
    this.lastEndTag = localName;
    
    this.labelStacks.removeLast();
  }
  
  public void characters(char[] ch, int start, int length)
    throws SAXException
  {
    this.textElementIdx += 1;
    if (this.flush)
    {
      flushBlock();
      this.flush = false;
    }
    if (this.inIgnorableElement != 0) {
      return;
    }
    boolean startWhitespace = false;
    boolean endWhitespace = false;
    if (length == 0) {
      return;
    }
    int end = start + length;
    for (int i = start; i < end; i++) {
      if (Character.isWhitespace(ch[i])) {
        ch[i] = ' ';
      }
    }
    while (start < end)
    {
      char c = ch[start];
      if (c != ' ') {
        break;
      }
      startWhitespace = true;
      start++;
      length--;
    }
    while (length > 0)
    {
      char c = ch[(start + length - 1)];
      if (c != ' ') {
        break;
      }
      endWhitespace = true;
      length--;
    }
    if (length == 0)
    {
      if ((startWhitespace) || (endWhitespace))
      {
        if (!this.sbLastWasWhitespace)
        {
          this.textBuffer.append(' ');
          this.tokenBuffer.append(' ');
        }
        this.sbLastWasWhitespace = true;
      }
      else
      {
        this.sbLastWasWhitespace = false;
      }
      this.lastEvent = Event.WHITESPACE;
      return;
    }
    if ((startWhitespace) && 
      (!this.sbLastWasWhitespace))
    {
      this.textBuffer.append(' ');
      this.tokenBuffer.append(' ');
    }
    if (this.blockTagLevel == -1) {
      this.blockTagLevel = this.tagLevel;
    }
    this.textBuffer.append(ch, start, length);
    this.tokenBuffer.append(ch, start, length);
    if (endWhitespace)
    {
      this.textBuffer.append(' ');
      this.tokenBuffer.append(' ');
    }
    this.sbLastWasWhitespace = endWhitespace;
    this.lastEvent = Event.CHARACTERS;
    
    this.currentContainedTextElements.set(this.textElementIdx);
  }
  
  List<TextBlock> getTextBlocks()
  {
    return this.textBlocks;
  }
  
  public void flushBlock()
  {
    if (this.inBody == 0)
    {
      if (("TITLE".equalsIgnoreCase(this.lastStartTag)) && (this.inBody == 0)) {
        setTitle(this.tokenBuffer.toString().trim());
      }
      this.textBuffer.setLength(0);
      this.tokenBuffer.setLength(0);
      return;
    }
    int length = this.tokenBuffer.length();
    switch (length)
    {
    case 0: 
      return;
    case 1: 
      if (this.sbLastWasWhitespace)
      {
        this.textBuffer.setLength(0);
        this.tokenBuffer.setLength(0); return;
      }
      break;
    }
    String[] tokens = UnicodeTokenizer.tokenize(this.tokenBuffer);
    
    int numWords = 0;
    int numLinkedWords = 0;
    int numWrappedLines = 0;
    int currentLineLength = -1;
    int maxLineLength = 80;
    int numTokens = 0;
    int numWordsCurrentLine = 0;
    for (String token : tokens) {
      if ("$<".equals(token))
      {
        this.inAnchorText = true;
      }
      else if (">$".equals(token))
      {
        this.inAnchorText = false;
      }
      else if (isWord(token))
      {
        numTokens++;
        numWords++;
        numWordsCurrentLine++;
        if (this.inAnchorText) {
          numLinkedWords++;
        }
        int tokenLength = token.length();
        currentLineLength += tokenLength + 1;
        if (currentLineLength > 80)
        {
          numWrappedLines++;
          currentLineLength = tokenLength;
          numWordsCurrentLine = 1;
        }
      }
      else
      {
        numTokens++;
      }
    }
    if (numTokens == 0) {
      return;
    }
    int numWordsInWrappedLines;
    if (numWrappedLines == 0)
    {
       numWordsInWrappedLines = numWords;
      numWrappedLines = 1;
    }
    else
    {
      numWordsInWrappedLines = numWords - numWordsCurrentLine;
    }
    TextBlock tb = new TextBlock(this.textBuffer.toString().trim(), this.currentContainedTextElements, numWords, numLinkedWords, numWordsInWrappedLines, numWrappedLines, this.offsetBlocks);
    

    this.currentContainedTextElements = new BitSet();
    
    this.offsetBlocks += 1;
    
    this.textBuffer.setLength(0);
    this.tokenBuffer.setLength(0);
    
    tb.setTagLevel(this.blockTagLevel);
    addTextBlock(tb);
    this.blockTagLevel = -1;
  }
  
  protected void addTextBlock(TextBlock tb)
  {
    for (Integer l : this.fontSizeStack) {
      if (l != null)
      {
        tb.addLabel("font-" + l);
        break;
      }
    }
    for (LinkedList<LabelAction> labelStack : this.labelStacks) {
      if (labelStack != null) {
        for (LabelAction labels : labelStack) {
          if (labels != null) {
            labels.addTo(tb);
          }
        }
      }
    }
    this.textBlocks.add(tb);
  }
  
  private static final Pattern PAT_VALID_WORD_CHARACTER = Pattern.compile("[\\p{L}\\p{Nd}\\p{Nl}\\p{No}]");
  
  private static boolean isWord(String token)
  {
    return PAT_VALID_WORD_CHARACTER.matcher(token).find();
  }
  
  private static enum Event
  {
    START_TAG,  END_TAG,  CHARACTERS,  WHITESPACE;
    
    private Event() {}
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String s)
  {
    if ((s == null) || (s.length() == 0)) {
      return;
    }
    this.title = s;
  }
  
  public TextDocument toTextDocument()
  {
    flushBlock();
    
    return new TextDocument(getTitle(), getTextBlocks());
  }
  
  public void addWhitespaceIfNecessary()
  {
    if (!this.sbLastWasWhitespace)
    {
      this.tokenBuffer.append(' ');
      this.textBuffer.append(' ');
      this.sbLastWasWhitespace = true;
    }
  }
  
  public void addLabelAction(LabelAction la)
    throws IllegalStateException
  {
    LinkedList<LabelAction> labelStack = (LinkedList)this.labelStacks.getLast();
    if (labelStack == null)
    {
      labelStack = new LinkedList();
      this.labelStacks.removeLast();
      this.labelStacks.add(labelStack);
    }
    labelStack.add(la);
  }
}

