import gov.va.vinci.leo.nyha.listeners.CSVListener

File filePath = new File("data/output/outputData.csv");
listener = new CSVListener(filePath);
listener.writeHeaders()
