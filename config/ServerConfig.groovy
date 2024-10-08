/**
 * Server configuration variables
 * Author: Olga Patterson
 * 2016.10.10

 /**
 * The UIMA AS Broker url that is coordinating requests.
 */

//URL for local UIMA broker
brokerURL = "tcp://localhost:61616"

/**
 * The endpoint name of the UIMA AS service to use for processing. The service will be
 * registered with the broker as this service name. Clients use the broker/service combination
 * to connect to this service.
 */

endpoint = "Nyha"

/** Tell the service to persist the descriptors that are generated, deletes them by default **/
deleteOnExit = true
//descriptorDirectory = "config/desc"

// Sync vs Async scaleout. isAsync=false means that the service will run as synchronous
isAsync = false
instanceNumber = 1
createTypes = false
casPoolSize = 4
