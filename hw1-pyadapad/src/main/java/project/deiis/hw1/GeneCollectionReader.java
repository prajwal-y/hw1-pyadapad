package project.deiis.hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import project.deiis.types.InputData;

/**
 * This class is responsible for reading input text line by line, and splitting the sentenceId and
 * the string containing gene information (geneData) and passing the information to the analysis
 * engine using the InputData feature in the Cas.
 * 
 * @author pyadaoad
 *
 */
public class GeneCollectionReader extends CollectionReader_ImplBase {

  public static final String PARAM_INPUTFILE = "InputFile";

  private File inputFile;

  /**
   * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
   */
  public void initialize() throws ResourceInitializationException {
    File file = new File(((String) getConfigParameterValue(PARAM_INPUTFILE)).trim());
    if (!file.exists()) {
      throw new ResourceInitializationException("Input file not found", new Object[] {
          PARAM_INPUTFILE, this.getMetaData().getName(), file.getPath() });
    }
    inputFile = file;
  }

  /**
   * @see org.apache.uima.collection.CollectionReader#hasNext()
   */
  public boolean hasNext() {
    return true;
  }

  /**
   * Reads the input file line by line, splits the sentenceId and the string which contains gene
   * data before passing to the GeneDataProcessor.
   */
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }

    BufferedReader br = new BufferedReader(new FileReader(inputFile));
    String line;
    int counter = 0;
    while ((line = br.readLine()) != null) {
      InputData input = new InputData(jcas);
      String sentenceId = line.split(" ")[0];
      input.setSentenceId(sentenceId);
      input.setGeneData(line.substring(sentenceId.length() + 1));
      input.setBegin(counter++);
      input.addToIndexes();
    }
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#close()
   */
  public void close() throws IOException {
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
   */
  public Progress[] getProgress() {
    return null;
  }

}
