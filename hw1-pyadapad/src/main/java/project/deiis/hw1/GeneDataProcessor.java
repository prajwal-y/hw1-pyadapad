package project.deiis.hw1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import project.deiis.types.InputData;
import project.deiis.types.Results;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

public class GeneDataProcessor extends JCasAnnotator_ImplBase {

  Chunker chunker = null;
  
  @Override
  public void process(JCas jCas) throws AnalysisEngineProcessException {
    File modelFile = new File("/home/prajwal/Desktop/gene_model_2");
    // System.out.println("Reading chunker from file=" + modelFile);
    chunker = null;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    processInstance(jCas);
  }

  public void processInstance(JCas jCas) {
    FSIterator<Annotation> it = jCas.getAnnotationIndex(InputData.type).iterator();
    int counter = 0;
    while (it.hasNext()) {
      InputData input = (InputData) it.next();
      String sentenceId = input.getSentenceId();
      String geneProduct = input.getGeneData();

      /*Map<Integer, Integer> offsets = new HashMap<Integer, Integer>();
      try {
        PosTagNamedEntityRecognizer p = new PosTagNamedEntityRecognizer();
        offsets = p.getGeneSpans(geneProduct);
      } catch (ResourceInitializationException e) {
        // TODOAuto-generated catch block
        e.printStackTrace();
      }*/

      /*for (Integer i : offsets.keySet()) {
        Integer sIndex = i;
        Integer eIndex = offsets.get(i);
        String geneString = geneProduct.substring(sIndex, eIndex);*/
        

        // for (int i = 1; i < args.length; ++i) {
        Chunking chunking = chunker.chunk(geneProduct);
        //System.out.println("Chunking=" + chunking);
        Set<Chunk> genes = chunking.chunkSet();

        for (Chunk c : genes) {
          //System.out.println(c.start());
          //System.out.println(c.end());
          int start = c.start();
          int end = c.end();
          //System.out.println(geneProduct.substring(start, end));
          Results results = new Results(jCas);
          results.setSentenceId(sentenceId);
          String gene = geneProduct.substring(start, end);
          results.setGeneProduct(gene);
          int startOffset = 0;
          if(start != 0)
            startOffset = geneProduct.substring(0, start -1).replace(" ", "").length();
          results.setGeneStartOffset(startOffset);
          results.setGeneEndOffset(startOffset + gene.replace(" ", "").length() - 1);
          results.setBegin(counter++);
          results.addToIndexes();
        }
      }
    }
  }
//}
