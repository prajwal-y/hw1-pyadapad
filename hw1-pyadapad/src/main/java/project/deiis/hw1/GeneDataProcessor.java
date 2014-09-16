package project.deiis.hw1;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

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
      InputData input = (InputData)it.next();
      String sentenceId = input.getSentenceId();
      String geneProduct = input.getGeneData();
      Integer startOffset = 10;
      Integer endOffset = 20;
      Results results = new Results(jCas);
      results.setSentenceId(sentenceId);
      results.setGeneProduct(geneProduct);
      results.setGeneStartOffset(startOffset);
      results.setGeneStartOffset(endOffset);
      results.addToIndexes();
    }
  }
}
