
/* First created by JCasGen Mon Nov 02 10:16:59 MST 2020 */
package gov.va.vinci.leo.nyha.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType_Type;

/** 
 * Updated by JCasGen Mon Nov 02 10:16:59 MST 2020
 * @generated */
public class TermPattern_Type extends AnnotationPatternType_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TermPattern.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.leo.nyha.types.TermPattern");



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TermPattern_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    