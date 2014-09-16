package project.deiis.hw1;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import project.deiis.types.InputData;
import project.deiis.types.Results;

public class GeneDataProcessor extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jCas) throws AnalysisEngineProcessException {
    processInstance(jCas);
  }

  public void processInstance(JCas jCas) {
    FSIterator<Annotation> it = jCas.getAnnotationIndex(InputData.type).iterator();
    while (it.hasNext()) {
      InputData input = (InputData) it.next();
      String sentenceId = input.getSentenceId();
      String geneProduct = input.getGeneData();
      Map<Integer, Integer> offsets = new HashMap<Integer, Integer>();
      try {
        PosTagNamedEntityRecognizer p = new PosTagNamedEntityRecognizer();
        offsets = p.getGeneSpans(geneProduct);
      } catch (ResourceInitializationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for (Integer i : offsets.keySet()) {
        Integer sIndex = i;
        Integer eIndex = offsets.get(i);
        Results results = new Results(jCas);
        results.setSentenceId(sentenceId);
        results.setGeneProduct(geneProduct.substring(sIndex, eIndex));
        results.setGeneStartOffset(sIndex);
        results.setGeneStartOffset(eIndex);
        results.addToIndexes();
      }
    }
  }
}
