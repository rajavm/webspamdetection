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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.UnsupportedCharsetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class HTMLFetcher
{
  private static final Pattern PAT_CHARSET = Pattern.compile("charset=([^; ]+)$");
  
  public static HTMLDocument fetch(URL url)
    throws IOException
  {
    URLConnection conn = url.openConnection();
    String ct = conn.getContentType();
    

    Charset cs = Charset.forName("UTF-8");
    if (ct != null)
    {
      Matcher m = PAT_CHARSET.matcher(ct);
      if (m.find())
      {
        String charset = m.group(1);
        try
        {
          cs = Charset.forName(charset);
        }
        catch (UnsupportedCharsetException e) {}
      }
    }
    InputStream in = conn.getInputStream();
    
    String encoding = conn.getContentEncoding();
    if (encoding != null) {
      if ("gzip".equalsIgnoreCase(encoding)) {
        in = new GZIPInputStream(in);
      } else {
       // System.err.println("WARN: unsupported Content-Encoding: " + encoding);
      }
    }
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buf = new byte[4096];
    int r;
    while ((r = in.read(buf)) != -1) {
      bos.write(buf, 0, r);
    }
    in.close();
    
    byte[] data = bos.toByteArray();
    



    CharsetDecoder decoder = cs.newDecoder();
    decoder.onMalformedInput(CodingErrorAction.IGNORE);
    decoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
    CharBuffer parsedData = decoder.decode(ByteBuffer.wrap(data));
    
    CharsetEncoder encoder = cs.newEncoder();
    ByteBuffer encodedParsedData = encoder.encode(parsedData);
    
    data = encodedParsedData.array();
    
    return new HTMLDocument(data, cs);
  }
}
