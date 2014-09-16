
/* First created by JCasGen Sun Sep 14 23:53:48 EDT 2014 */
package project.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Mon Sep 15 23:40:55 EDT 2014
 * @generated */
public class Results_Type extends GeneAnnotator_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Results_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Results_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Results(addr, Results_Type.this);
  			   Results_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Results(addr, Results_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Results.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("project.deiis.types.Results");
 
  /** @generated */
  final Feature casFeat_sentenceId;
  /** @generated */
  final int     casFeatCode_sentenceId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSentenceId(int addr) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "project.deiis.types.Results");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "project.deiis.types.Results");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneProduct;
  /** @generated */
  final int     casFeatCode_geneProduct;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeneProduct(int addr) {
        if (featOkTst && casFeat_geneProduct == null)
      jcas.throwFeatMissing("geneProduct", "project.deiis.types.Results");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneProduct);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneProduct(int addr, String v) {
        if (featOkTst && casFeat_geneProduct == null)
      jcas.throwFeatMissing("geneProduct", "project.deiis.types.Results");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneProduct, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneStartOffset;
  /** @generated */
  final int     casFeatCode_geneStartOffset;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getGeneStartOffset(int addr) {
        if (featOkTst && casFeat_geneStartOffset == null)
      jcas.throwFeatMissing("geneStartOffset", "project.deiis.types.Results");
    return ll_cas.ll_getIntValue(addr, casFeatCode_geneStartOffset);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneStartOffset(int addr, int v) {
        if (featOkTst && casFeat_geneStartOffset == null)
      jcas.throwFeatMissing("geneStartOffset", "project.deiis.types.Results");
    ll_cas.ll_setIntValue(addr, casFeatCode_geneStartOffset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneEndOffset;
  /** @generated */
  final int     casFeatCode_geneEndOffset;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getGeneEndOffset(int addr) {
        if (featOkTst && casFeat_geneEndOffset == null)
      jcas.throwFeatMissing("geneEndOffset", "project.deiis.types.Results");
    return ll_cas.ll_getIntValue(addr, casFeatCode_geneEndOffset);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneEndOffset(int addr, int v) {
        if (featOkTst && casFeat_geneEndOffset == null)
      jcas.throwFeatMissing("geneEndOffset", "project.deiis.types.Results");
    ll_cas.ll_setIntValue(addr, casFeatCode_geneEndOffset, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Results_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceId = jcas.getRequiredFeatureDE(casType, "sentenceId", "uima.cas.String", featOkTst);
    casFeatCode_sentenceId  = (null == casFeat_sentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceId).getCode();

 
    casFeat_geneProduct = jcas.getRequiredFeatureDE(casType, "geneProduct", "uima.cas.String", featOkTst);
    casFeatCode_geneProduct  = (null == casFeat_geneProduct) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneProduct).getCode();

 
    casFeat_geneStartOffset = jcas.getRequiredFeatureDE(casType, "geneStartOffset", "uima.cas.Integer", featOkTst);
    casFeatCode_geneStartOffset  = (null == casFeat_geneStartOffset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneStartOffset).getCode();

 
    casFeat_geneEndOffset = jcas.getRequiredFeatureDE(casType, "geneEndOffset", "uima.cas.Integer", featOkTst);
    casFeatCode_geneEndOffset  = (null == casFeat_geneEndOffset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneEndOffset).getCode();

  }
}



    