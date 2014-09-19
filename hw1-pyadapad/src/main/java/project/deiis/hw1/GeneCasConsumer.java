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

public class GeneCasConsumer extends CasConsumer_ImplBase {

  public static final String PARAM_OUTPUTDIR = "OutputFile";

  private File outFile;

  public void initialize() throws ResourceInitializationException {
    outFile = new File(((String) getConfigParameterValue(PARAM_OUTPUTDIR)).trim());
    /*
     * if (!outFile.exists()) { System.out.println("File does not exist"); }
     */
  }

  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {

    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    FSIterator it = jcas.getAnnotationIndex(Results.type).iterator();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile, true)));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    while (it.isValid()) {
      Results result = (Results) it.get();
      //System.out.println(result.getGeneProduct());
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
