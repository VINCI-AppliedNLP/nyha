import gov.va.vinci.leo.regex.types.RegularExpressionType

/* An arbitrary name for this annotator. Used in the pipeline for the name of this annotation. */
name = "MyRegexAnnotator"

configuration {
    /* All configuration for this annotator. */
    defaults {
        /* Global for all configrations below if a property specified here is not overridden in a section below. */
        //keep the same (for patrick)
        outputType = RegularExpressionType.class.canonicalName
        case_sensitive = false
        matchedPatternFeatureName = "pattern"
        concept_feature_name = "concept"
        groupFeatureName = "group"
    }

    /* An arbitrary name for this set of patterns/config. */

    "NYHA_concept" {
        expressions = [
                'NYHA',
                'New\\s*York(Heart\\*)?(Association)?(functional\\s*class)?',
                '(NYHA)?\\s*functional\\s*class/stage',
                '(NYHA)?\\s*functional\\s*class(ification)?',
                'NYHA?\\s*FC',
                'functional heart',
                'C?HF(\\s*|-)class(ification)?`',
                'heart\\s*association',
                ' heart\\s*failure\\s*class(ification)?',
                'fc?nal',
                '\\bfc',
                'functional\\s*status\\s*class(ification)?',
                'shf(\\s*|-)class(ification)?',
                'dhf(\\s*|-*)class(ification)?  ',
                'systolic\\s*heart\\s*failure\\s*class(ification)? ',
                'diastolic\\s*heart\\s*failure\\s*class(ification)? ',
                'hfref(\\s*|-)class(ification)?',
                'NYHA\\s*(for\\s*)?chf',
                'NYHA\\s*classification\\s*for\\s*chf',
                '\\(NYHA\\)\\s*(for\\s*)?chf',
                'NYHAFC',
                'NYHA\\s*status'


        ]
        outputType = "gov.va.vinci.leo.nyha.types.Term"
    }

    "CHF_concept" {
        /* This concept is similar to NYHA concept,
        however more restrictive in the Pattern Annotator
        due to the Imprecise nature of the terms.

        */
        expressions = [
                'C?HF',
                'heart\\s*failure',
                '(s|d)\\s*C?hf',
                'functional\\s*status',
                'hfref',
                'heart\\s*failure\\s*stage'

        ]

        outputType = "gov.va.vinci.leo.nyha.types.CHF_Term"
    }

    //I had to include middle words in some of the NYHA_concept

    // patterns in order to restrict the types of patterns that are allowed
    // for terms that are too common.(CHF_TERM)

    "NYHA_word" {
        expressions = ['class',
                       '-class',
                       'grade',
                       'score',
                       'stage',
                       '\\bis\\b',
                       'classification',
                        '\bwas\b',
                        'class/stage'
        ]

        concept_feature_value = "NYHA_word"
        outputType = "gov.va.vinci.leo.nyha.types.Middle"
    }

    "NYHA-1" {
        expressions = ['(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc|_))(1|one|I)(a|b|c|d|\\.|,|;)?\\b',
                        '(1|I)\\s*(of|out\\s*of)(4|IV)'
                      // '(I|1)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]\\s*(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(IV|4)(\\s*of\\s*4)?\\s*\\[\\s*\\]',
                       //'\\[\\s*x\\s*\\]\\s*(class\\s*)?(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(IV|4)(\\s*of\\s*4)?'
                        ]
        concept_feature_value = "NYHA_1"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "NYHA-1.5" {
        expressions = [
                '(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc))(1|one|I) *(-|to|or|/) *(2|II|two)(a|b|c|d|\\.)?\\b'
        ]
        concept_feature_value = "NYHA_1.5"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "NYHA-2" {
        expressions = ['(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc|_))(2|two|II|11)(a|b|c|d|\\.|,|;)?\\b',\
                        '(2|II)\\s*(of|out\\s*of)(4|IV)',
                       //'(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(II|2)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]\\s*(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(IV|4)(\\s*of\\s*4)?\\s*\\[\\s*\\]',
                       //'\\[\\s*\\]\\s*(class\\s*)?(I|1)(\\s*of\\s*4)?\\s*\\[x\\]\\s*(class\\s*)?(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(IV|4)(\\s*of\\s*4)?'
                       ]

        concept_feature_value = "NYHA_2"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }
    "NYHA-2.5" {
        expressions = [
                '(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc))\\s*(2|II|two|11)\\s*(-|to|or|/)\\s*(3|III|three|111)(a|b|c|d|\\.|,|;)?\\b'
        ]

        concept_feature_value = "NYHA_2.5"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "NYHA-3" {
        expressions = ['(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc|_))(3|three|III|111)(a|b|c|d|\\.|,|;)?\\b',
                       '(3|III)\\s*(of|out\\s*of)(4|IV)',
                       //'(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(III|3)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]\\s*(IV|4)(\\s*of\\s*4)?\\s*\\[\\s*\\]',
                       //'\\[\\s*\\]\\s*(class\\s*)?(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(II|2)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]\\s*(class\\s*)?(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(IV|4)(\\s*of\\s*4)?']
                        ]
        concept_feature_value = "NYHA_3"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "NYHA-3.5" {
        expressions = [
                '(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc))(3|III|three|111)\\s*(-|to|or|/)\\s*(4|IV|four|1v)(a|b|c|d|\\.|,|;)?\\b'
        ]
        concept_feature_value = "NYHA_3.5"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "NYHA-4" {
        expressions = ['(?<=(ef|failure|hf|nal|class|NYHA|ion|\\b|fc|_))(4|four|IV|1v)(a|b|c|d|\\.|,|;)?\\b',
                       '(4|IV)\\s*(of|out\\s*of|-)(4|IV)',
                       //'(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(III|3)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(IV|4)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]',
                       //'\\[\\s*\\]\\s*(class\\s*)?(I|1)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(II|2)(\\s*of\\s*4)?\\s*\\[\\s*\\]\\s*(class\\s*)?(III|3)(\\s*of\\s*4)?\\s*\\[\\s*x\\s*\\]\\s*(class\\s*)?(IV|4)(\\s*of\\s*4)?']
                        ]
        concept_feature_value = "NYHA_4"
        outputType = "gov.va.vinci.leo.nyha.types.NYHA_score"
    }

    "Exclude" {
        expressions = [
                'CCS',
                'canadian\\s*card\\w+\\s*society\\s*functional\\s*class',
                '\\d{2,}',
                '\\d+.\\d{2,}',
                ': *\\[\\] *yes,?',
                '\\s*episodes?',
                '\\s*times',
                '\\s*nights?',
                '\\s*/?days?',
                '\\s*/?weeks?',
                '\\s*/?wks?',
                '\\s*months?',
                '\\s*minutes?',
                '\\s*years?',
                '\\s*MO\\.?',
                'x *(/ *)?(weeks?|wks?)', //  2x/week
                '.\\dx?/?\\s*(time|week|wk|day|month|minute|y)', //  2-3x/week
                '2/2',
                '%',
                '-[5-9]',
                //Irrelevant Measurements and dates
                '\\d\\d/\\d\\d+',
                '\\d+\\.\\d+',
                '\\d+.\\d+.\\d+',
                '\\( ?\\d+ ?\\) ?((\\d+|\\-|\\*) ?)+',
                'smtwthf',
                '\\d{1,4}\\)',
                //'systolic',
                //'diastolic',
                'functional\\s*problem\\s*solving',
               // 'shf',
                '\\[\\s*\\]\\s*NYHA\\s*Class',
                '2\\s*vessel\\s*disease',
                'functional\\s*status',
                'CHADS2?\\s*score',
                'MADIT\\s*HF',
                'CKD\\s*stage',
                'cfc-f',
                'FCC',
                'FCR',
                'ccs\\s*functional\\s*\\)\\s*class',
                //Specific template found
                'Not\\s*NYHA\\s*FC',
                'ONE OF PATIENT\'S DISCHARGE'


        ]
        concept_feature_value = "Exclude"
        outputType = "gov.va.vinci.leo.nyha.types.Exclude"
    }
}

