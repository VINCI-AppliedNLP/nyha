package gov.va.vinci.leo.nyha;

import gov.va.vinci.leo.nyha.pipeline.BasePipeline;
import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.tools.LeoUtils;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
 

/**
 *
 * @author OVP
 *
 * Elite pipeline includes:
 * -- RegEx to search for Term
 * -- WindowAnnotator to detect window boundaries
 * -- Context to determine the Term context within the Window
 * -- AnnotationPatternAnnotator to detect additional context information
 *
 */
public class NyhaService {
  
  private static final Logger log = Logger.getLogger(LeoUtils.getRuntimeClass().toString());
  
  @Option(name = "-serviceConfigFile", usage = "The groovy config file that defines the service properties. (only ONE allowed).", required = true)
  public File[] serviceConfigFile;
  
  @Option(name = "-pipeline", usage = "Select pipeline.", required = false)
  public String[] pipeline;
  
  int numberOfInstances = 1;
  boolean isAsync = false;
  boolean createTypes = false;
  private String aggregatePath="";
  
  
  public NyhaService() {
  }
  
  /**
   * @param args
   */
  
  public static void main(String[] args) {
    gov.va.vinci.leo.nyha.NyhaService current_service = new gov.va.vinci.leo.nyha.NyhaService();
    if (args.length == 0) {
      current_service.serviceConfigFile = new File[]{new File("config/ServerConfig.groovy")};
      current_service.pipeline = new String[]{"gov.va.vinci.leo.nyha.pipeline.Pipeline"};
      
    } else {
      
      CmdLineParser parser = new CmdLineParser(current_service);
      try {
        parser.parseArgument(args);
      } catch (CmdLineException e) {
        printUsage();
        System.exit(1);
      }
    }
    current_service.run();
  }
  
  public static void printUsage() {
    CmdLineParser parser = new CmdLineParser(new gov.va.vinci.leo.nyha.NyhaService());
    System.out.print("Usage: java " + gov.va.vinci.leo.nyha.NyhaService.class.getCanonicalName());
    parser.printSingleLineUsage(System.out);
    System.out.println();
    parser.printUsage(System.out);
    
  }
  
  public void run() {
    log.info(" \r\n \r\n ===  Starting Service " + LeoUtils.getTimestampDateDotTime() + " ====\r\n  ");
    
    gov.va.vinci.leo.Service service = null;
    
    try {
      service = new gov.va.vinci.leo.Service();
      setServerProperties(service);
      
      LeoAEDescriptor aggregate = new LeoAEDescriptor();
      LeoTypeSystemDescription types = new LeoTypeSystemDescription();
      
      /** Create an aggregate of the components. */
      for (String line : pipeline) {
        Class pipe = Class.forName(line);
        BasePipeline pipeInstance = (BasePipeline) pipe.newInstance();
        System.out.println("Adding pipeline: " + pipeInstance.getClass().getCanonicalName());
        aggregate.addDelegate(pipeInstance.getPipeline());

      /* create type system */
        types.addTypeSystemDescription(pipeInstance.getLeoTypeSystemDescription());
      }
      if(createTypes) {
        types.jCasGen("src/main/java/", "target/classes");
        types.toXML("config/TypeSystem.xml");
      }
      
      aggregate.setIsAsync(false);
      aggregate.setNumberOfInstances(1);

			/* Deploy the service. */
      service.deploy(aggregate);
      aggregatePath = service.getAggregateDescriptorFile();
      System.out.println("\r\nDeployment: " + service.getDeploymentDescriptorFile());
      System.out.println("Aggregate: " + service.getAggregateDescriptorFile());
  
      System.out.println("Service running, press enter in this console to stop.");
      System.in.read();
  
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  

  public String getAggregatePath(){
    return this.aggregatePath;
  }
  public void stopService(){
    System.exit(0);
  }
  
  /**
   * Loading properties from configuration file
   *
   * @param leoServer
   * @return
   * @throws MalformedURLException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  protected gov.va.vinci.leo.Service setServerProperties(gov.va.vinci.leo.Service leoServer) throws MalformedURLException,
      InvocationTargetException, IllegalAccessException {
    if (serviceConfigFile.length != 1) {
      return leoServer;
    }
    
    ConfigSlurper configSlurper = new ConfigSlurper();
    ConfigObject o = configSlurper.parse(serviceConfigFile[0].toURI().toURL());
    if (o.keySet().contains("brokerURL"))
      leoServer.setBrokerURL(o.get("brokerURL").toString());
    
    if (o.keySet().contains("endpoint"))
      leoServer.setEndpoint( o.get("endpoint").toString());
    
    if (o.keySet().contains("deleteOnExit"))
      leoServer.setDeleteOnExit(Boolean.parseBoolean( o.get("deleteOnExit").toString()));
    
    if (o.keySet().contains("descriptorDirectory"))
      leoServer.setDescriptorDirectory( o.get("descriptorDirectory").toString());
    
    if (o.keySet().contains("casPoolSize"))
      leoServer.setCasPoolSize(Integer.parseInt(o.get("casPoolSize").toString()));
    
    if (o.keySet().contains("CCTimeout"))
      leoServer.setCCTimeout(Integer.parseInt(o.get("CCTimeout").toString()));
    
    if (o.keySet().contains("jamQueryIntervalInSeconds"))
      leoServer.setJamQueryIntervalInSeconds(Integer.parseInt(o.get("jamQueryIntervalInSeconds").toString()));
    
    if (o.keySet().contains("jamResetStatisticsAfterQuery"))
      leoServer.setJamResetStatisticsAfterQuery(Boolean.parseBoolean( o.get("jamResetStatisticsAfterQuery").toString()));
    
    if (o.keySet().contains("jamServerBaseUrl"))
      leoServer.setJamServerBaseUrl( o.get("jamServerBaseUrl").toString());
    
    if (o.keySet().contains("instanceNumber"))
      numberOfInstances = Integer.parseInt(o.get("instanceNumber").toString());
    
    if (o.keySet().contains("isAsync"))
      isAsync = Boolean.parseBoolean(o.get("isAsync").toString());
    
    
    if (o.keySet().contains("createTypes"))
      createTypes = Boolean.parseBoolean(o.get("createTypes").toString());
    
    return leoServer;
  }
}

