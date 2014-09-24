package project.deiis.hw1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import project.deiis.types.Results;

/**
 * This class is responsible for writing the results to the specified output file.
 * GeneDataProcessor sends an entry for each gene name obtained to the consumer, which processes
 * them and writes them to the output file.
 * 
 * @author pyadapad
 *
 */
public class GeneCasConsumer extends CasConsumer_ImplBase {

  public static final String PARAM_OUTPUTDIR = "OutputFile";

  private File outFile;

  /**
   * Initializes the output file object
   */
  public void initialize() throws ResourceInitializationException {
    outFile = new File(((String) getConfigParameterValue(PARAM_OUTPUTDIR)).trim());
  }

  /**
   * This method processes the gene data received from the annotator
   */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    FSIterator<?> it = jcas.getAnnotationIndex(Results.type).iterator();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile, true)));
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException occurred: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException occurred: " + e.getMessage());
    }
    while (it.isValid()) {
      Results result = (Results) it.get();
      writer.print(result.getSentenceId() + "|");
      writer.print(result.getGeneStartOffset() + " ");
      writer.print(result.getGeneEndOffset() + "|");
      writer.print(result.getGeneProduct());
      writer.println();
      it.moveToNext();
    }
    writer.close();
  }
}
