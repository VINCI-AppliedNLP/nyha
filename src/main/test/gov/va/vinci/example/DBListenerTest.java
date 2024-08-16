package gov.va.vinci.example;

import java.util.ArrayList;

import junit.framework.Assert;

import gov.va.vinci.leo.elite.listeners.EliteDbsListener;

import org.junit.Test;

public class DBListenerTest {

	@Test
	public void testCreateStatement() throws Exception {
		ArrayList<String[]> fieldList = new ArrayList<String[]>();
		fieldList.add(new String[] { "TIUDocumentSID", "bigint" });
		fieldList.add(new String[] { "Term", "varchar(200)" });
		fieldList.add(new String[] { "Experiencer", "varchar(20)" });
		fieldList.add(new String[] { "Negation", "varchar(20)" });
		fieldList.add(new String[] { "Temporality", "varchar(20)" });
		fieldList.add(new String[] { "Snippet", "varchar(2000)" });
		String statement = EliteDbsListener.createCreateStatement("[***ORD***]", "[nlp].[nlptest]",
		    fieldList);
		Assert
		    .assertEquals(
		        "CREATE TABLE [***ORD***].[nlp].[nlptest] ( TIUDocumentSID bigint, Term varchar(200), Experiencer varchar(20), Negation varchar(20), Temporality varchar(20), Snippet varchar(2000) ) ;",
		        statement);

	}

	@Test
	public void testInsertStatement() throws Exception {
		ArrayList<String[]> fieldList = new ArrayList<String[]>();
		fieldList.add(new String[] { "TIUDocumentSID", "bigint" });
		fieldList.add(new String[] { "Term", "varchar(200)" });
		fieldList.add(new String[] { "Experiencer", "varchar(20)" });
		fieldList.add(new String[] { "Negation", "varchar(20)" });
		fieldList.add(new String[] { "Temporality", "varchar(20)" });
		fieldList.add(new String[] { "Snippet", "varchar(2000)" });
		String statement = EliteDbsListener.createInsertStatement("[***ORD***]", "[nlp].[nlptest]",
		    fieldList);
		Assert
		    .assertEquals(
		        "INSERT INTO [***ORD***].[nlp].[nlptest] ( TIUDocumentSID, Term, Experiencer, Negation, Temporality, Snippet ) VALUES (  ?, ?, ?, ?, ?, ? ) ;",
		        statement);
	}

}
