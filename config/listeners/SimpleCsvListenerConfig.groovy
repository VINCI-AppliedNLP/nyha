package listeners

import gov.va.vinci.leo.listener.SimpleCsvListener
import gov.va.vinci.leo.tools.LeoUtils


String timeStamp = LeoUtils.getTimestampDateDotTime().replaceAll("[.]", "_")
String csvDir =   "data/output/AllDocuments.csv"
if(!(new File(csvDir)).exists()) (new File(csvDir).getParentFile()).mkdirs()

listener = new SimpleCsvListener(new File(csvDir), "gov.va.vinci.leo.types.CSI")