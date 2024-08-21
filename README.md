
# NYHA -- New York Heart Association Score Extraction System


The NYHA score extraction system is designed to automatically identify and extract NYHA scores from clinical text. The system uses regular expressions and pattern matching rules to locate mentions of NYHA scores and annotate them for further analysis.

## Citation

If you use this system, please cite:
- Mohanty, A. F. et al. Characteristics and Healthcare Utilization Among Veterans Treated for Heart Failure With Reduced Ejection Fraction Who Switched to Sacubitril/Valsartan. Circ. Heart Fail. 12, e005691 (2019). [PMID: 31718321](http://www.ncbi.nlm.nih.gov/pubmed/31718321)


### Pipeline Summary
The Pipeline class in the gov.va.vinci.leo.nyha.pipeline package defines a sequence of annotators that process text documents to extract relevant information. 

Here is a brief overview of the pipeline logic:

**RegexAnnotator:** Runs regular expressions on the document to identify specific patterns. It extracts NYHA Type, Middle Type, and Value Type annotations.

**FilterAnnotator:** Removes overlapping annotations and keeps only the specified types.

**WindowAnnotator:** Creates annotation windows around identified terms.

**AnnotationPatternAnnotator:** Detects predefined patterns in the text.

**NyhaLogicAnnotator:** Implements custom logic to annotate the processed text based on the identified patterns and scores.
NyhaLogicAnnotator Summary

The NyhaLogicAnnotator class in the gov.va.vinci.leo.nyha.ae package processes annotations of type TermPattern and assigns a NYHA value.




For each pattern, it creates a Logic annotation.
It extracts the NYHA value from the pattern's anchor if it is of type NYHA_score.
Type System Description: The getLeoTypeSystemDescription method provides the type system description for the annotator.
This setup ensures that the text is processed in a structured manner, extracting and annotating valuable information related to NYHA scores.
