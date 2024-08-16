

/* First created by JCasGen Mon Nov 02 10:16:59 MST 2020 */
package gov.va.vinci.leo.nyha.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Nov 02 10:16:59 MST 2020
 * XML source: /var/folders/sj/wyls7zkd607cbvrx6m1lx9g00000gp/T/leoTypeDescription_a8689109-f9d0-4e3a-94ea-cb677bd7ee8a11831264079530698272.xml
 * @generated */
public class TermContext extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TermContext.class);
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
  protected TermContext() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TermContext(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TermContext(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TermContext(JCas jcas, int begin, int end) {
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
  //* Feature: Experiencer

  /** getter for Experiencer - gets 
   * @generated
   * @return value of the feature 
   */
  public String getExperiencer() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Experiencer == null)
      jcasType.jcas.throwFeatMissing("Experiencer", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Experiencer);}
    
  /** setter for Experiencer - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setExperiencer(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Experiencer == null)
      jcasType.jcas.throwFeatMissing("Experiencer", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Experiencer, v);}    
   
    
  //*--------------*
  //* Feature: ExperiencerPattern

  /** getter for ExperiencerPattern - gets 
   * @generated
   * @return value of the feature 
   */
  public String getExperiencerPattern() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_ExperiencerPattern == null)
      jcasType.jcas.throwFeatMissing("ExperiencerPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_ExperiencerPattern);}
    
  /** setter for ExperiencerPattern - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setExperiencerPattern(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_ExperiencerPattern == null)
      jcasType.jcas.throwFeatMissing("ExperiencerPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_ExperiencerPattern, v);}    
   
    
  //*--------------*
  //* Feature: Negation

  /** getter for Negation - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNegation() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Negation == null)
      jcasType.jcas.throwFeatMissing("Negation", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Negation);}
    
  /** setter for Negation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNegation(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Negation == null)
      jcasType.jcas.throwFeatMissing("Negation", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Negation, v);}    
   
    
  //*--------------*
  //* Feature: NegationPattern

  /** getter for NegationPattern - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNegationPattern() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_NegationPattern == null)
      jcasType.jcas.throwFeatMissing("NegationPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_NegationPattern);}
    
  /** setter for NegationPattern - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNegationPattern(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_NegationPattern == null)
      jcasType.jcas.throwFeatMissing("NegationPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_NegationPattern, v);}    
   
    
  //*--------------*
  //* Feature: Temporality

  /** getter for Temporality - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTemporality() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Temporality == null)
      jcasType.jcas.throwFeatMissing("Temporality", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Temporality);}
    
  /** setter for Temporality - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTemporality(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Temporality == null)
      jcasType.jcas.throwFeatMissing("Temporality", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_Temporality, v);}    
   
    
  //*--------------*
  //* Feature: TemporalityPattern

  /** getter for TemporalityPattern - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTemporalityPattern() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_TemporalityPattern == null)
      jcasType.jcas.throwFeatMissing("TemporalityPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_TemporalityPattern);}
    
  /** setter for TemporalityPattern - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTemporalityPattern(String v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_TemporalityPattern == null)
      jcasType.jcas.throwFeatMissing("TemporalityPattern", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setStringValue(addr, ((TermContext_Type)jcasType).casFeatCode_TemporalityPattern, v);}    
   
    
  //*--------------*
  //* Feature: Window

  /** getter for Window - gets 
   * @generated
   * @return value of the feature 
   */
  public Annotation getWindow() {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Window == null)
      jcasType.jcas.throwFeatMissing("Window", "gov.va.vinci.leo.nyha.types.TermContext");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TermContext_Type)jcasType).casFeatCode_Window)));}
    
  /** setter for Window - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWindow(Annotation v) {
    if (TermContext_Type.featOkTst && ((TermContext_Type)jcasType).casFeat_Window == null)
      jcasType.jcas.throwFeatMissing("Window", "gov.va.vinci.leo.nyha.types.TermContext");
    jcasType.ll_cas.ll_setRefValue(addr, ((TermContext_Type)jcasType).casFeatCode_Window, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    