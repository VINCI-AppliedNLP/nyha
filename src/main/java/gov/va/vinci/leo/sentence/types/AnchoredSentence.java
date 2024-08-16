

/* First created by JCasGen Mon Nov 02 10:16:59 MST 2020 */
package gov.va.vinci.leo.sentence.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Sentence Type
 * Updated by JCasGen Mon Nov 02 10:16:59 MST 2020
 * XML source: /var/folders/sj/wyls7zkd607cbvrx6m1lx9g00000gp/T/leoTypeDescription_a8689109-f9d0-4e3a-94ea-cb677bd7ee8a11831264079530698272.xml
 * @generated */
public class AnchoredSentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AnchoredSentence.class);
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
  protected AnchoredSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AnchoredSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AnchoredSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public AnchoredSentence(JCas jcas, int begin, int end) {
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
  //* Feature: Anchor

  /** getter for Anchor - gets Anchor Annotation around which the sentence was created
   * @generated
   * @return value of the feature 
   */
  public Annotation getAnchor() {
    if (AnchoredSentence_Type.featOkTst && ((AnchoredSentence_Type)jcasType).casFeat_Anchor == null)
      jcasType.jcas.throwFeatMissing("Anchor", "gov.va.vinci.leo.sentence.types.AnchoredSentence");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnchoredSentence_Type)jcasType).casFeatCode_Anchor)));}
    
  /** setter for Anchor - sets Anchor Annotation around which the sentence was created 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnchor(Annotation v) {
    if (AnchoredSentence_Type.featOkTst && ((AnchoredSentence_Type)jcasType).casFeat_Anchor == null)
      jcasType.jcas.throwFeatMissing("Anchor", "gov.va.vinci.leo.sentence.types.AnchoredSentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnchoredSentence_Type)jcasType).casFeatCode_Anchor, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    