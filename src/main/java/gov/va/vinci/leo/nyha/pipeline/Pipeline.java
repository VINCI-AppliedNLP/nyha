package gov.va.vinci.leo.nyha.pipeline;

/*
 * #%L
 * NLP Leo demonstation
 * %%
 * Copyright (C) 2010 - 2016 Department of Veterans Affairs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import gov.va.vinci.leo.annotationpattern.ae.AnnotationPatternAnnotator;
import gov.va.vinci.leo.context.ae.ContextAnnotator;
import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.filter.ae.FilterAnnotator;
import gov.va.vinci.leo.nyha.ae.NyhaLogicAnnotator;
import gov.va.vinci.leo.regex.ae.RegexAnnotator;
import gov.va.vinci.leo.sentence.ae.AnchoredSentenceAnnotator;
import gov.va.vinci.leo.window.ae.WindowAnnotator;
import org.apache.uima.resource.metadata.TypeDescription;
import org.apache.uima.resource.metadata.impl.TypeDescription_impl;

import java.io.File;


public class Pipeline extends BasePipeline {
  private String TYPE_REGEX = "gov.va.vinci.leo.regex.types.RegularExpressionType";
  private String TYPE_PATTERN = "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType";
  private String SENTENCE_TYPE = "gov.va.vinci.leo.sentence.types.AnchoredSentence";
  private String RESOURCE_PATH = "src/main/resources/";
  private String RESOURCE_TERM = "nyha.groovy";
  private String RESOURCE_TEMPLATE = "template.regex.";
  private String RESOURCE_PATTERN = "nyha.pattern";
  private String RESOURCE_CONTEXT = "contextRules.txt";
  private String TYPE_TERM = "gov.va.vinci.leo.nyha.types.Term";
  private String TYPE_CHF_TERM = "gov.va.vinci.leo.nyha.types.CHF_Term";
  private String TYPE_MIDDLE = "gov.va.vinci.leo.nyha.types.Middle";
  private String TYPE_VALUE = "gov.va.vinci.leo.nyha.types.NYHA_score";
  private String TYPE_TEMP_VALUE = "gov.va.vinci.leo.nyha.types.NYHA_Template_score";
  private String TYPE_EXCLUDE = "gov.va.vinci.leo.nyha.types.Exclude";
  private String TERM_PATTERN = "gov.va.vinci.leo.nyha.types.TermPattern";
  private String TYPE_WINDOW_FEATURE = "Anchor";
  private String TYPE_CONTEXT = "gov.va.vinci.leo.nyha.types.TermContext";
  private String TYPE_WINDOW = "gov.va.vinci.leo.nyha.types.TermWindow";

  /**
   * Constructor
   *
   */
  public Pipeline() throws Exception {
    /* List for holding our annotators. This list, and the order of the list created the annotator pipeline. */
    
    
    pipeline = new LeoAEDescriptor();
    
    /** First, run regex on the document. ()
     * NYHA Type
     * Middle Type
     * Value Type
     *
     * */
    pipeline.addDelegate(new RegexAnnotator()
            .setGroovyConfigFile(RESOURCE_PATH + RESOURCE_TERM)
                    // .setResource(RESOURCE_PATH + RESOURCE_TERM)
            .setCaseSensitive(false)
            .setConceptFeatureName("concept")
            .setGroupFeatureName("group")
            .setMatchedPatternFeatureName("pattern")
            .setName("TermAnnotator")
            //.setOutputType(TYPE_TERM)
            .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

    pipeline.addDelegate(new FilterAnnotator()
            .setTypesToKeep(new String[]{TYPE_TERM, TYPE_VALUE, TYPE_MIDDLE})
            .setRemoveOverlapping(true)
            .setName("OverlapFilter")
            .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
    pipeline.addDelegate(new FilterAnnotator()
              .setTypesToDelete(new String[]{TYPE_TERM, TYPE_VALUE, TYPE_MIDDLE, TYPE_CHF_TERM})
              .setTypesToKeep(new String[]{TYPE_EXCLUDE})
              .setRemoveOverlapping(true)
              .setName("ExcludeFilter")
              .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));


    log.info("Resource files will be used  : \r\n"
        + (new File(RESOURCE_PATH + RESOURCE_TERM)).getAbsolutePath()
        + "\r\n" + (new File(RESOURCE_PATH + RESOURCE_CONTEXT)).getAbsolutePath());

      pipeline.addDelegate(new WindowAnnotator()
              .setAnchorFeature(TYPE_WINDOW_FEATURE)
              .setRtWindowSize(35)
              .setInputTypes(TYPE_TERM)
              .setOutputType(TYPE_WINDOW)
              .setName("WindowAnnotator")
              .getDescriptor());
      pipeline.addDelegate(new RegexAnnotator()
              //.setGroovyConfigFile(RESOURCE_PATH + RESOURCE_TEMPLATE)
              .setResource(RESOURCE_PATH + RESOURCE_TEMPLATE)
              .setCaseSensitive(false)
              .setConceptFeatureName("concept")
              .setGroupFeatureName("group")
              .setName("Temp_Value")
              .setInputTypes(TYPE_WINDOW)
              .setOutputType(TYPE_TEMP_VALUE)
              .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

/*  Pattern detection AnnotationPatternAnnotation -- nyha.pattern   */
    pipeline.addDelegate(new AnnotationPatternAnnotator()
        .setResource(RESOURCE_PATH + RESOURCE_PATTERN)
        .setOutputType(TERM_PATTERN)
        .setName("ContextPatternAnnotator")
        .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

    pipeline.addDelegate(new FilterAnnotator()
              .setTypesToKeep(new String[]{TERM_PATTERN})
              .setRemoveOverlapping(true)
              .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

    pipeline.addDelegate(new NyhaLogicAnnotator().getLeoAEDescriptor()
            .setName("LogicAnnotator")
            .addTypeSystemDescription(getLeoTypeSystemDescription()));

  }
  
  
  @Override
  protected LeoTypeSystemDescription defineTypeSystem() {
    
    if (description == null) try {
        description = new AnchoredSentenceAnnotator().getLeoTypeSystemDescription();
        description.addTypeSystemDescription(new AnnotationPatternAnnotator().getLeoTypeSystemDescription());
        description.addTypeSystemDescription(new RegexAnnotator().getLeoTypeSystemDescription());
        description.addType(TYPE_TERM, "", TYPE_REGEX);
        description.addType(TYPE_CHF_TERM, "", TYPE_REGEX);
        description.addType(TYPE_TEMP_VALUE, "", TYPE_REGEX);
        description.addType(TYPE_MIDDLE, "", TYPE_REGEX);
        description.addType(TYPE_VALUE, "", TYPE_REGEX);
        description.addType(TYPE_EXCLUDE, "", TYPE_REGEX);
        description.addType(TERM_PATTERN, "", TYPE_PATTERN);
        description.addTypeSystemDescription((new ContextAnnotator()).getLeoTypeSystemDescription(TYPE_CONTEXT));
        description.addTypeSystemDescription((new WindowAnnotator()).getLeoTypeSystemDescription());
        description.addType(TYPE_WINDOW, "", "gov.va.vinci.leo.window.types.Window");
        TypeDescription finalType = new TypeDescription_impl("gov.va.vinci.leo.nyha.types.Logic", "", "uima.tcas.Annotation");
        finalType.addFeature("NYHA_Value", "", "uima.cas.String");
        description.addType(finalType);

    } catch (Exception e) {
        e.printStackTrace();
    }
    return description;
  }
}
