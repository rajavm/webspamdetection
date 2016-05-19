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
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.filters.english.DensityRulesClassifier;
import de.l3s.boilerpipe.filters.heuristics.BlockProximityFusion;
import de.l3s.boilerpipe.filters.heuristics.SimpleBlockFusionProcessor;

public class DefaultExtractor
  extends ExtractorBase
{
  public static final DefaultExtractor INSTANCE = new DefaultExtractor();
  
  public static DefaultExtractor getInstance()
  {
    return INSTANCE;
  }
  
  public boolean process(TextDocument doc)
    throws BoilerpipeProcessingException
  {
    return DensityRulesClassifier.INSTANCE.process(doc);
  }
}
