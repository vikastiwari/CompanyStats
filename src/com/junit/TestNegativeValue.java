/**
 * 
 */
package com.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vikas.CSVFile;
import com.vikas.MaxShareDetails;

import static com.vikas.CompanyConstants.CSVState.*;

/**
 * @author Home
 *
 */
public class TestNegativeValue {

	private String fileName;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		if(fileName==null)
		{
		Properties prop = new Properties();
		FileInputStream fis=null;
	    try {
	    	String temp=System.getProperty("user.dir")+File.separator+"properties"+File.separator+"JUnit.properties";
	    	fis=new FileInputStream(temp);
	    	prop.load(fis);
	       fileName = prop.getProperty(TestNegativeValue.class.getSimpleName().toString());
	       fis.close();
	        } catch (IOException ex) {
	           ex.printStackTrace();
	      }
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 */
	
	@Test
	public final void testFindMaxShareValue() {
		
		MaxShareDetails[] out_array = null;
		try {
			CSVFile obj = new CSVFile(fileName);
			assertNotNull(obj);
			assertEquals("Illegal State of CSV File",UNINITIALIZED,obj.getState());
			out_array=obj.findMaxShareValues();
			assertNull(out_array);
			assertEquals("Illegal State of CSV File",NEGATIVE_VALUE,obj.getState());
			assertEquals("Illegal State of CSV File",NEGATIVE_VALUE,obj.getState());
			assertArrayEquals(out_array,obj.findMaxShareValues());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	(expected = NullPointerException.class)
	public final void nulltestFindMaxShareValue2() throws FileNotFoundException {
		CSVFile obj = new CSVFile(null);
		assertNull(obj);
	}
	
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	(expected = FileNotFoundException.class)
	public final void wrongfileNameTest() throws FileNotFoundException {
		CSVFile obj = new CSVFile(fileName+fileName);
		assertNull(obj);
	}
	

}
