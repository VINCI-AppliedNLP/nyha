package readers

import gov.va.vinci.leo.cr.BatchDatabaseCollectionReader

db_engine = "db_engine"
db_name = "db_name"

String query = ''' SELECT DocumentID, ReportText, RowNo from db_name.InputTable where RowNo between {min} and {max}'''

batches = [0, 10000] // change the index
batchSize = 30000;   // Adjust batch size based on your system capabilities and scaleout requirements
idColumn = "DocumentID"  // Column name that contains document identifier
noteColumn = "ReportText"  // Column name that contains text to process

/************************************************************/
/***** You should not need to change the code below *********/
/************************************************************/
String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://"+db_engine+":1433;databasename="+db_name+";integratedSecurity=true"
String dbUser = ""
String dbPwd = ""

reader = new  BatchDatabaseCollectionReader(driver, url, dbUser, dbPwd, query, idColumn.toLowerCase(), noteColumn.toLowerCase(), batches[0], batches[1], batchSize)

