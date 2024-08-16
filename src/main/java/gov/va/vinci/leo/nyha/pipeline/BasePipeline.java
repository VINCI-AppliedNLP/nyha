package gov.va.vinci.leo.nyha.pipeline;


import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;

public abstract class BasePipeline {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(gov.va.vinci.leo.tools.LeoUtils.getRuntimeClass().toString());
    protected LeoAEDescriptor pipeline = null;
    protected LeoTypeSystemDescription description = null;
    
    
    public LeoTypeSystemDescription getLeoTypeSystemDescription()  {
        if (description == null) {
            return defineTypeSystem();
        }else
            return description;
    }
    
    public LeoAEDescriptor getPipeline() {
        return pipeline;
    }
    
    protected abstract LeoTypeSystemDescription defineTypeSystem ();
}
