package com.api.TestAPI;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class TSVReaderTest
{
	@Test	
	public void testTSVReader() throws IOException
	{
		int count=0;
		InputStream inputStream = TSVReaderApp.class.getClass().getResourceAsStream("/users.tsv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		{
			while(reader.readLine() != null)
			{
				count++;
			}
		}
		assertTrue(count>4);
	}
}
