/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import project.deiis.types.InputData;

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
   * @see org.apache.uima.collection.CollectionReader#getNext(org.apache.uima.cas.CAS). Reads the
   *      input file line by line, splits the sentenceId and the string which contains gene data
   *      before passing to the GeneDataProcessor.
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
