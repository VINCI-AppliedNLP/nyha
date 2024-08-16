
/* First created by JCasGen Mon Nov 02 10:16:59 MST 2020 */
package gov.va.vinci.leo.nyha.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Nov 02 10:16:59 MST 2020
 * @generated */
public class Logic_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Logic.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.leo.nyha.types.Logic");
 
  /** @generated */
  final Feature casFeat_NYHA_Value;
  /** @generated */
  final int     casFeatCode_NYHA_Value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNYHA_Value(int addr) {
        if (featOkTst && casFeat_NYHA_Value == null)
      jcas.throwFeatMissing("NYHA_Value", "gov.va.vinci.leo.nyha.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NYHA_Value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNYHA_Value(int addr, String v) {
        if (featOkTst && casFeat_NYHA_Value == null)
      jcas.throwFeatMissing("NYHA_Value", "gov.va.vinci.leo.nyha.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_NYHA_Value, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Logic_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_NYHA_Value = jcas.getRequiredFeatureDE(casType, "NYHA_Value", "uima.cas.String", featOkTst);
    casFeatCode_NYHA_Value  = (null == casFeat_NYHA_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NYHA_Value).getCode();

  }
}



    