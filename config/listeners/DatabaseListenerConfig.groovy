import gov.va.vinci.leo.nyha.listeners.NyhaDatabaseListener
import gov.va.vinci.leo.tools.LeoUtils

db_engine = "db_engine"
db_name = "db_name"
int batchSize = 1000

String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://"+db_engine+":1433;databasename="+db_name+";integratedSecurity=true"
String dbUser = ""
String dbPwd = ""


String timeStamp = LeoUtils.getTimestampDateUnderscoreTime().substring(0, 8)
String tableName = "[dbo].[OutputTableName_"+ timeStamp + "]"

fieldList = [
        ["DocID", "0", "bigint"],

        ["NyhaValue", "-1", "varchar(50)"],
        ["Snippet", "-1", "varchar(5000)"],
        ["SpanStart", "-1", "int"],
        ["SpanEnd", "-1", "int"],
]

boolean dropExisting = false;
listener = NyhaDatabaseListener.createNewListener(driver, url, dbUser, dbPwd, db_name, tableName, batchSize, fieldList)
//create table
listener.createTable(listener.createStatement, dropExisting, tableName)
println(listener.createStatement)
println(listener.preparedStatementSQL)
  