

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
public class Logic extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Logic.class);
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
  protected Logic() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Logic(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Logic(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Logic(JCas jcas, int begin, int end) {
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
  //* Feature: NYHA_Value

  /** getter for NYHA_Value - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNYHA_Value() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_NYHA_Value == null)
      jcasType.jcas.throwFeatMissing("NYHA_Value", "gov.va.vinci.leo.nyha.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_NYHA_Value);}
    
  /** setter for NYHA_Value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNYHA_Value(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_NYHA_Value == null)
      jcasType.jcas.throwFeatMissing("NYHA_Value", "gov.va.vinci.leo.nyha.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_NYHA_Value, v);}    
  }

    