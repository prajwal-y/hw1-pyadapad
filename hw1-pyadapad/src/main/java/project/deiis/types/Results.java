

/* First created by JCasGen Sun Sep 14 23:53:48 EDT 2014 */
package project.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.IntegerArray;


/** 
 * Updated by JCasGen Mon Sep 15 23:40:55 EDT 2014
 * XML source: /home/prajwal/git/hw1-pyadapad/hw1-pyadapad/src/main/resources/collection_readers/GeneCollectionReader.xml
 * @generated */
public class Results extends GeneAnnotator {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Results.class);
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
  protected Results() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Results(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Results(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Results(JCas jcas, int begin, int end) {
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
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "project.deiis.types.Results");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Results_Type)jcasType).casFeatCode_sentenceId);}
    
  /** setter for sentenceId - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentenceId(String v) {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "project.deiis.types.Results");
    jcasType.ll_cas.ll_setStringValue(addr, ((Results_Type)jcasType).casFeatCode_sentenceId, v);}    
   
    
  //*--------------*
  //* Feature: geneProduct

  /** getter for geneProduct - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneProduct() {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneProduct == null)
      jcasType.jcas.throwFeatMissing("geneProduct", "project.deiis.types.Results");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Results_Type)jcasType).casFeatCode_geneProduct);}
    
  /** setter for geneProduct - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneProduct(String v) {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneProduct == null)
      jcasType.jcas.throwFeatMissing("geneProduct", "project.deiis.types.Results");
    jcasType.ll_cas.ll_setStringValue(addr, ((Results_Type)jcasType).casFeatCode_geneProduct, v);}    
   
    
  //*--------------*
  //* Feature: geneStartOffset

  /** getter for geneStartOffset - gets 
   * @generated
   * @return value of the feature 
   */
  public int getGeneStartOffset() {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneStartOffset == null)
      jcasType.jcas.throwFeatMissing("geneStartOffset", "project.deiis.types.Results");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Results_Type)jcasType).casFeatCode_geneStartOffset);}
    
  /** setter for geneStartOffset - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneStartOffset(int v) {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneStartOffset == null)
      jcasType.jcas.throwFeatMissing("geneStartOffset", "project.deiis.types.Results");
    jcasType.ll_cas.ll_setIntValue(addr, ((Results_Type)jcasType).casFeatCode_geneStartOffset, v);}    
   
    
  //*--------------*
  //* Feature: geneEndOffset

  /** getter for geneEndOffset - gets 
   * @generated
   * @return value of the feature 
   */
  public int getGeneEndOffset() {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneEndOffset == null)
      jcasType.jcas.throwFeatMissing("geneEndOffset", "project.deiis.types.Results");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Results_Type)jcasType).casFeatCode_geneEndOffset);}
    
  /** setter for geneEndOffset - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneEndOffset(int v) {
    if (Results_Type.featOkTst && ((Results_Type)jcasType).casFeat_geneEndOffset == null)
      jcasType.jcas.throwFeatMissing("geneEndOffset", "project.deiis.types.Results");
    jcasType.ll_cas.ll_setIntValue(addr, ((Results_Type)jcasType).casFeatCode_geneEndOffset, v);}    
  }

    