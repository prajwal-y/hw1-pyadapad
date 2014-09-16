

/* First created by JCasGen Mon Sep 15 20:34:40 EDT 2014 */
package project.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Mon Sep 15 23:40:55 EDT 2014
 * XML source: /home/prajwal/git/hw1-pyadapad/hw1-pyadapad/src/main/resources/collection_readers/GeneCollectionReader.xml
 * @generated */
public class InputData extends GeneAnnotator {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(InputData.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected InputData() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public InputData(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public InputData(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public InputData(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sentenceId

  /** getter for sentenceId - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentenceId() {
    if (InputData_Type.featOkTst && ((InputData_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "project.deiis.types.InputData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((InputData_Type)jcasType).casFeatCode_sentenceId);}
    
  /** setter for sentenceId - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentenceId(String v) {
    if (InputData_Type.featOkTst && ((InputData_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "project.deiis.types.InputData");
    jcasType.ll_cas.ll_setStringValue(addr, ((InputData_Type)jcasType).casFeatCode_sentenceId, v);}    
   
    
  //*--------------*
  //* Feature: geneData

  /** getter for geneData - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneData() {
    if (InputData_Type.featOkTst && ((InputData_Type)jcasType).casFeat_geneData == null)
      jcasType.jcas.throwFeatMissing("geneData", "project.deiis.types.InputData");
    return jcasType.ll_cas.ll_getStringValue(addr, ((InputData_Type)jcasType).casFeatCode_geneData);}
    
  /** setter for geneData - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneData(String v) {
    if (InputData_Type.featOkTst && ((InputData_Type)jcasType).casFeat_geneData == null)
      jcasType.jcas.throwFeatMissing("geneData", "project.deiis.types.InputData");
    jcasType.ll_cas.ll_setStringValue(addr, ((InputData_Type)jcasType).casFeatCode_geneData, v);}    
  }

    