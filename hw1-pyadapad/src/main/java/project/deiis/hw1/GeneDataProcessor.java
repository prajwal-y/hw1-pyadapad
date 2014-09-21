package project.deiis.hw1;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

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
    // Open the model file and train the chunker with the gene model
    File modelFile = new File("./src/main/resources/data/gene_model");
    chunker = null;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (IOException e) {
      System.out.println("IOException occurred: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println("ClassNotFoundException occurred: " + e.getMessage());
    }
    processInstance(jCas);
  }

  /**
   * This method processes the input from the collection reader.
   * Gets the sentence and fetches the gene names using the Chunking 
   * API of LingPipe
   * @param jCas
   */
  public void processInstance(JCas jCas) {
    FSIterator<Annotation> it = jCas.getAnnotationIndex(InputData.type).iterator();
    int counter = 0;
    while (it.hasNext()) {
      InputData input = (InputData) it.next();
      String sentenceId = input.getSentenceId();
      String geneProduct = input.getGeneData();
      Chunking chunking = chunker.chunk(geneProduct);
      Set<Chunk> genes = chunking.chunkSet();

      for (Chunk c : genes) {
        ;
        int start = c.start();
        int end = c.end();
        Results results = new Results(jCas);
        results.setSentenceId(sentenceId);
        String gene = geneProduct.substring(start, end);
        results.setGeneProduct(gene);
        int startOffset = 0;
        if (start != 0)
          startOffset = geneProduct.substring(0, start - 1).replace(" ", "").length();
        results.setGeneStartOffset(startOffset);
        results.setGeneEndOffset(startOffset + gene.replace(" ", "").length() - 1);
        results.setBegin(counter++);
        results.addToIndexes();
      }
    }
  }
}
